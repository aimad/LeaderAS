/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Intervention;
import com.lds.vo.InterventionId;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface InterventionDao {

    public List getAllIntervention();

    public Intervention getIntervention(InterventionId id);

    public void update(Intervention affaire);

    public void insert(Intervention affaire);

    public void delete(InterventionId id);
}
