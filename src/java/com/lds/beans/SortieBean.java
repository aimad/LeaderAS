/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.BonSortieHDao;
import com.lds.persistance.PersonnelHDao;
import com.lds.vo.Bonsortie;
import com.lds.vo.Personnel;
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
    private BonsortieDataModel mediumBonsortiesModel;
    private String id_pers;
    private PersonnelHDao dao1=new PersonnelHDao() ;
    private Personnel p;

    public SortieBean() {

        sortie = new Bonsortie();
        bonsorties = new ArrayList<Bonsortie>();
        //selectedBonsortie=new Bonsortie();
        //populateRandomCars(cars, 50);  
        dao = new BonSortieHDao();
        dao1 = new PersonnelHDao();
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        id_pers=new String();
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
        dao.insert(sortie);
        sortie = new Bonsortie();
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        return "succesAjoutArticle";

    }

    public String modif() {
        if (selectedBonsortie == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un bonsortie", "Selectionnez une ligne !"));
            return "";
        } else {
            //typeUser=selectedBonsortie.getTypeuser().getTypeuser();
            //
            if(selectedBonsortie.getPersonnel()!=null) 
            {
                 p = selectedBonsortie.getPersonnel();
                 id_pers=p.getIdpersonnel();
                p=dao1.getPersonnel(id_pers);
                id_pers=p.getNom();
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
            //typeUser=selectedBonsortie.getTypeuser().getTypeuser();
                  return "details_sortie";
        }
    }

    public String enrModif() {
        //selectedBonsortie.setTypeuser(new Typeuser(typeUser));
        p=dao1.getNomPersonnel(id_pers);
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
        //selectedBonsortie.setTypeuser(new Typeuser(typeUser));
        //dao.update(selectedBonsortie);
        bonsorties = dao.getAllBonSorties();
        mediumBonsortiesModel = new BonsortieDataModel(bonsorties);
        return "succesAjoutArticle";
    }
}
