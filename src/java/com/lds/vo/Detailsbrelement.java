package com.lds.vo;
// Generated 13 juil. 2012 11:34:38 by Hibernate Tools 3.2.1.GA



/**
 * Detailsbrelement generated by hbm2java
 */
public class Detailsbrelement  implements java.io.Serializable {


     private DetailsbrelementId id;
     private Bonreception bonreception;
     private Element element;
     private Integer qntlivre;

    public Detailsbrelement() {
    }

	
    public Detailsbrelement(DetailsbrelementId id, Bonreception bonreception, Element element) {
        this.id = id;
        this.bonreception = bonreception;
        this.element = element;
    }
    public Detailsbrelement(DetailsbrelementId id, Bonreception bonreception, Element element, Integer qntlivre) {
       this.id = id;
       this.bonreception = bonreception;
       this.element = element;
       this.qntlivre = qntlivre;
    }
   
    public DetailsbrelementId getId() {
        return this.id;
    }
    
    public void setId(DetailsbrelementId id) {
        this.id = id;
    }
    public Bonreception getBonreception() {
        return this.bonreception;
    }
    
    public void setBonreception(Bonreception bonreception) {
        this.bonreception = bonreception;
    }
    public Element getElement() {
        return this.element;
    }
    
    public void setElement(Element element) {
        this.element = element;
    }
    public Integer getQntlivre() {
        return this.qntlivre;
    }
    
    public void setQntlivre(Integer qntlivre) {
        this.qntlivre = qntlivre;
    }




}


