package com.lds.beans;

import com.lds.persistance.*;
import com.lds.vo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;

public class BesoinBean implements Serializable {

    private BesoinDao dao;
    private Besoin besoin;
    private List<Besoin> besoins;
    private Besoin selectedBesoin;
    private LazyDataModel<Besoin> mediumBesoinsModel;
    private String id_projet;
    private BesoinarticleDataModel mediumbesoindetailsModel;
    private DetailsBesoinArticleHDao1 details_article_dao;
    private Detailsarticlebesoin  selecteddetailsbesoinarticle;
    private String id_article;
    private String qnt_besoin;
    private String id_fourniture;
    private ArticleHDao article_dao;
    private FournitureHDao fourniture_dao;
    private BesoinfournitureDataModel mediumbesoindetails_1Model;
    private Detailsfourniturebesoin  selecteddetailsbesoinfourniture;
    private DetailsBesoinFounitureHDao1 details_fourniture_dao;
    private String qnt_besoin2;

    
    
      public BesoinBean() {

        besoin = new Besoin();
        besoins = new ArrayList<Besoin>();
        //selectedBesoin=new Besoin();
        //populateRandomCars(cars, 50);  
        dao = new BesoinHDao();
        besoins = dao.getAllBesoin();
        mediumBesoinsModel = new BesoinDataModel(besoins);
        article_dao=new ArticleHDao();
        fourniture_dao=new FournitureHDao();
        details_fourniture_dao= new DetailsBesoinFounitureHDao1();
        details_article_dao =new DetailsBesoinArticleHDao1();
        qnt_besoin="";
            }
      public String getQnt_besoin2() {
        return qnt_besoin2;
    }

    public void setQnt_besoin2(String qnt_besoin2) {
        this.qnt_besoin2 = qnt_besoin2;
    }

       public BesoinfournitureDataModel getMediumbesoindetails_1Model() {
        return mediumbesoindetails_1Model;
    }

    public Detailsfourniturebesoin getSelecteddetailsbesoinfourniture() {
        return selecteddetailsbesoinfourniture;
    }

    public void setSelecteddetailsbesoinfourniture(Detailsfourniturebesoin selecteddetailsbesoinfourniture) {
        this.selecteddetailsbesoinfourniture = selecteddetailsbesoinfourniture;
    }

    public void setMediumbesoindetails_1Model(BesoinfournitureDataModel mediumbesoindetails_1Model) {
        this.mediumbesoindetails_1Model = mediumbesoindetails_1Model;
    }
 public String getId_article() {
        return id_article;
    }

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getId_fourniture() {
        return id_fourniture;
    }

    public void setId_fourniture(String id_fourniture) {
        this.id_fourniture = id_fourniture;
    }

    public String getQnt_besoin() {
         //System.out.println("GGGGGGGettttttttttttttttttttttttt");
        return qnt_besoin;
    }

    public void setQnt_besoin(String qnt_besoin) {
       // System.out.println("settttttttttttttttttttttttt");
        this.qnt_besoin = qnt_besoin;
         //System.out.println("settttttttttttttttttttttttt"+qnt_besoin);
    }

      public BesoinarticleDataModel getMediumbesoindetailsModel() {
        return mediumbesoindetailsModel;
    }

    public void setMediumbesoindetailsModel(BesoinarticleDataModel mediumbesoindetailsModel) {
        this.mediumbesoindetailsModel = mediumbesoindetailsModel;
    }

    public Detailsarticlebesoin getSelecteddetailsbesoinarticle() {
        return selecteddetailsbesoinarticle;
    }

    public void setSelecteddetailsbesoinarticle(Detailsarticlebesoin selecteddetailsbesoinarticle) {
        this.selecteddetailsbesoinarticle = selecteddetailsbesoinarticle;
    }
    public String getId_projet() {
        return id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }


    public List<Besoin> getBesoins() {
        return besoins;
    }

    public void setBesoins(List<Besoin> besoins) {
        this.besoins = besoins;
    }
 
  

    public Besoin getSelectedBesoin() {
        return selectedBesoin;
    }

    public void setSelectedBesoin(Besoin selectedBesoin) {
        this.selectedBesoin = selectedBesoin;
    }

    public LazyDataModel<Besoin> getMediumBesoinsModel() {
        return mediumBesoinsModel;
    }

    public Besoin getBesoin() {
        return besoin;
    }

