/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Personnel;
import com.lds.vo.Typeuser;
import java.util.List;
import junit.framework.TestCase;
import org.junit.*;

/**
 *
 * @author zarito
 */
public class PersonnelHDaoTest extends TestCase {
    
    DataBaseConnection dbConn;
    PersonnelHDao dao;
    
    public PersonnelHDaoTest(String text) {
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
        dao = new PersonnelHDao();
        deleteAllPersonnels();
        setUpRecord();
    }
    
    @After
    @Override
    public void tearDown() {
           dbConn = null;
           dao = null;
    }

      private void deleteAllPersonnels() {
        String sql = "DELETE FROM personnel";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO personnel VALUES ('1','2','XX','aimad','12/3/1989','rue xx','0677889988','xx@xx.com','test test','mec','')";
        dbConn.execute(sql);
    }
    /**
     * Test of getAllPersonnels method, of class PersonnelHDao.
     */
    @Test
    public void testGetAllPersonnels() {
        System.out.println("getAllPersonnels");
         int i = 0;
        List personnels = dao.getAllPersonnels();
        assertEquals(personnels.size(), 1);
        Personnel c = (Personnel) personnels.get(i);
        assertEquals(c.getNom(), "XX");
    }

    /**
     * Test of getPersonnel method, of class PersonnelHDao.
     */
    @Test
    public void testGetPersonnel() {
        System.out.println("getPersonnel");
         Personnel c = dao.getPersonnel("1");
        assertEquals(c.getNom(), "XX");
    }

        /**
     * Test of insert method, of class PersonnelHDao.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Personnel c = new Personnel();
        c.setIdpersonnel("2");
        c.setTypeuser(new Typeuser(1));
        c.setNom("yy");
        c.setPrenom("ahmed");
        c.setDatenaissance(null);
        c.setEmail("yy@yy.com");
        c.setTel("067874565");
        c.setAdresse("rue yy agadir");
        c.setDescription("");
        c.setFonction("");
        dao.insert(c);
        String sql = "SELECT * FROM personnel";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 2);
        
    }
    /**
     * Test of update method, of class PersonnelHDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Personnel c = dao.getPersonnel("1");
        c.setNom("NAJAHI");
        dao.update(c);
        assertEquals(c.getNom(), "NAJAHI");
    }


    /**
     * Test of delete method, of class PersonnelHDao.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        dao.delete("1");
        String sql = "SELECT * FROM personnel";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}
