package com.springapp.mvc.web.utils;

import com.springapp.mvc.domain.product.hmc.LiveTool;
import com.springapp.mvc.service.interfaces.liveTool.LiveToolService;
import com.springapp.mvc.service.interfaces.robots.RobotsService;
import com.springapp.mvc.util.cart.Product;
import com.springapp.mvc.util.cart.compare.CompareCart;
import com.springapp.mvc.util.cart.compare.CompareCartItem;
import com.springapp.mvc.web.products.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CompareController {
    @Autowired
    private LiveToolService liveToolService;

    @Autowired
    private RobotsService robotsService;

    @Autowired
    private ProductController productController;

    @RequestMapping(value = "/compare", method = RequestMethod.GET)
    public void comparison(
//            @RequestParam(required = false) String itemsId,
            Map<String, Object> map,
            HttpSession session) {
        CompareCart compareCart = (CompareCart)session.getAttribute("compare");
        List<CompareCartItem> compareCartItem = compareCart.getItems();
        String itemsId = "";
        for(CompareCartItem item : compareCartItem)
            itemsId += item.getProduct().getProductId() + ",";
        if (!itemsId.equals("")) {
            map.put("comparisonList", liveToolService.getMachinesList(itemsId.split(",")));
            map.put("comparisonListRobots", robotsService.getRobotsList(itemsId.split(",")));
        }
    }

    @RequestMapping(value = "/addToCompare/{id}/{currentPage}", method = RequestMethod.GET)
    public String addToCompare(@PathVariable String id,
                               @PathVariable String currentPage,
                               HttpSession session,
                               Map<String,Object> map) {
        Product product;
        LiveTool liveTool = liveToolService.getMachine(id);
        if(liveTool == null)
            product = robotsService.getRobot(id);
        else
            product = liveTool;
        CompareCart compareCart = (CompareCart)session.getAttribute("compare");
        compareCart.addItem(product);
        session.setAttribute("compare", compareCart);
        productController.putMachinesForBlocks(map);
        if (currentPage.equals("index"))
            currentPage = "/";
        return "redirect:/"+currentPage;
    }

    @RequestMapping(value = "/removeFromCompare/{itemId}")
    public String removeFromCompare(@PathVariable String itemId,
                                    HttpSession session){
        CompareCart compareCart = (CompareCart)session.getAttribute("compare");
        for (CompareCartItem item : compareCart.getItems())
            if (item.getProduct().getProductId().equals(itemId)) {
                compareCart.getItems().remove(item);
                break;
            }
        return "redirect:/compare";
    }
}
