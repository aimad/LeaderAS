package com.lds.vo;
// Generated 20 juil. 2012 18:55:33 by Hibernate Tools 3.2.1.GA



/**
 * Detailssortieelement generated by hbm2java
 */
public class Detailssortieelement  implements java.io.Serializable {


     private DetailssortieelementId id;
     private Element element;
     private Bonsortie bonsortie;
     private Integer qntsortie;

    public Detailssortieelement() {
    }

	
    public Detailssortieelement(DetailssortieelementId id, Element element, Bonsortie bonsortie) {
        this.id = id;
        this.element = element;
        this.bonsortie = bonsortie;
    }
    public Detailssortieelement(DetailssortieelementId id, Element element, Bonsortie bonsortie, Integer qntsortie) {
       this.id = id;
       this.element = element;
       this.bonsortie = bonsortie;
       this.qntsortie = qntsortie;
    }
   
    public DetailssortieelementId getId() {
        return this.id;
    }
    
    public void setId(DetailssortieelementId id) {
        this.id = id;
    }
    public Element getElement() {
        return this.element;
    }
    
    public void setElement(Element element) {
        this.element = element;
    }
    public Bonsortie getBonsortie() {
        return this.bonsortie;
    }
    
    public void setBonsortie(Bonsortie bonsortie) {
        this.bonsortie = bonsortie;
    }
    public Integer getQntsortie() {
        return this.qntsortie;
    }
    
    public void setQntsortie(Integer qntsortie) {
        this.qntsortie = qntsortie;
    }




}


