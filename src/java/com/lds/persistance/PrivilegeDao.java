/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Privilege;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface PrivilegeDao {
     public List getAllPrivileges();

    public Privilege getPrivilege(String id);

    public void update(Privilege privilege);

    public void insert(Privilege privilege);

    public void delete(String id);
    
}
