/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ArticleHDao;
import com.lds.persistance.BonSortieHDao;
import com.lds.persistance.DetailsSortieArticleDao;
import com.lds.persistance.DetailsSortieArticleHDao;
import com.lds.persistance.DetailsSortieFournitureHDao;
import com.lds.persistance.FournitureHDao;
import com.lds.persistance.PersonnelHDao;
import com.lds.persistance.ProjetHDao;
import com.lds.vo.Article;
import com.lds.vo.Bonsortie;
import com.lds.vo.Detailssortiearticle;
import com.lds.vo.DetailssortiearticleId;
import com.lds.vo.Detailssortiefourniture;
import com.lds.vo.DetailssortiefournitureId;
import com.lds.vo.Fourniture;
import com.lds.vo.Personnel;
import com.lds.vo.Projet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ELKAOUMI
 */
@ManagedBean
@RequestScoped
public class SortieBean implements Serializable {

    private List<Bonsortie> filteredBonsorties;
    private Personnel pers;
    private List<Bonsortie> bonsorties;
    private Bonsortie selectedBonsortie;
    private Bonsortie[] selectedBonsorties;
    private Bonsortie sortie;
    private BonSortieHDao dao;
    private DetailsSortieArticleHDao dao2;
    private BonsortieDataModel mediumBonsortiesModel;
    private details_sortie_article_DataModel mediumBonsortiesdetailsModel;
    private details_sortie_fourniture_DataModel mediumBonsorties_fourdetailsModel;
    private String id_pers;
    private String id_projet;
    private PersonnelHDao dao1 = new PersonnelHDao();
    private Personnel p;
    private ProjetHDao projet_dao;
    private String id_article;
    private String id_fourniture;
    private String qnt_sortie;
    private ArticleHDao dao_article;
    private FournitureHDao dao_four;
    private DetailsSortieFournitureHDao dao_fourniture;
    private Detailssortiearticle selecteddetailssortiearticle;
    private Detailssortiefourniture selecteddetailssortiefourniture;
    private String qnt_sortie2;

    public SortieBean() {

        sortie = new Bonsortie();
        bonsorties = new ArrayList<Bonsortie>();
        //selectedBonsortie=new Bonsortie();
        //populateRandomCars(cars, 50);  
        dao = new BonSortieHDao();
        dao1 = new PersonnelHDao();
        projet_dao = new ProjetHDao();
        dao2 = new DetailsSortieArticleHDao();
        dao_fourniture = new DetailsSortieFournitureHDao();
        dao_article = new ArticleHDao();
        dao_four=new FournitureHDao();
        bonsorties = dao.getAllBonSorties();

        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        id_pers = new String();
        id_projet = new String();
        id_article = "";
        qnt_sortie = "";
    }

    public String getQnt_sortie2() {
        return qnt_sortie2;
    }

    public void setQnt_sortie2(String qnt_sortie2) {
        this.qnt_sortie2 = qnt_sortie2;
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

    public String getQnt_sortie() {

        return qnt_sortie;
    }

    public void setQnt_sortie(String qnt_sortie) {

        this.qnt_sortie = qnt_sortie;
    }

    public Detailssortiefourniture getSelecteddetailssortiefourniture() {
        return selecteddetailssortiefourniture;
    }

    public void setSelecteddetailssortiefourniture(Detailssortiefourniture selecteddetailssortiefourniture) {
        this.selecteddetailssortiefourniture = selecteddetailssortiefourniture;
    }

    public details_sortie_fourniture_DataModel getMediumBonsorties_fourdetailsModel() {
        return mediumBonsorties_fourdetailsModel;
    }

    public void setMediumBonsorties_fourdetailsModel(details_sortie_fourniture_DataModel mediumBonsorties_fourdetailsModel) {
        this.mediumBonsorties_fourdetailsModel = mediumBonsorties_fourdetailsModel;
    }

    public Detailssortiearticle getSelecteddetailssortiearticle() {
        return selecteddetailssortiearticle;
    }

    public void setSelecteddetailssortiearticle(Detailssortiearticle selecteddetailssortiearticle) {
        this.selecteddetailssortiearticle = selecteddetailssortiearticle;
    }

    public String getId_projet() {
        return id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }

    public String getId_pers() {
        return id_pers;
    }

    public List<String> allpersonnel() {
        List<String> all = new ArrayList<String>();
        dao1 = new PersonnelHDao();
        ArrayList<Personnel> l = (ArrayList<Personnel>) dao1.getAllPersonnels();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Personnel pu = (Personnel) li.next();
            all.add(pu.getNom());
        }

        return all;
    }

