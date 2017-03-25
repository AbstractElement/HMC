package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.filters.hmcFilter.DriveTypeFilter;

import java.util.List;

/**
 * Created by Vladislav on 25.03.2017.
 */
public interface DriveTypeFilterDAO {
    public void addDriveType(DriveTypeFilter driveTypeFilter);
    public List<DriveTypeFilter> driveTypeList();
}
