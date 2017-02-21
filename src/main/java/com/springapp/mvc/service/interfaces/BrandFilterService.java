package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.filters.BrandFilter;

import java.util.List;

/**
 * Created by Vladislav on 13.02.2017.
 */
public interface BrandFilterService {
    public List listBrand();
    public BrandFilter getBrand(String name);
    public void addBrand(String name);
}
