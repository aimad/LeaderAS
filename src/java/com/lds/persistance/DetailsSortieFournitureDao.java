/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailssortiefourniture;
import com.lds.vo.DetailssortiefournitureId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsSortieFournitureDao {
    
     public List getAllDetailssortiefournitures();

    public Detailssortiefourniture getDetailssortiefourniture(DetailssortiefournitureId id);
    
    public void update(Detailssortiefourniture detailssortiefourniture);

    public void insert(Detailssortiefourniture detailssortiefourniture);

    public void delete(DetailssortiefournitureId id);
    
}
