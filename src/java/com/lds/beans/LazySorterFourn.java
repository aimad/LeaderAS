/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

/**
 *
 * @author zarito
 */
import com.lds.vo.Fournisseur;
import java.util.Comparator;
import org.primefaces.model.SortOrder;

public class LazySorterFourn implements Comparator<Fournisseur> {

    private String sortField;
    
    private SortOrder sortOrder;
    
    public LazySorterFourn(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Fournisseur fournisseur1, Fournisseur fournisseur2) {
        try {
            Object value1 = Fournisseur.class.getField(this.sortField).get(fournisseur1);
            Object value2 = Fournisseur.class.getField(this.sortField).get(fournisseur2);

            int value = ((Comparable)value1).compareTo(value2);
            
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
