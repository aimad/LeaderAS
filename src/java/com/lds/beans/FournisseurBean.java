/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;


import com.lds.persistance.FournisseurHDao;
import com.lds.vo.Fournisseur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
  
 
  
public class FournisseurBean implements Serializable {  
 
  
    private List<Fournisseur> filteredFournisseurs;                
    private List<Fournisseur> fournisseurs;    
    private Fournisseur selectedFournisseur;            
    private  Fournisseur four;
    private  FournisseurHDao dao;
    private  FournisseurDataModel mediumFournisseursModel;
  
    public FournisseurBean() {      
        
        four = new Fournisseur();
        fournisseurs = new ArrayList<Fournisseur>();
        //selectedFournisseur=new Fournisseur();
        //populateRandomCars(cars, 50);  
        dao = new FournisseurHDao();
        fournisseurs = dao.getAllFournisseur();
        mediumFournisseursModel = new FournisseurDataModel(fournisseurs); 
    }      
  
    public Fournisseur getSelectedFournisseur() {  
        return selectedFournisseur;  
    }  
  
    public void setSelectedFournisseur(Fournisseur selectedFournisseur) {  
        this.selectedFournisseur = selectedFournisseur;  
    }  
       public LazyDataModel<Fournisseur> getMediumFournisseursModel() {
        return mediumFournisseursModel;
    }

    public Fournisseur getFour() {
        return four;
    }

    public void setClt(Fournisseur four) {
        this.four = four;
    }
         
    public List<Fournisseur> getFilteredFournisseurs() {          
        return filteredFournisseurs;  
    }  
  
    public void setFilteredFournisseurs(List<Fournisseur> filteredFournisseurs) {                 
        this.filteredFournisseurs = filteredFournisseurs;  
    }  
  
    public List<Fournisseur> getFournisseurs() { 
        
        return fournisseurs;  
    }  
    public void supprimer() {
        if (selectedFournisseur == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un fournisseur", "Selectionnez une ligne !"));
        }
        
        dao.delete(selectedFournisseur.getIdfournisseur());
        fournisseurs = dao.getAllFournisseur();
        mediumFournisseursModel = new FournisseurDataModel(fournisseurs);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Fournisseur fournisseur : fournisseurs) {
            if (fournisseur.getIdfournisseur().equals(four.getIdfournisseur())) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Ce fournisseur existe dejà !", "Veuillez changer le Code de fournisseur."));
                return "echecAjoutFour";
            }
        }
        
        dao.insert(four);
        four = new Fournisseur();
        fournisseurs = dao.getAllFournisseur();
        mediumFournisseursModel = new FournisseurDataModel(fournisseurs);
        return "succesAjoutFour";

    }
    
    

    public String modif() {
        if (selectedFournisseur == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un fournisseur", "Selectionnez une ligne !"));
        return "";      
        }
        else
        {
           //typeUser=selectedFournisseur.getTypeuser().getTypeuser();
        return "modifFour";}
    }
    
    public String enrModif(){
        //selectedFournisseur.setTypeuser(new Typeuser(typeUser));
        dao.update(selectedFournisseur);
        fournisseurs = dao.getAllFournisseur();
        mediumFournisseursModel = new FournisseurDataModel(fournisseurs);
        return "succesAjoutFour";
    }
    
        public List<String> allNomFournisseurs() {
        List<String> all = new ArrayList<String>();                
        Iterator li = fournisseurs.iterator();
        while (li.hasNext()) {
//Recupération objet
            Fournisseur fo = (Fournisseur) li.next();
            all.add(fo.getIdfournisseur());
        }

        return all;
    }
    
} 