/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Affaire;
import com.lds.vo.AffaireId;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface AffaireDao {
 
    public List getAllAffaire();

    public Affaire getAffaire(AffaireId id);

    public void update(Affaire affaire);

    public void insert(Affaire affaire);

    public void delete(AffaireId id);   
}
