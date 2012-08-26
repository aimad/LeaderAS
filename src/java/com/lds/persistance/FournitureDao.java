/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Fourniture;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface FournitureDao {

    public List getAllFourniture();

    public Fourniture getFourniture(String id);

    public void update(Fourniture article);

    public void insert(Fourniture article);

    public void delete(String id);
}
