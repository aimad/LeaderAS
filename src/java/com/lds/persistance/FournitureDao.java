/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Fourniture;
import com.lds.vo.FournitureId;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface FournitureDao {

    public List getAllFourniture();

    public Fourniture getFourniture(FournitureId id);

    public void update(Fourniture article);

    public void insert(Fourniture article);

    public void delete(FournitureId id);
}
