package com.lds.vo;
// Generated 13 juil. 2012 07:24:47 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Detailstachepersonnel generated by hbm2java
 */
public class Detailstachepersonnel  implements java.io.Serializable {


     private DetailstachepersonnelId id;
     private Tache tache;
     private Personnel personnel;
     private Date datedebut;
     private Date datefin;

    public Detailstachepersonnel() {
    }

	
    public Detailstachepersonnel(DetailstachepersonnelId id, Tache tache, Personnel personnel) {
        this.id = id;
        this.tache = tache;
        this.personnel = personnel;
    }
    public Detailstachepersonnel(DetailstachepersonnelId id, Tache tache, Personnel personnel, Date datedebut, Date datefin) {
       this.id = id;
       this.tache = tache;
       this.personnel = personnel;
       this.datedebut = datedebut;
       this.datefin = datefin;
    }
   
    public DetailstachepersonnelId getId() {
        return this.id;
    }
    
    public void setId(DetailstachepersonnelId id) {
        this.id = id;
    }
    public Tache getTache() {
        return this.tache;
    }
    
    public void setTache(Tache tache) {
        this.tache = tache;
    }
    public Personnel getPersonnel() {
        return this.personnel;
    }
    
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    public Date getDatedebut() {
        return this.datedebut;
    }
    
    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }
    public Date getDatefin() {
        return this.datefin;
    }
    
    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }




}


