package com.lds.vo;
// Generated 7 aout 2012 07:43:48 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Privilege generated by hbm2java
 */
public class Privilege  implements java.io.Serializable {


     private String idpriv;
     private String lienpriv;
     private String nompriv;
     private Set detailsprivusers = new HashSet(0);

    public Privilege() {
    }

	
    public Privilege(String idpriv) {
        this.idpriv = idpriv;
    }
    public Privilege(String idpriv, String lienpriv, String nompriv, Set detailsprivusers) {
       this.idpriv = idpriv;
       this.lienpriv = lienpriv;
       this.nompriv = nompriv;
       this.detailsprivusers = detailsprivusers;
    }
   
    public String getIdpriv() {
        return this.idpriv;
    }
    
    public void setIdpriv(String idpriv) {
        this.idpriv = idpriv;
    }
    public String getLienpriv() {
        return this.lienpriv;
    }
    
    public void setLienpriv(String lienpriv) {
        this.lienpriv = lienpriv;
    }
    public String getNompriv() {
        return this.nompriv;
    }
    
    public void setNompriv(String nompriv) {
        this.nompriv = nompriv;
    }
    public Set getDetailsprivusers() {
        return this.detailsprivusers;
    }
    
    public void setDetailsprivusers(Set detailsprivusers) {
        this.detailsprivusers = detailsprivusers;
    }




}


