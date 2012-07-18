/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;
/**
 *
 * @author zarito
 */
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
  
public class PersonBean {  
  
    private String login;  
      
    private String password;  
  
    public String getLogin() {  
        return login;  
    }  
    public void setLogin(String login) {  
        this.login = login;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
      
    public void savePerson(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome " + login +"!"));  
    }  
}  
                      