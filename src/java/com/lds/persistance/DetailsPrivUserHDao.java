/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Detailsprivuser;
import com.lds.vo.DetailsprivuserId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author zarito
 */
public class DetailsPrivUserHDao implements DetailsPrivUserDao {
     private List<Detailsprivuser> detailsPrivUserList;
    private Detailsprivuser detailsPrivUser;

    @Override
    public List getAllDetailsPrivUsers() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            detailsPrivUserList = session.createQuery("from Detailsprivuser").list();
            return detailsPrivUserList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }


    @Override
    public Detailsprivuser getDetailsPrivUser(DetailsprivuserId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Detailsprivuser  where idpersonnel =:idpersonnel and idpriv =:idpriv");
            q.setString("idpriv", id.getIdpriv());
            q.setString("idpersonnel", id.getIdpersonnel());
            return (Detailsprivuser) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Detailsprivuser detailsPrivUser) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(detailsPrivUser);
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
    public void insert(Detailsprivuser detailsPrivUser) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(detailsPrivUser);
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
    public void delete(DetailsprivuserId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            detailsPrivUser = (Detailsprivuser) session.get(Detailsprivuser.class, id);
            session.delete(detailsPrivUser);
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

