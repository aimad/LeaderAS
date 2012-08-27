/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailssortiearticle;
import com.lds.vo.Detailssortiearticle;
import com.lds.vo.DetailssortiearticleId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsSortieArticleHDao implements DetailsSortieArticleDao {
     private List<Detailssortiearticle> detailssortiearticleList;
    private Detailssortiearticle detailssortiearticle;

    @Override
    public List getAllDetailssortiearticles() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailssortiearticleList = session.createQuery("from Detailssortiearticle").list();
            return detailssortiearticleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
  public List getAllDetailssortiearticles_id(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailssortiearticleList = session.createQuery("from Detailssortiearticle where idsortie='"+id+"'").list();
            return detailssortiearticleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailssortiearticle getDetailssortiearticle(DetailssortiearticleId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailssortiearticle  where idsortie =:idsortie and idarticle =:idarticle");
            q.setString("idsortie", id.getIdsortie());
            q.setString("idarticle", id.getIdarticle());
            return (Detailssortiearticle) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailssortiearticle detailssortiearticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailssortiearticle);
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
    public void insert(Detailssortiearticle detailssortiearticle) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailssortiearticle);
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
    public void delete(DetailssortiearticleId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailssortiearticle = (Detailssortiearticle) session.get(Detailssortiearticle.class, id);
            session.delete(detailssortiearticle);
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

