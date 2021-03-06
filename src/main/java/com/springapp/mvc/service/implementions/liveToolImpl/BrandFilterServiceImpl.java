//package com.springapp.mvc.service.implementions.liveToolImpl;
//
//import com.springapp.mvc.dao.interfaces.filters.BrandFilterDAO;
//import com.springapp.mvc.domain.filters.liveToolFilter.BrandFilter;
//import com.springapp.mvc.service.interfaces.liveTool.BrandFilterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * Created by Vladislav on 13.02.2017.
// */
//
//@Service
//public class BrandFilterServiceImpl implements BrandFilterService{
//    @Autowired
//    private BrandFilterDAO brandFilterDAO;
//
//    @Override
//    @Transactional
//    public BrandFilter getBrand(String name) {
//        return brandFilterDAO.getBrand(name);
//    }
//
//    @Override
//    @Transactional
//    @SuppressWarnings("unchecked")
//    public List<BrandFilter> listBrand() {
//        return brandFilterDAO.listBrand();
//    }
//
//    @Override
//    @Transactional
//    public void addBrand(String name) {
//        brandFilterDAO.addBrand(name);
//    }
//}
