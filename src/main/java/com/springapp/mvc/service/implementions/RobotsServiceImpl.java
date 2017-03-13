package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.RobotsDAO;
import com.springapp.mvc.domain.robots.Robots;
import com.springapp.mvc.service.interfaces.RobotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
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

    @Override
    @Transactional
    public List<Robots> getRobotsList(String[] productsId){
        List<Robots> list = new ArrayList<Robots>();
        for (String productId : productsId) {
            Robots robots = robotsDAO.getRobot(productId);
            if (robots != null)
                list.add(robots);
        }
        return list;
    }

    @Override
    @Transactional
    public List<Robots> listFiltered(String manufacturer, String yearFrom, String yearTo, String axes,
                                     String load, String reach, String location) {
        String[] manufacturerArr = (manufacturer != null) ? manufacturer.split(",") : null;
        String[] yearArr = {yearFrom, yearTo};
        String[] axesArr = (axes != null) ? axes.split(",") : null;
        String[] loadArr = (load != null) ? load.split(",") : null;
        String[] reachArr = (reach != null) ? reach.split(",") : null;
        String[] locationArr = (location != null) ? location.split(",") : null;
        return robotsDAO.listFiltered(manufacturerArr, yearArr, axesArr, loadArr, reachArr, locationArr);
    }
}
