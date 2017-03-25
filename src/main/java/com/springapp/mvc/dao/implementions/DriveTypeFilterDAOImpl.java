package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.DriveTypeFilterDAO;
import com.springapp.mvc.domain.filters.hmcFilter.DriveTypeFilter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 25.03.2017.
 */

@Repository
public class DriveTypeFilterDAOImpl implements DriveTypeFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDriveType(DriveTypeFilter driveTypeFilter) {
        sessionFactory.getCurrentSession().saveOrUpdate(driveTypeFilter);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DriveTypeFilter> driveTypeList() {
        return sessionFactory.getCurrentSession().createCriteria(DriveTypeFilter.class).list();
    }
}
