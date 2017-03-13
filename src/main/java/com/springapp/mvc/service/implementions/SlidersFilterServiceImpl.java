package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.SlidersFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.SlidersFilter;
import com.springapp.mvc.service.interfaces.SlidersFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladislav on 02.03.2017.
 */
@Service
@Transactional
public class SlidersFilterServiceImpl implements SlidersFilterService {
    @Autowired
    private SlidersFilterDAO slidersFilterDAO;

    @Override
    public List<String> getAxes() {
        return slidersFilterDAO.getAxes();
    }

//    @Override
//    public List<String> getLoadName() {
//        return slidersFilterDAO.getLoadName();
//    }
//
//    @Override
//    public List<String> getReachName() {
//        return slidersFilterDAO.getReachName();
//    }

    @Override
    public List<String> getLoadValues() {
        return slidersFilterDAO.getLoadValues();
    }

    @Override
    public List<String> getReachValues() {
        return slidersFilterDAO.getReachValues();
    }

    @Override
    public List<SlidersFilter> getAllElements() {
        return slidersFilterDAO.getAllElements();
    }

    //
//    public Map<String, String> getLoadArr(){
//        Map<String, String> map = new HashMap<>();
//        List<String> loadValues = slidersFilterDAO.getLoadValues();
//        List<String> loadName = slidersFilterDAO.getLoadName();
//        for (int i = 0; i < loadName.size(); i++){
//            map.put(loadValues.get(i), loadName.get(i));
//        }
//        return map;
//    }
}
