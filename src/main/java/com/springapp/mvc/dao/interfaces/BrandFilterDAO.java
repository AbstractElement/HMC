package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.hmc.BrandFilter;

import java.util.List;

/**
 * Created by Vladislav on 13.02.2017.
 */
public interface BrandFilterDAO {
    public List listBrand();
    public BrandFilter getBrand(String name);
    public void addBrand(String name);
}
