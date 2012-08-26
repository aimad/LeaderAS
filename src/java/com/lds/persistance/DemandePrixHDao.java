/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Demandeprix;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ELKAOUMI
 */
public class DemandePrixHDao implements DemandePrixDao {

    private List<Demandeprix> DemandePrixList;
    private List<Demandeprix> DemandePrixList1;
    private Demandeprix demandePrix;

    @Override
    public List getAllDevis() {
          Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            DemandePrixList = session.createQuery("from Demandeprix").list();
            return DemandePrixList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }    

    public Demandeprix getDevis(String id) {
         Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Demandeprix as c where c.numdemandeprix=:id");
            q.setString("id", id);
            return (Demandeprix) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Demandeprix demandePrix) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(demandePrix);
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
    public void insert(Demandeprix demandePrix) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(demandePrix);
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
    public void delete(String id) {
          Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            demandePrix = (Demandeprix) session.get(Demandeprix.class, id);
            session.delete(demandePrix);
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
