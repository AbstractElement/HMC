package com.springapp.mvc.service.implementions.liveToolImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersLiveTool.ModelsFilterDAO;
import com.springapp.mvc.domain.filters.liveToolFilter.FilterModelEntity;
import com.springapp.mvc.service.interfaces.liveTool.ModelsFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ModelsFilterServiceImpl implements ModelsFilterService{
    @Autowired
    private ModelsFilterDAO modelsFilterDAO;

    @Override
    public List<FilterModelEntity> listModels() {
        return modelsFilterDAO.listModels();
    }

    @Override
    public FilterModelEntity getModel(String model) {
        return modelsFilterDAO.getModel(model);
    }

    @Override
    public void addModel(FilterModelEntity model) {
        modelsFilterDAO.addModel(model);
    }
}
