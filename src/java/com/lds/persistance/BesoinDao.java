/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;


import com.lds.vo.Besoin;
import java.util.List;
/**
 *
 * @author ELKAOUMI
 */
public interface BesoinDao {
     public List getAllBesoin();

    public Besoin getBesoin(String id);

    public void update(Besoin besoin);

    public void insert(Besoin besoin);

    public void delete(String id);
    
}
