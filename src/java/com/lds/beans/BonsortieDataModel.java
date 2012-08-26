package com.lds.beans;

import com.lds.vo.Bonsortie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class BonsortieDataModel extends LazyDataModel<Bonsortie> {
    
    private List<Bonsortie> datasource;
       
    public BonsortieDataModel(List<Bonsortie> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Bonsortie getRowData(String rowKey) {
        for(Bonsortie bonsortie : datasource) {
            if(bonsortie.getIdsortie().equals(rowKey))
                return bonsortie;
        }

        return null;
    }

    @Override
    public Object getRowKey(Bonsortie bonsortie) {
        return bonsortie.getIdsortie();
    }

    @Override
    public List<Bonsortie> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Bonsortie> data = new ArrayList<Bonsortie>();

        //filter
        for(Bonsortie bonsortie : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(bonsortie.getClass().getField(filterProperty).get(bonsortie));

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
                data.add(bonsortie);
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