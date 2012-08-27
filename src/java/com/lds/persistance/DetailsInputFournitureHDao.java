/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsbrfourniture;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsInputFournitureHDao implements DetailsInputFournitureDao {
     private List<Detailsbrfourniture> detailsbrfournitureList;
    private Detailsbrfourniture detailsbrfourniture;

    @Override
    public List getAllDetailsbrfournitures() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbrfournitureList = session.createQuery("from Detailsbrfourniture").list();
            return detailsbrfournitureList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
  
    
    public List getAllDetailsbrfournitures_id(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsbrfournitureList = session.createQuery("from Detailsbrfourniture where numreception='"+id+"'").list();
            return detailsbrfournitureList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsbrfourniture getDetailsbrfourniture(String id_fourniture,String id_reception) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsbrfourniture  where numreception =:numreception and numfourniture =:numfourniture");
            q.setString("numfourniture", id_fourniture);
            q.setString("numreception", id_reception);
            return (Detailsbrfourniture) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsbrfourniture detailsbrfourniture) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsbrfourniture);
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
    public void insert(Detailsbrfourniture detailsbrfourniture) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsbrfourniture);
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
    public void delete(String id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsbrfourniture = (Detailsbrfourniture) session.get(Detailsbrfourniture.class, id);
            session.delete(detailsbrfourniture);
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

