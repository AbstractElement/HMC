package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.DriveTypeFilterDAO;
import com.springapp.mvc.domain.filters.hmcFilter.DriveTypeFilter;
import com.springapp.mvc.service.interfaces.DriveTypeFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 25.03.2017.
 */
@Service
@Transactional
public class DriveTypeFilterServiceImpl implements DriveTypeFilterService {
    @Autowired
    private DriveTypeFilterDAO driveTypeFilterDAO;

    @Override
    public void addDriveType(DriveTypeFilter driveTypeFilter) {
        driveTypeFilterDAO.addDriveType(driveTypeFilter);
    }

    @Override
    public List<DriveTypeFilter> driveTypeList() {
        return driveTypeFilterDAO.driveTypeList();
    }
}
