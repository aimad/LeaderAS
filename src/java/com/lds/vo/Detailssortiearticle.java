package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA



/**
 * Detailssortiearticle generated by hbm2java
 */
public class Detailssortiearticle  implements java.io.Serializable {


     private DetailssortiearticleId id;
     private Bonsortie bonsortie;
     private Article article;
     private Integer qntsortie;
     private Integer qntretour;

    public Detailssortiearticle() {
    }

	
    public Detailssortiearticle(DetailssortiearticleId id, Bonsortie bonsortie, Article article) {
        this.id = id;
        this.bonsortie = bonsortie;
        this.article = article;
    }
    public Detailssortiearticle(DetailssortiearticleId id, Bonsortie bonsortie, Article article, Integer qntsortie, Integer qntretour) {
       this.id = id;
       this.bonsortie = bonsortie;
       this.article = article;
       this.qntsortie = qntsortie;
       this.qntretour = qntretour;
    }
   
    public DetailssortiearticleId getId() {
        return this.id;
    }
    
    public void setId(DetailssortiearticleId id) {
        this.id = id;
    }
    public Bonsortie getBonsortie() {
        return this.bonsortie;
    }
    
    public void setBonsortie(Bonsortie bonsortie) {
        this.bonsortie = bonsortie;
    }
    public Article getArticle() {
        return this.article;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }
    public Integer getQntsortie() {
        return this.qntsortie;
    }
    
    public void setQntsortie(Integer qntsortie) {
        this.qntsortie = qntsortie;
    }
    public Integer getQntretour() {
        return this.qntretour;
    }
    
    public void setQntretour(Integer qntretour) {
        this.qntretour = qntretour;
    }




}

