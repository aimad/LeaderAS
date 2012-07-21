/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

/**
 *
 * @author zarito
 */
public class EditorBean {  
  
    private String value;  
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
    
    public String actionEditor(){
        return "Test" ;
    }
}  