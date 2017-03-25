package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.filters.hmcFilter.DriveTypeFilter;

import java.util.List;

/**
 * Created by Vladislav on 25.03.2017.
 */
public interface DriveTypeFilterService {
    public void addDriveType(DriveTypeFilter driveTypeFilter);
    public List<DriveTypeFilter> driveTypeList();
}
