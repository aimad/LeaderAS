/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsdemandearticle;
import com.lds.vo.DetailsdemandearticleId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsdemandearticleDao {
    
    public List getAllDetailsdemandearticle();

    public Detailsdemandearticle getDetailsdemandearticle(DetailsdemandearticleId id);

    public void update(Detailsdemandearticle detailsdemandearticle);

    public void insert(Detailsdemandearticle detailsdemandearticle);

    public void delete(DetailsdemandearticleId id);
    
}
