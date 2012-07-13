/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author zarito
 */
public class HibernateUtil
{
    private static SessionFactory sessionFactory;
    public static void createSessionFactory()
    {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    public static Session getSession()
    {
        return sessionFactory.openSession();
    }
}

   