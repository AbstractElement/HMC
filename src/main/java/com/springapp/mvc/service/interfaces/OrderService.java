package com.springapp.mvc.service.interfaces;

import com.springapp.mvc.domain.product.hmc.Order;

/**
 * Created by Vladislav on 17.02.2017.
 */
public interface OrderService {
    public void addOrder(Order order);
    public Order getOrder(int orderId);
    public void deleteOrder(int orderId);
}
