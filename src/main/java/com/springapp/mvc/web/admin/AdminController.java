package com.springapp.mvc.web.admin;

import com.springapp.mvc.domain.User;

import com.springapp.mvc.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    private HmcService hmcService;

    @Autowired
    private UserService userService;

    @Autowired
    private WorkWithFilesService workWithFilesService;


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

    static void putPagesInfo(Map<String, Object> map, int itemsNum, int itemsPerPage) {
        int pagesNum = itemsNum / itemsPerPage;
        if (itemsNum % itemsPerPage != 0) {
            pagesNum++;
        }
        map.put("itemsPerPage", itemsPerPage);
        map.put("itemsNum", itemsNum);
        map.put("pagesNum", pagesNum);
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
