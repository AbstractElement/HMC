package com.springapp.mvc.service.implementions.robotsImpl;

import com.springapp.mvc.dao.interfaces.filters.filtersRobots.ReachFilterDAO;
import com.springapp.mvc.domain.filters.robotFilters.ReachFilter;
import com.springapp.mvc.service.interfaces.robots.ReachFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 19.03.2017.
 */

@Service
@Transactional
public class ReachFilterServiceImpl implements ReachFilterService {
    @Autowired
    private ReachFilterDAO reachFilterDAO;

    @Override
    public List<ReachFilter> getReachValues() {
        return reachFilterDAO.getReachValues();
    }

    @Override
    public void addReachFilter(ReachFilter reachFilter) {
        reachFilterDAO.addReachFilter(reachFilter);
    }

    @Override
    public void uploadReachFilter(ReachFilter reachFilter) {
        reachFilterDAO.uploadReachFilter(reachFilter);
    }

    @Override
    public void deleteReachFilter(ReachFilter reachFilter) {
        reachFilterDAO.deleteReachFilter(reachFilter);
    }

    @Override
    public ReachFilter getReachFilter(int index) {
        return reachFilterDAO.getReachFilter(index);
    }

    @Override
    public void changeNumPosition(ReachFilter reachFilter) {
        reachFilterDAO.changeNumPosition(reachFilter);
    }
}
