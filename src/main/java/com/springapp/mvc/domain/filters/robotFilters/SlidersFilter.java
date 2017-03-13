package com.springapp.mvc.domain.filters.robotFilters;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vladislav on 02.03.2017.
 */
@Entity
@Table(name = "sliders_filter", catalog = "hmc_example")
public class SlidersFilter {
    @Id
    private int id;

    private String axes;

    private String loadValues;

//    private String loadName;

    private String reachValues;

//    private String reachName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAxes() {
        return axes;
    }

    public void setAxes(String axes) {
        this.axes = axes;
    }

    public String getLoadValues() {
        return loadValues;
    }

    public void setLoadValues(String loadValues) {
        this.loadValues = loadValues;
    }
//
//    public String getLoadName() {
//        return loadName;
//    }
//
//    public void setLoadName(String loadName) {
//        this.loadName = loadName;
//    }

    public String getReachValues() {
        return reachValues;
    }

    public void setReachValues(String reachValues) {
        this.reachValues = reachValues;
    }

//    public String getReachName() {
//        return reachName;
//    }
//
//    public void setReachName(String reachName) {
//        this.reachName = reachName;
//    }
}
