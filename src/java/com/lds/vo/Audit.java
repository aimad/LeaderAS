package com.lds.vo;


import java.util.Date;

/**
 * Audit generated by hbm2java
 */
public class Audit  implements java.io.Serializable {


     private String idaudit;
     private String typeoperation;
     private String userid;
     private String username;
     private String typemodification;
     private Date dateaudit;
     private Integer heuraudit;

    public Audit() {
    }

	
    public Audit(String idaudit) {
        this.idaudit = idaudit;
    }
    public Audit(String idaudit, String typeoperation, String userid, String username, String typemodification, Date dateaudit, Integer heuraudit) {
       this.idaudit = idaudit;
       this.typeoperation = typeoperation;
       this.userid = userid;
       this.username = username;
       this.typemodification = typemodification;
       this.dateaudit = dateaudit;
       this.heuraudit = heuraudit;
    }
   
    public String getIdaudit() {
        return this.idaudit;
    }
    
    public void setIdaudit(String idaudit) {
        this.idaudit = idaudit;
    }
    public String getTypeoperation() {
        return this.typeoperation;
    }
    
    public void setTypeoperation(String typeoperation) {
        this.typeoperation = typeoperation;
    }
    public String getUserid() {
        return this.userid;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTypemodification() {
        return this.typemodification;
    }
    
    public void setTypemodification(String typemodification) {
        this.typemodification = typemodification;
    }
    public Date getDateaudit() {
        return this.dateaudit;
    }
    
    public void setDateaudit(Date dateaudit) {
        this.dateaudit = dateaudit;
    }
    public Integer getHeuraudit() {
        return this.heuraudit;
    }
    
    public void setHeuraudit(Integer heuraudit) {
        this.heuraudit = heuraudit;
    }




}


