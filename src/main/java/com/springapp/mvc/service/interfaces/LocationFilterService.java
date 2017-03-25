package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.filters.LocationFilter;

import java.util.List;

/**
 * Created by Vladislav on 01.03.2017.
 */
public interface LocationFilterService {
    public List<LocationFilter> listLocation();
    public void addLocation(LocationFilter location);
    public LocationFilter getLocation(String location);
    public List<LocationFilter> listRobotLocation();
    public List<LocationFilter> listLiveToolLocation();
}
