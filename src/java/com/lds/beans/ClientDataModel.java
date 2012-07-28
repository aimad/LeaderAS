package com.lds.beans;

import com.lds.vo.Client;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class ClientDataModel extends LazyDataModel<Client> {
    
    private List<Client> datasource;
       
    public ClientDataModel(List<Client> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Client getRowData(String rowKey) {
        for(Client client : datasource) {
            if(client.getIdclient().equals(rowKey))
                return client;
        }

        return null;
    }

    @Override
    public Object getRowKey(Client client) {
        return client.getIdclient();
    }

    @Override
    public List<Client> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Client> data = new ArrayList<Client>();

        //filter
        for(Client client : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(client.getClass().getField(filterProperty).get(client));

                    if(filterValue == null || fieldValue.startsWith(filterValue)) {
                        match = true;
                    }
                    else {
                        match = false;
                        break;
                    }
                } catch(Exception e) {
                    match = false;
                } 
            }

            if(match) {
                data.add(client);
            }
        }

        //sort
        /*if(sortField != null) {
            Collections.sort(data, new LazySorter(sortField, sortOrder));
        }*/

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if(dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            }
            catch(IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        }
        else {
            return data;
        }
    }
}