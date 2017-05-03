//package com.springapp.mvc.dao.implementions.filtersImpl.filtersLiveToolImpl;
//
//import com.springapp.mvc.dao.interfaces.filters.filtersLiveTool.DriveTypeFilterDAO;
//import com.springapp.mvc.domain.filters.liveToolFilter.DriveTypeFilter;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * Created by Vladislav on 25.03.2017.
// */
//
//@Repository
//public class DriveTypeFilterDAOImpl implements DriveTypeFilterDAO {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void addDriveType(DriveTypeFilter driveTypeFilter) {
//        sessionFactory.getCurrentSession().saveOrUpdate(driveTypeFilter);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<DriveTypeFilter> driveTypeList() {
//        return sessionFactory.getCurrentSession().createCriteria(DriveTypeFilter.class).list();
//    }
//}
