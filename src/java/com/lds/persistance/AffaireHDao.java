/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Affaire;
import com.lds.vo.AffaireId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ELKAOUMI
 */
public class AffaireHDao  implements AffaireDao{
    private List<Affaire> affaireList;
    private Affaire affaire;

    @Override
    public List getAllAffaire() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            affaireList = session.createQuery("from Affaire").list();
            return affaireList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Affaire getAffaire(AffaireId id) {
       Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Affaire  where idprojet=:idprojet and numaffaire=:numaffaire");
            q.setString("idprojet", id.getIdprojet());
            q.setString("numaffaire", id.getNumaffaire());
            return (Affaire) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Affaire affaire) {
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
    public void insert(Affaire affaire) {
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
    public void delete(AffaireId id) {
       Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            affaire = (Affaire) session.get(Affaire.class, id);
            session.delete(affaire);
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
    

