package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA



/**
 * Detailsfourniturebc generated by hbm2java
 */
public class Detailsfourniturebc  implements java.io.Serializable {


     private DetailsfourniturebcId id;
     private Fourniture fourniture;
     private Boncommande boncommande;
     private Integer qntCommande;
     private Double prixUnitaire;
     private Integer qntLivre;

    public Detailsfourniturebc() {
    }

	
    public Detailsfourniturebc(DetailsfourniturebcId id, Fourniture fourniture, Boncommande boncommande) {
        this.id = id;
        this.fourniture = fourniture;
        this.boncommande = boncommande;
    }
    public Detailsfourniturebc(DetailsfourniturebcId id, Fourniture fourniture, Boncommande boncommande, Integer qntCommande, Double prixUnitaire, Integer qntLivre) {
       this.id = id;
       this.fourniture = fourniture;
       this.boncommande = boncommande;
       this.qntCommande = qntCommande;
       this.prixUnitaire = prixUnitaire;
       this.qntLivre = qntLivre;
    }
   
    public DetailsfourniturebcId getId() {
        return this.id;
    }
    
    public void setId(DetailsfourniturebcId id) {
        this.id = id;
    }
    public Fourniture getFourniture() {
        return this.fourniture;
    }
    
    public void setFourniture(Fourniture fourniture) {
        this.fourniture = fourniture;
    }
    public Boncommande getBoncommande() {
        return this.boncommande;
    }
    
    public void setBoncommande(Boncommande boncommande) {
        this.boncommande = boncommande;
    }
    public Integer getQntCommande() {
        return this.qntCommande;
    }
    
    public void setQntCommande(Integer qntCommande) {
        this.qntCommande = qntCommande;
    }
    public Double getPrixUnitaire() {
        return this.prixUnitaire;
    }
    
    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public Integer getQntLivre() {
        return this.qntLivre;
    }
    
    public void setQntLivre(Integer qntLivre) {
        this.qntLivre = qntLivre;
    }




}


