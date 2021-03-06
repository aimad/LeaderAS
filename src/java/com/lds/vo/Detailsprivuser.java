package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA



/**
 * Detailsprivuser generated by hbm2java
 */
public class Detailsprivuser  implements java.io.Serializable {


     private DetailsprivuserId id;
     private Privilege privilege;
     private Personnel personnel;
     private String description;

    public Detailsprivuser() {
    }

	
    public Detailsprivuser(DetailsprivuserId id, Privilege privilege, Personnel personnel) {
        this.id = id;
        this.privilege = privilege;
        this.personnel = personnel;
    }
    public Detailsprivuser(DetailsprivuserId id, Privilege privilege, Personnel personnel, String description) {
       this.id = id;
       this.privilege = privilege;
       this.personnel = personnel;
       this.description = description;
    }
   
    public DetailsprivuserId getId() {
        return this.id;
    }
    
    public void setId(DetailsprivuserId id) {
        this.id = id;
    }
    public Privilege getPrivilege() {
        return this.privilege;
    }
    
    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
    public Personnel getPersonnel() {
        return this.personnel;
    }
    
    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


