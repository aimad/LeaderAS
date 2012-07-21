/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.vo.Personnel;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author zarito
 */
public class PersonnelDataModel extends ListDataModel<Personnel> implements SelectableDataModel<Personnel> {    
  
    public PersonnelDataModel() {  
    }  
  
    public PersonnelDataModel(List<Personnel> data) {  
        super(data);  
    }  
      
    @Override  
    public Personnel getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
          
        List<Personnel> personnels = (List<Personnel>) getWrappedData();  
          
        for(Personnel personnel : personnels) {  
            if(personnel.getIdpersonnel().equals(rowKey))  
                return personnel;  
        }  
          
        return null;  
    }  
  
    @Override  
    public String getRowKey(Personnel personnel) {  
        return personnel.getIdpersonnel();
    } 
}