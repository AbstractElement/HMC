package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.filters.hmcFilter.ToolHolderFilter;

import java.util.List;

/**
 * Created by Vladislav on 27.03.2017.
 */
public interface ToolHolderService {
    public void addToolHolder(ToolHolderFilter toolHolderFilter);
    public List<ToolHolderFilter> toolHolderList();
}