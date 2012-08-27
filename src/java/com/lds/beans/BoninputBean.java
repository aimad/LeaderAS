/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;


import com.lds.persistance.ArticleHDao;
import com.lds.persistance.BonCommandeHDao;
import com.lds.persistance.BonReceptionHDao;
import com.lds.persistance.DetailsBcArticleHDao;
import com.lds.persistance.DetailsBcFournitureHDao;
import com.lds.persistance.DetailsInputArticleHDao;
import com.lds.persistance.DetailsInputFournitureHDao;
import com.lds.persistance.FournitureHDao;
import com.lds.vo.Article;
import com.lds.vo.Boncommande;
import com.lds.vo.Bonreception;
import com.lds.vo.Detailsbcarticle;
import com.lds.vo.DetailsbcarticleId;
import com.lds.vo.Detailsbrarticle;
import com.lds.vo.DetailsbrarticleId;
import com.lds.vo.Detailsbrfourniture;
import com.lds.vo.Detailsfourniturebc;
import com.lds.vo.DetailsfourniturebcId;
import com.lds.vo.Fourniture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
  
 
  
public class BoninputBean implements Serializable {  
   
    public BoninputBean() {          
        elt = new Bonreception();
        bonreceptions = new ArrayList<Bonreception>();
        //selectedBonreception=new Bonreception();
        //populateRandomCars(cars, 50);  
        dao = new BonReceptionHDao();
        bonreceptions = dao.getAllBonReceptions();
        mediumBonreceptionsModel = new BoninputDataModel(bonreceptions); 
        detailsInputArticleHDao=new DetailsInputArticleHDao();
        detailsInputFournitureHDao=new DetailsInputFournitureHDao();
        article_dao=new ArticleHDao();
        fourniture_dao=new FournitureHDao();
    } 
  
    private List<Bonreception> filteredBonreceptions;  
  
    private List<Bonreception> bonreceptions;  
  
    private Bonreception selectedBonreception;  
  
    private Bonreception[] selectedBonreceptions;
    
    private Bonreception elt;
    private BonReceptionHDao dao;
    private BoninputDataModel mediumBonreceptionsModel;
    private String id_bonreception;
    private String id_commande;
    private details_input_sortie_article_DataModel mediumInputdetailsModel;
    private Detailsbrarticle selecteddetailsinputarticle;
    private String qnt_livre;
    private String id_article;
    private DetailsInputArticleHDao detailsInputArticleHDao;
    private String id_fourniture;
    private DetailsInputFournitureHDao detailsInputFournitureHDao;
    private Detailsbrfourniture selecteddetailsinputfourniture;
    private details_input_fourniture_DataModel mediumInputdetailsModel_four;
    private ArticleHDao article_dao;
    private FournitureHDao fourniture_dao;
    private String qnt_livre2;

    public String getQnt_livre2() {
        return qnt_livre2;
    }

    public void setQnt_livre2(String qnt_livre2) {
        this.qnt_livre2 = qnt_livre2;
    }
    
    public DetailsInputFournitureHDao getDetailsInputFournitureHDao() {
        return detailsInputFournitureHDao;
    }

    public void setDetailsInputFournitureHDao(DetailsInputFournitureHDao detailsInputFournitureHDao) {
        this.detailsInputFournitureHDao = detailsInputFournitureHDao;
    }

    public String getId_fourniture() {
        return id_fourniture;
    }

    public void setId_fourniture(String id_fourniture) {
        this.id_fourniture = id_fourniture;
    }

    public details_input_fourniture_DataModel getMediumInputdetailsModel_four() {
        return mediumInputdetailsModel_four;
    }

    public void setMediumInputdetailsModel_four(details_input_fourniture_DataModel mediumInputdetailsModel_four) {
        this.mediumInputdetailsModel_four = mediumInputdetailsModel_four;
    }

    public Detailsbrfourniture getSelecteddetailsinputfourniture() {
        return selecteddetailsinputfourniture;
    }

    public void setSelecteddetailsinputfourniture(Detailsbrfourniture selecteddetailsinputfourniture) {
        this.selecteddetailsinputfourniture = selecteddetailsinputfourniture;
    }

    public String getId_article() {
        return id_article;
    }

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getQnt_livre() {
        return qnt_livre;
    }

    public void setQnt_livre(String qnt_livre) {
        this.qnt_livre = qnt_livre;
    }

    public Detailsbrarticle getSelecteddetailsinputarticle() {
        return selecteddetailsinputarticle;
    }

    public void setSelecteddetailsinputarticle(Detailsbrarticle selecteddetailsinputarticle) {
        this.selecteddetailsinputarticle = selecteddetailsinputarticle;
    }

