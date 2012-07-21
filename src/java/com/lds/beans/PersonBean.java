/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;
/**
 *
 * @author zarito
 */
import com.lds.persistance.HibernateUtil;
import com.lds.persistance.PersonnelDao;
import com.lds.persistance.PersonnelHDao;
import com.lds.vo.Personnel;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
  
public class PersonBean {  
  
    private String login;  
      
    private String password;  
  
    public PersonBean(){
        HibernateUtil.createSessionFactory();
    }
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
      
    public String savePerson() {  
        
        PersonnelDao perDao = new PersonnelHDao ();
        Personnel per = perDao.getPersonnel(getLogin());
       
        if (per == null || !per.getPassword().equals(getPassword()))  {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe est incorrect! "));   
           return "Rejected" ; 
        }
        else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("pers", per);
            return "Accepted";
            
        }
            
    } 
         
}                     