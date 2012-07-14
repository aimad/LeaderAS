/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsbcelement;
import com.lds.vo.DetailsbcelementId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsBCElementHDao implements DetailsBCElementDao {
    private List<Detailsbcelement> detailsbcelementList;
    private Detailsbcelement detailsbcelement;

    @Override
    public List getAllDetailsBCElement() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbcelementList = session.createQuery("from Detailsbcelement").list();
            return detailsbcelementList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsbcelement getDetailsBCElement(DetailsbcelementId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsbcelement  where idelement=:idelement and numbc=:numbc");
            q.setString("idelement", id.getIdelement());
            q.setString("numbc", id.getNumbc());
            return (Detailsbcelement) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsbcelement detailsbcelement) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsbcelement);
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
    public void insert(Detailsbcelement detailsbcelement) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detailsbcelement);
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
    public void delete(DetailsbcelementId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsbcelement = (Detailsbcelement) session.get(Detailsbcelement.class, id);
            session.delete(detailsbcelement);
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
