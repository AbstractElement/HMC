package com.springapp.mvc.service.implementions.liveToolImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersLiveTool.DFilterDAO;
import com.springapp.mvc.domain.filters.liveToolFilter.FilterDEntity;
import com.springapp.mvc.service.interfaces.liveTool.DFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DFilterServiceImpl implements DFilterService{
    @Autowired
    private DFilterDAO filterDAO;

    @Override
    public List<FilterDEntity> listD() {
        return filterDAO.listD();
    }

    @Override
    public FilterDEntity getD(int value) {
        return filterDAO.getD(value);
    }

    @Override
    public void addD(FilterDEntity value) {
        filterDAO.addD(value);
    }
}
