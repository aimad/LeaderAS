package com.lds.beans;

import com.lds.vo.Fourniture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class FournitureDataModel extends LazyDataModel<Fourniture> {
    
    private List<Fourniture> datasource;
       
    public FournitureDataModel(List<Fourniture> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Fourniture getRowData(String rowKey) {
        for(Fourniture fourniture : datasource) {
            if(fourniture.getNumfourniture().equals(rowKey))
                return fourniture;
        }

        return null;
    }

    @Override
    public Object getRowKey(Fourniture fourniture) {
        return fourniture.getNumfourniture();
    }

    @Override
    public List<Fourniture> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Fourniture> data = new ArrayList<Fourniture>();

        //filter
        for(Fourniture fourniture : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(fourniture.getClass().getField(filterProperty).get(fourniture));

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
                data.add(fourniture);
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