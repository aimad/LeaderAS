package com.lds.vo;
// Generated 13 juil. 2012 07:24:47 by Hibernate Tools 3.2.1.GA



/**
 * DetailsbcelementId generated by hbm2java
 */
public class DetailsbcelementId  implements java.io.Serializable {


     private String numbc;
     private String idelement;

    public DetailsbcelementId() {
    }

    public DetailsbcelementId(String numbc, String idelement) {
       this.numbc = numbc;
       this.idelement = idelement;
    }
   
    public String getNumbc() {
        return this.numbc;
    }
    
    public void setNumbc(String numbc) {
        this.numbc = numbc;
    }
    public String getIdelement() {
        return this.idelement;
    }
    
    public void setIdelement(String idelement) {
        this.idelement = idelement;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetailsbcelementId) ) return false;
		 DetailsbcelementId castOther = ( DetailsbcelementId ) other; 
         
		 return ( (this.getNumbc()==castOther.getNumbc()) || ( this.getNumbc()!=null && castOther.getNumbc()!=null && this.getNumbc().equals(castOther.getNumbc()) ) )
 && ( (this.getIdelement()==castOther.getIdelement()) || ( this.getIdelement()!=null && castOther.getIdelement()!=null && this.getIdelement().equals(castOther.getIdelement()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNumbc() == null ? 0 : this.getNumbc().hashCode() );
         result = 37 * result + ( getIdelement() == null ? 0 : this.getIdelement().hashCode() );
         return result;
   }   


}


