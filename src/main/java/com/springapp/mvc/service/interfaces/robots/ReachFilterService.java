package com.springapp.mvc.service.interfaces.robots;

import com.springapp.mvc.domain.filters.robotFilters.ReachFilter;

import java.util.List;

/**
 * Created by Vladislav on 19.03.2017.
 */
public interface ReachFilterService {
    public List<ReachFilter> getReachValues();
    public void addReachFilter(ReachFilter reachFilter);
    public void uploadReachFilter(ReachFilter reachFilter);
    public void deleteReachFilter(ReachFilter reachFilter);
    public ReachFilter getReachFilter(int index);
    public void changeNumPosition(ReachFilter reachFilter);
}
