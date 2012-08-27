package com.lds.beans;

import com.lds.vo.Fournisseur;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 * Dummy implementation of LazyDataModel that uses a list to mimic a real datasource like a database.
 */
public class FournisseurDataModel extends LazyDataModel<Fournisseur> {
    
    private List<Fournisseur> datasource;
       
    public FournisseurDataModel(List<Fournisseur> datasource) {
        this.datasource = datasource;
    }
    
    @Override
    public Fournisseur getRowData(String rowKey) {
        for(Fournisseur fournisseur : datasource) {
            if(fournisseur.getIdfournisseur().equals(rowKey))
                return fournisseur;
        }

        return null;
    }

    @Override
    public Object getRowKey(Fournisseur fournisseur) {
        return fournisseur.getIdfournisseur();
    }

    @Override
    public List<Fournisseur> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,String> filters) {
        List<Fournisseur> data = new ArrayList<Fournisseur>();

        //filter
        for(Fournisseur fournisseur : datasource) {
            boolean match = true;

            for(Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    String filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(fournisseur.getClass().getField(filterProperty).get(fournisseur));

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
                data.add(fournisseur);
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