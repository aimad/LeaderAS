/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.HibernateUtil;
import junit.framework.TestCase;
import com.lds.vo.Fournisseur;
import com.lds.vo.Fourniture;
import com.lds.vo.FournitureId;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public class FournitureHDaoTest extends TestCase {

    DataBaseConnection dbConn;
    FournitureHDao dao;

    public FournitureHDaoTest(String text) {
        super(text);
        HibernateUtil.createSessionFactory();
    }

    @Override
    protected void setUp() {
        dbConn = new DataBaseConnection();
        dao = new FournitureHDao();
        deleteAllFourniture();
        setUpRecord();
    }

    @Override
    protected void tearDown() {
        dbConn = null;
        dao = null;
    }

    private void deleteAllFourniture() {
        String sql = "DELETE FROM fourniture";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO element VALUES ('1')";
        dbConn.execute(sql);
        String sql1 = "INSERT INTO fourniture VALUES ('1','1','test',10)";
        dbConn.execute(sql);
        dbConn.execute(sql1);
    }

    public void testGetAllFournitures() {
//logger.debug("*******************StartingtestGetAllCreanciers*******************");
        int i = 0;
        List fournitures = dao.getAllFourniture();
        assertEquals(fournitures.size(), 1);
        Fourniture c = (Fourniture) fournitures.get(i);
        assertEquals(c.getQntfourniture().intValue(),10);
    }

    public void testGetFourniture()
    {
    FournitureId id=new FournitureId(); ;
    id.setIdelement("1");
    id.setNumfourniture("1");
        Fourniture c = dao.getFourniture(id);
        assertEquals(c.getQntfourniture().intValue(),10);
    }

public void testInsertFourniture() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        Fourniture c = new Fourniture();
        FournitureId id=new FournitureId(); 
        String sql = "INSERT INTO element VALUES ('2')";
        dbConn.execute(sql);
    id.setIdelement("2");
    id.setNumfourniture("2");
        c.setId(id);
        c.setDescfourniture("tt");
        c.setQntfourniture(10);
        dao.insert(c);
        String sql1 = "SELECT * FROM Fourniture";
        int numberOfRecords = dbConn.getNumberOfRecords(sql1);
        assertEquals(numberOfRecords, 2);
    }

    public void testUpdateFournisseur() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        FournitureId id=new FournitureId(); ;
    id.setIdelement("1");
    id.setNumfourniture("1");
        Fourniture c = dao.getFourniture(id);
        c.setQntfourniture(20);
        dao.update(c);
        assertEquals(c.getQntfourniture().intValue(),20);
    }

    public void testDeleteFournisseur() {
//logger.info("*******************Starting testDeleteCreancier*******************");
        FournitureId id=new FournitureId("1","1"); 
        dao.delete(id);
        String sql = "SELECT * FROM Fournisseur";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}