/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Devis;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface DevisDao {

    public List getAllDevis();

    public Devis getDevis(String id);

    public void update(Devis devis);

    public void insert(Devis devis);

    public void delete(String id);
}
