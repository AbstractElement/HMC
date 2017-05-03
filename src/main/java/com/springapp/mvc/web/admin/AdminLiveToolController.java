package com.springapp.mvc.web.admin;

import com.springapp.mvc.domain.filters.liveToolFilter.FilterDEntity;
import com.springapp.mvc.domain.filters.liveToolFilter.FilterModelEntity;
import com.springapp.mvc.domain.product.hmc.LiveToolEntity;
import com.springapp.mvc.service.interfaces.*;
import com.springapp.mvc.service.interfaces.liveTool.DFilterService;
import com.springapp.mvc.service.interfaces.liveTool.LiveToolService;
import com.springapp.mvc.service.interfaces.liveTool.ModelsFilterService;
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
public class AdminLiveToolController {

    @Autowired
    private WorkWithFilesService workWithFilesService;

    @Autowired
    private ModelsFilterService modelsFilterService;

    @Autowired
    private DFilterService dFilterService;

    @Autowired
    private LiveToolService liveToolService;

    @RequestMapping(value="/hmc", method = RequestMethod.GET)
    public void hmc(Map<String,Object> map) {
        List<LiveToolEntity> machineList = liveToolService.listMachine();
        map.put("machineList", machineList);
        AdminController.putPagesInfo(map, machineList.size(), 10);
    }

    @RequestMapping(value = "/hmc/edit", method = RequestMethod.POST)
    public String editMachine(@ModelAttribute("machine") LiveToolEntity machine){
        liveToolService.editMachine(machine);
//        brandFilterService.addBrand(machine.getBrand());
        return "redirect:/admin/hmc";
    }
//
    @RequestMapping(value = "/hmc/renewFiltersLiveTool", method = RequestMethod.POST)
    public String renewLivaToolFilters(){
        for (String model : liveToolService.getModels()){
            FilterModelEntity filterModelEntity = new FilterModelEntity();
            filterModelEntity.setModel(model);
            modelsFilterService.addModel(filterModelEntity);
        }
        for(int d : liveToolService.getD()){
            FilterDEntity driveTypeFilter = new FilterDEntity();
            driveTypeFilter.setValue(d);
            dFilterService.addD(driveTypeFilter);
        }
        return "redirect:/admin/hmc";
    }

    @RequestMapping(value = "/hmc/upload", method = RequestMethod.POST)
    public String adminUploadHmcFromFiles(@RequestParam("textFile") MultipartFile[] machines, HttpServletRequest request){
        if (machines != null && machines.length > 0) {
            String path = request.getServletContext().getRealPath("") + "/resources/";
            workWithFilesService.uploadMachines(path, machines);
        }
        return "redirect:/admin/hmc";
    }
}
