/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.ArticleHDao;
import com.lds.persistance.BonCommandeHDao;
import com.lds.persistance.DetailsBcArticleHDao;
import com.lds.persistance.DetailsBcFournitureHDao;
import com.lds.persistance.FournisseurHDao;
import com.lds.persistance.FournitureHDao;
import com.lds.persistance.ProjetHDao;
import com.lds.vo.Article;
import com.lds.vo.Boncommande;
import com.lds.vo.Detailsbcarticle;
import com.lds.vo.DetailsbcarticleId;
import com.lds.vo.Detailsfourniturebc;
import com.lds.vo.DetailsfourniturebcId;
import com.lds.vo.Fournisseur;
import com.lds.vo.Fourniture;
import com.lds.vo.Projet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BcBean implements Serializable {

    private List<Boncommande> filteredBoncommandes;
    private List<Boncommande> boncommandes;
    private Boncommande selectedBoncommande;
    private Boncommande[] selectedBoncommandes;
    private Boncommande elt;
    private BonCommandeHDao dao;
    private BoncommandeDataModel mediumBoncommandesModel;
    private String id_fournisseur;
    private String id_projet;
    private BcarticleDataModel mediumBoncommandesModel_article;
    private BcfournitureDataModel mediumBoncommandesModel_fourniture;
    private Detailsbcarticle selectedBoncommande_article;
    private Detailsfourniturebc selectedBoncommande_fourniture;
    private String id_article;
    private String qnt_commande;
    private String prix_unitaire;
    private String id_fourniture;
    private String prix_fourniture;
    private String qnt_fourniture;
    private ArticleHDao article_dao;
    private FournitureHDao fourniture_dao;
    private DetailsBcArticleHDao article_details_dao;
    private DetailsBcFournitureHDao fourniture_details_dao;

    public BcBean() {
        elt = new Boncommande();
        boncommandes = new ArrayList<Boncommande>();
        //selectedBoncommande=new Boncommande();
        //populateRandomCars(cars, 50);  
        dao = new BonCommandeHDao();
        boncommandes = dao.getAllBonCommandes();
        mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);
        article_dao = new ArticleHDao();
        article_details_dao = new DetailsBcArticleHDao();
        fourniture_details_dao = new DetailsBcFournitureHDao();
        fourniture_dao = new FournitureHDao();

    }

    public String getId_fourniture() {
        return id_fourniture;
    }

    public void setId_fourniture(String id_fourniture) {
        this.id_fourniture = id_fourniture;
    }

    public String getPrix_fourniture() {
        return prix_fourniture;
    }

    public void setPrix_fourniture(String prix_fourniture) {
        this.prix_fourniture = prix_fourniture;
    }

    public String getQnt_fourniture() {
        return qnt_fourniture;
    }

    public void setQnt_fourniture(String qnt_fourniture) {
        this.qnt_fourniture = qnt_fourniture;
    }

    public String getId_article() {
        return id_article;
    }

    public void setId_article(String id_article) {
        this.id_article = id_article;
    }

    public String getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(String prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getQnt_commande() {
        return qnt_commande;
    }

    public void setQnt_commande(String qnt_commande) {
        this.qnt_commande = qnt_commande;
    }

    public BoncommandeDataModel getMediumBoncommandesModel() {
        return mediumBoncommandesModel;
    }

    public void setMediumBoncommandesModel(BoncommandeDataModel mediumBoncommandesModel) {
        this.mediumBoncommandesModel = mediumBoncommandesModel;
    }

    public BcarticleDataModel getMediumBoncommandesModel_article() {
        return mediumBoncommandesModel_article;
    }

    public void setMediumBoncommandesModel_article(BcarticleDataModel mediumBoncommandesModel_article) {
        this.mediumBoncommandesModel_article = mediumBoncommandesModel_article;
    }

    public BcfournitureDataModel getMediumBoncommandesModel_fourniture() {
        return mediumBoncommandesModel_fourniture;
    }

    public void setMediumBoncommandesModel_fourniture(BcfournitureDataModel mediumBoncommandesModel_fourniture) {
        this.mediumBoncommandesModel_fourniture = mediumBoncommandesModel_fourniture;
    }

    public Detailsbcarticle getSelectedBoncommande_article() {
        return selectedBoncommande_article;
    }

    public void setSelectedBoncommande_article(Detailsbcarticle selectedBoncommande_article) {
        this.selectedBoncommande_article = selectedBoncommande_article;
    }

    public Detailsfourniturebc getSelectedBoncommande_fourniture() {
        return selectedBoncommande_fourniture;
    }

    public void setSelectedBoncommande_fourniture(Detailsfourniturebc selectedBoncommande_fourniture) {
        this.selectedBoncommande_fourniture = selectedBoncommande_fourniture;
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

    public List<String> allfournisseur() {
        List<String> all = new ArrayList<String>();
        FournisseurHDao four_dao = new FournisseurHDao();
        ArrayList<Fournisseur> l = (ArrayList<Fournisseur>) four_dao.getAllFournisseur();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Fournisseur pu = (Fournisseur) li.next();
            // pu=four_dao.getFournisseur(pu.getIdfournisseur());
            all.add(pu.getNom());
        }

        return all;
    }

    public String getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(String id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public String getId_projet() {
        return id_projet;
    }

    public void setId_projet(String id_projet) {
        this.id_projet = id_projet;
    }
    private String id_boncommande;

    public void setId_boncommande(String id_boncommande) {
        this.id_boncommande = id_boncommande;
    }

    public String getId_boncommande() {
        return id_boncommande;
    }

    public Boncommande getSelectedBoncommande() {
        return selectedBoncommande;
    }

    public void setSelectedBoncommande(Boncommande selectedBoncommande) {
        this.selectedBoncommande = selectedBoncommande;
    }

    public Boncommande getElt() {
        return elt;
    }

    public void setElt(Boncommande elt) {
        this.elt = elt;
    }

    public List<Boncommande> getFilteredBoncommandes() {
        return filteredBoncommandes;
    }

    public void setFilteredBoncommandes(List<Boncommande> filteredBoncommandes) {
        this.filteredBoncommandes = filteredBoncommandes;
    }

    public List<Boncommande> getBoncommandes() {
        return boncommandes;
    }

    public void supprimer() {
        if (selectedBoncommande == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un boncommande", "Selectionnez une ligne !"));
        }

        dao.delete(selectedBoncommande.getNumbc());
        //dao1.delete(selectedBoncommande.getId().getIdboncommande());
        boncommandes = dao.getAllBonCommandes();
        mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Boncommande boncommande : boncommandes) {
            if (boncommande.getNumbc().equals(elt.getNumbc())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce boncommande existe dejà !", "Veuillez changer le Code de boncommande."));
                return "boncommande_ajout";
            }
        }
        //elt.setIdboncommande(id_boncommande);
        //dao1.insert(new Element(id_boncommande));
        FournisseurHDao four_dao = new FournisseurHDao();
        ProjetHDao projet_dao = new ProjetHDao();
        elt.setFournisseur(four_dao.getFournisseur_nom(id_fournisseur));
        elt.setProjet(projet_dao.getProjet(id_projet));
        elt.setPrixht(0.0);
        dao.insert(elt);
        elt = new Boncommande();
        boncommandes = dao.getAllBonCommandes();
        id_boncommande = new String();
        id_projet = "";
        id_fournisseur = "";
        mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);
        return "succesAjoutBoncommande";

    }

    public String modif() {
        if (selectedBoncommande == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un boncommande", "Selectionnez une ligne !"));
            return "";
        } else {
            //typeUser=selectedBoncommande.getTypeuser().getTypeuser();
            id_projet = selectedBoncommande.getProjet().getIdprojet();
            FournisseurHDao four_dao = new FournisseurHDao();
            id_fournisseur = selectedBoncommande.getFournisseur().getIdfournisseur();
            id_fournisseur = four_dao.getFournisseur(id_fournisseur).getNom();
            return "modif";
        }
    }

    public String enrModif() {
        //selectedBoncommande.setTypeuser(new Typeuser(typeUser));
        FournisseurHDao four_dao = new FournisseurHDao();
        ProjetHDao projet_dao = new ProjetHDao();
        selectedBoncommande.setProjet(projet_dao.getProjet(id_projet));
        selectedBoncommande.setFournisseur(four_dao.getFournisseur_nom(id_fournisseur));
        dao.update(selectedBoncommande);
        boncommandes = dao.getAllBonCommandes();
        mediumBoncommandesModel = new BoncommandeDataModel(boncommandes);
        return "succesAjoutBoncommande";
    }

    public String enrDetails() {
        //System.out.println("wakkkkkkkwakkkkkkk");
        Article article = article_dao.getArticle(id_article);
        if (article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
            System.err.println("ggg");
            return "details_1";
        } else {
            Integer t = new Integer(0);
            try {
                //  System.out.println(qnt_besoin+"hhh");
                t = new Integer(qnt_commande);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                System.err.println("aaaaaaaaa");
                return "details_1";
            }
            Double d = new Double(0);
            try {
                d = new Double(prix_unitaire);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                System.err.println("aaaaaaaaa");
                return "details_1";

            }
            // Article a = article_dao.getArticle(id_article);
            List<Detailsbcarticle> details_list_article = article_details_dao.getAllDetailsbcarticles();
            Detailsbcarticle details = new Detailsbcarticle(new DetailsbcarticleId(selectedBoncommande.getNumbc(), id_article), selectedBoncommande, article, d, t, new Integer(0));
            for (Detailsbcarticle des : details_list_article) {
                if (des.getId().equals(details.getId())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce article existe dejà !", "Veuillez changer le Code de article."));
                    return "details_1";
                }
            }

            article_details_dao.insert(details);
            selectedBoncommande.setPrixht(selectedBoncommande.getPrixht() + d * t);
            dao.update(selectedBoncommande);
            // Integer  = article_dao.getArticle(id_article);
            mediumBoncommandesModel_article = new BcarticleDataModel(article_details_dao.getDetailsbcarticles_id(selectedBoncommande.getNumbc()));
            id_article = "";
            qnt_commande = "";
            prix_unitaire = "";
            return "details_1";

        }
    }

    public void supprimer_details() {
        System.out.println("mmmmmmmmmmm");
        if (selectedBoncommande_article == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une article", "Selectionnez une ligne !"));
            System.out.println("gggggggg");
        }
        //System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        selectedBoncommande.setPrixht(selectedBoncommande.getPrixht() - (selectedBoncommande_article.getPrixunitaire() * selectedBoncommande_article.getQntcommande()));
        dao.update(selectedBoncommande);
        article_details_dao.delete(selectedBoncommande_article.getId());
        mediumBoncommandesModel_article = new BcarticleDataModel(article_details_dao.getDetailsbcarticles_id(selectedBoncommande.getNumbc()));

    }

    public String enrDetails_four() {
        //System.out.println("wakkkkkkkwakkkkkkk");
        Fourniture fourniture = fourniture_dao.getFourniture(id_fourniture);
        if (fourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° fourniture n'exist pas  !", "Veuillez changer le Code de fourniture."));
            System.err.println("ggg");
            return "details_1";
        } else {
            Integer t = new Integer(0);
            try {
                //  System.out.println(qnt_besoin+"hhh");
                t = new Integer(qnt_fourniture);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                System.err.println("aaaaaaaaa");
                return "details_1";
            }
            Double d = new Double(0);
            try {
                d = new Double(prix_fourniture);
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "N° article n'exist pas  !", "Veuillez changer le Code d'article."));
                System.err.println("aaaaaaaaa");
                return "details_1";

            }
            // Article a = article_dao.getArticle(id_article);
            List<Detailsfourniturebc> details_list_fourniture = fourniture_details_dao.getAllDetailsbcfournitures();
            Detailsfourniturebc details = new Detailsfourniturebc(new DetailsfourniturebcId(selectedBoncommande.getNumbc(), id_fourniture), fourniture, selectedBoncommande, t, d, new Integer(0));
            for (Detailsfourniturebc des : details_list_fourniture) {
                if (des.getId().equals(details.getId())) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce article existe dejà !", "Veuillez changer le Code de article."));
                    return "details_1";
                }
            }

            fourniture_details_dao.insert(details);
            selectedBoncommande.setPrixht(selectedBoncommande.getPrixht() + d * t);
            dao.update(selectedBoncommande);
            // Integer  = article_dao.getArticle(id_article);
            mediumBoncommandesModel_fourniture = new BcfournitureDataModel(fourniture_details_dao.getDetailsfourniturebcs_id(selectedBoncommande.getNumbc()));
