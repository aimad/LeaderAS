package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Boncommande generated by hbm2java
 */
public class Boncommande  implements java.io.Serializable {


     private String numbc;
     private Fournisseur fournisseur;
     private Projet projet;
     private Date dateboncommande;
     private Double prixht;
     private Set detailsbcarticles = new HashSet(0);
     private Set detailsfourniturebcs = new HashSet(0);
     private Set bonreceptions = new HashSet(0);

    public Boncommande() {
    }

	
    public Boncommande(String numbc, Fournisseur fournisseur, Projet projet) {
        this.numbc = numbc;
        this.fournisseur = fournisseur;
        this.projet = projet;
    }
    public Boncommande(String numbc, Fournisseur fournisseur, Projet projet, Date dateboncommande, Double prixht, Set detailsbcarticles, Set detailsfourniturebcs, Set bonreceptions) {
       this.numbc = numbc;
       this.fournisseur = fournisseur;
       this.projet = projet;
       this.dateboncommande = dateboncommande;
       this.prixht = prixht;
       this.detailsbcarticles = detailsbcarticles;
       this.detailsfourniturebcs = detailsfourniturebcs;
       this.bonreceptions = bonreceptions;
    }
   
    public String getNumbc() {
        return this.numbc;
    }
    
    public void setNumbc(String numbc) {
        this.numbc = numbc;
    }
    public Fournisseur getFournisseur() {
        return this.fournisseur;
    }
    
    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }
    public Projet getProjet() {
        return this.projet;
    }
    
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    public Date getDateboncommande() {
        return this.dateboncommande;
    }
    
    public void setDateboncommande(Date dateboncommande) {
        this.dateboncommande = dateboncommande;
    }
    public Double getPrixht() {
        return this.prixht;
    }
    
    public void setPrixht(Double prixht) {
        this.prixht = prixht;
    }
    public Set getDetailsbcarticles() {
        return this.detailsbcarticles;
    }
    
    public void setDetailsbcarticles(Set detailsbcarticles) {
        this.detailsbcarticles = detailsbcarticles;
    }
    public Set getDetailsfourniturebcs() {
        return this.detailsfourniturebcs;
    }
    
    public void setDetailsfourniturebcs(Set detailsfourniturebcs) {
        this.detailsfourniturebcs = detailsfourniturebcs;
    }
    public Set getBonreceptions() {
        return this.bonreceptions;
    }
    
    public void setBonreceptions(Set bonreceptions) {
        this.bonreceptions = bonreceptions;
    }




}


