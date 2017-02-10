package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.HmcDAO;
import com.springapp.mvc.domain.hmc.Hmc;
import org.eclipse.persistence.jpa.rs.util.list.QueryList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HmcDAOImpl implements HmcDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Hmc> listMachine() {
        return sessionFactory.getCurrentSession().createQuery("from Hmc where isSold = 'No'").list();
    }

    @SuppressWarnings("unchecked")
    public List<String[]> listMachineForSiteMap() {
        Query query = sessionFactory.getCurrentSession().createQuery("select productId, type, model from Hmc where isSold = 'No'");
        return (List<String[]>) query.list();
    }

    @SuppressWarnings("unchecked")
    public Hmc getMachine(String productId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hmc where productId='" + productId + "'");
        return (Hmc) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public void addMachine(Hmc machine) {
        sessionFactory.getCurrentSession().saveOrUpdate(machine);
    }

    @SuppressWarnings("unchecked")
    public List<Hmc> listFiltered(String[] brandArr, String[] model, int[] priceRangeArr) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Hmc.class);
        if (brandArr != null) {
            criteria.add(Restrictions.in("brand", brandArr));
        }
        if (model != null) {
            criteria.add(Restrictions.in("model", model));
        }
        if (priceRangeArr != null) {
            criteria.add(Restrictions.between("price", priceRangeArr[0], priceRangeArr[1]));
        }
//        if (locationArr != null) {
//            criteria.add(Restrictions.in("machineLocationEn", locationArr));
//        }
//        if (cncArr != null) {
//            criteria.add(Restrictions.in("systemCNC", cncArr));
//        }
//        if (xMotionRangeArr != null) {
//            criteria.add(Restrictions.between("xMotion", xMotionRangeArr[0], xMotionRangeArr[1]));
//        }
//        if (yMotionRangeArr != null) {
//            criteria.add(Restrictions.between("yMotion", yMotionRangeArr[0], yMotionRangeArr[1]));
//        }
//        if (zMotionRangeArr != null) {
//            criteria.add(Restrictions.between("zMotion", zMotionRangeArr[0], zMotionRangeArr[1]));
//        }
//        if (xTableSizeRangeArr != null) {
//            criteria.add(Restrictions.between("xTableSize", xTableSizeRangeArr[0], xTableSizeRangeArr[1]));
//        }
//        if (yTableSizeRangeArr != null) {
//            criteria.add(Restrictions.between("yTableSize", yTableSizeRangeArr[0], yTableSizeRangeArr[1]));
//        }
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public void editMachine(Hmc machine) {
        sessionFactory.getCurrentSession().update(machine);
    }

    @SuppressWarnings("unchecked")
    public List<Hmc> randomListMachine() {
        return sessionFactory.getCurrentSession().createQuery("from Hmc where isSold = 'No' order by rand()").setMaxResults(4).list();
    }

    @SuppressWarnings("unchecked")
    public List<Hmc> newArrivalsList() {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hmc where isSold = 'No'");
//        criteria.addOrder(Order.desc("productId")).setMaxResults(4);
            return query.list();
    }

}