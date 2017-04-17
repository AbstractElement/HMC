package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.product.hmc.LiveTool;

import java.util.List;

public interface LiveToolDAO {
    public List<LiveTool> listMachine();
    public List<String[]> listMachineForSiteMap();
    public LiveTool getMachine(String productId);
    public void addMachine(LiveTool machine);
    public List<LiveTool> listFiltered(String[] brandArr, String[] countriesArr, String[] driveTypesArr, String[] toolHoldersArr);
    public void editMachine(LiveTool machine);
    public List<LiveTool> randomListMachine();
    public List<LiveTool> newArrivalsList();
    public List<String> getLocationList();
    public List<String> getBrandsList();
    public List<String> getDriveTypeList();
    public List<String> getToolHolderList();
}
