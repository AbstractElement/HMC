package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.RobotsDAO;
import com.springapp.mvc.domain.robots.Robots;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 24.02.2017.
 */

@Repository
public class RobotsDAOImpl implements RobotsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRobot(Robots robot) {
        sessionFactory.getCurrentSession().saveOrUpdate(robot);
    }

    @Override
    public Robots getRobot(int id) {
        return (Robots)sessionFactory.getCurrentSession().createQuery("from Robots where id = ?").setParameter(0, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Robots> listRobots() {
        return sessionFactory.getCurrentSession().createQuery("from Robots").list();
    }
}
