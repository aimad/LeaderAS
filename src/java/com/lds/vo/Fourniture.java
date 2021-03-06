package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Fourniture generated by hbm2java
 */
public class Fourniture  implements java.io.Serializable {


     private String numfourniture;
     private String descfourniture;
     private Integer qntfourniture;
     private Set detailsfourniturebesoins = new HashSet(0);
     private Set detailsfourniturebcs = new HashSet(0);
     private Set detailsbrfournitures = new HashSet(0);
     private Set detailssortiefournitures = new HashSet(0);

    public Fourniture() {
    }

	
    public Fourniture(String numfourniture) {
        this.numfourniture = numfourniture;
    }
    public Fourniture(String numfourniture, String descfourniture, Integer qntfourniture, Set detailsfourniturebesoins, Set detailsfourniturebcs, Set detailsbrfournitures, Set detailssortiefournitures) {
       this.numfourniture = numfourniture;
       this.descfourniture = descfourniture;
       this.qntfourniture = qntfourniture;
       this.detailsfourniturebesoins = detailsfourniturebesoins;
       this.detailsfourniturebcs = detailsfourniturebcs;
       this.detailsbrfournitures = detailsbrfournitures;
       this.detailssortiefournitures = detailssortiefournitures;
    }
   
    public String getNumfourniture() {
        return this.numfourniture;
    }
    
    public void setNumfourniture(String numfourniture) {
        this.numfourniture = numfourniture;
    }
    public String getDescfourniture() {
        return this.descfourniture;
    }
    
    public void setDescfourniture(String descfourniture) {
        this.descfourniture = descfourniture;
    }
    public Integer getQntfourniture() {
        return this.qntfourniture;
    }
    
    public void setQntfourniture(Integer qntfourniture) {
        this.qntfourniture = qntfourniture;
    }
    public Set getDetailsfourniturebesoins() {
        return this.detailsfourniturebesoins;
    }
    
    public void setDetailsfourniturebesoins(Set detailsfourniturebesoins) {
        this.detailsfourniturebesoins = detailsfourniturebesoins;
    }
    public Set getDetailsfourniturebcs() {
        return this.detailsfourniturebcs;
    }
    
    public void setDetailsfourniturebcs(Set detailsfourniturebcs) {
        this.detailsfourniturebcs = detailsfourniturebcs;
    }
    public Set getDetailsbrfournitures() {
        return this.detailsbrfournitures;
    }
    
    public void setDetailsbrfournitures(Set detailsbrfournitures) {
        this.detailsbrfournitures = detailsbrfournitures;
    }
    public Set getDetailssortiefournitures() {
        return this.detailssortiefournitures;
    }
    
    public void setDetailssortiefournitures(Set detailssortiefournitures) {
        this.detailssortiefournitures = detailssortiefournitures;
    }




}


