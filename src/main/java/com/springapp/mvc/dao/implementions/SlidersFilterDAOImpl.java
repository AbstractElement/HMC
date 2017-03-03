package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.SlidersFilterDAO;
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
    public List<String> getAxes() {
        return sessionFactory.getCurrentSession().createQuery("select axes from SlidersFilter ").list();
    }
}
