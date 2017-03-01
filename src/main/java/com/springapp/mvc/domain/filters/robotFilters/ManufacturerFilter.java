package com.springapp.mvc.domain.filters.robotFilters;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Vladislav on 28.02.2017.
 */

@Entity
@Table(name = "manufacturer_filter", catalog = "hmc_example")
public class ManufacturerFilter {
    @Id
    private int id;

    private String nameManufacturer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameManufacturer() {
        return nameManufacturer;
    }

    public void setNameManufacturer(String nameManufacturer) {
        this.nameManufacturer = nameManufacturer;
    }
}
