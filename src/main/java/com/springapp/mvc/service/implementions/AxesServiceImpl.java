package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.AxesDAO;
import com.springapp.mvc.domain.filters.robotFilters.AxesFilter;
import com.springapp.mvc.service.interfaces.AxesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 02.03.2017.
 */
@Service
@Transactional
public class AxesServiceImpl implements AxesService {
    @Autowired
    private AxesDAO axesDAO;

    @Override
    public List<String> getAxes() {
        return axesDAO.getAxes();
    }

//    @Override
//    public List<String> getLoadValues() {
//        return axesDAO.getLoadValues();
//    }
//
//    @Override
//    public List<String> getReachValues() {
//        return axesDAO.getReachValues();
//    }
//
//    @Override
//    public List<SlidersFilter> getAllElements() {
//        return axesDAO.getAllElements();
//    }
//
//    @Override
//    public void uploadAxesFilter(AxesFilter axesFilter) {
//        axesDAO.uploadSlidersFilter(axesFilter);
//    }
//
//    @Override
//    public void deleteAxesFilter(AxesFilter axesFilter) {
//        axesDAO.deleteSlidersFilter(axesFilter);
//    }
//
//    @Override
//    public void addAxesFilter(AxesFilter axesFilter) {
//        axesDAO.addSlidersFilter(axesFilter);
//    }
//
//    public String[] sortedFilter(List<String> filter){
//        String[] filtersArr = new String[filter.size()];
//        int i = 0;
//        for (String filterElem : filter)
//            if (filterElem != null && !filterElem.equals("")) {
//                filtersArr[i] = filterElem;
//                i++;
//            }
//
//        return filtersArr;
//    }
}
