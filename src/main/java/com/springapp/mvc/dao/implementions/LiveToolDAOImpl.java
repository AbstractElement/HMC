package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.LiveToolDAO;
import com.springapp.mvc.domain.product.hmc.LiveTool;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LiveToolDAOImpl implements LiveToolDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<LiveTool> listMachine() {
        return sessionFactory.getCurrentSession().createQuery("from LiveTool where isSold = 'No'").list();
    }

    @SuppressWarnings("unchecked")
    public List<String[]> listMachineForSiteMap() {
        Query query = sessionFactory.getCurrentSession().createQuery("select productId, type, model from LiveTool where isSold = 'No'");
        return (List<String[]>) query.list();
    }

    @SuppressWarnings("unchecked")
    public LiveTool getMachine(String productId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from LiveTool where productId='" + productId + "'");
        return (LiveTool) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public void addMachine(LiveTool machine) {
        sessionFactory.getCurrentSession().saveOrUpdate(machine);
    }

    @SuppressWarnings("unchecked")
    public List<LiveTool> listFiltered(String[] brandArr, String[] countriesArr, String[] driveTypesArr, String[] toolHolderArr) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LiveTool.class);
        if (brandArr != null) {
            criteria.add(Restrictions.in("brand", brandArr));
        }
        if (countriesArr != null) {
            criteria.add(Restrictions.in("producingCountry", countriesArr));
        }
        if (driveTypesArr != null) {
            criteria.add(Restrictions.in("driveType", driveTypesArr));
        }
        if (toolHolderArr != null) {
            criteria.add(Restrictions.in("toolHolder", toolHolderArr));
        }
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
    public void editMachine(LiveTool machine) {
        sessionFactory.getCurrentSession().update(machine);
    }

    @SuppressWarnings("unchecked")
    public List<LiveTool> randomListMachine() {
        return sessionFactory.getCurrentSession().createQuery("from LiveTool where isSold = 'No' order by rand()").setMaxResults(4).list();
    }

    @SuppressWarnings("unchecked")
    public List<LiveTool> newArrivalsList() {
        Query query = sessionFactory.getCurrentSession().createQuery("from LiveTool where isSold = 'No'");
//        criteria.addOrder(Order.desc("productId")).setMaxResults(4);
            return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getLocationList() {
        return sessionFactory.getCurrentSession().createQuery("select distinct producingCountry from LiveTool ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getBrandsList() {
        return sessionFactory.getCurrentSession().createQuery("select distinct brand from LiveTool ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getDriveTypeList() {
        return sessionFactory.getCurrentSession().createQuery("select distinct driveType from LiveTool ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getToolHolderList() {
        return sessionFactory.getCurrentSession().createQuery("select distinct toolHolder from LiveTool ").list();
    }
}