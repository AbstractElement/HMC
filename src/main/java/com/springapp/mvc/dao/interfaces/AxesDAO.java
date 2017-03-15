package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.filters.robotFilters.AxesFilter;

import java.util.List;

/**
 * Created by Vladislav on 02.03.2017.
 */
public interface AxesDAO {
    public List<String> getAxes();
//    public List<String> getReachValues();
//    public List<AxesFilter> getAllElements();
//    public void addAxesFilter(AxesFilter axesFilter);
//    public void uploadAxesFilter(AxesFilter axesFilter);
//    public void deleteAxesFilter(AxesFilter axesFilter);
}
