package com.springapp.mvc.service.interfaces.robots;

import com.springapp.mvc.domain.filters.robotFilters.ManufacturerFilter;

import java.util.List;

/**
 * Created by Vladislav on 01.03.2017.
 */
public interface ManufacturerFilterService {
    public List<ManufacturerFilter> listManufacturer();
    public ManufacturerFilter getManufacturer(String name);
    public void addManufacturer(String name);
}
