package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.RobotsDAO;
import com.springapp.mvc.domain.robots.Robots;
import com.springapp.mvc.service.interfaces.RobotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;

/**
 * Created by Vladislav on 24.02.2017.
 */
@Service
public class RobotsServiceImpl implements RobotsService {
    @Autowired
    private RobotsDAO robotsDAO;

    @Override
    @Transactional
    public void addRobot(Robots robot) {
        robotsDAO.addRobot(robot);
    }

    @Override
    @Transactional
    public Robots getRobot(String id) {
        return robotsDAO.getRobot(id);
    }

    @Override
    @Transactional
    public List<Robots> listRobots() {
        return robotsDAO.listRobots();
    }

    @Override
    @Transactional
    public void editRobot(Robots robots){
       robotsDAO.editRobot(robots);
    }
}
