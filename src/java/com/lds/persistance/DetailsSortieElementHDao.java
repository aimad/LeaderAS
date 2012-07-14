/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailssortieelement;
import com.lds.vo.DetailssortieelementId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsSortieElementHDao implements DetailsSortieElementDao{
    
    private List<Detailssortieelement> detailssortieelementList;
    private Detailssortieelement detailssortieelement;

    @Override
    public List getAllDetailsSortieElement() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailssortieelementList = session.createQuery("from Detailssortieelement").list();
            return detailssortieelementList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailssortieelement getDetailsSortieElement(DetailssortieelementId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailssortieelement  where idelement=:idelement and idsortie=:idsortie");
            q.setString("idelement", id.getIdelement());
            q.setString("idsortie", id.getIdsortie());
            return (Detailssortieelement) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailssortieelement detailssortieelement) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailssortieelement);
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
    public void insert(Detailssortieelement detailssortieelement) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detailssortieelement);
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
    public void delete(DetailssortieelementId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailssortieelement = (Detailssortieelement) session.get(Detailssortieelement.class, id);
            session.delete(detailssortieelement);
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
