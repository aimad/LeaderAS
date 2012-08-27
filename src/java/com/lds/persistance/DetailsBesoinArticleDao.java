/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsarticlebesoin;
import com.lds.vo.DetailsarticlebesoinId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBesoinArticleDao {
    
     public List getAllDetailsarticlebesoins();

    public Detailsarticlebesoin getDetailsarticlebesoin(DetailsarticlebesoinId id);
    
    public void update(Detailsarticlebesoin detailsarticlebesoin);

    public void insert(Detailsarticlebesoin detailsarticlebesoin);

    public void delete(DetailsarticlebesoinId id);
    
}
