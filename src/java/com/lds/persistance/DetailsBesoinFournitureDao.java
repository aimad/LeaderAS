/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsfourniturebesoin;
import com.lds.vo.DetailsfourniturebesoinId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBesoinFournitureDao {
    
     public List getAllDetailsfourniturebesoins();

    public Detailsfourniturebesoin getDetailsfourniturebesoin(DetailsfourniturebesoinId id);
    
    public void update(Detailsfourniturebesoin detailsfourniturebesoin);

    public void insert(Detailsfourniturebesoin detailsfourniturebesoin);

    public void delete(DetailsfourniturebesoinId id);
    
}
