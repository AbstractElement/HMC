package com.springapp.mvc.service.interfaces.liveTool;

import com.springapp.mvc.domain.filters.liveToolFilter.FilterDEntity;

import java.util.List;

/**
 * Created by Vladislav on 02.05.2017.
 */
public interface DFilterService {
    public List<FilterDEntity> listD();
    public FilterDEntity getD(int value);
    public void addD(FilterDEntity value);
}
