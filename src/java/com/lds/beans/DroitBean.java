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
import com.lds.vo.DetailsprivuserId;
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

    //Fonction pour la gestion des accès aux pages
    public void authorize() {
        //Recupération de la session courante et initialisation
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Personnel p = (Personnel) facesContext.getExternalContext().getSessionMap().get("pers");
        ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) facesContext.getApplication().getNavigationHandler();

        //Si pas de connexion ( session )
        if (p == null) {

            nav.performNavigation("/vue/access-denied");
            
        } else {

            String id = facesContext.getExternalContext().getRequestParameterMap().get("id");
            String path = facesContext.getExternalContext().getRequestPathInfo();

            //on teste sur l'id et le path du privilege
            if (!"-1".equals(id) && p.getTypeuser().getTypeuser() == 2) {

                DetailsprivuserId privuserId = new DetailsprivuserId(p.getIdpersonnel(), id);
                DetailsPrivUserDao dao = new DetailsPrivUserHDao();
                Detailsprivuser privuser = dao.getDetailsPrivUser(privuserId);
                String[] tab = path.split("/");
                //Si l'user n'a pas ce privilège
                if (privuser == null) {
                    
                    nav.performNavigation("/vue/no-access");
                    
                    //on compare les chemins
                } else {
                    
                    String path1 = privuser.getPrivilege().getLienpriv();
                    String[] tab1 = path1.split("/");
                    if (!tab1[4].equals(tab[2])) {
                        nav.performNavigation("/vue/no-access");
                        
                    }
                }
            }
            
            //Si c'est pas l'accueil
            else if ("-1".equals(id) && p.getTypeuser().getTypeuser() == 2 && !path.equals("/vue/accueil.xhtml")) {
                nav.performNavigation("/vue/no-access");
         
            }
        }
    }

    public ArrayList<Privilege> chargeMenu() {

        //Initialisation variables
        ArrayList<Privilege> droits = new ArrayList();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Personnel p = (Personnel) facesContext.getExternalContext().getSessionMap().get("pers");
        
        //si c'est l'admin
        if (p.getTypeuser().getTypeuser() == 1) {
            
            PrivilegeDao priv = new PrivilegeHDao();
            ArrayList l = (ArrayList) priv.getAllPrivileges();
            Privilege pr = new Privilege();
            pr.setIdpriv("7");
            pr.setLienpriv("/LeaderAS/faces/vue/personnel/accueil.xhtml?id=-1");
            pr.setNompriv("Gestion du Personnel");
            l.add(pr);
            droits = l;

        } else {
            //Sinon on cherche les droits dans detailsPrivUser
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
    public String getLogin(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Personnel p = (Personnel) facesContext.getExternalContext().getSessionMap().get("pers");
        return p.getIdpersonnel();
    }
}
