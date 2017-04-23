package com.springapp.mvc.dao.implementions.filtersImpl.filtersLiveToolImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersLiveTool.ToolHolderDAO;
import com.springapp.mvc.domain.filters.liveToolFilter.ToolHolderFilter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ToolHolderDAOImpl implements ToolHolderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addToolHolder(ToolHolderFilter toolHolderFilter) {
        sessionFactory.getCurrentSession().saveOrUpdate(toolHolderFilter);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<ToolHolderFilter> toolHolderList() {
        return sessionFactory.getCurrentSession().createCriteria(ToolHolderFilter.class).list();
    }
}
