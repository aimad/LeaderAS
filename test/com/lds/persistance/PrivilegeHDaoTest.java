/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Privilege;
import java.util.List;
import junit.framework.TestCase;
import org.junit.*;

/**
 *
 * @author zarito
 */
public class PrivilegeHDaoTest extends TestCase {
    
    DataBaseConnection dbConn;
    PrivilegeHDao dao;
    
    public PrivilegeHDaoTest(String text) {
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
        dao = new PrivilegeHDao();
        deleteAllPrivileges();
        setUpRecord();
    }
    
    @After
    @Override
    public void tearDown() {
           dbConn = null;
           dao = null;
    }

      private void deleteAllPrivileges() {
        String sql = "DELETE FROM privilege";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO privilege VALUES ('1','xx@xx.com','XX')";
        dbConn.execute(sql);
    }
    /**
     * Test of getAllPrivileges method, of class PrivilegeHDao.
     */
    @Test
    public void testGetAllPrivileges() {
        System.out.println("getAllPrivileges");
         int i = 0;
        List privileges = dao.getAllPrivileges();
        assertEquals(privileges.size(), 1);
        Privilege c = (Privilege) privileges.get(i);
       // assertEquals(c.getIdpriv(), "1");
        assertEquals(c.getNompriv(), "XX");
    }

    /**
     * Test of getPrivilege method, of class PrivilegeHDao.
     */
    @Test
    public void testGetPrivilege() {
        System.out.println("getPrivilege");
         Privilege c = dao.getPrivilege("1");
        assertEquals(c.getNompriv(), "XX");
    }

        /**
     * Test of insert method, of class PrivilegeHDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Privilege c = new Privilege();
        c.setIdpriv("2");
        c.setLienpriv("yy@yy.com");
        c.setNompriv("XX");
        dao.insert(c);
        String sql = "SELECT * FROM privilege";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 2);
        
    }
    /**
     * Test of update method, of class PrivilegeHDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Privilege c = dao.getPrivilege("1");
        c.setNompriv("NAJAHI Soft");
        dao.update(c);
        assertEquals(c.getNompriv(), "NAJAHI Soft");
    }


    /**
     * Test of delete method, of class PrivilegeHDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        dao.delete("1");
        String sql = "SELECT * FROM privilege";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}
