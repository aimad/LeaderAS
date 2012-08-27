/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.vo.Detailsdemandearticle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author zarito
 */
public class DetailsDemandeArticleDataModel extends LazyDataModel<Detailsdemandearticle> {
    private List<Detailsdemandearticle> datasource;
       
    public DetailsDemandeArticleDataModel(List<Detailsdemandearticle> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Detailsdemandearticle getRowData(String rowKey) {
        for(Detailsdemandearticle article : datasource) {
            if(article.getId().getIdarticle().equals(rowKey))
                return article;
        }

        return null;
    }

    @Override
    public Object getRowKey(Detailsdemandearticle article) {
        return article.getId().getIdarticle();
    }

    @Override
    public List<Detailsdemandearticle> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Detailsdemandearticle> data = new ArrayList<Detailsdemandearticle>();

        //filter
        for(Detailsdemandearticle article : datasource) {
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
