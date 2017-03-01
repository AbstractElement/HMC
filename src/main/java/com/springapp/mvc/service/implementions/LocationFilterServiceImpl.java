package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.LocationFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.LocationFilter;
import com.springapp.mvc.service.interfaces.LocationFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 01.03.2017.
 */
@Repository
@Transactional
public class LocationFilterServiceImpl implements LocationFilterService {
    @Autowired
    private LocationFilterDAO locationFilterDAO;

    @Override
    public List<LocationFilter> listLocation() {
        return locationFilterDAO.listLocation();
    }

    @Override
    public void addLocation(String location) {
        locationFilterDAO.addLocation(location);
    }

    @Override
    public LocationFilter getLocation(String location) {
        return locationFilterDAO.getLocation(location);
    }
}
