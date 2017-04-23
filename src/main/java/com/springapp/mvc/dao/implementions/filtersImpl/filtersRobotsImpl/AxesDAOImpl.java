package com.springapp.mvc.dao.implementions.filtersImpl.filtersRobotsImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersRobots.AxesDAO;
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

}
