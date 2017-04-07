package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.ToolHolderDAO;
import com.springapp.mvc.domain.filters.hmcFilter.ToolHolderFilter;
import com.springapp.mvc.service.interfaces.ToolHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 27.03.2017.
 */
@Service
@Transactional
public class ToolHolderServiceImpl implements ToolHolderService {
    @Autowired
    private ToolHolderDAO toolHolderDAO;

    @Override
    public void addToolHolder(ToolHolderFilter toolHolderFilter) {
        toolHolderDAO.addToolHolder(toolHolderFilter);
    }

    @Override
    public List<ToolHolderFilter> toolHolderList() {
        return toolHolderDAO.toolHolderList();
    }
}
