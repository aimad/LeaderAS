/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsfourniturebc;
import com.lds.vo.DetailsfourniturebcId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBcFournitureDao {
    
     public List getAllDetailsbcfournitures();

    public Detailsfourniturebc getDetailsbcfourniture(DetailsfourniturebcId id);
    
    public void update(Detailsfourniturebc detailsbcfourniture);

    public void insert(Detailsfourniturebc detailsbcfourniture);

    public void delete(DetailsfourniturebcId id);
    
}
