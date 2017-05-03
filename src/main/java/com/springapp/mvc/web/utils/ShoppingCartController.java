package com.springapp.mvc.web.utils;

import com.springapp.mvc.domain.product.hmc.LiveToolEntity;
import com.springapp.mvc.service.interfaces.liveTool.LiveToolService;
import com.springapp.mvc.service.interfaces.robots.RobotsService;
import com.springapp.mvc.util.cart.Product;
import com.springapp.mvc.util.cart.shopping.ShoppingCartItem;
import com.springapp.mvc.web.products.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ShoppingCartController {
    @Autowired
    private LiveToolService liveToolService;

    @Autowired
    private RobotsService robotsService;

    @Autowired
    private ProductController productController;

    @RequestMapping(value = "/hmc/cart", method = RequestMethod.GET)
    public void cart(Map<String, Object> map,
                     HttpSession session) {
//        String itemsId = "";
//        ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("basket");
//        for (ShoppingCartItem itemId : shoppingCart.getItems())
//            itemsId += itemId.getProduct().getProductId() + ",";
//        map.put("cartListLiveTool", liveToolService.getMachinesList(itemsId.split(",")));
//        map.put("cartListRobot", robotsService.getRobotsList(itemsId.split(",")));
//        return "/hmc/cart";
    }

    @RequestMapping(value = "/addToCart/{id}/{currentPage}", method = RequestMethod.GET)
    public String addToCart(@PathVariable String id,
                            @PathVariable String currentPage,
                            HttpSession session,
                            Map<String,Object> map) {
        Product product;
        LiveToolEntity liveTool = liveToolService.getMachine(id);
        if(liveTool == null)
            product = robotsService.getRobot(id);
        else
            product = liveTool;
        com.springapp.mvc.util.cart.shopping.ShoppingCart shoppingCart = (com.springapp.mvc.util.cart.shopping.ShoppingCart)session.getAttribute("basket");
        shoppingCart.addItem(product);
//        shoppingCart.calculateTotal();
//        session.setAttribute("basket", shoppingCart);
        map.put("basket", shoppingCart);
        productController.putMachinesForBlocks(map);
        if (currentPage.equals("index"))
            currentPage = "/";
        return "redirect:/"+currentPage;
    }

    @RequestMapping(value = "/incrementQuantity/{itemId}")
    public String incrementQuantity(@PathVariable String itemId,
                                    HttpSession session){
        com.springapp.mvc.util.cart.shopping.ShoppingCart shoppingCart = (com.springapp.mvc.util.cart.shopping.ShoppingCart)session.getAttribute("basket");
        for (ShoppingCartItem item : shoppingCart.getItems())
            if (item.getProduct().getProductId().equals(itemId)) {
                item.incrementQuantity();
                break;
            }
//        shoppingCart.calculateTotal();
        return "redirect:/hmc/cart";
    }

    @RequestMapping(value = "/decrementQuantity/{itemId}")
    public String decrementQuantity(@PathVariable String itemId,
                                    HttpSession session){
        com.springapp.mvc.util.cart.shopping.ShoppingCart shoppingCart = (com.springapp.mvc.util.cart.shopping.ShoppingCart)session.getAttribute("basket");
        for (ShoppingCartItem item : shoppingCart.getItems())
            if (item.getProduct().getProductId().equals(itemId)) {
                item.decrementQuantity();
                break;
            }
//        shoppingCart.calculateTotal();
        return "redirect:/hmc/cart";
    }

    @RequestMapping(value = "/removeFromCart/{itemId}")
    public String removeFromCart(@PathVariable String itemId,
                                 HttpSession session){
        com.springapp.mvc.util.cart.shopping.ShoppingCart shoppingCart = (com.springapp.mvc.util.cart.shopping.ShoppingCart)session.getAttribute("basket");
        for (ShoppingCartItem item : shoppingCart.getItems())
            if (item.getProduct().getProductId().equals(itemId)) {
                shoppingCart.getItems().remove(item);
                break;
            }
//        shoppingCart.calculateTotal();
        return "redirect:/hmc/cart";
    }
}
