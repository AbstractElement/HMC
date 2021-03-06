package com.springapp.mvc.domain.filters.robotFilters;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vladislav on 02.03.2017.
 */
@Entity
@Table(name = "filter_axes", catalog = "hmc_example")
public class AxesFilter {
    @Id
    private int id;

    private String axes;

    private int numPosition;

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

    public int getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(int numPosition) {
        this.numPosition = numPosition;
    }
}
