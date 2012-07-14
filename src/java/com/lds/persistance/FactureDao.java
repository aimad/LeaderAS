/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Facture;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface FactureDao {

    public List getAllFacture();

    public Facture getFacture(String id);

    public void update(Facture facture);

    public void insert(Facture facture);

    public void delete(String id);
}
