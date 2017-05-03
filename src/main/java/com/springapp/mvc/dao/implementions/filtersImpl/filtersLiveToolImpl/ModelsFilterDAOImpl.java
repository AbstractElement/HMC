package com.springapp.mvc.dao.implementions.filtersImpl.filtersLiveToolImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersLiveTool.ModelsFilterDAO;
import com.springapp.mvc.domain.filters.liveToolFilter.FilterModelEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by Vladislav on 02.05.2017.
 */
@Repository
public class ModelsFilterDAOImpl implements ModelsFilterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<FilterModelEntity> listModels() {
        return sessionFactory.getCurrentSession().createQuery("from FilterModelEntity ").list();
    }

    @Override
    public FilterModelEntity getModel(String model) {
        return (FilterModelEntity)sessionFactory.getCurrentSession().createQuery
                ("from FilterModelEntity where model = ?").setParameter(0, model).uniqueResult();
    }

    @Override
    public void addModel(FilterModelEntity model) {
        sessionFactory.getCurrentSession().saveOrUpdate(model);
    }
}
