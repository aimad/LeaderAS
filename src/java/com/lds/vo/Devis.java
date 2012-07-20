package com.lds.vo;
// Generated 20 juil. 2012 18:55:33 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * Devis generated by hbm2java
 */
public class Devis  implements java.io.Serializable {


     private String numdevis;
     private Affaire affaire;
     private Date datedevis;
     private String liendevis;
     private BigDecimal montantdevis;
     private String descdevis;

    public Devis() {
    }

	
    public Devis(String numdevis, Affaire affaire) {
        this.numdevis = numdevis;
        this.affaire = affaire;
    }
    public Devis(String numdevis, Affaire affaire, Date datedevis, String liendevis, BigDecimal montantdevis, String descdevis) {
       this.numdevis = numdevis;
       this.affaire = affaire;
       this.datedevis = datedevis;
       this.liendevis = liendevis;
       this.montantdevis = montantdevis;
       this.descdevis = descdevis;
    }
   
    public String getNumdevis() {
        return this.numdevis;
    }
    
    public void setNumdevis(String numdevis) {
        this.numdevis = numdevis;
    }
    public Affaire getAffaire() {
        return this.affaire;
    }
    
    public void setAffaire(Affaire affaire) {
        this.affaire = affaire;
    }
    public Date getDatedevis() {
        return this.datedevis;
    }
    
    public void setDatedevis(Date datedevis) {
        this.datedevis = datedevis;
    }
    public String getLiendevis() {
        return this.liendevis;
    }
    
    public void setLiendevis(String liendevis) {
        this.liendevis = liendevis;
    }
    public BigDecimal getMontantdevis() {
        return this.montantdevis;
    }
    
    public void setMontantdevis(BigDecimal montantdevis) {
        this.montantdevis = montantdevis;
    }
    public String getDescdevis() {
        return this.descdevis;
    }
    
    public void setDescdevis(String descdevis) {
        this.descdevis = descdevis;
    }




}


