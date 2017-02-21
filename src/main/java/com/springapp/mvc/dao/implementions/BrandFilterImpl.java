package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.BrandFilterDAO;
import com.springapp.mvc.filters.BrandFilter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by Vladislav on 13.02.2017.
 */
@Repository
public class BrandFilterImpl implements BrandFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<BrandFilter> listBrand() {
        return sessionFactory.getCurrentSession().createQuery("from BrandFilter").list();
    }

    @Override
    public BrandFilter getBrand(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery("from BrandFilter where brand = '" + name + "'");
        return (BrandFilter)query.uniqueResult();
    }

    @Override
    public void addBrand(String name) {
        BrandFilter brandFilter = new BrandFilter();
        brandFilter.setBrand(name);
        sessionFactory.getCurrentSession().saveOrUpdate(brandFilter);
    }
}
