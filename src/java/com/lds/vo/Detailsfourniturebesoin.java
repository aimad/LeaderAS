package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA



/**
 * Detailsfourniturebesoin generated by hbm2java
 */
public class Detailsfourniturebesoin  implements java.io.Serializable {


     private DetailsfourniturebesoinId id;
     private Fourniture fourniture;
     private Besoin besoin;
     private Integer qntbesoin;

    public Detailsfourniturebesoin() {
    }

	
    public Detailsfourniturebesoin(DetailsfourniturebesoinId id, Fourniture fourniture, Besoin besoin) {
        this.id = id;
        this.fourniture = fourniture;
        this.besoin = besoin;
    }
    public Detailsfourniturebesoin(DetailsfourniturebesoinId id, Fourniture fourniture, Besoin besoin, Integer qntbesoin) {
       this.id = id;
       this.fourniture = fourniture;
       this.besoin = besoin;
       this.qntbesoin = qntbesoin;
    }
   
    public DetailsfourniturebesoinId getId() {
        return this.id;
    }
    
    public void setId(DetailsfourniturebesoinId id) {
        this.id = id;
    }
    public Fourniture getFourniture() {
        return this.fourniture;
    }
    
    public void setFourniture(Fourniture fourniture) {
        this.fourniture = fourniture;
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

