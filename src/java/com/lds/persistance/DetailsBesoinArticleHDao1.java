/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;



import com.lds.vo.Detailsarticlebesoin;
import com.lds.vo.DetailsarticlebesoinId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsBesoinArticleHDao1 implements DetailsBesoinArticleDao {
    private List<Detailsarticlebesoin> detailsarticlebesoinList;
    private Detailsarticlebesoin detailsarticlebesoin;
    
    @Override
    public List getAllDetailsarticlebesoins() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsarticlebesoinList = session.createQuery("from Detailsarticlebesoin").list();
            return detailsarticlebesoinList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
 public List getDetailsarticlebesoins_id(String id_bc) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsarticlebesoinList = session.createQuery("from Detailsarticlebesoin where idbesoin='"+id_bc+"'").list();
            return detailsarticlebesoinList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsarticlebesoin getDetailsarticlebesoin(DetailsarticlebesoinId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsarticlebesoin  where idbesoin =:idbesoin and idarticle =:idarticle");
            q.setString("idbesoin", id.getIdbesoin());
            q.setString("idarticle", id.getIdarticle());
            return (Detailsarticlebesoin) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsarticlebesoin detailsarticlebesoin) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsarticlebesoin);
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
    public void insert(Detailsarticlebesoin detailsarticlebesoin) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsarticlebesoin);
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
    public void delete(DetailsarticlebesoinId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsarticlebesoin = (Detailsarticlebesoin) session.get(Detailsarticlebesoin.class, id);
            session.delete(detailsarticlebesoin);
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
    public void deleteAll(String id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        int i=0;
        try {
            List<Detailsarticlebesoin> l=this.getDetailsarticlebesoins_id(id);
            do{
            tx = session.beginTransaction();
            //detailsarticlebesoin = (Detailsarticlebesoin) session.get(Detailsarticlebesoin.class, id);
            session.delete(l.get(i));
            tx.commit();
            i++;
            }while(i<l.size());
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

