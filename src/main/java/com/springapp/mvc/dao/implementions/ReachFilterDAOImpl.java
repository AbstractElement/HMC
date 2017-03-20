package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.ReachFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.LoadFilter;
import com.springapp.mvc.domain.filters.robotFilters.ReachFilter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 19.03.2017.
 */
@Repository
public class ReachFilterDAOImpl implements ReachFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<ReachFilter> getReachValues() {
        return sessionFactory.getCurrentSession().createQuery("from ReachFilter order by numPosition").list();
    }

    @Override
    public void addReachFilter(ReachFilter reachFilter) {
        sessionFactory.getCurrentSession().saveOrUpdate(reachFilter);
    }

    @Override
    public void uploadReachFilter(ReachFilter reachFilter) {
        sessionFactory.getCurrentSession().saveOrUpdate(reachFilter);
    }

    @Override
    public void deleteReachFilter(ReachFilter reachFilter) {
        sessionFactory.getCurrentSession().delete(reachFilter);
    }

    @Override
    public ReachFilter getReachFilter(int index) {
        return (ReachFilter)sessionFactory.getCurrentSession().
                createQuery("from ReachFilter where id = '" + index + "'").uniqueResult();
    }

    @Override
    public void changeNumPosition(ReachFilter reachFilter) {
        sessionFactory.getCurrentSession().createQuery("update ReachFilter set numPosition = numPosition + 1" +
                " where numPosition >= '" + reachFilter.getNumPosition() + "'");
    }
}
