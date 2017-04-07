package com.springapp.mvc.web.products;

import com.springapp.mvc.domain.filters.robotFilters.MainRobotFilter;
import com.springapp.mvc.domain.robots.Robots;
import com.springapp.mvc.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ProductRobotController {
    @Autowired
    private RobotsService robotsService;

    @Autowired
    private ProductController productController;

    @Autowired
    private ManufacturerFilterService manufacturerFilterService;

    @Autowired
    private LocationFilterService locationFilterService;

    @Autowired
    private AxesService axesService;

    @Autowired
    private LoadFilterService loadFilterService;

    @Autowired
    private ReachFilterService reachFilterService;

    @RequestMapping(value = "/robots", method = RequestMethod.GET)
    public void getRobots(Map<String, Object> map){
        List<Robots> robotsList = robotsService.listRobots();
        map.put("mainFilter", new MainRobotFilter());
        map.put("machineManufacturer", manufacturerFilterService.listManufacturer());
        map.put("axesArr", axesService.getAxes());
        map.put("loadArr", loadFilterService.getLoadValues());
        map.put("reachArr", reachFilterService.getReachValues());
        map.put("robotsList", robotsList);
        map.put("machineLocation", locationFilterService.listRobotLocation());
        productController.putPagesInfo(map, null, robotsList.size());
    }

    @RequestMapping(value = "/robot/filter", method = RequestMethod.GET)
    public String robotFiltered(@ModelAttribute(value = "mainFilter") MainRobotFilter filters,
                                @RequestParam(value = "perPage", required = false) String perPage,
                              Map<String, Object> map) {
        List<Robots> robotList;
        if (filters.getManufacturer() == null && filters.getYearFrom() == null && filters.getYearTo() == null
                && filters.getLoad() == null && filters.getLocation() == null && filters.getReach() == null &&
                filters.getAxes() == null)
            robotList = robotsService.listRobots();
        else
            robotList = robotsService.listFiltered(filters.getManufacturer(), filters.getYearFrom(), filters.getYearTo(),
                    filters.getAxes(), filters.getLoad(), filters.getReach(), filters.getLocation());
        map.put("mainFilter", filters);
        map.put("machineManufacturer", manufacturerFilterService.listManufacturer());
        map.put("machineLocation", locationFilterService.listRobotLocation());
        map.put("axesArr", axesService.getAxes());
        map.put("loadArr", loadFilterService.getLoadValues());
        map.put("reachArr", reachFilterService.getReachValues());
        map.put("robotsList", robotList);
        productController.putPagesInfo(map, perPage, robotList.size());
        return "/robots";
    }

    @RequestMapping(value = "/robot{productId}", method = RequestMethod.GET)
    public ModelAndView robotItem(@PathVariable("productId") String productId, Map<String, Object> map) {
        Robots machine = robotsService.getRobot(productId);
        if (machine == null) {
            return new ModelAndView("error/error404");
        }
        map.put("machine", machine);
        return new ModelAndView("robot/machine", map);
    }




}