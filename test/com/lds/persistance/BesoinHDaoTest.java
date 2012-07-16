/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Besoin;
import com.lds.vo.Client;
import com.lds.vo.Projet;
import java.sql.Date;
import java.util.List;
import junit.framework.TestCase;
import org.junit.*;

/**
 *
 * @author zarito
 */
public class BesoinHDaoTest extends TestCase {
    
    DataBaseConnection dbConn;
    BesoinHDao dao;
    
    public BesoinHDaoTest(String text) {
        super(text);
        HibernateUtil.createSessionFactory();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    @Override
    public void setUp() {
        dbConn = new DataBaseConnection();
        dao = new BesoinHDao();
        deleteAllBesoins();
        setUpRecord();
    }
    
    @After
    @Override
    public void tearDown() {
           dbConn = null;
           dao = null;
    }

      private void deleteAllBesoins() {
        String sql = "DELETE FROM besoin";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql0="INSERT INTO projet VALUES('1')";
        String sql = "INSERT INTO besoin VALUES ('1','1','2000-12-1','test')";
        dbConn.execute(sql0);
        dbConn.execute(sql);
    }
    /**
     * Test of getAllClients method, of class ClientHDao.
     */
    @Test
    public void testGetAllBesoins() {
        System.out.println("getAllBesoins");
         int i = 0;
        List besoins = dao.getAllBesoin();
        assertEquals(besoins.size(), 1);
        Besoin c = (Besoin) besoins.get(i);
        assertEquals(c.getDescbesoin(), "test");
    }

    /**
     * Test of getClient method, of class ClientHDao.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
         Besoin c = dao.getBesoin("1");
        assertEquals(c.getDescbesoin(), "test");
    }

        /**
     * Test of insert method, of class ClientHDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Besoin c = new Besoin();
        c.setIdbesoin("2");
        c.setDatebesoin(new Date(200-12-2));
        c.setDescbesoin("yy@yy.com");
        Projet p=new Projet();
        p.setIdprojet("2");
        Client c1 = new Client();
        c1.setIdclient("2");
        c1.setNomclient("yy");
        c1.setEmail("yy@yy.com");
        c1.setTel("067874565");
        c1.setFax("028823456");
        c1.setAdresse("rue yy agadir");
        c1.setDescription("0987");
        p.setClient(c1);
        c.setProjet(p);
        dao.insert(c);
        String sql = "SELECT * FROM besoin";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 2);
        
    }
    /**
     * Test of update method, of class ClientHDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Besoin c = dao.getBesoin("1");
        c.setDescbesoin("NAJAHI Soft");
        dao.update(c);
        assertEquals(c.getDescbesoin(), "NAJAHI Soft");
    }


    /**
     * Test of delete method, of class ClientHDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        dao.delete("1");
        String sql = "SELECT * FROM besoin";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}
