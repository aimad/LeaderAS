/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsbrelement;
import com.lds.vo.DetailsbrelementId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsBRElementHDao implements DetailsBRElementDao {
    private List<Detailsbrelement> detailsbrelementList;
    private Detailsbrelement detailsbrelement;

    @Override
    public List getAllDetailsBRElement() {
        Session session = com.lds.vo.HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbrelementList = session.createQuery("from Detailsbrelement").list();
            return detailsbrelementList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsbrelement getDetailsBRElement(DetailsbrelementId id) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsbrelement  where idelement=:idelement and numreception=:numreception");
            q.setString("idelement", id.getIdelement());
            q.setString("numreception", id.getNumreception());
            return (Detailsbrelement) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsbrelement detailsbrelement) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsbrelement);
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
    public void insert(Detailsbrelement detailsbrelement) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detailsbrelement);
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
    public void delete(DetailsbrelementId id) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsbrelement = (Detailsbrelement) session.get(Detailsbrelement.class, id);
            session.delete(detailsbrelement);
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
