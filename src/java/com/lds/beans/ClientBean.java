/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;


import com.lds.persistance.ClientHDao;
import com.lds.vo.Client;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
  
 
  
public class ClientBean implements Serializable {  
 
  
    private List<Client> filteredClients;  
  
    private List<Client> clients;  
  
    private Client selectedClient;        
    
    private  Client clt;
    private  ClientHDao dao;
    private  ClientDataModel mediumClientsModel;
  
    public ClientBean() {  
        
        clt = new Client();
        clients = new ArrayList<Client>();
        //selectedClient=new Client();
        //populateRandomCars(cars, 50);  
        dao = new ClientHDao();
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients); 
    }  
  
    public Client getSelectedClient() {  
        return selectedClient;  
    }  
  
    public void setSelectedClient(Client selectedClient) {  
        this.selectedClient = selectedClient;  
    }  
       public LazyDataModel<Client> getMediumClientsModel() {
        return mediumClientsModel;
    }

    public Client getClt() {
        return clt;
    }

    public void setClt(Client clt) {
        this.clt = clt;
    }
         
    public List<Client> getFilteredClients() {  
        return filteredClients;  
    }  
  
    public void setFilteredClients(List<Client> filteredClients) {  
        this.filteredClients = filteredClients;  
    }  
  
    public List<Client> getClients() {  
        return clients;  
    }  
    
     public void supprimer() {
        if (selectedClient == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un client", "Selectionnez une ligne !"));
        }
        
        dao.delete(selectedClient.getIdclient());
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients);

    }

    public String ajouter() {
        //Si le login est dejà utilisé 

        for (Client client : clients) {
            if (client.getIdclient().equals(clt.getIdclient())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ce client existe dejà !", "Veuillez changer le Code du client."));
                return "echecAjout";
            }
        }
        //sinon
        
        dao.insert(clt);
        clt=new Client();
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients);
        return "succesAjout";

    }
    
    

    public String modif() {
        if (selectedClient == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Veuillez choisir un client", "Selectionnez une ligne !"));
        return "";      
        }
        else
        {                 
            return "modif";}
    }
    
    public String enrModif(){
        dao.update(selectedClient);
        clients = dao.getAllClients();
        mediumClientsModel = new ClientDataModel(clients);
        return "succesAjout";
    }
    
} 