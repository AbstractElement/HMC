package com.springapp.mvc.domain.filters.robotFilters;

import javax.persistence.*;

/**
 * Created by Vladislav on 19.03.2017.
 */

@Entity
@Table(name = "filter_reach", catalog = "hmc_example")
public class ReachFilter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String reachValue;

    private int numPosition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReachValue() {
        return reachValue;
    }

    public void setReachValue(String reachValue) {
        this.reachValue = reachValue;
    }

    public int getNumPosition() {
        return numPosition;
    }

    public void setNumPosition(int numPosition) {
        this.numPosition = numPosition;
    }
}
