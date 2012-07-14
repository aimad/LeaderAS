/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Projet;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface ProjetDao {

    public List getAllProjet();

    public Projet getProjet(String id);

    public void update(Projet projet);

    public void insert(Projet projet);

    public void delete(String id);
}
