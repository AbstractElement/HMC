package com.springapp.mvc.service.interfaces.liveTool;

import com.springapp.mvc.domain.filters.liveToolFilter.FilterModelEntity;

import java.util.List;

/**
 * Created by Vladislav on 02.05.2017.
 */
public interface ModelsFilterService {
    public List<FilterModelEntity> listModels();
    public FilterModelEntity getModel(String model);
    public void addModel(FilterModelEntity model);
}
