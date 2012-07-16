package com.lds.vo;
// Generated 16 juil. 2012 17:30:31 by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bonsortie generated by hbm2java
 */
public class Bonsortie  implements java.io.Serializable {


     private String idsortie;
     private Personnel personnel;
     private Date datesortie;
     private String descsortie;
     private Set detailssortieelements = new HashSet(0);

    public Bonsortie() {
    }

	
    public Bonsortie(String idsortie, Personnel personnel) {
        this.idsortie = idsortie;
        this.personnel = personnel;
    }
    public Bonsortie(String idsortie, Personnel personnel, Date datesortie, String descsortie, Set detailssortieelements) {
       this.idsortie = idsortie;
       this.personnel = personnel;
       this.datesortie = datesortie;
       this.descsortie = descsortie;
       this.detailssortieelements = detailssortieelements;
    }
   
    public String getIdsortie() {
        return this.idsortie;
    }
    
    public void setIdsortie(String idsortie) {
        this.idsortie = idsortie;
    }
    public Personnel getPersonnel() {
        return this.personnel;
    }
    
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    public Date getDatesortie() {
        return this.datesortie;
    }
    
    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }
    public String getDescsortie() {
        return this.descsortie;
    }
    
    public void setDescsortie(String descsortie) {
        this.descsortie = descsortie;
    }
    public Set getDetailssortieelements() {
        return this.detailssortieelements;
    }
    
    public void setDetailssortieelements(Set detailssortieelements) {
        this.detailssortieelements = detailssortieelements;
    }




}