    public details_input_sortie_article_DataModel getMediumInputdetailsModel() {
        return mediumInputdetailsModel;
    }

    public void setMediumInputdetailsModel(details_input_sortie_article_DataModel mediumInputdetailsModel) {
        this.mediumInputdetailsModel = mediumInputdetailsModel;
    }

    public String getId_commande() {
        return id_commande;
    }

    public void setId_commande(String id_commande) {
        this.id_commande = id_commande;
    }

    public void setId_bonreception(String id_bonreception) {
        this.id_bonreception = id_bonreception;
    }

    public String getId_bonreception() {
        return id_bonreception;
    }
  
    
  
    public Bonreception getSelectedBonreception() {  
        return selectedBonreception;  
    }  
  
    public void setSelectedBonreception(Bonreception selectedBonreception) {  
        this.selectedBonreception = selectedBonreception;  
    }  
       public LazyDataModel<Bonreception> getMediumBonreceptionsModel() {
        return mediumBonreceptionsModel;
    }

    public Bonreception getElt() {
        return elt;
    }

    public void setElt(Bonreception elt) {
        this.elt = elt;
    }
         
    public List<Bonreception> getFilteredBonreceptions() {  
        return filteredBonreceptions;  
    }  
  
    public void setFilteredBonreceptions(List<Bonreception> filteredBonreceptions) {  
        this.filteredBonreceptions = filteredBonreceptions;  
    }  
  
