/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsbrarticle;
import com.lds.vo.DetailsbrarticleId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsInputArticleDao {
    
     public List getAllDetailsbrarticles();

    public Detailsbrarticle getDetailsbrarticle(DetailsbrarticleId id);
    
    public void update(Detailsbrarticle detailsbrarticle);

    public void insert(Detailsbrarticle detailsbrarticle);

    public void delete(DetailsbrarticleId id);
    
}
