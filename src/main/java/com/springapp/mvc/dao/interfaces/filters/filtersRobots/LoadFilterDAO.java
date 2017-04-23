package com.springapp.mvc.dao.interfaces.filters.filtersRobots;


import com.springapp.mvc.domain.filters.robotFilters.LoadFilter;

import java.util.List;

/**
 * Created by Vladislav on 15.03.2017.
 */
public interface LoadFilterDAO {
    public List<LoadFilter> getLoadValues();
    public void addLoadFilter(LoadFilter loadFilter);
    public void uploadLoadFilter(LoadFilter loadFilter);
    public void deleteLoadFilter(LoadFilter loadFilter);
    public LoadFilter getLoadFilter(int index);
    public void changeNumPosition(LoadFilter loadFilter);
}
