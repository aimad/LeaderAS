/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Fournisseur;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author ELKAOUMI
 */
public class FournisseurHDaoTest extends TestCase {

    DataBaseConnection dbConn;
    FournisseurHDao dao;

    public FournisseurHDaoTest(String text) {
        super(text);
        HibernateUtil.createSessionFactory();
    }

    @Override
    protected void setUp() {
        dbConn = new DataBaseConnection();
        dao = new FournisseurHDao();
        deleteAllFournisseurs();
        setUpRecord();
    }

    @Override
    protected void tearDown() {
        dbConn = null;
        dao = null;
    }

    private void deleteAllFournisseurs() {
        String sql = "DELETE FROM fournisseur";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO fournisseur VALUES ('1','XX','xx@xx.com','0677889988','0677889988','rue xx ','test test')";
        dbConn.execute(sql);
    }

    public void testGetAllFournissers() {
//logger.debug("*******************StartingtestGetAllCreanciers*******************");
        int i = 0;
        List fournisseurs = dao.getAllFournisseur();
        assertEquals(fournisseurs.size(), 1);
        Fournisseur c = (Fournisseur) fournisseurs.get(i);
        assertEquals(c.getNom(), "XX");
    }

    public void testGetFournisseur() {
        Fournisseur c = dao.getFournisseur("1");
        assertEquals(c.getNom(), "XX");
    }

    public void testInsertFournisseur() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        Fournisseur c = new Fournisseur();
        c.setIdfournisseur("2");
        c.setNom("yy");
        c.setEmail("yy@yy.com");
        c.setTel("067874565");
        c.setFax("028823456");
        c.setAdresse("rue yy agadir");
        c.setDescription("0987");
        dao.insert(c);
        String sql = "SELECT * FROM fournisseur";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 2);
    }

    public void testUpdateFournisseur() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        Fournisseur c = dao.getFournisseur("1");
        c.setNom("NAJAHI Soft");
        dao.update(c);
        assertEquals(c.getNom(), "NAJAHI Soft");
    }

    public void testDeleteFournisseur() {
//logger.info("*******************Starting testDeleteCreancier*******************");
        dao.delete("1");
        String sql = "SELECT * FROM fournisseur";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}