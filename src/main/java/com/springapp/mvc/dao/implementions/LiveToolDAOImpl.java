package com.springapp.mvc.dao.implementions;

import com.springapp.mvc.dao.interfaces.LiveToolDAO;
import com.springapp.mvc.domain.product.hmc.LiveToolEntity;
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
    public List<LiveToolEntity> listMachine() {
        return sessionFactory.getCurrentSession().createQuery("from LiveToolEntity where isSold = 'No'").list();
    }

    @SuppressWarnings("unchecked")
    public List<String[]> listMachineForSiteMap() {
        Query query = sessionFactory.getCurrentSession().createQuery("select productId, type, model from LiveToolEntity where isSold = 'No'");
        return (List<String[]>) query.list();
    }

    @SuppressWarnings("unchecked")
    public LiveToolEntity getMachine(String productId) {
        Query query = sessionFactory.getCurrentSession().createQuery("from LiveToolEntity where productId='" + productId + "'");
        return (LiveToolEntity) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public void addMachine(LiveToolEntity machine) {
        sessionFactory.getCurrentSession().saveOrUpdate(machine);
    }

    @SuppressWarnings("unchecked")
    public List<LiveToolEntity> listFiltered(String[] modelsArr, String[] dArr) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LiveToolEntity.class);
        if (modelsArr != null) {
            criteria.add(Restrictions.in("model", modelsArr));
        }
        if (dArr != null) {
            Integer[] dIntArr = new Integer[dArr.length];
            for (int i = 0; i < dIntArr.length; i++){
                dIntArr[i] = Integer.parseInt(dArr[i]);
            }
            criteria.add(Restrictions.in("d", dIntArr));
        }
//        if (driveTypesArr != null) {
//            criteria.add(Restrictions.in("driveType", driveTypesArr));
//        }
//        if (toolHolderArr != null) {
//            criteria.add(Restrictions.in("toolHolder", toolHolderArr));
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
    public void editMachine(LiveToolEntity machine) {
        sessionFactory.getCurrentSession().update(machine);
    }

    @SuppressWarnings("unchecked")
    public List<LiveToolEntity > randomListMachine() {
        return sessionFactory.getCurrentSession().createQuery("from LiveToolEntity where isSold = 'No' order by rand()").setMaxResults(4).list();
    }

    @SuppressWarnings("unchecked")
    public List<LiveToolEntity > newArrivalsList() {
        Query query = sessionFactory.getCurrentSession().createQuery("from LiveToolEntity where isSold = 'No'");
//        criteria.addOrder(Order.desc("productId")).setMaxResults(4);
            return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getModels() {
        return sessionFactory.getCurrentSession().createQuery("select distinct model from LiveToolEntity ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Integer> getD() {
        return sessionFactory.getCurrentSession().createQuery("select distinct d from LiveToolEntity ").list();
    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<String> getDriveTypeList() {
//        return sessionFactory.getCurrentSession().createQuery("select distinct driveType from LiveTool ").list();
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<String> getToolHolderList() {
//        return sessionFactory.getCurrentSession().createQuery("select distinct toolHolder from LiveTool ").list();
//    }
}