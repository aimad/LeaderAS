/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Personnel;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface PersonnelDao {
     public List getAllPersonnels();

    public Personnel getPersonnel(String id);
    
    public void update(Personnel personnel);

    public void insert(Personnel personnel);

    public void delete(String id);
    
}
