package com.springapp.mvc.dao.interfaces;

import com.springapp.mvc.domain.product.hmc.Order;

/**
 * Created by Vladislav on 17.02.2017.
 */
public interface OrderDAO {
    public void addOrder(Order order);
    public Order getOrder(int orderId);
    public void deleteOrder(int orderId);
}
