package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Demandeprix generated by hbm2java
 */
public class Demandeprix  implements java.io.Serializable {


     private String referencedemande;
     private Date datedemande;
     private Set detailsdemandeelements = new HashSet(0);

    public Demandeprix() {
    }

	
    public Demandeprix(String referencedemande) {
        this.referencedemande = referencedemande;
    }
    public Demandeprix(String referencedemande, Date datedemande, Set detailsdemandeelements) {
       this.referencedemande = referencedemande;
       this.datedemande = datedemande;
       this.detailsdemandeelements = detailsdemandeelements;
    }
   
    public String getReferencedemande() {
        return this.referencedemande;
    }
    
    public void setReferencedemande(String referencedemande) {
        this.referencedemande = referencedemande;
    }
    public Date getDatedemande() {
        return this.datedemande;
    }
    
    public void setDatedemande(Date datedemande) {
        this.datedemande = datedemande;
    }
    public Set getDetailsdemandeelements() {
        return this.detailsdemandeelements;
    }
    
    public void setDetailsdemandeelements(Set detailsdemandeelements) {
        this.detailsdemandeelements = detailsdemandeelements;
    }




}


