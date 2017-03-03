package com.springapp.mvc.domain.filters.robotFilters;

import javax.persistence.*;

/**
 * Created by Vladislav on 28.02.2017.
 */

@Entity
@Table(name = "location_filter", catalog = "hmc_example")
public class LocationFilter {
    @GeneratedValue
    private int id;

    @Id
    @Column(name = "countryName")
    private String countryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
