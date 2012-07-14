/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Article;
import com.lds.vo.ArticleId;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ELKAOUMI
 */
public class ArticleHDao implements ArticleDao {

    private List<Article> articleList;
    private Article article;

    @Override
    public List getAllArticle() {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            articleList = session.createQuery("from Article").list();
            return articleList;
        } catch (HibernateException e) {
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Article getArticle(ArticleId id) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            Query q = session.createQuery("from Article  where idelement=:idelement and idarticle=:idarticle");
            q.setString("idelement", id.getIdelement());
            q.setString("idarticle", id.getIdarticle());
            return (Article) q.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Article article) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(article);
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
    public void insert(Article article) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(article);
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
    public void delete(ArticleId id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            article = (Article) session.get(Article.class, id);
            session.delete(article);
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