    public List<Bonreception> getBonreceptions() {  
        return bonreceptions;  
    }  
    public void supprimer() {
        if (selectedBonreception == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonreception", "Selectionnez une ligne !"));
        }
        
        dao.delete(selectedBonreception.getNumreception());
        //dao1.delete(selectedBonreception.getId().getIdbonreception());
        bonreceptions = dao.getAllBonReceptions();
        mediumBonreceptionsModel = new BoninputDataModel(bonreceptions);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Bonreception bonreception : bonreceptions) {
            if (bonreception.getNumreception().equals(elt.getNumreception())) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Ce bonreception existe dejà !", "Veuillez changer le Code de bonreception."));
                return "input_ajout";
            }
        }
        BonCommandeHDao comm=new BonCommandeHDao();
        List<Boncommande> commandes=comm.getAllBonCommandes();
        int k=0;
        for (Boncommande boncommande :commandes ) {
            if (boncommande.getNumbc().equals(id_commande)) {
               k=1;
            }
        }
        if(k==0)
        {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"N° Bon de commande n'exist pas !", "Veuillez changer le Code de Bon Commande."));
                return "input_ajout";
        }
        elt.setBoncommande(comm.getBonCommande(id_commande));
        //dao1.insert(new Element(id_bonreception));
        dao.insert(elt);
        elt = new Bonreception();
        bonreceptions = dao.getAllBonReceptions();
        id_commande=new String();
        mediumBonreceptionsModel = new BoninputDataModel(bonreceptions);
        return "succesAjoutArticle";

    }
    
    

    public String modif() {
        if (selectedBonreception == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonreception", "Selectionnez une ligne !"));
        return "";      
        }
        else
        {
            id_commande=selectedBonreception.getBoncommande().getNumbc();
           //typeUser=selectedBonreception.getTypeuser().getTypeuser();
        return "modif_input";}
    }
    
    public String enrModif(){
        //selectedBonreception.setTypeuser(new Typeuser(typeUser));
         BonCommandeHDao comm=new BonCommandeHDao();
         List<Boncommande> commandes=comm.getAllBonCommandes();
        int k=0;
        for (Boncommande boncommande :commandes ) {
            if (boncommande.getNumbc().equals(id_commande)) {
               k=1;
            }
        }
        if(k==0)
        {
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"N° Bon de commande n'exist pas !", "Veuillez changer le Code de Bon Commande."));
                return "modif_input";
        }
        selectedBonreception.setBoncommande(comm.getBonCommande(id_commande));
        dao.update(selectedBonreception);
        bonreceptions = dao.getAllBonReceptions();
        mediumBonreceptionsModel = new BoninputDataModel(bonreceptions);
        id_commande=new String();
        return "succesAjoutArticle";
    }
    public String details() {
        if (selectedBonreception == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un Bon livraison", "Selectionnez une ligne !"));
            return "";
        } else {
            mediumInputdetailsModel = new details_input_sortie_article_DataModel(detailsInputArticleHDao.getAllDetailsbrarticles_id(selectedBonreception.getNumreception()));
            mediumInputdetailsModel_four = new details_input_fourniture_DataModel(detailsInputFournitureHDao.getAllDetailsbrfournitures_id(selectedBonreception.getNumreception()));
             id_commande = selectedBonreception.getBoncommande().getNumbc();
               
            return "details_input";
        }
    }
    public List<String> getallarticle()
    {
    List <String> articles=new ArrayList<String>();
    DetailsBcArticleHDao details_article_bc=new DetailsBcArticleHDao();
    List<Detailsbcarticle> list_Detailsbcarticle=new ArrayList<Detailsbcarticle>();
    list_Detailsbcarticle=details_article_bc.getDetailsbcarticles_id(selectedBonreception.getBoncommande().getNumbc());
    Iterator li = list_Detailsbcarticle.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Detailsbcarticle pu = (Detailsbcarticle) li.next();
        articles.add(pu.getArticle().getIdarticle());
        }
        return articles;
    } 
    public List<String> getallfourniture()
    {
    List <String> fournitures=new ArrayList<String>();
    DetailsBcFournitureHDao details_fourniture_bc=new DetailsBcFournitureHDao();
    List<Detailsfourniturebc> list_Detailsbcfourniture=new ArrayList<Detailsfourniturebc>();
    list_Detailsbcfourniture=details_fourniture_bc.getDetailsfourniturebcs_id(selectedBonreception.getBoncommande().getNumbc());
    Iterator li = list_Detailsbcfourniture.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Detailsfourniturebc pu = (Detailsfourniturebc) li.next();
        fournitures.add(pu.getFourniture().getNumfourniture());
        }
        return fournitures;
    }
    public String enrDetails() {
   System.out.println("wakkkkkkkwakkkkkkk");
        Article article = article_dao.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("ggg");
            return "details_input";
        }
        else
        {
        Integer t = new Integer(0);
        try {
            t = new Integer(qnt_livre);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("aaaaaaaaa");
            return "details_input";
        }
        DetailsBcArticleHDao comm=new DetailsBcArticleHDao();
        Detailsbcarticle dca=comm.getDetailsbcarticle(new DetailsbcarticleId(selectedBonreception.getBoncommande().getNumbc(),id_article));
        Integer qnt_commande=dca.getQntcommande();
        qnt_commande=qnt_commande-dca.getQntlivre();
        if(qnt_commande<=0)
        {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "qnt_commande<=0  !", "Veuillez changer le Code d'article."));
           //System.err.println("LLLLLLLLLLLLL");
            return "details_input";
        }
        else
        {
          if(qnt_commande<t)
          {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Quantité demandé est inférieur que Quantité commandé  !", "Veuillez changer le Quantité d'article."));
            //System.err.println("MMMMMMMMMMMMMMMMM");
            return "details_input";
          }
          else
          {
        
        Detailsbrarticle dd = detailsInputArticleHDao.getDetailsbrarticle(new DetailsbrarticleId(selectedBonreception.getNumreception(),id_article));
        if (dd == null) {
            Article a = article_dao.getArticle(id_article);
             DetailsBcArticleHDao details_article_bc=new DetailsBcArticleHDao();
            Detailsbcarticle d_bc=details_article_bc.getDetailsbcarticle(new DetailsbcarticleId(selectedBonreception.getBoncommande().getNumbc(),id_article));
           
            Detailsbrarticle details = new Detailsbrarticle(new DetailsbrarticleId(selectedBonreception.getNumreception(),id_article),selectedBonreception,a,t);
                detailsInputArticleHDao.insert(details);
               // Integer  = article_dao.getArticle(id_article);
                a.setQntarticle(a.getQntarticle() + t);
                article_dao.update(a);
                d_bc.setQntlivre(d_bc.getQntlivre()+t);
                details_article_bc.update(d_bc);
                
                mediumInputdetailsModel = new details_input_sortie_article_DataModel(detailsInputArticleHDao.getAllDetailsbrarticles_id(selectedBonreception.getNumreception()));

                return "details_input";
            
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article Exist déja  !", "Veuillez changer le Code d'article."));
            //System.err.println("TTTTTTTTTTTTT");
            return "details_input";

        }
    }}}
} 
public void supprimer_details() {
    System.out.println("mmmmmmmmmmm");
        if (selecteddetailsinputarticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
        System.out.println("gggggggg");
        }
        //System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        detailsInputArticleHDao.delete(selecteddetailsinputarticle.getId());
        Article a = article_dao.getArticle(selecteddetailsinputarticle.getArticle().getIdarticle());
        a.setQntarticle(a.getQntarticle() - selecteddetailsinputarticle.getQntlivre());
        article_dao.update(a);
         DetailsBcArticleHDao details_article_bc=new DetailsBcArticleHDao();
            Detailsbcarticle d_bc=details_article_bc.getDetailsbcarticle(new DetailsbcarticleId(selectedBonreception.getBoncommande().getNumbc(),selecteddetailsinputarticle.getArticle().getIdarticle()));
           d_bc.setQntlivre(d_bc.getQntlivre()-selecteddetailsinputarticle.getQntlivre());
                details_article_bc.update(d_bc);
        mediumInputdetailsModel = new details_input_sortie_article_DataModel(detailsInputArticleHDao.getAllDetailsbrarticles_id(selectedBonreception.getNumreception()));

    }
