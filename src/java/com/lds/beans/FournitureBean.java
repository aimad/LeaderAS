/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;


import com.lds.persistance.FournitureHDao;
import com.lds.vo.Fourniture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
  
 
  
public class FournitureBean implements Serializable {  
 
  
    private List<Fourniture> filteredFournitures;  
  
    private List<Fourniture> fournitures;  
  
    private Fourniture selectedFourniture;  
  
    private Fourniture[] selectedFournitures;
    
    private  Fourniture elt;
    private  FournitureHDao dao;
    private  FournitureDataModel mediumFournituresModel;
    private String id_fourniture;

    public void setId_fourniture(String id_fourniture) {
        this.id_fourniture = id_fourniture;
    }

    public String getId_fourniture() {
        return id_fourniture;
    }
  
    public FournitureBean() {   
        //System.out.println("hhhh");
        elt = new Fourniture();
        //System.out.println("hhhh");
        fournitures = new ArrayList<Fourniture>();
        //selectedFourniture=new Fourniture();
        //populateRandomCars(cars, 50);  
        //System.out.println("hhhh");
        dao = new FournitureHDao();
        fournitures = dao.getAllFourniture();
        mediumFournituresModel = new FournitureDataModel(fournitures); 
       // System.out.println("hhhh");
    }  
  
    public Fourniture getSelectedFourniture() {  
        return selectedFourniture;  
    }  
  
    public void setSelectedFourniture(Fourniture selectedFourniture) {  
        this.selectedFourniture = selectedFourniture;  
    }  
       public LazyDataModel<Fourniture> getMediumFournituresModel() {
        return mediumFournituresModel;
    }

    public Fourniture getElt() {
        return elt;
    }

    public void setElt(Fourniture elt) {
        this.elt = elt;
    }
         
    public List<Fourniture> getFilteredFournitures() {  
        return filteredFournitures;  
    }  
  
    public void setFilteredFournitures(List<Fourniture> filteredFournitures) {  
        this.filteredFournitures = filteredFournitures;  
    }  
  
    public List<Fourniture> getFournitures() {  
        return fournitures;  
    }  
    public void supprimer() {
        if (selectedFourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un fourniture", "Selectionnez une ligne !"));
        }
        
        dao.delete(selectedFourniture.getNumfourniture());
        //dao1.delete(selectedFourniture.getId().getNumfourniture());
        fournitures = dao.getAllFourniture();
        mediumFournituresModel = new FournitureDataModel(fournitures);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Fourniture fourniture : fournitures) {
            if (fourniture.getNumfourniture().equals(elt.getNumfourniture())) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Ce fourniture existe dejà !", "Veuillez changer le Code de fourniture."));
                return "article_ajout_four";
            }
        }
        elt.setNumfourniture(id_fourniture);
        //dao1.insert(new Element(id_fourniture));
        dao.insert(elt);
        elt = new Fourniture();
        fournitures = dao.getAllFourniture();
        mediumFournituresModel = new FournitureDataModel(fournitures);
        return "succesAjoutArticle";

    }
    
    

    public String modif() {
        if (selectedFourniture == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir une fourniture", "Selectionnez une ligne !"));
        return "";      
        }
        else
        {
           //typeUser=selectedFourniture.getTypeuser().getTypeuser();
        return "modif_stock_four";}
    }
    
    public String enrModif(){
        //selectedFourniture.setTypeuser(new Typeuser(typeUser));
        dao.update(selectedFourniture);
        fournitures = dao.getAllFourniture();
        mediumFournituresModel = new FournitureDataModel(fournitures);
        return "succesAjoutArticle";
    }
    
} 