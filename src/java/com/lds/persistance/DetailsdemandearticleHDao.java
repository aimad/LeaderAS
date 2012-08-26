/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsdemandearticle;
import com.lds.vo.DetailsdemandearticleId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsdemandearticleHDao implements DetailsdemandearticleDao {
    
       private List<Detailsdemandearticle> detailsdemandearticleList;
    private Detailsdemandearticle detailsdemandearticle;

    @Override
    public List getAllDetailsdemandearticle() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsdemandearticleList = session.createQuery("from Detailsdemandearticle").list();
            return detailsdemandearticleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
      
    @Override
    public Detailsdemandearticle getDetailsdemandearticle(DetailsdemandearticleId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsdemandearticle  where numdemandeprix=:numdemandeprix and idarticle=:idarticle");
            q.setString("numdemandeprix", id.getNumdemandeprix());
            q.setString("idarticle", id.getIdarticle());
            return (Detailsdemandearticle) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsdemandearticle detailsdemandearticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsdemandearticle);
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
    public void insert(Detailsdemandearticle detailsdemandearticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detailsdemandearticle);
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
    public void delete(DetailsdemandearticleId id) {
       Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsdemandearticle = (Detailsdemandearticle) session.get(Detailsdemandearticle.class, id);
            session.delete(detailsdemandearticle);
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
