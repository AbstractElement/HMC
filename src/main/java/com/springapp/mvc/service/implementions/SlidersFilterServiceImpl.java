package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.SlidersFilterDAO;
import com.springapp.mvc.service.interfaces.SlidersFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
