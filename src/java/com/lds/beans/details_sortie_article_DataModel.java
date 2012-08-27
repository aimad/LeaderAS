package com.lds.beans;

import com.lds.vo.Detailssortiearticle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class details_sortie_article_DataModel extends LazyDataModel<Detailssortiearticle> {
    
    private List<Detailssortiearticle> datasource;
       
    public details_sortie_article_DataModel(List<Detailssortiearticle> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Detailssortiearticle getRowData(String rowKey) {
        for(Detailssortiearticle detailssortiearticle : datasource) {
            if(detailssortiearticle.getId().getIdarticle().equals(rowKey))
                return detailssortiearticle;
        }

        return null;
    }

    @Override
    public Object getRowKey(Detailssortiearticle detailssortiearticle) {
        return detailssortiearticle.getId().getIdarticle();
    }

    @Override
    public List<Detailssortiearticle> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Detailssortiearticle> data = new ArrayList<Detailssortiearticle>();

        //filter
        for(Detailssortiearticle detailssortiearticle : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(detailssortiearticle.getClass().getField(filterProperty).get(detailssortiearticle));

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
                data.add(detailssortiearticle);
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