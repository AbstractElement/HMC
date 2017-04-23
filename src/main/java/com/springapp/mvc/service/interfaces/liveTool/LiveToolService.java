package com.springapp.mvc.service.interfaces.liveTool;

import com.springapp.mvc.domain.product.hmc.LiveTool;

import java.util.List;

public interface LiveToolService {
    public List<LiveTool> listMachine();
    public List<String[]> listMachineForSiteMap();
    public LiveTool getMachine(String productId);
    public List<LiveTool> getMachinesList(String[] productIdArr);
    public List<LiveTool> listFiltered(String brands, String model, String priceFrom, String priceTo);
    public void editMachine(LiveTool machine);
    public List<LiveTool> randomListMachine();
    public List<LiveTool> newArrivalsList();
    public List<String> getLocationList();
    public List<String> getBrandsList();
    public List<String> getDriveTypeList();
    public List<String> getToolHolderList();
}
