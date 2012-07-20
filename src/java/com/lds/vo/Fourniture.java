package com.lds.vo;
// Generated 20 juil. 2012 18:55:33 by Hibernate Tools 3.2.1.GA



/**
 * Fourniture generated by hbm2java
 */
public class Fourniture  implements java.io.Serializable {


     private FournitureId id;
     private Element element;
     private String descfourniture;
     private Integer qntfourniture;

    public Fourniture() {
    }

	
    public Fourniture(FournitureId id, Element element) {
        this.id = id;
        this.element = element;
    }
    public Fourniture(FournitureId id, Element element, String descfourniture, Integer qntfourniture) {
       this.id = id;
       this.element = element;
       this.descfourniture = descfourniture;
       this.qntfourniture = qntfourniture;
    }
   
    public FournitureId getId() {
        return this.id;
    }
    
    public void setId(FournitureId id) {
        this.id = id;
    }
    public Element getElement() {
        return this.element;
    }
    
    public void setElement(Element element) {
        this.element = element;
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




}


