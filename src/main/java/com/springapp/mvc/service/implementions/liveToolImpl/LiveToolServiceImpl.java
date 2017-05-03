package com.springapp.mvc.service.implementions.liveToolImpl;

import com.springapp.mvc.dao.interfaces.LiveToolDAO;
import com.springapp.mvc.domain.product.hmc.LiveToolEntity;
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
    public List<LiveToolEntity> listMachine() {
        return liveToolDAO.listMachine();
    }

    @Transactional
    public List<String[]> listMachineForSiteMap(){
        return liveToolDAO.listMachineForSiteMap();
    }

    @Transactional
    public LiveToolEntity getMachine(String productId) {
        return liveToolDAO.getMachine(productId);
    }

    @Transactional
    public List<LiveToolEntity> listFiltered(String models, String d) {
        String[] modelArr = (models != null) ? models.split(",") : null;
        String[] dArr = (d != null) ? d.split(",") : null;
        return liveToolDAO.listFiltered(modelArr, dArr);
    }

    private int[] getRangeArr(String range) {
        return new int[]{Integer.valueOf(range.split(",")[0]), Integer.valueOf(range.split(",")[1])};
    }

    @Transactional
    public List<LiveToolEntity> getMachinesList(String[] productIdArr) {
        List<LiveToolEntity> list = new ArrayList<LiveToolEntity>();
        for (String productId : productIdArr) {
            LiveToolEntity hmc = liveToolDAO.getMachine(productId);
            if (hmc != null)
                list.add(hmc);
        }
        return list;
    }

    @Transactional
    public void editMachine(LiveToolEntity machine) {
        liveToolDAO.editMachine(machine);
    }

    @Transactional
    public List<LiveToolEntity> randomListMachine() {
        return liveToolDAO.randomListMachine();
    }

    @Transactional
    public List<LiveToolEntity> newArrivalsList() {
        return liveToolDAO.newArrivalsList();
    }

    @Override
    @Transactional
    public List<String> getModels() {
        return liveToolDAO.getModels();
    }

    @Override
    @Transactional
    public List<Integer> getD() {
        return liveToolDAO.getD();
    }
//
//    @Override
//    @Transactional
//    public List<String> getDriveTypeList() {
//        return liveToolDAO.getDriveTypeList();
//    }
//
//    @Override
//    @Transactional
//    public List<String> getToolHolderList() {
//        return liveToolDAO.getToolHolderList();
//    }
}