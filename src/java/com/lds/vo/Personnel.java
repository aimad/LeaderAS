package com.lds.vo;
// Generated 7 aout 2012 07:43:48 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Personnel generated by hbm2java
 */
public class Personnel  implements java.io.Serializable {


     private String idpersonnel;
     private Typeuser typeuser;
     private String nom;
     private String prenom;
     private Date datenaissance;
     private String adresse;
     private String tel;
     private String email;
     private String description;
     private String fonction;
     private String password;
     private Set bonsorties = new HashSet(0);
     private Set detailsprivusers = new HashSet(0);
     private Set detailstachepersonnels = new HashSet(0);

    public Personnel() {
    }

	
    public Personnel(String idpersonnel, Typeuser typeuser) {
        this.idpersonnel = idpersonnel;
        this.typeuser = typeuser;
    }
    public Personnel(String idpersonnel, Typeuser typeuser, String nom, String prenom, Date datenaissance, String adresse, String tel, String email, String description, String fonction, String password, Set bonsorties, Set detailsprivusers, Set detailstachepersonnels) {
       this.idpersonnel = idpersonnel;
       this.typeuser = typeuser;
       this.nom = nom;
       this.prenom = prenom;
       this.datenaissance = datenaissance;
       this.adresse = adresse;
       this.tel = tel;
       this.email = email;
       this.description = description;
       this.fonction = fonction;
       this.password = password;
       this.bonsorties = bonsorties;
       this.detailsprivusers = detailsprivusers;
       this.detailstachepersonnels = detailstachepersonnels;
    }
   
    public String getIdpersonnel() {
        return this.idpersonnel;
    }
    
    public void setIdpersonnel(String idpersonnel) {
        this.idpersonnel = idpersonnel;
    }
    public Typeuser getTypeuser() {
        return this.typeuser;
    }
    
    public void setTypeuser(Typeuser typeuser) {
        this.typeuser = typeuser;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Date getDatenaissance() {
        return this.datenaissance;
    }
    
    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }
    public String getAdresse() {
        return this.adresse;
    }
    
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getFonction() {
        return this.fonction;
    }
    
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Set getBonsorties() {
        return this.bonsorties;
    }
    
    public void setBonsorties(Set bonsorties) {
        this.bonsorties = bonsorties;
    }
    public Set getDetailsprivusers() {
        return this.detailsprivusers;
    }
    
    public void setDetailsprivusers(Set detailsprivusers) {
        this.detailsprivusers = detailsprivusers;
    }
    public Set getDetailstachepersonnels() {
        return this.detailstachepersonnels;
    }
    
    public void setDetailstachepersonnels(Set detailstachepersonnels) {
        this.detailstachepersonnels = detailstachepersonnels;
    }




}


