/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Affaire;
import com.lds.vo.AffaireId;
import java.sql.Date;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author ELKAOUMI
 */
public class AffaireHDaoTest extends TestCase {

    DataBaseConnection dbConn;
    AffaireHDao dao;

    public AffaireHDaoTest(String text) {
        super(text);
        HibernateUtil.createSessionFactory();
    }

    @Override
    protected void setUp() {
        dbConn = new DataBaseConnection();
        dao = new AffaireHDao();
        deleteAllAffaire();
        setUpRecord();
    }

    @Override
    protected void tearDown() {
        dbConn = null;
        dao = null;
    }

    private void deleteAllAffaire() {
        String sql = "DELETE FROM affaire";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql0 = "INSERT INTO client VALUES ('1','aimad','xx@xx','098678','098678','fff','ddd')";
        String sql = "INSERT INTO projet VALUES ('1','1')";
        String sql1 = "INSERT INTO affaire VALUES ('1','1','2002-12-1','2002-12-1','ddd',1000.0)";
        dbConn.execute(sql0);
        dbConn.execute(sql);
        dbConn.execute(sql1);
        
    }

    public void testGetAllAffaires() {
//logger.debug("*******************StartingtestGetAllCreanciers*******************");
        int i = 0;
        List affaires = dao.getAllAffaire();
        assertEquals(affaires.size(), 1);
        Affaire c = (Affaire) affaires.get(i);
        assertEquals(c.getMontantaffaire(), 1000.0);
    }

    public void testGetAffaire() {
        AffaireId id = new AffaireId();
        id.setIdprojet("1");
        id.setNumaffaire("1");
        Affaire c = dao.getAffaire(id);
        assertEquals(c.getMontantaffaire(), 1000.0);
    }

    public void testInsertAffaire() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        AffaireId id = new AffaireId();
        String sql0 = "INSERT INTO client VALUES ('2','aimad','xx@xx','098678','098678','fff','ddd')";
        String sql = "INSERT INTO projet VALUES ('2','2')";
        dbConn.execute(sql0);
        dbConn.execute(sql);
        id.setIdprojet("2");
        id.setNumaffaire("2");
        Affaire c = new Affaire();
        c.setId(id);
        c.setDatedebutaffaire(new Date(2002 - 12 - 2));
        c.setDatefinaffaire(new Date(2002 - 12 - 2));
        c.setDescprojet("tt");
        c.setMontantaffaire(1000.2);
        dao.insert(c);
        String sql1 = "SELECT * FROM affaire";
        int numberOfRecords = dbConn.getNumberOfRecords(sql1);
        assertEquals(numberOfRecords, 2);
    }

    public void testUpdateFournisseur() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        AffaireId id = new AffaireId();
        id.setIdprojet("1");
        id.setNumaffaire("1");
        Affaire c = dao.getAffaire(id);
        c.setMontantaffaire(100.1);
        dao.update(c);
        assertEquals(c.getMontantaffaire(), 100.1);
    }

    public void testDeleteFournisseur() {
//logger.info("*******************Starting testDeleteCreancier*******************");
        AffaireId id = new AffaireId("1", "1");
        dao.delete(id);
        String sql = "SELECT * FROM affaire";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}