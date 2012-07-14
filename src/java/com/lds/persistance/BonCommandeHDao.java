/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Boncommande;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class BonCommandeHDao implements BonCommandeDao{

 private List<Boncommande> boncommandeList;
 private Boncommande boncommande;

    @Override
    public List getAllBonCommandes() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            boncommandeList = session.createQuery("from Boncommande").list();
            return boncommandeList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Boncommande getBonCommande(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Boncommande as c where c.numbc =:id");
            q.setString("id", id);
            return (Boncommande) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Boncommande boncommande) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(boncommande);
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
    public void insert(Boncommande boncommande) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(boncommande);
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
            boncommande = (Boncommande) session.get(Boncommande.class, id);
            session.delete(boncommande);
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
