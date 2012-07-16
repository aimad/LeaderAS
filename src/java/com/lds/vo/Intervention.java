package com.lds.vo;
// Generated 16 juil. 2012 17:30:31 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Intervention generated by hbm2java
 */
public class Intervention  implements java.io.Serializable {


     private InterventionId id;
     private Projet projet;
     private String descintervention;
     private Date dateintervention;
     private String lieuintervention;

    public Intervention() {
    }

	
    public Intervention(InterventionId id, Projet projet) {
        this.id = id;
        this.projet = projet;
    }
    public Intervention(InterventionId id, Projet projet, String descintervention, Date dateintervention, String lieuintervention) {
       this.id = id;
       this.projet = projet;
       this.descintervention = descintervention;
       this.dateintervention = dateintervention;
       this.lieuintervention = lieuintervention;
    }
   
    public InterventionId getId() {
        return this.id;
    }
    
    public void setId(InterventionId id) {
        this.id = id;
    }
    public Projet getProjet() {
        return this.projet;
    }
    
    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    public String getDescintervention() {
        return this.descintervention;
    }
    
    public void setDescintervention(String descintervention) {
        this.descintervention = descintervention;
    }
    public Date getDateintervention() {
        return this.dateintervention;
    }
    
    public void setDateintervention(Date dateintervention) {
        this.dateintervention = dateintervention;
    }
    public String getLieuintervention() {
        return this.lieuintervention;
    }
    
    public void setLieuintervention(String lieuintervention) {
        this.lieuintervention = lieuintervention;
    }




}


