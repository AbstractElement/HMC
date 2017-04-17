package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.product.robots.Robots;

import java.util.List;

/**
 * Created by Vladislav on 24.02.2017.
 */
public interface RobotsDAO {
    public void addRobot(Robots robot);
    public Robots getRobot(String product_id);
    public List<Robots> listRobots();
    public void editRobot(Robots robot);
    public List<Robots> listFiltered(String[] manufacturers, String[] years,
                                     String[] axesArr, String[] loadArr, String[] reachArr, String[] locations);
    public List<String> getLocationList();
}
