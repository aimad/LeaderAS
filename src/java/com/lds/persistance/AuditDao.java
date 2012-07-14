/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Audit;
import java.util.List;

/**
 *
 * @author ELKAOUMI
 */
public interface AuditDao {
    public List getAllAudit();

    public Audit getAudit(String id);

    public void update(Audit audit);

    public void insert(Audit audit);

    public void delete(String id);
}
