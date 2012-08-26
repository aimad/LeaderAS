/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Demandeprix;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface DemandePrixDao {
    
    public  List getAllDevis();
        
    public Demandeprix getDevis(String id);

    public void update(Demandeprix demandePrix);

    public void insert(Demandeprix demandePrix);

    public void delete(String id);
    
}
