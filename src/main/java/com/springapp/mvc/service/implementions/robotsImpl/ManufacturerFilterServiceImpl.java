package com.springapp.mvc.service.implementions.robotsImpl;

import com.springapp.mvc.dao.interfaces.filters.ManufacturerFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.ManufacturerFilter;
import com.springapp.mvc.service.interfaces.robots.ManufacturerFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 01.03.2017.
 */
@Service
@Transactional
public class ManufacturerFilterServiceImpl implements ManufacturerFilterService{
    @Autowired
    private ManufacturerFilterDAO manufacturerFilterDAO;

    @Override
    public List<ManufacturerFilter> listManufacturer() {
        return manufacturerFilterDAO.listManufacturer();
    }

    @Override
    public ManufacturerFilter getManufacturer(String name) {
        return manufacturerFilterDAO.getManufacturer(name);
    }

    @Override
    public void addManufacturer(String name) {
        manufacturerFilterDAO.addManufacturer(name);
    }
}
