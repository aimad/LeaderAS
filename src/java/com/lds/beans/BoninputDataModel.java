package com.lds.beans;

import com.lds.vo.Bonreception;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class BoninputDataModel extends LazyDataModel<Bonreception> {
    
    private List<Bonreception> datasource;
       
    public BoninputDataModel(List<Bonreception> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Bonreception getRowData(String rowKey) {
        for(Bonreception bonreception : datasource) {
            if(bonreception.getNumreception().equals(rowKey))
                return bonreception;
        }

        return null;
    }

    @Override
    public Object getRowKey(Bonreception bonreception) {
        return bonreception.getNumreception();
    }

    @Override
    public List<Bonreception> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Bonreception> data = new ArrayList<Bonreception>();

        //filter
        for(Bonreception bonreception : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(bonreception.getClass().getField(filterProperty).get(bonreception));

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
                data.add(bonreception);
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