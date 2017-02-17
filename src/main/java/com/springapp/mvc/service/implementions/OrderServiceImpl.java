package com.springapp.mvc.service.implementions;

import com.springapp.mvc.dao.interfaces.OrderDAO;
import com.springapp.mvc.domain.hmc.Order;
import com.springapp.mvc.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vladislav on 17.02.2017.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Override
    @Transactional
    public Order getOrder(int orderId) {
        return orderDAO.getOrder(orderId);
    }

    @Override
    @Transactional
    public void deleteOrder(int orderId) {
        orderDAO.deleteOrder(orderId);
    }
}
