/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Article;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface ArticleDao {

    public List getAllArticle();

    public Article getArticle(String id);

    public void update(Article article);

    public void insert(Article article);

    public void delete(String id);
}
