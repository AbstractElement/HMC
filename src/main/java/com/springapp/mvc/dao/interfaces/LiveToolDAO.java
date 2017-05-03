package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.product.hmc.LiveToolEntity;

import java.util.List;

public interface LiveToolDAO {
    public List<LiveToolEntity> listMachine();
    public List<String[]> listMachineForSiteMap();
    public LiveToolEntity getMachine(String productId);
    public void addMachine(LiveToolEntity machine);
    public List<LiveToolEntity> listFiltered(String[] modelsArr, String[] dArr);
    public void editMachine(LiveToolEntity machine);
    public List<LiveToolEntity> randomListMachine();
    public List<LiveToolEntity> newArrivalsList();
    public List<String> getModels();
    public List<Integer> getD();
//    public List<String> getDriveTypeList();
//    public List<String> getToolHolderList();
}
