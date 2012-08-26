/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Personnel;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class PersonnelHDao implements PersonnelDao {
    private List<Personnel> personnelList;
    private Personnel personnel;

    @Override
    public List getAllPersonnels() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            personnelList = session.createQuery("from Personnel").list();
            return personnelList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Personnel getPersonnel(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Personnel as c where c.idpersonnel =:id");
            q.setString("id", id);
            return (Personnel) q.uniqueResult();
        } finally {
            session.close();
        }
    }
    @Override
     public Personnel getNomPersonnel(String id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Personnel as c where c.nom =:id");
            q.setString("id", id);
            return (Personnel) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Personnel personnel) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(personnel);
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
    public void insert(Personnel personnel) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(personnel);
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
            personnel = (Personnel) session.get(Personnel.class, id);
            session.delete(personnel);
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

