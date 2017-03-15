package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.AxesDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 02.03.2017.
 */
@Repository
public class AxesDAOImpl implements AxesDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getAxes() {
        return sessionFactory.getCurrentSession().createQuery("select axes from AxesFilter ").list();
    }
//
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<String> getReachValues() {
//        return sessionFactory.getCurrentSession().createQuery("select reachValues from SlidersFilter order by reachValues").list();
//    }
//
//    @SuppressWarnings("unchecked")
//    public List<SlidersFilter> getAllElements(){
//        return sessionFactory.getCurrentSession().createCriteria(SlidersFilter.class).list();
//    }
//
//    @Override
//    public void uploadAxesFilter(AxesFilter axesFilter) {
//        sessionFactory.getCurrentSession().saveOrUpdate(axesFilter);
//    }
//
//    @Override
//    public void addAxesFilter(AxesFilter axesFilter) {
//        sessionFactory.getCurrentSession().save(axesFilter);
//    }
//
//    @Override
//    public void deleteAxesFilter(AxesFilter axesFilter) {
//        sessionFactory.getCurrentSession().delete(axesFilter);
//    }
}