    public void setBesoin(Besoin pers) {
        this.besoin = pers;
    }

  
    public void supprimer() {
        if (selectedBesoin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));
        }
        details_article_dao.deleteAll(selectedBesoin.getIdbesoin());
         dao.delete(selectedBesoin.getIdbesoin());
        besoins = dao.getAllBesoin();
        mediumBesoinsModel = new BesoinDataModel(besoins);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Besoin b : besoins) {
            if (b.getIdbesoin().equals(besoin.getIdbesoin())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cet employé existe dejà !", "Veuillez changer le login."));
                return "echecAjout";
            }
        }
        //sinon
        
       
       // besoin.setTypeuser(new Typeuser(typeUser));
        ProjetHDao projet_dao = new ProjetHDao();
        besoin.setProjet(projet_dao.getProjet(id_projet));
        dao.insert(besoin);
        besoin = new Besoin(); 
        id_projet="";
        besoins = dao.getAllBesoin();
        mediumBesoinsModel = new BesoinDataModel(besoins);
        return "succesAjout";

    }
    
    

    public String modif() {
        if (selectedBesoin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));
        return "";      
        }
        else
        {
           //typeUser=selectedBesoin.getTypeuser().getTypeuser();
            id_projet=selectedBesoin.getProjet().getIdprojet();
        return "modif";}
    }
    public String enrModif(){
        //selectedBesoin.setTypeuser(new Typeuser(typeUser));
        ProjetHDao projet_dao = new ProjetHDao();
        selectedBesoin.setProjet(projet_dao.getProjet(id_projet));
        dao.update(selectedBesoin);
        besoins = dao.getAllBesoin();
        id_projet="";
        mediumBesoinsModel = new BesoinDataModel(besoins);
        return "succesAjout";
    }
     public List<String> allprojet() {
        List<String> all = new ArrayList<String>();
       ProjetHDao projet_dao = new ProjetHDao();
        ArrayList<Projet> l = (ArrayList<Projet>) projet_dao.getAllProjet();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Projet pu = (Projet) li.next();
            all.add(pu.getIdprojet());
        }

        return all;
    }
     public String details()
     {
     if (selectedBesoin == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un besoin", "Selectionnez une ligne avec les cercles!"));
        return "";      
        }
        else
        {
           //typeUser=selectedBesoin.getTypeuser().getTypeuser();
            id_projet=selectedBesoin.getProjet().getIdprojet();
          
      mediumbesoindetails_1Model = new BesoinfournitureDataModel(details_fourniture_dao.getDetailsfourniturebesoins_id(selectedBesoin.getIdbesoin()));
        mediumbesoindetailsModel = new BesoinarticleDataModel(details_article_dao.getDetailsarticlebesoins_id(selectedBesoin.getIdbesoin()));
        return "details";
        }
     }
     public void supprimer_details() {
    //System.out.println("mmmmmmmmmmm");
        if (selecteddetailsbesoinarticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
        System.out.println("gggggggg");
        }
        //System.out.println("ggggggggggggggggggggg"+selecteddetailsbesoinarticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        
        details_article_dao.delete(selecteddetailsbesoinarticle.getId());
        mediumbesoindetailsModel = new BesoinarticleDataModel(details_article_dao.getDetailsarticlebesoins_id(selectedBesoin.getIdbesoin()));

    }
       public String enrDetails() {
   //System.out.println("wakkkkkkkwakkkkkkk");
        Article article = article_dao.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            System.err.println("ggg");
            return "details";
        }
        else
        {
        Integer t = new Integer(0);
        try {
            System.out.println(qnt_besoin+"hhh");
            t = new Integer(qnt_besoin);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            System.err.println("aaaaaaaaa");
            return "details";
        }
           // Article a = article_dao.getArticle(id_article);
             Detailsarticlebesoin details = new Detailsarticlebesoin(new DetailsarticlebesoinId(selectedBesoin.getIdbesoin(),id_article),t);
                details_article_dao.insert(details);
               // Integer  = article_dao.getArticle(id_article);
               mediumbesoindetailsModel = new BesoinarticleDataModel(details_article_dao.getDetailsarticlebesoins_id(selectedBesoin.getIdbesoin()));

                return "details";
            
       }
} 
       public void supprimer_details_four()
{
//System.out.println("mmmmmmmmmmm");
        if (selecteddetailsbesoinfourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une fourniture", "Selectionnez une ligne !"));
       //System.out.println("gggggggg");
        }
        //System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        details_fourniture_dao.delete(selecteddetailsbesoinfourniture.getId());
        mediumbesoindetails_1Model = new BesoinfournitureDataModel(details_fourniture_dao.getDetailsfourniturebesoins_id(selectedBesoin.getIdbesoin()));

   
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
            t = new Integer(qnt_besoin2);
        } catch (Exception e) {
           // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("N° Fourniture n'exist pas  !", "Veuillez changer le Code de fourniture."));
            //System.err.println("aaaaaaaaa");
            return "details";
        }
           
            Detailsfourniturebesoin details = new Detailsfourniturebesoin(new DetailsfourniturebesoinId(selectedBesoin.getIdbesoin(),id_fourniture),fourniture,selectedBesoin,t);
                details_fourniture_dao.insert(details);
               // Integer  = article_dao.getArticle(id_article);
                mediumbesoindetails_1Model = new BesoinfournitureDataModel(details_fourniture_dao.getDetailsfourniturebesoins_id(selectedBesoin.getIdbesoin()));

                return "details";
            
        }
    }
}
