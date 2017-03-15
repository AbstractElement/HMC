package com.springapp.mvc.domain.filters.robotFilters;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vladislav on 15.03.2017.
 */

@Entity
@Table(name = "filter_load", catalog = "hmc_example")
public class LoadFilter {
    @Id
    private int id;

    private String loadValue;

    private int numPosition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(int numPosition) {
        this.numPosition = numPosition;
    }

    public String getLoadValue() {
        return loadValue;
    }

    public void setLoadValue(String loadValue) {
        this.loadValue = loadValue;
    }
}
