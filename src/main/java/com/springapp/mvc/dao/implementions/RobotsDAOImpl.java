package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.RobotsDAO;
import com.springapp.mvc.domain.robots.Robots;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
    @SuppressWarnings("unchecked")
    public void addRobot(Robots robot) {
        sessionFactory.getCurrentSession().saveOrUpdate(robot);
    }

    @Override
    public Robots getRobot(String product_id) {
        return (Robots)sessionFactory.getCurrentSession().
                createQuery("from Robots where productId = ?").setParameter(0, product_id).uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Robots> listRobots() {
        return sessionFactory.getCurrentSession().createQuery("from Robots").list();
    }

    @Override
    public void editRobot(Robots robot){
        sessionFactory.getCurrentSession().update(robot);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Robots> listFiltered(String[] manufacturers, String[] years, String[] axesArr, String[] loadArr,
                                     String[] reachArr, String[] locations) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Robots.class);
        if (manufacturers != null)
            criteria.add(Restrictions.in("manufacturer", manufacturers));
        if (years != null) {
            if (!years[0].equals("") && !years[1].equals(""))
                criteria.add(Restrictions.between("year", Integer.parseInt(years[0]),
                        Integer.parseInt(years[1])));
            else if(!years[0].equals(""))
                criteria.add(Restrictions.ge("year", Integer.parseInt(years[0])));
            else if(!years[1].equals(""))
                criteria.add(Restrictions.le("year", Integer.parseInt(years[1])));
        }
        if (axesArr != null) {
            criteria.add(Restrictions.in("axes", axesArr));
        }
        if (loadArr != null) {
            if (!loadArr[0].equals("") && !loadArr[1].equals(""))
                criteria.add(Restrictions.between("load", Integer.parseInt(loadArr[0]),
                        Integer.parseInt(loadArr[1])));
            else if(!loadArr[0].equals(""))
                criteria.add(Restrictions.ge("load", Integer.parseInt(loadArr[0])));
            else if(!loadArr[1].equals(""))
                criteria.add(Restrictions.le("load", Integer.parseInt(loadArr[1])));
        }
        if (reachArr != null) {
            if (!reachArr[0].equals("") && !reachArr[1].equals(""))
                criteria.add(Restrictions.between("reach", Integer.parseInt(reachArr[0]),
                        Integer.parseInt(reachArr[1])));
            else if(!reachArr[0].equals(""))
                criteria.add(Restrictions.ge("reach", Integer.parseInt(reachArr[0])));
            else if(!reachArr[1].equals(""))
                criteria.add(Restrictions.le("reach", Integer.parseInt(reachArr[1])));
        }
        if (locations != null)
            criteria.add(Restrictions.in("location", locations));
        return criteria.list();
    }

}
