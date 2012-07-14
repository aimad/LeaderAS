/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Boncommande;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface BonCommandeDao {
     public List getAllBonCommandes();

    public Boncommande getBonCommande(String id);

    public void update(Boncommande boncommande);

    public void insert(Boncommande boncommande);

    public void delete(String id);
}
