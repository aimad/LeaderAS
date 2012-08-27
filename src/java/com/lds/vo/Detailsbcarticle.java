package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA



/**
 * Detailsbcarticle generated by hbm2java
 */
public class Detailsbcarticle  implements java.io.Serializable {


     private DetailsbcarticleId id;
     private Boncommande boncommande;
     private Article article;
     private Double prixunitaire;
     private Integer qntcommande;
     private Integer qntlivre;

    public Detailsbcarticle() {
    }

	
    public Detailsbcarticle(DetailsbcarticleId id, Boncommande boncommande, Article article) {
        this.id = id;
        this.boncommande = boncommande;
        this.article = article;
    }
    public Detailsbcarticle(DetailsbcarticleId id, Boncommande boncommande, Article article, Double prixunitaire, Integer qntcommande, Integer qntlivre) {
       this.id = id;
       this.boncommande = boncommande;
       this.article = article;
       this.prixunitaire = prixunitaire;
       this.qntcommande = qntcommande;
       this.qntlivre = qntlivre;
    }
   
    public DetailsbcarticleId getId() {
        return this.id;
    }
    
    public void setId(DetailsbcarticleId id) {
        this.id = id;
    }
    public Boncommande getBoncommande() {
        return this.boncommande;
    }
    
    public void setBoncommande(Boncommande boncommande) {
        this.boncommande = boncommande;
    }
    public Article getArticle() {
        return this.article;
    }
    
    public void setArticle(Article article) {
        this.article = article;
    }
    public Double getPrixunitaire() {
        return this.prixunitaire;
    }
    
    public void setPrixunitaire(Double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }
    public Integer getQntcommande() {
        return this.qntcommande;
    }
    
    public void setQntcommande(Integer qntcommande) {
        this.qntcommande = qntcommande;
    }
    public Integer getQntlivre() {
        return this.qntlivre;
    }
    
    public void setQntlivre(Integer qntlivre) {
        this.qntlivre = qntlivre;
    }




}


