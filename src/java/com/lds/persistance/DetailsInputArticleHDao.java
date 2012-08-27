/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsbrarticle;
import com.lds.vo.Detailsbrarticle;
import com.lds.vo.DetailsbrarticleId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsInputArticleHDao implements DetailsInputArticleDao {
     private List<Detailsbrarticle> detailsbrarticleList;
    private Detailsbrarticle detailsbrarticle;

    @Override
    public List getAllDetailsbrarticles() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbrarticleList = session.createQuery("from Detailsbrarticle").list();
            return detailsbrarticleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
  public List getAllDetailsbrarticles_id(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbrarticleList = session.createQuery("from Detailsbrarticle where numreception='"+id+"'").list();
            return detailsbrarticleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsbrarticle getDetailsbrarticle(DetailsbrarticleId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsbrarticle  where numreception =:numreception and idarticle =:idarticle");
            q.setString("numreception", id.getNumreception());
            q.setString("idarticle", id.getIdarticle());
            return (Detailsbrarticle) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsbrarticle detailsbrarticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsbrarticle);
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
    public void insert(Detailsbrarticle detailsbrarticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsbrarticle);
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
    public void delete(DetailsbrarticleId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsbrarticle = (Detailsbrarticle) session.get(Detailsbrarticle.class, id);
            session.delete(detailsbrarticle);
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

