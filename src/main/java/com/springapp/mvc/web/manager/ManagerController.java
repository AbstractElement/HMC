package com.springapp.mvc.web.manager;

import com.springapp.mvc.domain.product.Letter;
import com.springapp.mvc.domain.product.hmc.Order;
import com.springapp.mvc.service.interfaces.WorkWithFilesService;
import com.springapp.mvc.util.EmailUtil;
import com.springapp.mvc.util.cart.shopping.ShoppingCart;
import com.springapp.mvc.util.cart.shopping.ShoppingCartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

@Controller
@RequestMapping("/managerplace")
public class ManagerController {
    @Autowired
    private WorkWithFilesService workWithFilesService;

    @Autowired
    private EmailUtil emailUtil;

    @RequestMapping(method = RequestMethod.GET)
    public String formLetter(ModelMap modelMap){
        modelMap.put("letter", new Letter());
        return "manager_letter";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String updateLetter(@RequestParam("textFile")MultipartFile letter,
                               HttpServletRequest request,
                               ModelMap modelMap){
        String path = request.getServletContext().getRealPath("") + "/resources/";
        modelMap.put("letter", workWithFilesService.uploadInformationLetter(path, letter));
        return "manager_letter";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String checkoutPost(@ModelAttribute Letter letter,
                               Map<String, Object> map) throws Exception {
        map.put("from", "vladis19tr@gmail.com");
        map.put("to", letter.getEmail());
        map.put("subject", "New proposal");
        map.put("bcclist", new ArrayList<>());
        map.put("letter", letter);
        emailUtil.sendEmail("letter.vm", map);
        return "redirect:/managerplace/manager_letter";
    }

    @RequestMapping(value = "/getPDF", method = RequestMethod.POST)
    public ResponseEntity<byte[]> getPdf(@ModelAttribute Letter letter,
                                         HttpServletRequest request) throws Exception {
        String path = request.getServletContext().getRealPath("") + "/resources";
        return workWithFilesService.getPDFLetter(path, letter);
    }
}
