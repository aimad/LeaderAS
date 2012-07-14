/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsbrelement;
import com.lds.vo.DetailsbrelementId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBRElementDao {
    
    public List getAllDetailsBRElement();

    public Detailsbrelement getDetailsBRElement(DetailsbrelementId id);

    public void update(Detailsbrelement detailsbrelement);

    public void insert(Detailsbrelement detailsbrelement);

    public void delete(DetailsbrelementId id);
}
