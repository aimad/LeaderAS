package com.lds.vo;
// Generated 13 juil. 2012 11:34:38 by Hibernate Tools 3.2.1.GA



/**
 * Detailselementbesoin generated by hbm2java
 */
public class Detailselementbesoin  implements java.io.Serializable {


     private DetailselementbesoinId id;
     private Element element;
     private Besoin besoin;
     private Integer qntbesoin;

    public Detailselementbesoin() {
    }

	
    public Detailselementbesoin(DetailselementbesoinId id, Element element, Besoin besoin) {
        this.id = id;
        this.element = element;
        this.besoin = besoin;
    }
    public Detailselementbesoin(DetailselementbesoinId id, Element element, Besoin besoin, Integer qntbesoin) {
       this.id = id;
       this.element = element;
       this.besoin = besoin;
       this.qntbesoin = qntbesoin;
    }
   
    public DetailselementbesoinId getId() {
        return this.id;
    }
    
    public void setId(DetailselementbesoinId id) {
        this.id = id;
    }
    public Element getElement() {
        return this.element;
    }
    
    public void setElement(Element element) {
        this.element = element;
    }
    public Besoin getBesoin() {
        return this.besoin;
    }
    
    public void setBesoin(Besoin besoin) {
        this.besoin = besoin;
    }
    public Integer getQntbesoin() {
        return this.qntbesoin;
    }
    
    public void setQntbesoin(Integer qntbesoin) {
        this.qntbesoin = qntbesoin;
    }




}


