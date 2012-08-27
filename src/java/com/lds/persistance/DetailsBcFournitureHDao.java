/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsfourniturebc;
import com.lds.vo.DetailsfourniturebcId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsBcFournitureHDao implements DetailsBcFournitureDao {
     private List<Detailsfourniturebc> detailsbcfournitureList;
    private Detailsfourniturebc detailsbcfourniture;

    @Override
    public List getAllDetailsbcfournitures() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbcfournitureList = session.createQuery("from Detailsfourniturebc").list();
            return detailsbcfournitureList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
 public List getDetailsfourniturebcs_id(String id_bc) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbcfournitureList = session.createQuery("from Detailsfourniturebc where numbc='"+id_bc+"'").list();
            return detailsbcfournitureList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsfourniturebc getDetailsbcfourniture(DetailsfourniturebcId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsfourniturebc  where numbc =:numbc and numfourniture =:numfourniture");
            q.setString("numbc", id.getNumbc());
            q.setString("numfourniture", id.getNumfourniture());
            return (Detailsfourniturebc) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsfourniturebc detailsbcfourniture) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsbcfourniture);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void insert(Detailsfourniturebc detailsbcfourniture) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsbcfourniture);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(DetailsfourniturebcId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsbcfourniture = (Detailsfourniturebc) session.get(Detailsfourniturebc.class, id);
            session.delete(detailsbcfourniture);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }

    }
}

