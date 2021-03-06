/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Bonsortie;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class BonSortieHDao implements BonSortieDao{
    
    private List<Bonsortie> bonsortieList;
    private Bonsortie bonsortie;

    @Override
    public List getAllBonSorties() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            bonsortieList = session.createQuery("from Bonsortie").list();
            return bonsortieList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Bonsortie getBonSortie(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Bonsortie as c where c.idsortie =:id");
            q.setString("id", id);
            return (Bonsortie) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Bonsortie bonsortie) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(bonsortie);
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
    public void insert(Bonsortie bonsortie) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(bonsortie);
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
            bonsortie = (Bonsortie) session.get(Bonsortie.class, id);
            session.delete(bonsortie);
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
