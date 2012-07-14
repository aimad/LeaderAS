/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailstachepersonnel;
import com.lds.vo.DetailstachepersonnelId;
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
public class DetailstachepersonnelHDao implements DetailstachepersonnelDao{
    private List<Detailstachepersonnel> detailsTachePersonnelList;
    private Detailstachepersonnel detailsTachePersonnel;

    @Override
    public List getAllDetailstachepersonnel() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsTachePersonnelList = session.createQuery("from Detailstachepersonnel").list();
            return detailsTachePersonnelList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Detailstachepersonnel getDetailstachepersonnel(DetailstachepersonnelId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailstachepersonnel  where numtache=:numtache and idpersonnel=:idpersonnel");
            q.setString("numtache", id.getNumtache());
            q.setString("idpersonnel", id.getIdpersonnel());
            return (Detailstachepersonnel) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailstachepersonnel detailstachepersonnel) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailstachepersonnel);
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
    public void insert(Detailstachepersonnel detailstachepersonnel) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(detailstachepersonnel);
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
    public void delete(DetailstachepersonnelId id) {
       Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsTachePersonnel = (Detailstachepersonnel) session.get(Detailstachepersonnel.class, id);
            session.delete(detailsTachePersonnel);
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
