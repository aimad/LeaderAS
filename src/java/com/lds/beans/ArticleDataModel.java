package com.lds.beans;

import com.lds.vo.Article;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class ArticleDataModel extends LazyDataModel<Article> {
    
    private List<Article> datasource;
       
    public ArticleDataModel(List<Article> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Article getRowData(String rowKey) {
        for(Article article : datasource) {
            if(article.getIdarticle().equals(rowKey))
                return article;
        }

        return null;
    }

    @Override
    public Object getRowKey(Article article) {
        return article.getIdarticle();
    }

    @Override
    public List<Article> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Article> data = new ArrayList<Article>();

        //filter
        for(Article article : datasource) {
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