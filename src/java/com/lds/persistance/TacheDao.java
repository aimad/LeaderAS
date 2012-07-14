/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Tache;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface TacheDao {

    public List getAllTache();

    public Tache getTache(String id);

    public void update(Tache tache);

    public void insert(Tache tache);

    public void delete(String id);
}
