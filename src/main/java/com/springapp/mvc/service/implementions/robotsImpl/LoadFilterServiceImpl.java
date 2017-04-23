package com.springapp.mvc.service.implementions.robotsImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersRobots.LoadFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.LoadFilter;
import com.springapp.mvc.service.interfaces.robots.LoadFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 15.03.2017.
 */
@Service
@Transactional
public class LoadFilterServiceImpl implements LoadFilterService {
    @Autowired
    private LoadFilterDAO loadFilterDAO;

    @Override
    public List<LoadFilter> getLoadValues() {
        return loadFilterDAO.getLoadValues();
    }

    @Override
    public void addLoadFilter(LoadFilter loadFilter) {
        loadFilterDAO.addLoadFilter(loadFilter);
    }

    @Override
    public void uploadLoadFilter(LoadFilter loadFilter) {
        loadFilterDAO.uploadLoadFilter(loadFilter);
    }

    @Override
    public void deleteLoadFilter(LoadFilter loadFilter) {
        loadFilterDAO.deleteLoadFilter(loadFilter);
    }

    @Override
    public LoadFilter getLoadFilter(int index) {
        return loadFilterDAO.getLoadFilter(index);
    }

    @Override
    public void changeNumPosition(LoadFilter loadFilter) {
        loadFilterDAO.changeNumPosition(loadFilter);
    }
}
