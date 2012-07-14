/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.persistance;

import com.lds.vo.Client;
import java.util.List;

/**
 *
 * @author zarito
 */
public interface ClientDao {

    public List getAllClients();

    public Client getClient(String id);

    public void update(Client client);

    public void insert(Client client);

    public void delete(String id);
    
}
