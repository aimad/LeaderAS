package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * Facture generated by hbm2java
 */
public class Facture  implements java.io.Serializable {


     private String numfacture;
     private Affaire affaire;
     private Date datefacture;
     private String descfacture;
     private BigDecimal montantfacture;
     private String lienfacture;

    public Facture() {
    }

	
    public Facture(String numfacture, Affaire affaire) {
        this.numfacture = numfacture;
        this.affaire = affaire;
    }
    public Facture(String numfacture, Affaire affaire, Date datefacture, String descfacture, BigDecimal montantfacture, String lienfacture) {
       this.numfacture = numfacture;
       this.affaire = affaire;
       this.datefacture = datefacture;
       this.descfacture = descfacture;
       this.montantfacture = montantfacture;
       this.lienfacture = lienfacture;
    }
   
    public String getNumfacture() {
        return this.numfacture;
    }
    
    public void setNumfacture(String numfacture) {
        this.numfacture = numfacture;
    }
    public Affaire getAffaire() {
        return this.affaire;
    }
    
    public void setAffaire(Affaire affaire) {
        this.affaire = affaire;
    }
    public Date getDatefacture() {
        return this.datefacture;
    }
    
    public void setDatefacture(Date datefacture) {
        this.datefacture = datefacture;
    }
    public String getDescfacture() {
        return this.descfacture;
    }
    
    public void setDescfacture(String descfacture) {
        this.descfacture = descfacture;
    }
    public BigDecimal getMontantfacture() {
        return this.montantfacture;
    }
    
    public void setMontantfacture(BigDecimal montantfacture) {
        this.montantfacture = montantfacture;
    }
    public String getLienfacture() {
        return this.lienfacture;
    }
    
    public void setLienfacture(String lienfacture) {
        this.lienfacture = lienfacture;
    }




}


