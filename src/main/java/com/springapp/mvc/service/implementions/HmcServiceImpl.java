package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.HmcDAO;
import com.springapp.mvc.domain.hmc.Hmc;
import com.springapp.mvc.service.interfaces.HmcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HmcServiceImpl implements HmcService {

    @Autowired
    private HmcDAO hmcDAO;

    @Transactional
    public List<Hmc> listMachine() {
        return hmcDAO.listMachine();
    }

    @Transactional
    public List<String[]> listMachineForSiteMap(){
        return hmcDAO.listMachineForSiteMap();
    }

    @Transactional
    public Hmc getMachine(String productId) {
        return hmcDAO.getMachine(productId);
    }

    @Transactional
    public List<Hmc> listFiltered(String brands, String model, String priceFrom, String priceTo) {
        String[] brandArr = (brands != null) ? brands.split(",") : null;
        String[] modelArr = (model != null) ? model.split(",") : null;
        String[] priceRangeArr = {priceFrom, priceTo};
        return hmcDAO.listFiltered(brandArr, modelArr, priceRangeArr);
    }

    private int[] getRangeArr(String range) {
        return new int[]{Integer.valueOf(range.split(",")[0]), Integer.valueOf(range.split(",")[1])};
    }

    @Transactional
    public List<Hmc> getMachinesList(String[] productIdArr) {
        List<Hmc> list = new ArrayList<Hmc>();
        for (String productId : productIdArr) {
            Hmc hmc = hmcDAO.getMachine(productId);
            if (hmc != null)
                list.add(hmc);
        }
        return list;
    }

    @Transactional
    public void editMachine(Hmc machine) {
        hmcDAO.editMachine(machine);
    }

    @Transactional
    public List<Hmc> randomListMachine() {
        return hmcDAO.randomListMachine();
    }

    @Transactional
    public List<Hmc> newArrivalsList() {
        return hmcDAO.newArrivalsList();
    }

    @Override
    @Transactional
    public List<String> getLocationList() {
        return hmcDAO.getLocationList();
    }

    @Override
    @Transactional
    public List<String> getBrandsList() {
        return hmcDAO.getBrandsList();
    }

    @Override
    @Transactional
    public List<String> getDriveType() {
        return hmcDAO.getDriveTypeList();
    }
}