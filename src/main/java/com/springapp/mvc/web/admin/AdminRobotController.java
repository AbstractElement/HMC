package com.springapp.mvc.web.admin;

import com.springapp.mvc.domain.filters.NamesTypeProducts;
import com.springapp.mvc.domain.filters.robotFilters.LoadFilter;
import com.springapp.mvc.domain.filters.LocationFilter;
import com.springapp.mvc.domain.filters.robotFilters.ReachFilter;
import com.springapp.mvc.domain.product.robots.Robots;
import com.springapp.mvc.service.interfaces.*;
import com.springapp.mvc.service.interfaces.robots.LoadFilterService;
import com.springapp.mvc.service.interfaces.robots.ManufacturerFilterService;
import com.springapp.mvc.service.interfaces.robots.ReachFilterService;
import com.springapp.mvc.service.interfaces.robots.RobotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladislav on 25.03.2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminRobotController {

    @Autowired
    private RobotsService robotsService;

    @Autowired
    private ManufacturerFilterService manufacturerFilterService;

    @Autowired
    private LoadFilterService loadFilterService;

    @Autowired
    private ReachFilterService reachFilterService;
    
    @Autowired
    private WorkWithFilesService workWithFilesService;

    @Autowired
    private LocationFilterService locationFilterService;


    @RequestMapping(value = "/robot", method = RequestMethod.GET)
    public void robot(Map<String, Object> map){
        List<Robots> robotsList = robotsService.listRobots();
        map.put("machine", new Robots());
        map.put("filterObj", new LoadFilter());
        map.put("reachObj", new ReachFilter());
        map.put("robotList", robotsList);
        map.put("filters", loadFilterService.getLoadValues());
        map.put("filtersReach", reachFilterService.getReachValues());
        AdminController.putPagesInfo(map, robotsList.size(), 10);
    }

    @RequestMapping(value = "/robot/renewFiltersRobot", method = RequestMethod.POST)
    public String renewRobotFilters(){
        List<String> nameLocation = robotsService.getLocationList();
        for (String location : nameLocation){
            LocationFilter locationFilter = new LocationFilter();
            locationFilter.setCountryName(location);
            locationFilter.setTypeProduct(NamesTypeProducts.ROBOT);
            locationFilterService.addLocation(locationFilter);
        }
        return "redirect:/admin/robot";
    }

    @RequestMapping(value = "/robot/edit", method = RequestMethod.POST)
    public String editRobot(@ModelAttribute("machine") Robots machine) {
        robotsService.editRobot(machine);
        manufacturerFilterService.addManufacturer(machine.getBrand());
        return "redirect:/admin/robot";
    }

    @RequestMapping(value = "/robot/upload", method = RequestMethod.POST)
    public String adminUploadRobotFromFiles(@RequestParam("textFile") MultipartFile[] machines, HttpServletRequest request){
        if (machines != null && machines.length > 0) {
            String path = request.getServletContext().getRealPath("") + "/resources/";
            workWithFilesService.uploadRobot(path, machines);
        }
        return "redirect:/admin/robot";
    }
    @RequestMapping(value = "/robot/saveLoadFilter", method = RequestMethod.POST)
    public String saveFilter(@ModelAttribute("filterObj") LoadFilter loadFilter){
        loadFilterService.uploadLoadFilter(loadFilter);
        return "redirect:/admin/robot";
    }

    @RequestMapping(value = "/robot/addFilter", method = RequestMethod.POST)
    public String addFilter(@ModelAttribute("filterObj") LoadFilter loadFilter){
        loadFilterService.addLoadFilter(loadFilter);
        return "redirect:/admin/robot";
    }


    @RequestMapping(value = "/robot/delFilter", method = RequestMethod.POST)
    public String delFilter(@ModelAttribute("filterObj") LoadFilter loadFilter){
        loadFilterService.deleteLoadFilter(loadFilter);
        return "redirect:/admin/robot";
    }

    @RequestMapping(value = "/robot/saveReachFilter", method = RequestMethod.POST)
    public String saveReachFilter(@ModelAttribute("reachObj") ReachFilter reachFilter){
        reachFilterService.uploadReachFilter(reachFilter);
        return "redirect:/admin/robot";
    }

    @RequestMapping(value = "/robot/addReachFilter", method = RequestMethod.POST)
    public String addReachFilter(@ModelAttribute("reachObj") ReachFilter reachFilter){
        reachFilterService.addReachFilter(reachFilter);
        return "redirect:/admin/robot";
    }


    @RequestMapping(value = "/robot/delReachFilter", method = RequestMethod.POST)
    public String delReachFilter(@ModelAttribute("reachObj") ReachFilter reachFilter){
        reachFilterService.deleteReachFilter(reachFilter);
        return "redirect:/admin/robot";
    }
}
