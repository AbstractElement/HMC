package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.ManufacturerFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.ManufacturerFilter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 01.03.2017.
 */
@Repository
public class ManufacturerFilterDAOImpl implements ManufacturerFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<ManufacturerFilter> listManufacturer() {
        return sessionFactory.getCurrentSession().createQuery("from ManufacturerFilter ").list();
    }

    @Override
    public ManufacturerFilter getManufacturer(String name) {
        return (ManufacturerFilter)sessionFactory.getCurrentSession().createQuery
                ("from ManufacturerFilter where nameManufacturer = ?").setString(0, name).uniqueResult();
    }

    @Override
    public void addManufacturer(String name) {
        ManufacturerFilter manufacturerFilter = new ManufacturerFilter();
        manufacturerFilter.setNameManufacturer(name);
        sessionFactory.getCurrentSession().saveOrUpdate(manufacturerFilter);
    }
}
