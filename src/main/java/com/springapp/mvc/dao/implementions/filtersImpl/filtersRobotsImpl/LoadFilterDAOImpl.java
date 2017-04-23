package com.springapp.mvc.dao.implementions.filtersImpl.filtersRobotsImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersRobots.LoadFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.LoadFilter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 15.03.2017.
 */
@Repository
public class LoadFilterDAOImpl implements LoadFilterDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<LoadFilter> getLoadValues() {
        return sessionFactory.getCurrentSession().createQuery("from LoadFilter order by numPosition").list();
    }

    @Override
    public void uploadLoadFilter(LoadFilter loadFilter) {
        sessionFactory.getCurrentSession().saveOrUpdate(loadFilter);
    }

    @Override
    public void addLoadFilter(LoadFilter loadFilter) {
        sessionFactory.getCurrentSession().save(loadFilter);
    }

    @Override
    public void deleteLoadFilter(LoadFilter loadFilter) {
        sessionFactory.getCurrentSession().delete(loadFilter);
    }

    @Override
    public LoadFilter getLoadFilter(int index) {
        return (LoadFilter)sessionFactory.getCurrentSession().createQuery
                ("from LoadFilter where id = '" + index + "'").uniqueResult();
    }

    public void changeNumPosition(LoadFilter loadFilter){
        sessionFactory.getCurrentSession().createQuery("update LoadFilter set numPosition = numPosition + 1" +
                " where numPosition >= '" + loadFilter.getNumPosition() + "'");
    }
}
