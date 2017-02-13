package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.hmc.Hmc;

import java.util.List;

public interface HmcDAO {
    public List<Hmc> listMachine();
    public List<String[]> listMachineForSiteMap();
    public Hmc getMachine(String productId);
    public void addMachine(Hmc machine);
    public List<Hmc> listFiltered(String[] brandArr, String[] model, String[] priceRangeArr);
    public void editMachine(Hmc machine);
    public List<Hmc> randomListMachine();
    public List<Hmc> newArrivalsList();
}
