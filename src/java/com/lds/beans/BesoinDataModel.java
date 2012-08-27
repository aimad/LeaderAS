package com.lds.beans;

import com.lds.vo.Besoin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class BesoinDataModel extends LazyDataModel<Besoin> {
    
    private List<Besoin> datasource;
       
    public BesoinDataModel(List<Besoin> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Besoin getRowData(String rowKey) {
        for(Besoin besoin : datasource) {
            if(besoin.getIdbesoin().equals(rowKey))
                return besoin;
        }

        return null;
    }

    @Override
    public Object getRowKey(Besoin besoin) {
        return besoin.getIdbesoin();
    }

    @Override
    public List<Besoin> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Besoin> data = new ArrayList<Besoin>();

        //filter
        for(Besoin besoin : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(besoin.getClass().getField(filterProperty).get(besoin));

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
                data.add(besoin);
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