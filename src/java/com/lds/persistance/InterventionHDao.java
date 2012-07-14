/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.HibernateUtil;
import com.lds.vo.Intervention;
import com.lds.vo.InterventionId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ELKAOUMI
 */
public class InterventionHDao implements InterventionDao {
    private List<Intervention> interventionList;
    private Intervention intervention;

    @Override
    public List getAllIntervention() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            interventionList = session.createQuery("from Intervention").list();
            return interventionList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Intervention getIntervention(InterventionId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Intervention  where idprojet=:idprojet and idintervention=:idintervention");
            q.setString("idprojet", id.getIdprojet());
            q.setString("idintervention", id.getIdintervention());
            return (Intervention) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Intervention affaire) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(affaire);
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
    public void insert(Intervention affaire) {
         Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(affaire);
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
    public void delete(InterventionId id) {
             Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            intervention = (Intervention) session.get(Intervention.class, id);
            session.delete(intervention);
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
