package com.springapp.mvc.web.products;

//import com.springapp.mvc.domain.product.hmc.LiveTool;
import com.springapp.mvc.domain.product.hmc.LiveToolEntity;
import com.springapp.mvc.domain.product.hmc.Order;
import com.springapp.mvc.domain.product.robots.Robots;
import com.springapp.mvc.service.interfaces.OrderService;
import com.springapp.mvc.service.interfaces.WorkWithFilesService;
import com.springapp.mvc.service.interfaces.liveTool.LiveToolService;
import com.springapp.mvc.service.interfaces.robots.RobotsService;
import com.springapp.mvc.service.interfaces.UserService;
import com.springapp.mvc.util.EmailUtil;
import com.springapp.mvc.util.cart.Product;
import com.springapp.mvc.util.cart.compare.CompareCart;
import com.springapp.mvc.util.cart.compare.CompareCartItem;
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
public class ProductController {
    @Autowired
    private LiveToolService liveToolService;

    @Autowired
    private RobotsService robotsService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private OrderService orderService;

    @Autowired
    private WorkWithFilesService workWithFilesService;


    public void putMachinesForBlocks(Map<String, Object> map) {
        map.put("randomMachineList", liveToolService.randomListMachine());
        map.put("newArrivalsList", liveToolService.newArrivalsList());
    }

    public void putPagesInfo(Map<String, Object> map, String perPage, int itemsNum) {
        int itemsPerPage = (perPage == null) ? 9 : Integer.parseInt(perPage);
        int pagesNum = itemsNum / itemsPerPage;
        if (itemsNum % itemsPerPage != 0) {
            pagesNum++;
        }
        map.put("itemsPerPage", itemsPerPage);
        map.put("itemsNum", itemsNum);
        map.put("pagesNum", pagesNum);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(Map<String,Object> map,
                             HttpSession session) {
        putMachinesForBlocks(map);
        if ((CompareCart)session.getAttribute("compare") == null)
            session.setAttribute("compare", new CompareCart());
        if ((ShoppingCart)session.getAttribute("basket") == null)
            session.setAttribute("basket", new ShoppingCart());
        return new ModelAndView("index", map);
    }

    @RequestMapping(value = "/hmc/authentication", method = RequestMethod.GET)
    public void authentication(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Map<String, Object> map) {
        if (error != null)
            map.put("error", "Invalid username or password!");
        if (logout != null)
            map.put("msg", "You've been logged out successfully.");
    }

    @RequestMapping(value = "/hmc/authentication", method = RequestMethod.POST)
    public void createNewAccount(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "email") String email,
                                 Map<String, Object> map) {
        userService.createNewAccount(username, password, email, "ROLE_USER");
        map.put("msg", "You've been registered successfully.");
    }



//
//    @RequestMapping(value = "/hmc/wishList", method = RequestMethod.GET)
//    public void wishList(@RequestParam(required = false) String itemsId, Map<String, Object> map) {
//        if (itemsId != null) {
//            map.put("wishList", liveToolService.getMachinesList(itemsId.split(",")));
//        }
//    }


    @RequestMapping(value = "/hmc/checkout", method = RequestMethod.GET)
    public void checkout(Map<String, Object> map,
                         HttpSession session) {
        Order order = new Order();
        String orderList = "";
        ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("basket");
        for (ShoppingCartItem item : shoppingCart.getItems()){
//            LiveToolEntity liveTool = liveToolService.getMachine(item.getProduct().getProductId());
            orderList += item.getProduct().getModel() + ",";
            orderList += item.getProduct().getProductId() + ";";
            orderList += item.getQuantity() + ";";
//            if(liveTool != null) {
//                orderList += liveTool.getModel() + ",";
//                orderList += liveTool.getProductId() + ";";
////                orderList += liveTool.getPrice() + ";";
//            }
//            else {
//                Robots robot = robotsService.getRobot(item.getProduct().getProductId());
//                if (robot != null) {
//                    orderList += robot.getModel() + ",";
//                    orderList += robot.getProductId() + ",";
//                    orderList += robot.getPrice() + ";";
//                }
//            }
        }
        order.setOrderList(orderList);
        map.put("order", order);
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

//    @RequestMapping(value = "/hmc/trackYourOrder", method = RequestMethod.GET)
//    public void trackYourOrder(@RequestParam(value = "message", required = false) String message,
//                               @RequestParam(value = "orderId", required = false) String orderId,
//                               @RequestParam(value = "emptyTheCart", required = false) String emptyTheCart,
//                               Map<String, Object> map) {
//        map.put("message", message);
//        map.put("orderId", orderId);
//        map.put("emptyTheCart", emptyTheCart);
//    }

    @RequestMapping(value = "/hmc/proposal", method = RequestMethod.GET)
    public void proposal(
//            @RequestParam(required = true) String itemsId,
            Map<String, Object> map) {
//        if (itemsId != null) {
//            map.put("proposalList", liveToolService.getMachinesList(itemsId.split(",")));
//        }
    }

    @RequestMapping(value = "/hmc/proposal", method = RequestMethod.POST)
    public ResponseEntity<byte[]> getPdf(HttpSession session,
                                         @RequestParam(value = "company", required = false) String company,
                                         @RequestParam(value = "director", required = false) String director,
                                         @RequestParam("showPrice") String showPrice,
                                         HttpServletRequest request) throws Exception {
        String path = request.getServletContext().getRealPath("") + "/resources";
        String products = "";
        ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("basket");
        for (ShoppingCartItem item : shoppingCart.getItems())
            products += item.getProduct().getProductId() + "," + item.getQuantity() + ";";
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
}
