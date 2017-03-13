package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.SlidersFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.SlidersFilter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 02.03.2017.
 */
@Repository
public class SlidersFilterDAOImpl implements SlidersFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getAxes() {
        return sessionFactory.getCurrentSession().createQuery("select axes from SlidersFilter ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getLoadValues() {
        return sessionFactory.getCurrentSession().createQuery("select loadValues from SlidersFilter order by loadValues").list();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<String> getLoadName() {
//        return sessionFactory.getCurrentSession().createQuery("select loadName from SlidersFilter").list();
//    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getReachValues() {
        return sessionFactory.getCurrentSession().createQuery("select reachValues from SlidersFilter order by reachValues").list();
    }

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<String> getReachName() {
//        return sessionFactory.getCurrentSession().createQuery("select reachName from SlidersFilter").list();
//    }

    @SuppressWarnings("unchecked")
    public List<SlidersFilter> getAllElements(){
        return sessionFactory.getCurrentSession().createCriteria(SlidersFilter.class).list();
    }
}
