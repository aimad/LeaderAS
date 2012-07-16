/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Audit;
import java.sql.Date;
import java.util.List;
import junit.framework.TestCase;
import org.junit.*;

/**
 *
 * @author zarito
 */
public class AuditHDaoTest extends TestCase {
    
    DataBaseConnection dbConn;
    AuditHDao dao;
    
    public AuditHDaoTest(String text) {
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
        dao = new AuditHDao();
        deleteAllAudits();
        setUpRecord();
    }
    
    @After
    @Override
    public void tearDown() {
           dbConn = null;
           dao = null;
    }

      private void deleteAllAudits() {
        String sql = "DELETE FROM audit";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO audit VALUES ('1','XX','xx@xx.com','0677889988','0677889988','2000-12-2',12)";
        dbConn.execute(sql);
    }
    /**
     * Test of getAllClients method, of class ClientHDao.
     */
    @Test
    public void testGetAllAudits() {
        System.out.println("getAllAudits");
         int i = 0;
        List audits = dao.getAllAudit();
        assertEquals(audits.size(), 1);
        Audit c = (Audit) audits.get(i);
        assertEquals(c.getTypeoperation(), "XX");
    }

    /**
     * Test of getClient method, of class ClientHDao.
     */
    @Test
    public void testGetClient() {
        System.out.println("getAudit");
         Audit c = dao.getAudit("1");
        assertEquals(c.getTypeoperation(), "XX");
    }

        /**
     * Test of insert method, of class ClientHDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Audit c = new Audit();
        c.setIdaudit("2");
        c.setDateaudit(new Date(2000-1-1));
        c.setHeuraudit(200);
        c.setTypemodification("tt");
        c.setTypeoperation("ddd");
        c.setUserid("1");
        c.setUsername("ddd");
        dao.insert(c);
        String sql = "SELECT * FROM audit";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 2);
        
    }
    /**
     * Test of update method, of class ClientHDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Audit c = dao.getAudit("1");
        c.setTypemodification("NAJAHI Soft");
        dao.update(c);
        assertEquals(c.getTypemodification(), "NAJAHI Soft");
    }


    /**
     * Test of delete method, of class ClientHDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        dao.delete("1");
        String sql = "SELECT * FROM audit";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}
