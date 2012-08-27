package com.lds.beans;

import com.lds.vo.Detailsfourniturebesoin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class BesoinfournitureDataModel extends LazyDataModel<Detailsfourniturebesoin> {
    
    private List<Detailsfourniturebesoin> datasource;
       
    public BesoinfournitureDataModel(List<Detailsfourniturebesoin> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Detailsfourniturebesoin getRowData(String rowKey) {
        for(Detailsfourniturebesoin article : datasource) {
            if(article.getId().getIdbesoin().equals(rowKey))
                return article;
        }

        return null;
    }

    @Override
    public Object getRowKey(Detailsfourniturebesoin article) {
        return article.getId().getIdbesoin();
    }

    @Override
    public List<Detailsfourniturebesoin> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Detailsfourniturebesoin> data = new ArrayList<Detailsfourniturebesoin>();

        //filter
        for(Detailsfourniturebesoin article : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(article.getClass().getField(filterProperty).get(article));

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
                data.add(article);
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