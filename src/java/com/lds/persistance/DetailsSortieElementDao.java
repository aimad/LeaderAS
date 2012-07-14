/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Detailssortieelement;
import com.lds.vo.DetailssortieelementId;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface DetailsSortieElementDao {
    
    public List getAllDetailsSortieElement();

    public Detailssortieelement getDetailsSortieElement(DetailssortieelementId id);

    public void update(Detailssortieelement detailssortieelement);

    public void insert(Detailssortieelement detailssortieelement);

    public void delete(DetailssortieelementId id);
}
