/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsbcarticle;
import com.lds.vo.DetailsbcarticleId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBcArticleDao {
    
     public List getAllDetailsbcarticles();

    public Detailsbcarticle getDetailsbcarticle(DetailsbcarticleId id);
    
    public void update(Detailsbcarticle detailsbcarticle);

    public void insert(Detailsbcarticle detailsbcarticle);

    public void delete(DetailsbcarticleId id);
    
}
