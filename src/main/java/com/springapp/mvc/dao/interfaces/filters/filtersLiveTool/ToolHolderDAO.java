package com.springapp.mvc.dao.interfaces.filters.filtersLiveTool;

import com.springapp.mvc.domain.filters.liveToolFilter.ToolHolderFilter;

import java.util.List;

/**
 * Created by Vladislav on 27.03.2017.
 */
public interface ToolHolderDAO {
    public void addToolHolder(ToolHolderFilter toolHolderFilter);
    public List<ToolHolderFilter> toolHolderList();
}
