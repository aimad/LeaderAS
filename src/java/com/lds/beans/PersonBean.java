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
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
  
public class PersonBean implements Serializable {  
  
    private String login;  
      
    private String password;  
  
    private String newPwd;
    
    private String oldPwd;

   
    
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
      
     public String getNewPwd() {
        return newPwd;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }
    public String savePerson() {  
        
        PersonnelDao perDao = new PersonnelHDao ();
        Personnel per = perDao.getPersonnel(getLogin());
       
        if (per == null || !per.getPassword().equals(getPassword()))  {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Le login ou le mot de passe est incorrect! ", ""));   
           return "Rejected" ; 
        }
        else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            session.setAttribute("pers", per);
            return "Accepted";
            
        }
            
    } 
    
    public String changePwd(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        Personnel p = (Personnel) facesContext.getExternalContext().getSessionMap().get("pers");
        
        if(!p.getPassword().equals(oldPwd)){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"L'ancien mot de passe est incorrect! ", ""));
            return "";
        }   
        else
        {
            PersonnelDao perDao = new PersonnelHDao ();
            p.setPassword(newPwd);
            perDao.update(p);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Modification effectuée avec succès !", ""));   
            
           return "changePwd";
            
        }
        
    }
    
    public String logout() {
    ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
     return "logout";
        }
    
    public String paramCompte(){
         FacesContext facesContext = FacesContext.getCurrentInstance();
         HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);         
         return "paramCompte";
    }
         
}                     