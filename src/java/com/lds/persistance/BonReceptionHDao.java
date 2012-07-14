/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Bonreception;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class BonReceptionHDao implements BonReceptionDao {
    private List<Bonreception> bonreceptionList;
    private Bonreception bonreception;

    @Override
    public List getAllBonReceptions() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            bonreceptionList = session.createQuery("from Bonreception").list();
            return bonreceptionList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Bonreception getBonReception(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Bonreception as c where c.numreception =:id");
            q.setString("id", id);
            return (Bonreception) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Bonreception bonreception) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(bonreception);
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
    public void insert(Bonreception bonreception) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(bonreception);
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
            bonreception = (Bonreception) session.get(Bonreception.class, id);
            session.delete(bonreception);
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
