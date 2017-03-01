package com.springapp.mvc.web;

import com.springapp.mvc.domain.hmc.Hmc;

import com.springapp.mvc.domain.User;

import com.springapp.mvc.domain.robots.Robots;
import com.springapp.mvc.service.interfaces.*;
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

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BrandFilterService brandFilterService;

    @Autowired
    private HmcService hmcService;

    @Autowired
    private RobotsService robotsService;

    @Autowired
    private UserService userService;

    @Autowired
    private WorkWithFilesService workWithFilesService;

    @Autowired
    private ManufacturerFilterService manufacturerFilterService;

    @Autowired
    private LocationFilterService locationFilterService;

    @RequestMapping(method = RequestMethod.GET)
    public String admin(HttpServletRequest request) {
        if(request.isUserInRole("ROLE_ADMIN")){
            return "redirect:/admin/hmc";
        }
        return "redirect:/admin/adminEntry";
    }

    @RequestMapping(value = "/adminEntry", method = RequestMethod.GET)
    public void adminEntry(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Map<String,Object> map) {
        if (error != null) {
            map.put("error", "Invalid username or password!");
        }
        if (logout != null) {
            map.put("msg", "You've been logged out successfully.");
        }
    }

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public void users(Map<String,Object> map) {
        List<User> userList = userService.listUsers();
        map.put("userList", userList);
        putPagesInfo(map, userList.size(), 20);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String changeUserRole(@RequestParam("userId") String num,
                                 @RequestParam("userRole") String role) {
        userService.setUserRole(num, role);
        return "redirect:/admin/users";
    }
    
    @RequestMapping(value="/hmc", method = RequestMethod.GET)
    public void hmc(Map<String,Object> map) {
        List<Hmc> machineList = hmcService.listMachine();
        map.put("machineList", machineList);
        putPagesInfo(map, machineList.size(), 10);
    }

    @RequestMapping(value = "/robot", method = RequestMethod.GET)
    public void robot(Map<String, Object> map){
        List<Robots> robotsList = robotsService.listRobots();
        map.put("machine", new Robots());
        map.put("robotList", robotsList);
        putPagesInfo(map, robotsList.size(), 10);
    }

    private void putPagesInfo(Map<String, Object> map, int itemsNum, int itemsPerPage) {
        int pagesNum = itemsNum / itemsPerPage;
        if (itemsNum % itemsPerPage != 0) {
            pagesNum++;
        }
        map.put("itemsPerPage", itemsPerPage);
        map.put("itemsNum", itemsNum);
        map.put("pagesNum", pagesNum);
    }

    @RequestMapping(value = "/hmc/edit", method = RequestMethod.POST)
     public String editMachine(@ModelAttribute("machine") Hmc machine){
        hmcService.editMachine(machine);
        brandFilterService.addBrand(machine.getBrand());
        return "redirect:/admin/hmc";
    }

    @RequestMapping(value = "/robot/edit", method = RequestMethod.POST)
    public String editRobot(@ModelAttribute("machine") Robots machine){
        robotsService.editRobot(machine);
        manufacturerFilterService.addManufacturer(machine.getManufacturer());
        locationFilterService.addLocation(machine.getLocation());
        return "redirect:/admin/robot";
    }

    @RequestMapping(value = "/hmc/upload", method = RequestMethod.POST)
    public String adminUploadHmcFromFiles(@RequestParam("textFile") MultipartFile[] machines, HttpServletRequest request){
        if (machines != null && machines.length > 0) {
            String path = request.getServletContext().getRealPath("") + "/resources/";
            workWithFilesService.uploadMachines(path, machines);
        }
        return "redirect:/admin/hmc";
    }

    @RequestMapping(value = "/robot/upload", method = RequestMethod.POST)
    public String adminUploadRobotFromFiles(@RequestParam("textFile") MultipartFile[] machines, HttpServletRequest request){
        if (machines != null && machines.length > 0) {
            String path = request.getServletContext().getRealPath("") + "/resources/";
            workWithFilesService.uploadRobot(path, machines);
        }
        return "redirect:/admin/robot";
    }

    @RequestMapping(value = "/gallery", method = RequestMethod.GET)
    public void gallery(HttpServletRequest request, Map<String,Object> map){
        String path = request.getServletContext().getRealPath("") + "/resources/images/products";
        map.put("imageList", workWithFilesService.listImage(path));
    }

    @RequestMapping(value = "/gallery/upload", method = RequestMethod.POST)
    public String adminUploadImages(@RequestParam("imageCollection") MultipartFile[] images, HttpServletRequest request){
        if (images != null && images.length > 0) {
            String path = request.getServletContext().getRealPath("") + "/resources/images/products";
            workWithFilesService.uploadImages(path, images);
        }
        return "redirect:/admin/gallery";
    }

    @RequestMapping(value = "/gallery/remove", method = RequestMethod.GET)
    public String removeImage(@RequestParam("image") String image, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("") + "/resources/images/products";
        workWithFilesService.removeImage(path,image);
        return "redirect:/admin/gallery";
    }
    



}
