package com.lds.vo;
// Generated 16 juil. 2012 17:30:31 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * Detailsbcelement generated by hbm2java
 */
public class Detailsbcelement  implements java.io.Serializable {


     private DetailsbcelementId id;
     private Element element;
     private Boncommande boncommande;
     private String qntcommande;
     private BigDecimal prixunitaire;

    public Detailsbcelement() {
    }

	
    public Detailsbcelement(DetailsbcelementId id, Element element, Boncommande boncommande) {
        this.id = id;
        this.element = element;
        this.boncommande = boncommande;
    }
    public Detailsbcelement(DetailsbcelementId id, Element element, Boncommande boncommande, String qntcommande, BigDecimal prixunitaire) {
       this.id = id;
       this.element = element;
       this.boncommande = boncommande;
       this.qntcommande = qntcommande;
       this.prixunitaire = prixunitaire;
    }
   
    public DetailsbcelementId getId() {
        return this.id;
    }
    
    public void setId(DetailsbcelementId id) {
        this.id = id;
    }
    public Element getElement() {
        return this.element;
    }
    
    public void setElement(Element element) {
        this.element = element;
    }
    public Boncommande getBoncommande() {
        return this.boncommande;
    }
    
    public void setBoncommande(Boncommande boncommande) {
        this.boncommande = boncommande;
    }
    public String getQntcommande() {
        return this.qntcommande;
    }
    
    public void setQntcommande(String qntcommande) {
        this.qntcommande = qntcommande;
    }
    public BigDecimal getPrixunitaire() {
        return this.prixunitaire;
    }
    
    public void setPrixunitaire(BigDecimal prixunitaire) {
        this.prixunitaire = prixunitaire;
    }




}


