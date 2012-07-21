/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import com.lds.persistance.DetailsPrivUserDao;
import com.lds.persistance.DetailsPrivUserHDao;
import com.lds.persistance.PrivilegeDao;
import com.lds.persistance.PrivilegeHDao;
import com.lds.vo.Detailsprivuser;
import com.lds.vo.Personnel;
import com.lds.vo.Privilege;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.context.FacesContext;

/**
 *
 * @author zarito
 */
public class DroitBean {

    /**
     * Creates a new instance of DroitBean
     */
    public DroitBean() {
    }

    public void authorize() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Personnel p = (Personnel) facesContext.getExternalContext().getSessionMap().get("pers");
        if (p == null) {
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) facesContext.getApplication().getNavigationHandler();

            nav.performNavigation("access-denied");
        }
    }

    public ArrayList<Privilege> chargeMenu() {

        ArrayList<Privilege> droits = new ArrayList();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Personnel p = (Personnel) facesContext.getExternalContext().getSessionMap().get("pers");
        if (p.getTypeuser().getTypeuser() == 1) {
            PrivilegeDao priv = new PrivilegeHDao();
            ArrayList l = (ArrayList) priv.getAllPrivileges();
            Privilege pr = new Privilege();
            pr.setIdpriv("7");
            pr.setLienpriv("/LeaderAS/faces/vue/personnel/accueil.xhtml");
            pr.setNompriv("Gestion du Personnel");
            l.add(pr);
            droits = l;

        } else {

            DetailsPrivUserDao privUser = new DetailsPrivUserHDao();

            ArrayList<Detailsprivuser> l = (ArrayList<Detailsprivuser>) privUser.getAllDetailsPrivUsers();
            Iterator li = l.iterator();
            while (li.hasNext()) {
                //Recupération objet
                Detailsprivuser pu = (Detailsprivuser) li.next();
                if (pu.getId().getIdpersonnel().equals(p.getIdpersonnel())) {
                    //traitement de l'objet
                    droits.add(pu.getPrivilege());
                    
                }


            }


        }
        return droits;
    }
}
