package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Boncommande generated by hbm2java
 */
public class Boncommande  implements java.io.Serializable {


     private String numbc;
     private Affaire affaire;
     private Fournisseur fournisseur;
     private Date dateboncommande;
     private BigDecimal prixht;
     private Set detailsbcelements = new HashSet(0);
     private Set bonreceptions = new HashSet(0);

    public Boncommande() {
    }

	
    public Boncommande(String numbc, Affaire affaire, Fournisseur fournisseur) {
        this.numbc = numbc;
        this.affaire = affaire;
        this.fournisseur = fournisseur;
    }
    public Boncommande(String numbc, Affaire affaire, Fournisseur fournisseur, Date dateboncommande, BigDecimal prixht, Set detailsbcelements, Set bonreceptions) {
       this.numbc = numbc;
       this.affaire = affaire;
       this.fournisseur = fournisseur;
       this.dateboncommande = dateboncommande;
       this.prixht = prixht;
       this.detailsbcelements = detailsbcelements;
       this.bonreceptions = bonreceptions;
    }
   
    public String getNumbc() {
        return this.numbc;
    }
    
    public void setNumbc(String numbc) {
        this.numbc = numbc;
    }
    public Affaire getAffaire() {
        return this.affaire;
    }
    
    public void setAffaire(Affaire affaire) {
        this.affaire = affaire;
    }
    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }
    
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    public Date getDateboncommande() {
        return this.dateboncommande;
    }
    
    public void setDateboncommande(Date dateboncommande) {
        this.dateboncommande = dateboncommande;
    }
    public BigDecimal getPrixht() {
        return this.prixht;
    }
    
    public void setPrixht(BigDecimal prixht) {
        this.prixht = prixht;
    }
    public Set getDetailsbcelements() {
        return this.detailsbcelements;
    }
    
    public void setDetailsbcelements(Set detailsbcelements) {
        this.detailsbcelements = detailsbcelements;
    }
    public Set getBonreceptions() {
        return this.bonreceptions;
    }
    
    public void setBonreceptions(Set bonreceptions) {
        this.bonreceptions = bonreceptions;
    }




}