    public List<String> allprojet() {
        List<String> all = new ArrayList<String>();
        projet_dao = new ProjetHDao();
        ArrayList<Projet> l = (ArrayList<Projet>) projet_dao.getAllProjet();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Projet pu = (Projet) li.next();
            all.add(pu.getIdprojet());
        }

        return all;
    }

    public void setId_pers(String id_pers) {
        this.id_pers = id_pers;
    }

    public Personnel getPers() {
        return pers;
    }

    public void setPers(Personnel pers) {
        this.pers = pers;
    }

    public BonsortieDataModel getMediumBonsortiesModel() {
        return mediumBonsortiesModel;
    }

    public void setMediumBonsortiesModel(BonsortieDataModel mediumBonsortiesModel) {
        this.mediumBonsortiesModel = mediumBonsortiesModel;
    }

    public void setFilteredBonsorties(List<Bonsortie> filteredBonsorties) {
        this.filteredBonsorties = filteredBonsorties;
    }

    public void setid_pers(String id_pers) {
        this.id_pers = id_pers;
    }

    public void setSelectedBonsortie(Bonsortie selectedBonsortie) {
        this.selectedBonsortie = selectedBonsortie;
    }

    public void setSortie(Bonsortie sortie) {
        this.sortie = sortie;
    }

    public List<Bonsortie> getFilteredBonsorties() {
        return filteredBonsorties;
    }

    public String getid_pers() {
        return id_pers;
    }

    public Bonsortie getSelectedBonsortie() {
        return selectedBonsortie;
    }

    public Bonsortie getSortie() {
        return sortie;
    }

    /** Creates a new instance of SortieBean */
    public void supprimer() {
        if (selectedBonsortie == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonsortie", "Selectionnez une ligne !"));
        }

        //dao.delete(selectedBonsortie.getIdsortie());
        dao.delete(selectedBonsortie.getIdsortie());
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Bonsortie bonsortie : bonsorties) {
            if (bonsortie.getIdsortie().equals(sortie.getIdsortie())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce bonsortie existe dejà !", "Veuillez changer le Code de bonsortie."));
                return "sortie_ajout";
            }
        }
        sortie.setPersonnel(dao1.getNomPersonnel(id_pers));
        sortie.setProjet(projet_dao.getProjet(id_projet));
        dao.insert(sortie);
        sortie = new Bonsortie();
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        return "succesAjoutArticle";

    }

    public details_sortie_article_DataModel getMediumBonsortiesdetailsModel() {
        return mediumBonsortiesdetailsModel;
    }

    public void setMediumBonsortiesdetailsModel(details_sortie_article_DataModel mediumBonsortiesdetailsModel) {
        this.mediumBonsortiesdetailsModel = mediumBonsortiesdetailsModel;
    }

    public String modif() {
        if (selectedBonsortie == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonsortie", "Selectionnez une ligne !"));
            return "";
        } else {
            //typeUser=selectedBonsortie.getTypeuser().getTypeuser();
            //
            if (selectedBonsortie.getPersonnel() != null) {
                p = selectedBonsortie.getPersonnel();
                id_pers = p.getIdpersonnel();
                p = dao1.getPersonnel(id_pers);
                id_pers = p.getNom();
                id_projet = selectedBonsortie.getProjet().getIdprojet();
            }
            //Bonsortie b = dao.getBonSortie(selectedBonsortie.getIdsortie());
            // System.out.println("gggg"+b.getPersonnel().getNom());
            return "modif_sortie";
        }
    }

    public String details() {
        if (selectedBonsortie == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonsortie", "Selectionnez une ligne !"));
            return "";
        } else {
            mediumBonsortiesdetailsModel = new details_sortie_article_DataModel(dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie()));
            mediumBonsorties_fourdetailsModel = new details_sortie_fourniture_DataModel(dao_fourniture.getAllDetailssortiefournitures_id(selectedBonsortie.getIdsortie()));
            p = selectedBonsortie.getPersonnel();
            id_pers = p.getIdpersonnel();
            p = dao1.getPersonnel(id_pers);
            id_pers = p.getNom();
            id_projet = selectedBonsortie.getProjet().getIdprojet();
            return "details_sortie";
        }
    }

    public String enrModif() {
        //selectedBonsortie.setTypeuser(new Typeuser(typeUser));
        p = dao1.getNomPersonnel(id_pers);
        selectedBonsortie.setPersonnel(p);
        dao.update(selectedBonsortie);
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        return "succesAjoutArticle";
    }
    /* public List list_details(){
    DetailsSortieElementHDao dse=new DetailsSortieElementHDao();
    return dse.getAllDetailsSortieElement();
    }*/

    public String enrDetails() {

        Article article = dao_article.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            System.err.println("ggg");
            return "details_sortie";
        }
        Integer t = new Integer(0);
        try {
            t = new Integer(qnt_sortie);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
           System.err.println("hhhhhhhh");
            return "details_sortie";
        }
        Detailssortiearticle dd = dao2.getDetailssortiearticle(new DetailssortiearticleId(selectedBonsortie.getIdsortie(), article.getIdarticle()));
        if (dd == null) {
            Integer qnt = dao_article.getArticle(id_article).getQntarticle();
            if ((qnt - t) < 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                System.err.println("aaaaaaaaa");
                return "details_sortie";
            } else {
                Detailssortiearticle details = new Detailssortiearticle(new DetailssortiearticleId(selectedBonsortie.getIdsortie(), article.getIdarticle()), selectedBonsortie, article, t, 0);
                dao2.insert(details);
                Article a = dao_article.getArticle(id_article);
                a.setQntarticle(qnt - t);
                dao_article.update(a);
                mediumBonsortiesdetailsModel = new details_sortie_article_DataModel(dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie()));

                return "details_sortie";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("llllllll");
            return "details_sortie";

        }
    }
