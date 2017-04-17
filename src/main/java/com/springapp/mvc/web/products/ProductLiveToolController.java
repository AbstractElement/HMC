package com.springapp.mvc.web.products;

import com.springapp.mvc.domain.filters.hmcFilter.BrandFilter;
import com.springapp.mvc.domain.filters.hmcFilter.MainLiveToolFilter;
import com.springapp.mvc.domain.product.hmc.LiveTool;
import com.springapp.mvc.domain.product.hmc.Order;
import com.springapp.mvc.service.interfaces.*;
import com.springapp.mvc.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladislav on 07.04.2017.
 */
@Controller
public class ProductLiveToolController {
    @Autowired
    private LiveToolService liveToolService;

    @Autowired
    private ProductController productController;

    @Autowired
    private LocationFilterService locationFilterService;

    @Autowired
    private BrandFilterService brandFilterService;

    @Autowired
    private WorkWithFilesService workWithFilesService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DriveTypeFilterService driveTypeFilterService;

    @Autowired
    private ToolHolderService toolHolderService;

    @Autowired
    private EmailUtil emailUtil;

    @RequestMapping(value = "/hmc", method = RequestMethod.GET)
    public void hmc(Map<String, Object> map) {
        List<LiveTool> machineList = liveToolService.listMachine();
        map.put("mainFilter", new MainLiveToolFilter());
        map.put("machineList", machineList);
        map.put("machineBrands", brandFilterService.listBrand());
        map.put("machineProducingCountry", locationFilterService.listLiveToolLocation());
        map.put("machineDriveType", driveTypeFilterService.driveTypeList());
        map.put("machineToolHolder", toolHolderService.toolHolderList());
        productController.putPagesInfo(map, null, machineList.size());
    }

    @RequestMapping(value = "/hmc/filter", method = RequestMethod.POST)
    public String hmcFiltered(@RequestParam(value = "perPage", required = false) String perPage,
                              @ModelAttribute(value = "liveToolObj") MainLiveToolFilter mainLiveToolFilter,
                              Map<String, Object> map) {
        List<LiveTool> machineList;
        if (mainLiveToolFilter.getBrand() == null && mainLiveToolFilter.getCountry() == null
                && mainLiveToolFilter.getDriveType() == null && mainLiveToolFilter.getVDI() == null)
            machineList = liveToolService.listMachine();
        else
            machineList = liveToolService.listFiltered(mainLiveToolFilter.getBrand(), mainLiveToolFilter.getCountry(),
                    mainLiveToolFilter.getDriveType(), mainLiveToolFilter.getVDI());
        List<BrandFilter> machineBrands = brandFilterService.listBrand();
        map.put("liveToolObj", mainLiveToolFilter);
        map.put("machineBrands", machineBrands);
        map.put("machineList", machineList);
        map.put("machineProducingCountry", locationFilterService.listLiveToolLocation());
        map.put("machineDriveType", driveTypeFilterService.driveTypeList());
        map.put("machineToolHolder", toolHolderService.toolHolderList());
        productController.putPagesInfo(map, perPage, machineList.size());
        return "/hmc";
    }

    @RequestMapping(value = "/hmc{productId}", method = RequestMethod.GET)
    public ModelAndView machineItem(@PathVariable("productId") String productId, Map<String, Object> map) {
        LiveTool machine = liveToolService.getMachine(productId);
        if (machine == null) {
            return new ModelAndView("error/error404");
        }
        map.put("machine", machine);
        return new ModelAndView("hmc/machine", map);
    }

    @RequestMapping(value = "/hmc/proposal", method = RequestMethod.GET)
    public void proposal(@RequestParam(required = true) String itemsId, Map<String, Object> map) {
        if (itemsId != null) {
            map.put("proposalList", liveToolService.getMachinesList(itemsId.split(",")));
        }
    }

    @RequestMapping(value = "/hmc/proposal", method = RequestMethod.POST)
    public ResponseEntity<byte[]> getPdf(@RequestParam("products") String products,
                                         @RequestParam(value = "company", required = false) String company,
                                         @RequestParam(value = "director", required = false) String director,
                                         @RequestParam("showPrice") String showPrice,
                                         HttpServletRequest request) throws Exception {
        String path = request.getServletContext().getRealPath("") + "/resources";
        return workWithFilesService.getPDFOffer(path, products, company, director, Boolean.getBoolean(showPrice));
    }

    @RequestMapping(value = "/hmc/proposalSingle", method = RequestMethod.GET)
    public void proposalSingle(@RequestParam(required = true) String productId, Map<String, Object> map) {
        map.put("machine", liveToolService.getMachine(productId));
    }

    @RequestMapping(value = "/hmc/proposalSingle", method = RequestMethod.POST)
    public ResponseEntity<byte[]> getPdfSingle(@RequestParam("productId") String productId,
                                               @RequestParam(value = "company", required = false) String company,
                                               @RequestParam(value = "director", required = false) String director,
                                               @RequestParam("showPrice") String showPrice,
                                               HttpServletRequest request) throws Exception {
        String path = request.getServletContext().getRealPath("") + "/resources";
        return workWithFilesService.getPDFOfferSingle(path, productId, company, director, Boolean.getBoolean(showPrice));
    }


    @RequestMapping(value = "/hmc/checkout", method = RequestMethod.POST)
    public void checkoutPost(@ModelAttribute("order")Order order,
                             Map<String, Object> map) {
        map.put("from", "vladis19tr@gmail.com");
        map.put("to", "vladis19tr@gmail.com");
        map.put("subject", "New proposal");
        map.put("bcclist", new ArrayList<>());
        order.setDate(new GregorianCalendar().getTime());
        orderService.addOrder(order);
        map.put("machineOrder", order);
        emailUtil.sendEmail("machine-order-admin.vm", map);
        map.put("to", order.getEmail());
        emailUtil.sendEmail("machine-order-customer.vm", map);
    }

    @RequestMapping(value = "/hmc/trackYourOrder", method = RequestMethod.GET)
    public void trackYourOrder(@RequestParam(value = "message", required = false) String message,
                               @RequestParam(value = "orderId", required = false) String orderId,
                               @RequestParam(value = "emptyTheCart", required = false) String emptyTheCart,
                               Map<String, Object> map) {
        map.put("message", message);
        map.put("orderId", orderId);
        map.put("emptyTheCart", emptyTheCart);
    }

}
