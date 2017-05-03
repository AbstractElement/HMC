package com.springapp.mvc.service.interfaces.liveTool;

import com.springapp.mvc.domain.product.hmc.LiveToolEntity;

import java.util.List;

public interface LiveToolService {
    public List<LiveToolEntity> listMachine();
    public List<String[]> listMachineForSiteMap();
    public LiveToolEntity getMachine(String productId);
    public List<LiveToolEntity> getMachinesList(String[] productIdArr);
    public List<LiveToolEntity> listFiltered(String models, String d);
    public void editMachine(LiveToolEntity machine);
    public List<LiveToolEntity> randomListMachine();
    public List<LiveToolEntity> newArrivalsList();
    public List<String> getModels();
    public List<Integer> getD();
//    public List<String> getDriveTypeList();
//    public List<String> getToolHolderList();
}
