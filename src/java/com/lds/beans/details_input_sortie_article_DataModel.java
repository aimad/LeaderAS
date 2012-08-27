package com.lds.beans;

import com.lds.vo.Detailsbrarticle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class details_input_sortie_article_DataModel extends LazyDataModel<Detailsbrarticle> {
    
    private List<Detailsbrarticle> datasource;
       
    public details_input_sortie_article_DataModel(List<Detailsbrarticle> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Detailsbrarticle getRowData(String rowKey) {
        for(Detailsbrarticle detailsbrarticle : datasource) {
            if(detailsbrarticle.getId().getIdarticle().equals(rowKey))
                return detailsbrarticle;
        }

        return null;
    }

    @Override
    public Object getRowKey(Detailsbrarticle detailsbrarticle) {
        return detailsbrarticle.getId().getIdarticle();
    }

    @Override
    public List<Detailsbrarticle> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Detailsbrarticle> data = new ArrayList<Detailsbrarticle>();

        //filter
        for(Detailsbrarticle detailsbrarticle : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(detailsbrarticle.getClass().getField(filterProperty).get(detailsbrarticle));

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
                data.add(detailsbrarticle);
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