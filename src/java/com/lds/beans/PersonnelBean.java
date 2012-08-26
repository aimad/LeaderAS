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

public class PersonnelBean implements Serializable {

    private PersonnelDao dao;
    private Personnel pers;
    private int typeUser;
    private String rpassword;
    private List<Personnel> personnels;
    private Personnel selectedPersonnel;
    private LazyDataModel<Personnel> mediumPersonnelsModel;
    private PrivilegeDao priv;
    private String[] favNumber2;
    private String[] favNumber3;
    private List<Privilege> list_priv;

    public PersonnelBean() {

        pers = new Personnel();
        personnels = new ArrayList<Personnel>();
        //selectedPersonnel=new Personnel();
        //populateRandomCars(cars, 50);  
        dao = new PersonnelHDao();
        personnels = dao.getAllPersonnels();
        mediumPersonnelsModel = new PersonnelDataModel(personnels);
        priv = new PrivilegeHDao();
        favNumber2 = new String[3];
        favNumber3 = new String[3];
        list_priv = priv.getAllPrivileges();

    }

    public String[] getFavNumber2Value() {

        favNumber2 = new String[3];
        for (int i = 0; i < 3; i++) {
            favNumber2[i] = list_priv.get(i).getNompriv();
        }

        return favNumber2;
    }

    public String getFavNumber2InString() {
        return Arrays.toString(favNumber2);
    }

    public String[] getFavNumber2() {
        return favNumber2;
    }

    public void setFavNumber2(String[] favNumber2) {
        this.favNumber2 = favNumber2;
    }

    public String[] getFavNumber3Value() {

        favNumber3 = new String[3];
        for (int i = 0; i < 3; i++) {
            favNumber3[i] = list_priv.get(i + 3).getNompriv();
        }

        return favNumber3;
    }

    public String getFavNumber3InString() {
        return Arrays.toString(favNumber3);
    }

    public String[] getFavNumber3() {
        return favNumber3;
    }

    public void setFavNumber3(String[] favNumber3) {
        this.favNumber3 = favNumber3;
    }

    public Personnel getSelectedPersonnel() {
        return selectedPersonnel;
    }

    public void setSelectedPersonnel(Personnel selectedPersonnel) {
        this.selectedPersonnel = selectedPersonnel;
    }

    public LazyDataModel<Personnel> getMediumPersonnelsModel() {
        return mediumPersonnelsModel;
    }

    public Personnel getPers() {
        return pers;
    }

    public void setPers(Personnel pers) {
        this.pers = pers;
    }

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    public int getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(int typeUser) {
        this.typeUser = typeUser;
    }

    public void supprimer() {
        if (selectedPersonnel == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un employé", "Selectionnez une ligne avec les cercles!"));
        }
        
        dao.delete(selectedPersonnel.getIdpersonnel());
        personnels = dao.getAllPersonnels();
        mediumPersonnelsModel = new PersonnelDataModel(personnels);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Personnel personnel : personnels) {
            if (personnel.getIdpersonnel().equals(pers.getIdpersonnel())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cet employé existe dejà !", "Veuillez changer le login."));
                return "echecAjout";
            }
        }
        //sinon
        
       
        pers.setTypeuser(new Typeuser(typeUser));
        dao.insert(pers);
          pers = new Personnel(); 
        personnels = dao.getAllPersonnels();
        mediumPersonnelsModel = new PersonnelDataModel(personnels);
        return "succesAjout";

    }
    
    

    public String modif() {
        if (selectedPersonnel == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un employé", "Selectionnez une ligne avec les cercles!"));
        return "";      
        }
        else
        {
           typeUser=selectedPersonnel.getTypeuser().getTypeuser();
        return "modif";}
    }
    
    public String enrModif(){
        selectedPersonnel.setTypeuser(new Typeuser(typeUser));
        dao.update(selectedPersonnel);
        personnels = dao.getAllPersonnels();
        mediumPersonnelsModel = new PersonnelDataModel(personnels);
        return "succesAjout";
    }
    
     public String droits() {
         
          if (selectedPersonnel == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un employé", "Selectionnez une ligne avec les cercles!"));
            return "";
            }
          
          else {
        favNumber2 = new String[3];
        favNumber3 = new String[3];
        DetailsPrivUserDao privUser = new DetailsPrivUserHDao();

        ArrayList<Detailsprivuser> l = (ArrayList<Detailsprivuser>) privUser.getAllDetailsPrivUsers();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Detailsprivuser pu = (Detailsprivuser) li.next();

            if (pu.getId().getIdpersonnel().equals(selectedPersonnel.getIdpersonnel())) {
                //traitement de l'objet
                if (new Integer(pu.getPrivilege().getIdpriv()) <= 3) {
                    favNumber2[new Integer(pu.getPrivilege().getIdpriv()) - 1] = pu.getPrivilege().getNompriv();
                } else {
                    favNumber3[new Integer(pu.getPrivilege().getIdpriv()) - 4] = pu.getPrivilege().getNompriv();
                }

            }

        }
        return "details";
          }

        
    }

    public String Enregistrer_priv() {
        DetailsPrivUserDao privUser = new DetailsPrivUserHDao();

        ArrayList<Detailsprivuser> l = (ArrayList<Detailsprivuser>) privUser.getAllDetailsPrivUsers();
        Iterator li = l.iterator();
        while (li.hasNext()) {
            //Recupération objet
            Detailsprivuser pu = (Detailsprivuser) li.next();

            if (pu.getId().getIdpersonnel().equals(selectedPersonnel.getIdpersonnel())) {
                //traitement de l'objet
               DetailsprivuserId id=new DetailsprivuserId(selectedPersonnel.getIdpersonnel(),pu.getPrivilege().getIdpriv()); 
           privUser.delete(id);
            }
        }
        int i=0;
        while(i<favNumber2.length)
        {
        if(!favNumber2[i].equals(""))
        {     
            PrivilegeHDao privhdao=new PrivilegeHDao();
            DetailsprivuserId id=new DetailsprivuserId(selectedPersonnel.getIdpersonnel(),privhdao.getnom_to_Privilege(favNumber2[i]).getIdpriv());
            Detailsprivuser priv_user=new Detailsprivuser(id,privhdao.getnom_to_Privilege(favNumber2[i]),selectedPersonnel,favNumber2[i]);
           privUser.insert(priv_user); 
        }
        i++;
        }
         i=0;
        while(i<favNumber3.length)
        {
        if(!favNumber3[i].equals(""))
        {     
            PrivilegeHDao privhdao=new PrivilegeHDao();
            DetailsprivuserId id=new DetailsprivuserId(selectedPersonnel.getIdpersonnel(),privhdao.getnom_to_Privilege(favNumber3[i]).getIdpriv());
            Detailsprivuser priv_user=new Detailsprivuser(id,privhdao.getnom_to_Privilege(favNumber3[i]),selectedPersonnel,favNumber3[i]);
           privUser.insert(priv_user); 
        }
        i++;
        }
        return "priv_insert";
    }
   
}
