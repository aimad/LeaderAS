/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailssortiearticle;
import com.lds.vo.DetailssortiearticleId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsSortieArticleDao {
    
     public List getAllDetailssortiearticles();

    public Detailssortiearticle getDetailssortiearticle(DetailssortiearticleId id);
    
    public void update(Detailssortiearticle detailssortiearticle);

    public void insert(Detailssortiearticle detailssortiearticle);

    public void delete(DetailssortiearticleId id);
    
}
