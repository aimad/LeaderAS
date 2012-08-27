package com.lds.beans;

import com.lds.vo.Detailsbrfourniture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class details_input_fourniture_DataModel extends LazyDataModel<Detailsbrfourniture> {
    
    private List<Detailsbrfourniture> datasource;
       
    public details_input_fourniture_DataModel(List<Detailsbrfourniture> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Detailsbrfourniture getRowData(String rowKey) {
        for(Detailsbrfourniture detailsbrfourniture : datasource) {
            if(detailsbrfourniture.getIddetails().equals(rowKey))
                return detailsbrfourniture;
        }

        return null;
    }

    @Override
    public Object getRowKey(Detailsbrfourniture detailsbrfourniture) {
        return detailsbrfourniture.getIddetails();
    }

    @Override
    public List<Detailsbrfourniture> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Detailsbrfourniture> data = new ArrayList<Detailsbrfourniture>();

        //filter
        for(Detailsbrfourniture detailsbrfourniture : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(detailsbrfourniture.getClass().getField(filterProperty).get(detailsbrfourniture));

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
                data.add(detailsbrfourniture);
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