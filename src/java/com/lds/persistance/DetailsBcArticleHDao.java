/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsbcarticle;
import com.lds.vo.DetailsbcarticleId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsBcArticleHDao implements DetailsBcArticleDao {
     private List<Detailsbcarticle> detailsbcarticleList;
    private Detailsbcarticle detailsbcarticle;

    @Override
    public List getAllDetailsbcarticles() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbcarticleList = session.createQuery("from Detailsbcarticle").list();
            return detailsbcarticleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
 public List getDetailsbcarticles_id(String id_bc) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbcarticleList = session.createQuery("from Detailsbcarticle where numbc='"+id_bc+"'").list();
            return detailsbcarticleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsbcarticle getDetailsbcarticle(DetailsbcarticleId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsbcarticle  where numbc =:numbc and idarticle =:idarticle");
            q.setString("numbc", id.getNumbc());
            q.setString("idarticle", id.getIdarticle());
            return (Detailsbcarticle) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsbcarticle detailsbcarticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsbcarticle);
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
    public void insert(Detailsbcarticle detailsbcarticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsbcarticle);
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
    public void delete(DetailsbcarticleId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsbcarticle = (Detailsbcarticle) session.get(Detailsbcarticle.class, id);
            session.delete(detailsbcarticle);
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

