/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Client;
import java.util.List;
import junit.framework.TestCase;
import org.junit.*;

/**
 *
 * @author zarito
 */
public class ClientHDaoTest extends TestCase {
    
    DataBaseConnection dbConn;
    ClientHDao dao;
    
    public ClientHDaoTest(String text) {
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
        dao = new ClientHDao();
        deleteAllClients();
        setUpRecord();
    }
    
    @After
    @Override
    public void tearDown() {
           dbConn = null;
           dao = null;
    }

      private void deleteAllClients() {
        String sql = "DELETE FROM client";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO client VALUES ('1','XX','xx@xx.com','0677889988','0677889988','rue xx ','test test')";
        dbConn.execute(sql);
    }
    /**
     * Test of getAllClients method, of class ClientHDao.
     */
    @Test
    public void testGetAllClients() {
        System.out.println("getAllClients");
         int i = 0;
        List clients = dao.getAllClients();
        assertEquals(clients.size(), 1);
        Client c = (Client) clients.get(i);
        assertEquals(c.getNomclient(), "XX");
    }

    /**
     * Test of getClient method, of class ClientHDao.
     */
    @Test
    public void testGetClient() {
        System.out.println("getClient");
         Client c = dao.getClient("1");
        assertEquals(c.getNomclient(), "XX");
    }

        /**
     * Test of insert method, of class ClientHDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Client c = new Client();
        c.setIdclient("2");
        c.setNomclient("yy");
        c.setEmail("yy@yy.com");
        c.setTel("067874565");
        c.setFax("028823456");
        c.setAdresse("rue yy agadir");
        c.setDescription("0987");
        dao.insert(c);
        String sql = "SELECT * FROM client";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 2);
        
    }
    /**
     * Test of update method, of class ClientHDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Client c = dao.getClient("1");
        c.setNomclient("NAJAHI Soft");
        dao.update(c);
        assertEquals(c.getNomclient(), "NAJAHI Soft");
    }


    /**
     * Test of delete method, of class ClientHDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        dao.delete("1");
        String sql = "SELECT * FROM client";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}