public String enrDetails_four() {
   //System.out.println("ddd");
        Fourniture fourniture = fourniture_dao.getFourniture(id_fourniture);
        if (fourniture == null) {
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", ""));
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("N° Fourniture n'exist pas  !", "Veuillez changer le Code de fourniture."));
            //System.err.println("ggg");
            return "details_input";
        }
        else
        {
        Integer t = new Integer(0);
        try {
            t = new Integer(qnt_livre2);
        } catch (Exception e) {
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("N° Fourniture n'exist pas  !", "Veuillez changer le Code de fourniture."));
            //System.err.println("aaaaaaaaa");
            return "details_input";
        }
        DetailsBcFournitureHDao comm=new DetailsBcFournitureHDao();
        Detailsfourniturebc dca=comm.getDetailsbcfourniture(new DetailsfourniturebcId(selectedBonreception.getBoncommande().getNumbc(),id_fourniture));
  
        Integer qnt_commande=dca.getQntCommande();
        System.out.println("hhhhhhhhh"+qnt_commande);
        System.out.println("ggggggggggggggg");
        System.out.println("mmmmmmmmmmmm"+dca.getQntLivre());
        qnt_commande=qnt_commande-dca.getQntLivre();
        if(qnt_commande<=0)
        {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "qnt_commande<=0  !", "Veuillez changer le Code d'article."));
           System.err.println("LLLLLLLLLLLLL");
            return "details_input";
        }
        else
        {
          if(qnt_commande<t)
          {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Quantité demandé est inférieur que Quantité commandé  !", "Veuillez changer le Quantité d'article."));
            System.err.println("MMMMMMMMMMMMMMMMM");
            return "details_input";
          }
          else
          {
        
        Detailsbrfourniture dd = detailsInputFournitureHDao.getDetailsbrfourniture(id_fourniture,selectedBonreception.getNumreception());
        if (dd == null) {
            Fourniture a = fourniture_dao.getFourniture(id_fourniture);
             DetailsBcFournitureHDao details_fourniture_bc=new DetailsBcFournitureHDao();
            Detailsfourniturebc d_bc=details_fourniture_bc.getDetailsbcfourniture(new DetailsfourniturebcId(selectedBonreception.getBoncommande().getNumbc(),id_fourniture));
           
            Detailsbrfourniture details = new Detailsbrfourniture(id_fourniture+selectedBonreception.getNumreception(),a,selectedBonreception,t);
                detailsInputFournitureHDao.insert(details);
               // Integer  = article_dao.getArticle(id_article);
                a.setQntfourniture(a.getQntfourniture() + t);
                fourniture_dao.update(a);
                d_bc.setQntLivre(d_bc.getQntLivre()+t);
                details_fourniture_bc.update(d_bc);
                
                mediumInputdetailsModel_four = new details_input_fourniture_DataModel(detailsInputFournitureHDao.getAllDetailsbrfournitures_id(selectedBonreception.getNumreception()));

                return "details_input";
            
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article Exist déja  !", "Veuillez changer le Code d'article."));
            System.err.println("TTTTTTTTTTTTT");
            return "details_input";

        }
    }}}
    }
public void supprimer_details_four()
{
System.out.println("mmmmmmmmmmm");
        if (selecteddetailsinputfourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une fourniture", "Selectionnez une ligne !"));
       System.out.println("gggggggg");
        }
        //System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        detailsInputFournitureHDao.delete(selecteddetailsinputfourniture.getIddetails());
        Fourniture a = fourniture_dao.getFourniture(selecteddetailsinputfourniture.getFourniture().getNumfourniture());
        a.setQntfourniture(a.getQntfourniture() - selecteddetailsinputfourniture.getQntlivre());
        fourniture_dao.update(a);
         DetailsBcFournitureHDao details_fourniture_bc=new DetailsBcFournitureHDao();
            Detailsfourniturebc d_bc=details_fourniture_bc.getDetailsbcfourniture(new DetailsfourniturebcId(selectedBonreception.getBoncommande().getNumbc(),selecteddetailsinputfourniture.getFourniture().getNumfourniture()));
           d_bc.setQntLivre(d_bc.getQntLivre()-selecteddetailsinputfourniture.getQntlivre());
                details_fourniture_bc.update(d_bc);
       mediumInputdetailsModel_four = new details_input_fourniture_DataModel(detailsInputFournitureHDao.getAllDetailsbrfournitures_id(selectedBonreception.getNumreception()));

   
}
}