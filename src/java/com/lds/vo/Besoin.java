package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Besoin generated by hbm2java
 */
public class Besoin  implements java.io.Serializable {


     private String idbesoin;
     private Projet projet;
     private Date datebesoin;
     private String descbesoin;
     private Set detailsfourniturebesoins = new HashSet(0);

    public Besoin() {
    }

	
    public Besoin(String idbesoin, Projet projet) {
        this.idbesoin = idbesoin;
        this.projet = projet;
    }
    public Besoin(String idbesoin, Projet projet, Date datebesoin, String descbesoin, Set detailsfourniturebesoins) {
       this.idbesoin = idbesoin;
       this.projet = projet;
       this.datebesoin = datebesoin;
       this.descbesoin = descbesoin;
       this.detailsfourniturebesoins = detailsfourniturebesoins;
    }
   
    public String getIdbesoin() {
        return this.idbesoin;
    }
    
    public void setIdbesoin(String idbesoin) {
        this.idbesoin = idbesoin;
    }
    public Projet getProjet() {
        return this.projet;
    }
    
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    public Date getDatebesoin() {
        return this.datebesoin;
    }
    
    public void setDatebesoin(Date datebesoin) {
        this.datebesoin = datebesoin;
    }
    public String getDescbesoin() {
        return this.descbesoin;
    }
    
    public void setDescbesoin(String descbesoin) {
        this.descbesoin = descbesoin;
    }
    public Set getDetailsfourniturebesoins() {
        return this.detailsfourniturebesoins;
    }
    
    public void setDetailsfourniturebesoins(Set detailsfourniturebesoins) {
        this.detailsfourniturebesoins = detailsfourniturebesoins;
    }




}


