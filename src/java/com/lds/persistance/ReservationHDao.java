/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Reservation;
import com.lds.vo.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author ELKAOUMI
 */
public class ReservationHDao implements ReservationDao {

     private List<Reservation> reservationList;
    private Reservation reservation;
    @Override
    public List getAllReservation() {
         Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            reservationList = session.createQuery("from Reservation").list();
            return reservationList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Reservation getReservation(String id) {
       Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Reservation as c where c.numreservation=:id");
            q.setString("id", id);
            return (Reservation) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Reservation reservation) {
         Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(reservation);
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
    public void insert(Reservation reservation) {
       Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(reservation);
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
            reservation = (Reservation) session.get(Reservation.class, id);
            session.delete(reservation);
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
