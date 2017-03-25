package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.LocationFilterDAO;
import com.springapp.mvc.domain.filters.LocationFilter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 01.03.2017.
 */
@Repository
public class LocationFilterDAOImpl implements LocationFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<LocationFilter> listLocation() {
        return sessionFactory.getCurrentSession().createQuery("from LocationFilter ").list();
    }

    @Override
    public void addLocation(LocationFilter location) {
        sessionFactory.getCurrentSession().saveOrUpdate(location);
    }

    @Override
    public LocationFilter getLocation(String location) {
        return (LocationFilter)sessionFactory.getCurrentSession().createQuery
                ("from LocationFilter where countryName = ?").setString(0, location).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LocationFilter> listRobotLocation() {
        return sessionFactory.getCurrentSession().createQuery("from LocationFilter where typeProduct = 'robot'").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<LocationFilter> listLiveToolLocation() {
        return sessionFactory.getCurrentSession().createQuery("from LocationFilter where typeProduct = 'livetool'").list();
    }
}
