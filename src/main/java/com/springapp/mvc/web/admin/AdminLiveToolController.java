package com.springapp.mvc.web.admin;

import com.springapp.mvc.domain.filters.NamesTypeProducts;
import com.springapp.mvc.domain.filters.LocationFilter;
import com.springapp.mvc.domain.filters.hmcFilter.DriveTypeFilter;
import com.springapp.mvc.domain.filters.hmcFilter.ToolHolderFilter;
import com.springapp.mvc.domain.product.hmc.LiveTool;
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

/**
 * Created by Vladislav on 25.03.2017.
 */
@Controller
@RequestMapping("/admin")
public class AdminLiveToolController {

    @Autowired
    private WorkWithFilesService workWithFilesService;

    @Autowired
    private BrandFilterService brandFilterService;

    @Autowired
    private LocationFilterService locationFilterService;

    @Autowired
    private DriveTypeFilterService driveTypeFilterService;

    @Autowired
    private ToolHolderService toolHolderService;

    @Autowired
    private LiveToolService liveToolService;

    @RequestMapping(value="/hmc", method = RequestMethod.GET)
    public void hmc(Map<String,Object> map) {
        List<LiveTool> machineList = liveToolService.listMachine();
        map.put("machineList", machineList);
        AdminController.putPagesInfo(map, machineList.size(), 10);
    }

    @RequestMapping(value = "/hmc/edit", method = RequestMethod.POST)
    public String editMachine(@ModelAttribute("machine") LiveTool machine){
        liveToolService.editMachine(machine);
//        brandFilterService.addBrand(machine.getBrand());
        return "redirect:/admin/hmc";
    }

    @RequestMapping(value = "/hmc/renewFiltersLiveTool", method = RequestMethod.POST)
    public String renewLivaToolFilters(){
        for (String location : liveToolService.getLocationList()){
            LocationFilter locationFilter = new LocationFilter();
            locationFilter.setCountryName(location);
            locationFilter.setTypeProduct(NamesTypeProducts.LIVE_TOOL);
            locationFilterService.addLocation(locationFilter);
        }
        liveToolService.getBrandsList().forEach(brandFilterService::addBrand);
        for(String driveType : liveToolService.getDriveTypeList()){
            DriveTypeFilter driveTypeFilter = new DriveTypeFilter();
            driveTypeFilter.setDriveType(driveType);
            driveTypeFilterService.addDriveType(driveTypeFilter);
        }
        for(String toolHolder : liveToolService.getToolHolderList()){
            ToolHolderFilter toolHolderFilter = new ToolHolderFilter();
            toolHolderFilter.setToolHolder(toolHolder);
            toolHolderService.addToolHolder(toolHolderFilter);
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
