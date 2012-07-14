/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailsdemandeelement;
import com.lds.vo.DetailsdemandeelementId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsDemandeElementDao {
    
    public List getAllDetailsDemandeElement();

    public Detailsdemandeelement getDetailsDemandeElement(DetailsdemandeelementId id);

    public void update(Detailsdemandeelement detailsdemandeelement);

    public void insert(Detailsdemandeelement detailsdemandeelement);

    public void delete(DetailsdemandeelementId id);
    
}
