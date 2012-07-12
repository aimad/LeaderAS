package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Affaire generated by hbm2java
 */
public class Affaire  implements java.io.Serializable {


     private AffaireId id;
     private Devis devis;
     private Projet projet;
     private Date datedebutaffaire;
     private Date datefinaffaire;
     private String descprojet;
     private BigDecimal montantaffaire;
     private Set taches = new HashSet(0);
     private Set boncommandes = new HashSet(0);
     private Set factures = new HashSet(0);

    public Affaire() {
    }

	
    public Affaire(AffaireId id, Devis devis, Projet projet) {
        this.id = id;
        this.devis = devis;
        this.projet = projet;
    }
    public Affaire(AffaireId id, Devis devis, Projet projet, Date datedebutaffaire, Date datefinaffaire, String descprojet, BigDecimal montantaffaire, Set taches, Set boncommandes, Set factures) {
       this.id = id;
       this.devis = devis;
       this.projet = projet;
       this.datedebutaffaire = datedebutaffaire;
       this.datefinaffaire = datefinaffaire;
       this.descprojet = descprojet;
       this.montantaffaire = montantaffaire;
       this.taches = taches;
       this.boncommandes = boncommandes;
       this.factures = factures;
    }
   
    public AffaireId getId() {
        return this.id;
    }
    
    public void setId(AffaireId id) {
        this.id = id;
    }
    public Devis getDevis() {
        return this.devis;
    }
    
    public void setDevis(Devis devis) {
        this.devis = devis;
    }
    public Projet getProjet() {
        return this.projet;
    }
    
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    public Date getDatedebutaffaire() {
        return this.datedebutaffaire;
    }
    
    public void setDatedebutaffaire(Date datedebutaffaire) {
        this.datedebutaffaire = datedebutaffaire;
    }
    public Date getDatefinaffaire() {
        return this.datefinaffaire;
    }
    
    public void setDatefinaffaire(Date datefinaffaire) {
        this.datefinaffaire = datefinaffaire;
    }
    public String getDescprojet() {
        return this.descprojet;
    }
    
    public void setDescprojet(String descprojet) {
        this.descprojet = descprojet;
    }
    public BigDecimal getMontantaffaire() {
        return this.montantaffaire;
    }
    
    public void setMontantaffaire(BigDecimal montantaffaire) {
        this.montantaffaire = montantaffaire;
    }
    public Set getTaches() {
        return this.taches;
    }
    
    public void setTaches(Set taches) {
        this.taches = taches;
    }
    public Set getBoncommandes() {
        return this.boncommandes;
    }
    
    public void setBoncommandes(Set boncommandes) {
        this.boncommandes = boncommandes;
    }
    public Set getFactures() {
        return this.factures;
    }
    
    public void setFactures(Set factures) {
        this.factures = factures;
    }




}


