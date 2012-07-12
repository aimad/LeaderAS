/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Fournisseur;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class FournisseurHDao implements FournisseurDao {

    private List<Fournisseur> fournisseurList;
    private Fournisseur fournisseur;

    @Override
    public List getAllFournisseurs() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            fournisseurList = session.createQuery("from Fournisseur").list();
            return fournisseurList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Fournisseur getFournisseur(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Fournisseur as c where c.idfournisseur =:id");
            q.setString("id", id);
            return (Fournisseur) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Fournisseur fournisseur) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(fournisseur);
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
    public void insert(Fournisseur fournisseur) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(fournisseur);
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
            fournisseur = (Fournisseur) session.get(Fournisseur.class, id);
            session.delete(fournisseur);
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
