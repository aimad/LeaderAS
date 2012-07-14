/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailselementbesoin;
import com.lds.vo.DetailselementbesoinId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsElementBesoinDao {
    
    public List getAllDetailsElementBesoin();

    public Detailselementbesoin getDetailsElementBesoin(DetailselementbesoinId id);

    public void update(Detailselementbesoin detailselementbesoin);

    public void insert(Detailselementbesoin detailselementbesoin);

    public void delete(DetailselementbesoinId id);
    
}
