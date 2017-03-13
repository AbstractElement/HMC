package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.filters.robotFilters.SlidersFilter;

import java.util.List;

/**
 * Created by Vladislav on 02.03.2017.
 */
public interface SlidersFilterDAO {
    public List<String> getAxes();
    public List<String> getLoadValues();
//    public List<String> getLoadName();
    public List<String> getReachValues();
//    public List<String> getReachName();
    public List<SlidersFilter> getAllElements();
}
