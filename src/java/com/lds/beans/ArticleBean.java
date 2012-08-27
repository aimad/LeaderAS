/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;


import com.lds.persistance.ArticleHDao;
import com.lds.vo.Article;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
  
 
  
public class ArticleBean implements Serializable {  
 
  
    private List<Article> filteredArticles;  
  
    private List<Article> articles;  
  
    private Article selectedArticle;  
  
    private Article[] selectedArticles;
    
    private  Article elt;
    private  ArticleHDao dao;
      private  ArticleDataModel mediumArticlesModel;
    private String id_article;

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getId_article() {
        return id_article;
    }
  
    public ArticleBean() {          
        elt = new Article();
        articles = new ArrayList<Article>();
        //selectedArticle=new Article();
        //populateRandomCars(cars, 50);  
        dao = new ArticleHDao();
        articles = dao.getAllArticle();
        mediumArticlesModel = new ArticleDataModel(articles); 
    }  
  
    public Article getSelectedArticle() {  
        return selectedArticle;  
    }  
  
    public void setSelectedArticle(Article selectedArticle) {  
        this.selectedArticle = selectedArticle;  
    }  
       public LazyDataModel<Article> getMediumArticlesModel() {
        return mediumArticlesModel;
    }

    public Article getElt() {
        return elt;
    }

    public void setElt(Article elt) {
        this.elt = elt;
    }
         
    public List<Article> getFilteredArticles() {  
        return filteredArticles;  
    }  
  
    public void setFilteredArticles(List<Article> filteredArticles) {  
        this.filteredArticles = filteredArticles;  
    }  
  
    public List<Article> getArticles() {  
        return articles;  
    }  
    public void supprimer() {
        if (selectedArticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un article", "Selectionnez une ligne !"));
        }
        
        dao.delete(selectedArticle.getIdarticle());
        //dao1.delete(selectedArticle.getId().getIdarticle());
        articles = dao.getAllArticle();
        mediumArticlesModel = new ArticleDataModel(articles);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Article article : articles) {
            if (article.getIdarticle().equals(elt.getIdarticle())) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Ce article existe dejà !", "Veuillez changer le Code de article."));
                return "article_ajout";
            }
        }
        elt.setIdarticle(id_article);
        //dao1.insert(new Element(id_article));
        dao.insert(elt);
        elt = new Article();
        articles = dao.getAllArticle();
        id_article=new String();
        mediumArticlesModel = new ArticleDataModel(articles);
        return "succesAjoutArticle";

    }
    
    

    public String modif() {
        if (selectedArticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un article", "Selectionnez une ligne !"));
        return "";      
        }
        else
        {
           //typeUser=selectedArticle.getTypeuser().getTypeuser();
        return "modif_stock";}
    }
    
    public String enrModif(){
        //selectedArticle.setTypeuser(new Typeuser(typeUser));
        dao.update(selectedArticle);
        articles = dao.getAllArticle();
        mediumArticlesModel = new ArticleDataModel(articles);
        return "succesAjoutArticle";
    }
    public List<String> allNomArticles() {
        List<String> all = new ArrayList<String>();                
        Iterator li = articles.iterator();
        while (li.hasNext()) {
//RecupÃ©ration objet
            Article pu = (Article) li.next();
            all.add(pu.getIdarticle());
        }

        return all;
    }
} 