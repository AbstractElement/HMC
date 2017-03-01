package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.LocationFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.LocationFilter;
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
    public void addLocation(String location) {
        LocationFilter locationFilter = new LocationFilter();
        locationFilter.setCountryName(location);
        sessionFactory.getCurrentSession().saveOrUpdate(locationFilter);
    }

    @Override
    public LocationFilter getLocation(String location) {
        return (LocationFilter)sessionFactory.getCurrentSession().createQuery
                ("from LocationFilter where countryName = ?").setString(0, location).uniqueResult();
    }
}
