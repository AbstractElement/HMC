package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.OrderDAO;
import com.springapp.mvc.domain.hmc.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladislav on 17.02.2017.
 */

@Repository
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order getOrder(int orderId) {
        return (Order)sessionFactory.getCurrentSession().createQuery("from Order where orderId = ?").setParameter(0, orderId);
    }

    @Override
    public void deleteOrder(int orderId) {
        sessionFactory.getCurrentSession().createQuery("delete from Order where orderId = ?").setParameter(0, orderId);
    }
}
