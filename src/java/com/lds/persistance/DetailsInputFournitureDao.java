/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsbrfourniture;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsInputFournitureDao {
    
     public List getAllDetailsbrfournitures();

    public Detailsbrfourniture getDetailsbrfourniture(String id_fourniture,String id_bonreception);
    
    public void update(Detailsbrfourniture detailsbrfourniture);

    public void insert(Detailsbrfourniture detailsbrfourniture);

    public void delete(String id);
    
}
