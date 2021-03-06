package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Fournisseur generated by hbm2java
 */
public class Fournisseur  implements java.io.Serializable {


     private String idfournisseur;
     private String nom;
     private String email;
     private String tel;
     private String fax;
     private String adresse;
     private String description;
     private Set boncommandes = new HashSet(0);
     private Set demandeprixes = new HashSet(0);

    public Fournisseur() {
    }

	
    public Fournisseur(String idfournisseur) {
        this.idfournisseur = idfournisseur;
    }
    public Fournisseur(String idfournisseur, String nom, String email, String tel, String fax, String adresse, String description, Set boncommandes, Set demandeprixes) {
       this.idfournisseur = idfournisseur;
       this.nom = nom;
       this.email = email;
       this.tel = tel;
       this.fax = fax;
       this.adresse = adresse;
       this.description = description;
       this.boncommandes = boncommandes;
       this.demandeprixes = demandeprixes;
    }
   
    public String getIdfournisseur() {
        return this.idfournisseur;
    }
    
    public void setIdfournisseur(String idfournisseur) {
        this.idfournisseur = idfournisseur;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
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
    public Set getBoncommandes() {
        return this.boncommandes;
    }
    
    public void setBoncommandes(Set boncommandes) {
        this.boncommandes = boncommandes;
    }
    public Set getDemandeprixes() {
        return this.demandeprixes;
    }
    
    public void setDemandeprixes(Set demandeprixes) {
        this.demandeprixes = demandeprixes;
    }




}


