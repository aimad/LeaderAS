/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailssortiefourniture;
import com.lds.vo.DetailssortiefournitureId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsSortieFournitureHDao implements DetailsSortieFournitureDao {
     private List<Detailssortiefourniture> detailssortiefournitureList;
    private Detailssortiefourniture detailssortiefourniture;

    @Override
    public List getAllDetailssortiefournitures() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailssortiefournitureList = session.createQuery("from Detailssortiefourniture").list();
            return detailssortiefournitureList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
  
    
    public List getAllDetailssortiefournitures_id(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailssortiefournitureList = session.createQuery("from Detailssortiefourniture where idsortie='"+id+"'").list();
            return detailssortiefournitureList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailssortiefourniture getDetailssortiefourniture(DetailssortiefournitureId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailssortiefourniture  where idsortie =:idsortie and numfourniture =:numfourniture");
            q.setString("idsortie", id.getIdsortie());
            q.setString("numfourniture", id.getNumfourniture());
            return (Detailssortiefourniture) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailssortiefourniture detailssortiefourniture) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailssortiefourniture);
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
    public void insert(Detailssortiefourniture detailssortiefourniture) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailssortiefourniture);
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
    public void delete(DetailssortiefournitureId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailssortiefourniture = (Detailssortiefourniture) session.get(Detailssortiefourniture.class, id);
            session.delete(detailssortiefourniture);
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

