/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Article;
import com.lds.vo.ArticleId;
import com.lds.vo.HibernateUtil;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author ELKAOUMI
 */
public class ArticleHDaoTest extends TestCase {

    DataBaseConnection dbConn;
    ArticleHDao dao;

    public ArticleHDaoTest(String text) {
        super(text);
        HibernateUtil.createSessionFactory();
    }

    @Override
    protected void setUp() {
        dbConn = new DataBaseConnection();
        dao = new ArticleHDao();
        deleteAllArticle();
        setUpRecord();
    }

    @Override
    protected void tearDown() {
        dbConn = null;
        dao = null;
    }

    private void deleteAllArticle() {
        String sql = "DELETE FROM article";
        dbConn.execute(sql);
    }

    private void setUpRecord() {
        String sql = "INSERT INTO element VALUES ('1')";
        dbConn.execute(sql);
        String sql1 = "INSERT INTO article VALUES ('1','1','test',10,'tt')";
        dbConn.execute(sql);
        dbConn.execute(sql1);
    }

    public void testGetAllFournitures() {
//logger.debug("*******************StartingtestGetAllCreanciers*******************");
        int i = 0;
        List artilces = dao.getAllArticle();
        assertEquals(artilces.size(), 1);
        Article c = (Article) artilces.get(i);
        assertEquals(c.getQntarticle().intValue(), 10);
    }

    public void testGetArticle() {
        ArticleId id = new ArticleId();;
        id.setIdelement("1");
        id.setIdarticle("1");
        Article c = dao.getArticle(id);
        assertEquals(c.getQntarticle().intValue(), 10);
    }

    public void testInsertArticle() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        Article c = new Article();
        ArticleId id = new ArticleId();
        String sql = "INSERT INTO element VALUES ('2')";
        dbConn.execute(sql);
        id.setIdelement("2");
        id.setIdarticle("2");
        c.setId(id);
        c.setDescarticle("tt");
        c.setQntarticle(10);
        c.setMarque("tt");
        dao.insert(c);
        String sql1 = "SELECT * FROM article";
        int numberOfRecords = dbConn.getNumberOfRecords(sql1);
        assertEquals(numberOfRecords, 2);
    }

    public void testUpdateFournisseur() {
//logger.debug("*******************Starting testInsertCreancier*******************");
        ArticleId id = new ArticleId();;
        id.setIdelement("1");
        id.setIdarticle("1");
        Article c = dao.getArticle(id);
        c.setQntarticle(20);
        dao.update(c);
        assertEquals(c.getQntarticle().intValue(), 20);
    }

    public void testDeleteFournisseur() {
//logger.info("*******************Starting testDeleteCreancier*******************");
        ArticleId id = new ArticleId("1", "1");
        dao.delete(id);
        String sql = "SELECT * FROM article";
        int numberOfRecords = dbConn.getNumberOfRecords(sql);
        assertEquals(numberOfRecords, 0);
    }
}