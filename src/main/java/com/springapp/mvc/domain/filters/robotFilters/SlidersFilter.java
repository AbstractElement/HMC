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

//    private String load;

    private String xReach;

    private String yReach;

    private String zReach;

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
//
//    public String getLoad() {
//        return load;
//    }
//
//    public void setLoad(String load) {
//        this.load = load;
//    }

    public String getxReach() {
        return xReach;
    }

    public void setxReach(String xReach) {
        this.xReach = xReach;
    }

    public String getyReach() {
        return yReach;
    }

    public void setyReach(String yReach) {
        this.yReach = yReach;
    }

    public String getzReach() {
        return zReach;
    }

    public void setzReach(String zReach) {
        this.zReach = zReach;
    }
}
