package com.lds.vo;
// Generated 25 aout 2012 10:08:18 by Hibernate Tools 3.2.1.GA



/**
 * DetailstachepersonnelId generated by hbm2java
 */
public class DetailstachepersonnelId  implements java.io.Serializable {


     private String numtache;
     private String idpersonnel;

    public DetailstachepersonnelId() {
    }

    public DetailstachepersonnelId(String numtache, String idpersonnel) {
       this.numtache = numtache;
       this.idpersonnel = idpersonnel;
    }
   
    public String getNumtache() {
        return this.numtache;
    }
    
    public void setNumtache(String numtache) {
        this.numtache = numtache;
    }
    public String getIdpersonnel() {
        return this.idpersonnel;
    }
    
    public void setIdpersonnel(String idpersonnel) {
        this.idpersonnel = idpersonnel;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetailstachepersonnelId) ) return false;
		 DetailstachepersonnelId castOther = ( DetailstachepersonnelId ) other; 
         
		 return ( (this.getNumtache()==castOther.getNumtache()) || ( this.getNumtache()!=null && castOther.getNumtache()!=null && this.getNumtache().equals(castOther.getNumtache()) ) )
 && ( (this.getIdpersonnel()==castOther.getIdpersonnel()) || ( this.getIdpersonnel()!=null && castOther.getIdpersonnel()!=null && this.getIdpersonnel().equals(castOther.getIdpersonnel()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNumtache() == null ? 0 : this.getNumtache().hashCode() );
         result = 37 * result + ( getIdpersonnel() == null ? 0 : this.getIdpersonnel().hashCode() );
         return result;
   }   


}


