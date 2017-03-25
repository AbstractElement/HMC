package com.springapp.mvc.domain.filters;

import javax.persistence.*;

/**
 * Created by Vladislav on 28.02.2017.
 */

@Entity
@Table(name = "filter_location", catalog = "hmc_example")
public class LocationFilter {
    @GeneratedValue
    private int id;

    @Id
    @Column(name = "countryName")
    private String countryName;

    private String typeProduct;

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

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }
}
