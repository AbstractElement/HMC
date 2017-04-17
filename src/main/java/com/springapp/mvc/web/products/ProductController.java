package com.springapp.mvc.web.products;

import com.springapp.mvc.domain.product.hmc.LiveTool;
import com.springapp.mvc.domain.product.hmc.Order;
import com.springapp.mvc.domain.product.robots.Robots;
import com.springapp.mvc.service.interfaces.LiveToolService;
import com.springapp.mvc.service.interfaces.RobotsService;
import com.springapp.mvc.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    void putMachinesForBlocks(Map<String, Object> map) {
        map.put("randomMachineList", liveToolService.randomListMachine());
        map.put("newArrivalsList", liveToolService.newArrivalsList());
    }

    void putPagesInfo(Map<String, Object> map, String perPage, int itemsNum) {
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
    public ModelAndView home(Map<String,Object> map) {
        putMachinesForBlocks(map);
        return new ModelAndView("index", map);
    }

    @RequestMapping(value = "/hmc/authentication", method = RequestMethod.GET)
    public void authentication(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Map<String, Object> map) {
        if (error != null) {
            map.put("error", "Invalid username or password!");
        }
        if (logout != null) {
            map.put("msg", "You've been logged out successfully.");
        }
    }

    @RequestMapping(value = "/hmc/authentication", method = RequestMethod.POST)
    public void createNewAccount(@RequestParam(value = "username") String username,
                                 @RequestParam(value = "password") String password,
                                 @RequestParam(value = "email") String email,
                                 Map<String, Object> map) {
        userService.createNewAccount(username, password, email, "ROLE_USER");
        map.put("msg", "You've been registered successfully.");
    }

    @RequestMapping(value = "/hmc/compare", method = RequestMethod.GET)
    public void comparison(@RequestParam(required = false) String itemsId, Map<String, Object> map) {
        if (itemsId != null) {
            map.put("comparisonList", liveToolService.getMachinesList(itemsId.split(",")));
            map.put("comparisonListRobots", robotsService.getRobotsList(itemsId.split(",")));
        }
    }


    @RequestMapping(value = "/hmc/wishList", method = RequestMethod.GET)
    public void wishList(@RequestParam(required = false) String itemsId, Map<String, Object> map) {
        if (itemsId != null) {
            map.put("wishList", liveToolService.getMachinesList(itemsId.split(",")));
        }
    }

    @RequestMapping(value = "/hmc/cart", method = RequestMethod.GET)
    public void cart(@RequestParam(required = false) String itemsId, Map<String, Object> map) {
        if (itemsId != null) {
            map.put("cartListLiveTool", liveToolService.getMachinesList(itemsId.split(",")));
            map.put("cartListRobot", robotsService.getRobotsList(itemsId.split(",")));
        }
    }

    @RequestMapping(value = "/hmc/checkout", method = RequestMethod.GET)
    public void checkout(@RequestParam(required = false) String itemsId, Map<String, Object> map) {
        Order order = new Order();
        if (itemsId != null) {
            String[] items = itemsId.split(",");
            String orderList = "";
            for (String item : items){
                LiveTool liveTool = liveToolService.getMachine(item);
                if(liveTool != null) {
                    orderList += liveTool.getModel() + ",";
                    orderList += liveTool.getProductId() + ",";
                    orderList += liveTool.getPrice() + ";";
                }
            }
            for (String item : items){
                Robots robot = robotsService.getRobot(item);
                if(robot != null) {
                    orderList += robot.getModel() + ",";
                    orderList += robot.getProductId() + ",";
                    orderList += robot.getPrice() + ";";
                }
            }
            order.setOrderList(orderList);
            map.put("order", order);
            map.put("checkoutListLiveTool", liveToolService.getMachinesList(itemsId.split(",")));
            map.put("checkoutListRobots", robotsService.getRobotsList(itemsId.split(",")));
        }
    }
}
