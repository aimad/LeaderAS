/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Fournisseur;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface FournisseurDao {

    public List getAllFournisseur();

    public Fournisseur getFournisseur(String id);

    public void update(Fournisseur fournisseur);

    public void insert(Fournisseur fournisseur);

    public void delete(String id);
}
