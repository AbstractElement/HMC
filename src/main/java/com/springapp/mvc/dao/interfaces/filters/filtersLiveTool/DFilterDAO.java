package com.springapp.mvc.dao.interfaces.filters.filtersLiveTool;

import com.springapp.mvc.domain.filters.liveToolFilter.FilterDEntity;

import java.util.List;

/**
 * Created by Vladislav on 02.05.2017.
 */
public interface DFilterDAO {
    public List<FilterDEntity> listD();
    public FilterDEntity getD(int value);
    public void addD(FilterDEntity value);
}
