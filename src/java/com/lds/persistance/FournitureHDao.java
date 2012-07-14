/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Fournisseur;
import com.lds.vo.Fourniture;
import com.lds.vo.FournitureId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ELKAOUMI
 */
public class FournitureHDao  implements FournitureDao {
private List<Fourniture> fournitureList;
    private Fourniture fourniture;
    

    @Override
    public List getAllFourniture() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            fournitureList = session.createQuery("from Fourniture").list();
            return fournitureList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Fourniture getFourniture(FournitureId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Fourniture  where idelement='"+id.getIdelement()+"' and numfourniture='"+id.getNumfourniture()+"'");
            return (Fourniture) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Fourniture f) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(f);
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
    public void insert(Fourniture f) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(f);
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
    public void delete(FournitureId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            fourniture = (Fourniture) session.get(Fourniture.class, id);
            session.delete(fourniture);
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