public String enrDetails_four() {
   System.out.println("ddd");
        Fourniture fourniture = dao_four.getFourniture(id_fourniture);
        if (fourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° Fourniture n'exist pas  !", "Veuillez changer le Code de fourniture."));
            //System.err.println("ggg");
            return "details_sortie";
        }
        Integer t = new Integer(0);
        try {
            t = new Integer(qnt_sortie2);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("aaaaaaaaa");
            return "details_sortie";
        }
        Detailssortiefourniture dd = dao_fourniture.getDetailssortiefourniture(new DetailssortiefournitureId(selectedBonsortie.getIdsortie(), fourniture.getNumfourniture()));
        if (dd == null) {
            Integer qnt = dao_four.getFourniture(id_fourniture).getQntfourniture();
            if ((qnt - t) < 0) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                //System.err.println("aaaaaaaaa");
                return "details_sortie";
            } else {
                Detailssortiefourniture details = new Detailssortiefourniture(new DetailssortiefournitureId(selectedBonsortie.getIdsortie(), fourniture.getNumfourniture()),fourniture,selectedBonsortie, t, 0);
                dao_fourniture.insert(details);
                Fourniture a = dao_four.getFourniture(id_fourniture);
                a.setQntfourniture(qnt - t);
                dao_four.update(a);
                mediumBonsorties_fourdetailsModel = new details_sortie_fourniture_DataModel(dao_fourniture.getAllDetailssortiefournitures_id(selectedBonsortie.getIdsortie()));

                return "details_sortie";
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            //System.err.println("llllllll");
            return "details_sortie";

        }
    }

    public void supprimer_details() {
        if (selecteddetailssortiearticle == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
        }
        System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        dao2.delete(selecteddetailssortiearticle.getId());
        Article a = dao_article.getArticle(selecteddetailssortiearticle.getArticle().getIdarticle());
        a.setQntarticle(a.getQntarticle() + selecteddetailssortiearticle.getQntsortie());
        dao_article.update(a);
        mediumBonsortiesdetailsModel = new details_sortie_article_DataModel(dao2.getAllDetailssortiearticles_id(selectedBonsortie.getIdsortie()));

    }
    public void supprimer_details_four() {
        if (selecteddetailssortiefourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une fourniture", "Selectionnez une ligne !"));
        }
       
       // System.out.println("id="+selecteddetailssortiefourniture.getId().getNumfourniture());
        //dao.delete(selectedBonsortie.getIdsortie());
        dao_fourniture.delete(selecteddetailssortiefourniture.getId());
        //
        //System.out.println("ggg"+selecteddetailssortiefourniture.getFourniture().getNumfourniture());
        Fourniture a = dao_four.getFourniture(selecteddetailssortiefourniture.getFourniture().getNumfourniture());
        //System.out.println("ddd"+a.getQntfourniture()+"ddd"+a.getNumfourniture());
        //System.out.println("ggggg"+selecteddetailssortiearticle.getId());
              
               
        a.setQntfourniture(a.getQntfourniture() + selecteddetailssortiefourniture.getQntsortie());
        dao_four.update(a);
        
            
        mediumBonsorties_fourdetailsModel = new details_sortie_fourniture_DataModel(dao_fourniture.getAllDetailssortiefournitures_id(selectedBonsortie.getIdsortie()));

    }
}
