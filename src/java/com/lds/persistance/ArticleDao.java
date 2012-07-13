/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Article;
import com.lds.vo.ArticleId;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface ArticleDao {

    public List getAllArticle();

    public Article getArticle(ArticleId id);

    public void update(Article article);

    public void insert(Article article);

    public void delete(ArticleId id);
}
