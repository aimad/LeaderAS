/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsdemandeelement;
import com.lds.vo.DetailsdemandeelementId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsDemandeElementHDao implements DetailsDemandeElementDao {
    
    private List<Detailsdemandeelement> detailsdemandeelementList;
    private Detailsdemandeelement detailsdemandeelement;

    @Override
    public List getAllDetailsDemandeElement() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsdemandeelementList = session.createQuery("from Detailsdemandeelement").list();
            return detailsdemandeelementList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsdemandeelement getDetailsDemandeElement(DetailsdemandeelementId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsdemandeelement  where idelement=:idelement and numdemandeprix=:numdemandeprix");
            q.setString("idelement", id.getIdelement());
            q.setString("numdemandeprix", id.getNumdemandeprix());
            return (Detailsdemandeelement) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsdemandeelement detailsdemandeelement) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsdemandeelement);
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
    public void insert(Detailsdemandeelement detailsdemandeelement) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detailsdemandeelement);
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
    public void delete(DetailsdemandeelementId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsdemandeelement = (Detailsdemandeelement) session.get(Detailsdemandeelement.class, id);
            session.delete(detailsdemandeelement);
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
