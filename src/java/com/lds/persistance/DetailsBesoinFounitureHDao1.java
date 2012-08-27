/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;



import com.lds.vo.Detailsfourniturebesoin;
import com.lds.vo.DetailsfourniturebesoinId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsBesoinFounitureHDao1 implements DetailsBesoinFournitureDao {
    private List<Detailsfourniturebesoin> detailsfourniturebesoinList;
    private Detailsfourniturebesoin detailsfourniturebesoin;
    
    @Override
    public List getAllDetailsfourniturebesoins() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsfourniturebesoinList = session.createQuery("from Detailsfourniturebesoin").list();
            return detailsfourniturebesoinList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }
 public List getDetailsfourniturebesoins_id(String id_bc) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsfourniturebesoinList = session.createQuery("from Detailsfourniturebesoin where idbesoin='"+id_bc+"'").list();
            return detailsfourniturebesoinList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailsfourniturebesoin getDetailsfourniturebesoin(DetailsfourniturebesoinId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsfourniturebesoin  where idbesoin =:idbesoin and numfourniture =:numfourniture");
            q.setString("idbesoin", id.getIdbesoin());
            q.setString("numfourniture", id.getNumfourniture());
            return (Detailsfourniturebesoin) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsfourniturebesoin detailsfourniturebesoin) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsfourniturebesoin);
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
    public void insert(Detailsfourniturebesoin detailsfourniturebesoin) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsfourniturebesoin);
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
    public void delete(DetailsfourniturebesoinId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsfourniturebesoin = (Detailsfourniturebesoin) session.get(Detailsfourniturebesoin.class, id);
            session.delete(detailsfourniturebesoin);
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

