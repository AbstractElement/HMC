package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.filters.robotFilters.ManufacturerFilter;
import com.springapp.mvc.domain.filters.robotFilters.SlidersFilter;

import java.util.List;
import java.util.Map;

/**
 * Created by Vladislav on 02.03.2017.
 */
public interface SlidersFilterService {
    public List<String> getAxes();
    public List<String> getLoadValues();
//    public List<String> getLoadName();
    public List<String> getReachValues();
//    public List<String> getReachName();
//    public Map<String, String> getLoadArr();
    public List<SlidersFilter> getAllElements();
}
