package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.robots.Robots;

import java.util.List;

/**
 * Created by Vladislav on 24.02.2017.
 */
public interface RobotsDAO {
    public void addRobot(Robots robot);
    public Robots getRobot(int id);
    public List<Robots> listRobots();
}
