package com.springapp.mvc.web.products;

import com.springapp.mvc.domain.filters.liveToolFilter.BrandFilter;
import com.springapp.mvc.domain.filters.liveToolFilter.MainLiveToolFilter;
import com.springapp.mvc.domain.product.hmc.LiveTool;
import com.springapp.mvc.domain.product.hmc.Order;
import com.springapp.mvc.service.interfaces.*;
import com.springapp.mvc.service.interfaces.liveTool.BrandFilterService;
import com.springapp.mvc.service.interfaces.liveTool.DriveTypeFilterService;
import com.springapp.mvc.service.interfaces.liveTool.LiveToolService;
import com.springapp.mvc.service.interfaces.liveTool.ToolHolderService;
import com.springapp.mvc.util.EmailUtil;
import com.springapp.mvc.util.cart.shopping.ShoppingCart;
import com.springapp.mvc.util.cart.shopping.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    private DriveTypeFilterService driveTypeFilterService;

    @Autowired
    private ToolHolderService toolHolderService;

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

}
