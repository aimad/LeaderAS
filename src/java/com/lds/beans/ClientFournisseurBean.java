/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lds.beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author ELKAOUMI
 */
@ManagedBean
@RequestScoped
public class ClientFournisseurBean {
    String page;

    public void setPage(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    /** Creates a new instance of selectedBean */
    public ClientFournisseurBean() {
    }
   public void change(ValueChangeEvent event) throws IOException {
     page = (String) event.getNewValue(); // Must however be the exact page URL. E.g. "contact.jsf".
    FacesContext.getCurrentInstance().getExternalContext().redirect(page);
}
}
