/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Bonreception;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface BonReceptionDao {
     public List getAllBonReceptions();

    public Bonreception getBonReception(String id);

    public void update(Bonreception bonreception);

    public void insert(Bonreception bonreception);

    public void delete(String id);
    
}
