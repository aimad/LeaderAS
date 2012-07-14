/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailselementbesoin;
import com.lds.vo.DetailselementbesoinId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsElementBesoinHDao implements DetailsElementBesoinDao {
    
    private List<Detailselementbesoin> detailselementbesoinList;
    private Detailselementbesoin detailselementbesoin;

    @Override
    public List getAllDetailsElementBesoin() {
        Session session = com.lds.vo.HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailselementbesoinList = session.createQuery("from Detailselementbesoin").list();
            return detailselementbesoinList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailselementbesoin getDetailsElementBesoin(DetailselementbesoinId id) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailselementbesoin  where idelement=:idelement and idbesoin=:idbesoin");
            q.setString("idelement", id.getIdelement());
            q.setString("idbesoin", id.getIdbesoin());
            return (Detailselementbesoin) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailselementbesoin detailselementbesoin) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailselementbesoin);
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
    public void insert(Detailselementbesoin detailselementbesoin) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detailselementbesoin);
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
    public void delete(DetailselementbesoinId id) {
        Session session = com.lds.vo.HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailselementbesoin = (Detailselementbesoin) session.get(Detailselementbesoin.class, id);
            session.delete(detailselementbesoin);
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
