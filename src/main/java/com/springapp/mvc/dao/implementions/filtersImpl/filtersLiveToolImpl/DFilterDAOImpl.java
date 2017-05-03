package com.springapp.mvc.dao.implementions.filtersImpl.filtersLiveToolImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersLiveTool.DFilterDAO;
import com.springapp.mvc.domain.filters.liveToolFilter.FilterDEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladislav on 02.05.2017.
 */
@Repository
public class DFilterDAOImpl implements DFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<FilterDEntity> listD() {
        return sessionFactory.getCurrentSession().createCriteria(FilterDEntity.class).list();
    }

    @Override
    public FilterDEntity getD(int value) {
        return (FilterDEntity)sessionFactory.getCurrentSession().createQuery
                ("from FilterDEntity where value = ?").setParameter(0, value).uniqueResult();
    }

    @Override
    public void addD(FilterDEntity d) {
        sessionFactory.getCurrentSession().saveOrUpdate(d);
    }
}