id_fourniture="";
qnt_fourniture="";
prix_fourniture="";
            return "details_1";

        }
    }

    public void supprimer_details_four() {
        System.out.println("mmmmmmmmmmm");
        if (selectedBoncommande_fourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une fourniture", "Selectionnez une ligne !"));
            System.out.println("gggggggg");
        }
        //System.out.println(selecteddetailssortiearticle.getId().getIdarticle());
        //dao.delete(selectedBonsortie.getIdsortie());
        selectedBoncommande.setPrixht(selectedBoncommande.getPrixht() - (selectedBoncommande_fourniture.getPrixUnitaire() * selectedBoncommande_fourniture.getQntCommande()));
        dao.update(selectedBoncommande);
        fourniture_details_dao.delete(selectedBoncommande_fourniture.getId());
        mediumBoncommandesModel_fourniture = new BcfournitureDataModel(fourniture_details_dao.getDetailsfourniturebcs_id(selectedBoncommande.getNumbc()));

    }

    public String details() {
        if (selectedBoncommande == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un BC", "Selectionnez une ligne avec les cercles!"));
            return "";
        } else {
            //typeUser=selectedBesoin.getTypeuser().getTypeuser();
            //id_projet=selectedBesoin.getProjet().getIdprojet();
            id_projet = selectedBoncommande.getProjet().getIdprojet();
            FournisseurHDao four_dao = new FournisseurHDao();
            id_fournisseur = selectedBoncommande.getFournisseur().getIdfournisseur();
            id_fournisseur = four_dao.getFournisseur(id_fournisseur).getNom();

            mediumBoncommandesModel_article = new BcarticleDataModel(article_details_dao.getDetailsbcarticles_id(selectedBoncommande.getNumbc()));
            mediumBoncommandesModel_fourniture = new BcfournitureDataModel(fourniture_details_dao.getDetailsfourniturebcs_id(selectedBoncommande.getNumbc()));
            return "details_1";
        }
    }
}
