package com.springapp.mvc.service.interfaces.robots;

import com.springapp.mvc.domain.filters.robotFilters.LoadFilter;

import java.util.List;

/**
 * Created by Vladislav on 15.03.2017.
 */
public interface LoadFilterService {
    public List<LoadFilter> getLoadValues();
    public LoadFilter getLoadFilter(int index);
    public void addLoadFilter(LoadFilter loadFilter);
    public void uploadLoadFilter(LoadFilter loadFilter);
    public void deleteLoadFilter(LoadFilter loadFilter);
    public void changeNumPosition(LoadFilter loadFilter);
}
