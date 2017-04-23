package com.springapp.mvc.service.implementions.liveToolImpl;

import com.springapp.mvc.dao.interfaces.LiveToolDAO;
import com.springapp.mvc.domain.product.hmc.LiveTool;
import com.springapp.mvc.service.interfaces.liveTool.LiveToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LiveToolServiceImpl implements LiveToolService {

    @Autowired
    private LiveToolDAO liveToolDAO;

    @Transactional
    public List<LiveTool> listMachine() {
        return liveToolDAO.listMachine();
    }

    @Transactional
    public List<String[]> listMachineForSiteMap(){
        return liveToolDAO.listMachineForSiteMap();
    }

    @Transactional
    public LiveTool getMachine(String productId) {
        return liveToolDAO.getMachine(productId);
    }

    @Transactional
    public List<LiveTool> listFiltered(String brands, String countries, String driveTypes, String toolHolders) {
        String[] brandArr = (brands != null) ? brands.split(",") : null;
        String[] countriesArr = (countries != null) ? countries.split(",") : null;
        String[] driveTypesArr = (driveTypes != null) ? driveTypes.split(",") : null;
        String[] toolHoldersArr = (toolHolders != null) ? toolHolders.split(",") : null;
        return liveToolDAO.listFiltered(brandArr, countriesArr, driveTypesArr, toolHoldersArr);
    }

    private int[] getRangeArr(String range) {
        return new int[]{Integer.valueOf(range.split(",")[0]), Integer.valueOf(range.split(",")[1])};
    }

    @Transactional
    public List<LiveTool> getMachinesList(String[] productIdArr) {
        List<LiveTool> list = new ArrayList<LiveTool>();
        for (String productId : productIdArr) {
            LiveTool hmc = liveToolDAO.getMachine(productId);
            if (hmc != null)
                list.add(hmc);
        }
        return list;
    }

    @Transactional
    public void editMachine(LiveTool machine) {
        liveToolDAO.editMachine(machine);
    }

    @Transactional
    public List<LiveTool> randomListMachine() {
        return liveToolDAO.randomListMachine();
    }

    @Transactional
    public List<LiveTool> newArrivalsList() {
        return liveToolDAO.newArrivalsList();
    }

    @Override
    @Transactional
    public List<String> getLocationList() {
        return liveToolDAO.getLocationList();
    }

    @Override
    @Transactional
    public List<String> getBrandsList() {
        return liveToolDAO.getBrandsList();
    }

    @Override
    @Transactional
    public List<String> getDriveTypeList() {
        return liveToolDAO.getDriveTypeList();
    }

    @Override
    @Transactional
    public List<String> getToolHolderList() {
        return liveToolDAO.getToolHolderList();
    }
}