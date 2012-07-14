/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Element;
import junit.framework.TestCase;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public class ElementHDaoTest extends TestCase {

    DataBaseConnection dbConn;
    ElementHDao dao;

    public ElementHDaoTest(String text) {
        super(text);
        HibernateUtil.createSessionFactory();
    }

    @Override
    protected void setUp() {
        dbConn = new DataBaseConnection();
        dao = new ElementHDao();
        deleteAllElements();
        setUpRecord();
    }

    @Override
    protected void tearDown() {
        dbConn = null;
        dao = null;
    }

    private void deleteAllElements() {
        String sql = "DELETE FROM element";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO element VALUES ('1')";
        dbConn.execute(sql);
    }

    public void testGetAllElement() {
//logger.debug("*******************StartingtestGetAllCreanciers*******************");
        int i = 0;
        List elements = dao.getAllElement();
        assertEquals(elements.size(), 1);
        Element c = (Element) elements.get(i);
        assertEquals(c.getIdelement(), "1");
    }

    public void testGetFournisseur() {
        Element c = dao.getElement("1");
        assertEquals(c.getIdelement(), "1");
    }

    public void testInsertFournisseur() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        Element c = new Element();
        c.setIdelement("2");
        dao.insert(c);
        String sql = "SELECT * FROM element";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 2);
    }

    public void testUpdateFournisseur() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        Element c = dao.getElement("1");
        dao.update(c);
        assertEquals(c.getIdelement(), "1");
    }

    public void testDeleteFournisseur() {
//logger.info("*******************Starting testDeleteCreancier*******************");
        dao.delete("1");
        String sql = "SELECT * FROM element";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}