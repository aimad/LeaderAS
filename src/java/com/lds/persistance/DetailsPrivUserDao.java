/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsprivuser;
import com.lds.vo.DetailsprivuserId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsPrivUserDao {
    
     public List getAllDetailsPrivUsers();

    public Detailsprivuser getDetailsPrivUser(DetailsprivuserId id);
    
    public void update(Detailsprivuser detailsPrivUser);

    public void insert(Detailsprivuser detailsPrivUser);

    public void delete(DetailsprivuserId id);
    
}
