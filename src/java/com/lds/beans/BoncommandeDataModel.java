package com.lds.beans;

import com.lds.vo.Boncommande;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class BoncommandeDataModel extends LazyDataModel<Boncommande> {
    
    private List<Boncommande> datasource;
       
    public BoncommandeDataModel(List<Boncommande> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Boncommande getRowData(String rowKey) {
        for(Boncommande boncommande : datasource) {
            if(boncommande.getNumbc().equals(rowKey))
                return boncommande;
        }

        return null;
    }

    @Override
    public Object getRowKey(Boncommande boncommande) {
        return boncommande.getNumbc();
    }

    @Override
    public List<Boncommande> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Boncommande> data = new ArrayList<Boncommande>();

        //filter
        for(Boncommande boncommande : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(boncommande.getClass().getField(filterProperty).get(boncommande));

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
                data.add(boncommande);
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