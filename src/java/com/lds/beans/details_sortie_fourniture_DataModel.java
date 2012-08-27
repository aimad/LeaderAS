package com.lds.beans;

import com.lds.vo.Detailssortiefourniture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class details_sortie_fourniture_DataModel extends LazyDataModel<Detailssortiefourniture> {
    
    private List<Detailssortiefourniture> datasource;
       
    public details_sortie_fourniture_DataModel(List<Detailssortiefourniture> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Detailssortiefourniture getRowData(String rowKey) {
        for(Detailssortiefourniture detailssortiefourniture : datasource) {
            if(detailssortiefourniture.getId().getNumfourniture().equals(rowKey))
                return detailssortiefourniture;
        }

        return null;
    }

    @Override
    public Object getRowKey(Detailssortiefourniture detailssortiefourniture) {
        return detailssortiefourniture.getId().getNumfourniture();
    }

    @Override
    public List<Detailssortiefourniture> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Detailssortiefourniture> data = new ArrayList<Detailssortiefourniture>();

        //filter
        for(Detailssortiefourniture detailssortiefourniture : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(detailssortiefourniture.getClass().getField(filterProperty).get(detailssortiefourniture));

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
                data.add(detailssortiefourniture);
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