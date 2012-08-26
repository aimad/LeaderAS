package com.lds.beans;

import com.lds.vo.Demandeprix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class DPrixDataModel extends LazyDataModel<Demandeprix> {
    
    private List<Demandeprix> datasource;
       
    public DPrixDataModel(List<Demandeprix> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Demandeprix getRowData(String rowKey) {
        for(Demandeprix demandeprix : datasource) {
            if(demandeprix.getNumdemandeprix().equals(rowKey))
                return demandeprix;
        }

        return null;
    }

    @Override
    public Object getRowKey(Demandeprix demandeprix) {
        return demandeprix.getNumdemandeprix();
    }

    @Override
    public List<Demandeprix> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Demandeprix> data = new ArrayList<Demandeprix>();

        //filter
        for(Demandeprix demandeprix : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(demandeprix.getClass().getField(filterProperty).get(demandeprix));

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
                data.add(demandeprix);
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