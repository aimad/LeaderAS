package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Element generated by hbm2java
 */
public class Element  implements java.io.Serializable {


     private String idelement;
     private Set fournitures = new HashSet(0);
     private Set detailsdemandeelements = new HashSet(0);
     private Set detailsbrelements = new HashSet(0);
     private Set detailssortieelements = new HashSet(0);
     private Set reservations = new HashSet(0);
     private Set articles = new HashSet(0);
     private Set detailselementbesoins = new HashSet(0);
     private Set detailsbcelements = new HashSet(0);

    public Element() {
    }

	
    public Element(String idelement) {
        this.idelement = idelement;
    }
    public Element(String idelement, Set fournitures, Set detailsdemandeelements, Set detailsbrelements, Set detailssortieelements, Set reservations, Set articles, Set detailselementbesoins, Set detailsbcelements) {
       this.idelement = idelement;
       this.fournitures = fournitures;
       this.detailsdemandeelements = detailsdemandeelements;
       this.detailsbrelements = detailsbrelements;
       this.detailssortieelements = detailssortieelements;
       this.reservations = reservations;
       this.articles = articles;
       this.detailselementbesoins = detailselementbesoins;
       this.detailsbcelements = detailsbcelements;
    }
   
    public String getIdelement() {
        return this.idelement;
    }
    
    public void setIdelement(String idelement) {
        this.idelement = idelement;
    }
    public Set getFournitures() {
        return this.fournitures;
    }
    
    public void setFournitures(Set fournitures) {
        this.fournitures = fournitures;
    }
    public Set getDetailsdemandeelements() {
        return this.detailsdemandeelements;
    }
    
    public void setDetailsdemandeelements(Set detailsdemandeelements) {
        this.detailsdemandeelements = detailsdemandeelements;
    }
    public Set getDetailsbrelements() {
        return this.detailsbrelements;
    }
    
    public void setDetailsbrelements(Set detailsbrelements) {
        this.detailsbrelements = detailsbrelements;
    }
    public Set getDetailssortieelements() {
        return this.detailssortieelements;
    }
    
    public void setDetailssortieelements(Set detailssortieelements) {
        this.detailssortieelements = detailssortieelements;
    }
    public Set getReservations() {
        return this.reservations;
    }
    
    public void setReservations(Set reservations) {
        this.reservations = reservations;
    }
    public Set getArticles() {
        return this.articles;
    }
    
    public void setArticles(Set articles) {
        this.articles = articles;
    }
    public Set getDetailselementbesoins() {
        return this.detailselementbesoins;
    }
    
    public void setDetailselementbesoins(Set detailselementbesoins) {
        this.detailselementbesoins = detailselementbesoins;
    }
    public Set getDetailsbcelements() {
        return this.detailsbcelements;
    }
    
    public void setDetailsbcelements(Set detailsbcelements) {
        this.detailsbcelements = detailsbcelements;
    }




}


