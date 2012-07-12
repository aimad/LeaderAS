package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Client generated by hbm2java
 */
public class Client  implements java.io.Serializable {


     private String idclient;
     private String nomclient;
     private String email;
     private String tel;
     private String fax;
     private String adresse;
     private String description;
     private Set projets = new HashSet(0);

    public Client() {
    }

	
    public Client(String idclient) {
        this.idclient = idclient;
    }
    public Client(String idclient, String nomclient, String email, String tel, String fax, String adresse, String description, Set projets) {
       this.idclient = idclient;
       this.nomclient = nomclient;
       this.email = email;
       this.tel = tel;
       this.fax = fax;
       this.adresse = adresse;
       this.description = description;
       this.projets = projets;
    }
   
    public String getIdclient() {
        return this.idclient;
    }
    
    public void setIdclient(String idclient) {
        this.idclient = idclient;
    }
    public String getNomclient() {
        return this.nomclient;
    }
    
    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Set getProjets() {
        return this.projets;
    }
    
    public void setProjets(Set projets) {
        this.projets = projets;
    }




}


