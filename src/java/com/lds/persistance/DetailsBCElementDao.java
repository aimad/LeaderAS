/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsbcelement;
import com.lds.vo.DetailsbcelementId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsBCElementDao {
    
    public List getAllDetailsBCElement();

    public Detailsbcelement getDetailsBCElement(DetailsbcelementId id);

    public void update(Detailsbcelement detailsbclement);

    public void insert(Detailsbcelement detailsbcelement);

    public void delete(DetailsbcelementId id);
}
