package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.filters.robotFilters.LocationFilter;

import java.util.List;

/**
 * Created by Vladislav on 01.03.2017.
 */
public interface LocationFilterDAO {
    public List<LocationFilter> listLocation();
    public void addLocation(String location);
    public LocationFilter getLocation(String location);
}
