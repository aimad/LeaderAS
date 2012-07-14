/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Bonsortie;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface BonSortieDao {
    
     public List getAllBonSorties();

    public Bonsortie getBonSortie(String id);

    public void update(Bonsortie bonsortie);

    public void insert(Bonsortie bonsortie);

    public void delete(String id);
    
}
