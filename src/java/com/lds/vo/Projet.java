package com.lds.vo;
// Generated 16 juil. 2012 17:30:31 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Projet generated by hbm2java
 */
public class Projet  implements java.io.Serializable {


     private String idprojet;
     private Client client;
     private Set interventions = new HashSet(0);
     private Set affaires = new HashSet(0);
     private Set reservations = new HashSet(0);
     private Set besoins = new HashSet(0);

    public Projet() {
    }

	
    public Projet(String idprojet, Client client) {
        this.idprojet = idprojet;
        this.client = client;
    }
    public Projet(String idprojet, Client client, Set interventions, Set affaires, Set reservations, Set besoins) {
       this.idprojet = idprojet;
       this.client = client;
       this.interventions = interventions;
       this.affaires = affaires;
       this.reservations = reservations;
       this.besoins = besoins;
    }
   
    public String getIdprojet() {
        return this.idprojet;
    }
    
    public void setIdprojet(String idprojet) {
        this.idprojet = idprojet;
    }
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    public Set getInterventions() {
        return this.interventions;
    }
    
    public void setInterventions(Set interventions) {
        this.interventions = interventions;
    }
    public Set getAffaires() {
        return this.affaires;
    }
    
    public void setAffaires(Set affaires) {
        this.affaires = affaires;
    }
    public Set getReservations() {
        return this.reservations;
    }
    
    public void setReservations(Set reservations) {
        this.reservations = reservations;
    }
    public Set getBesoins() {
        return this.besoins;
    }
    
    public void setBesoins(Set besoins) {
        this.besoins = besoins;
    }




}


