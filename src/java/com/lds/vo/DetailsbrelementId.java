package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA



/**
 * DetailsbrelementId generated by hbm2java
 */
public class DetailsbrelementId  implements java.io.Serializable {


     private String numreception;
     private String idelement;

    public DetailsbrelementId() {
    }

    public DetailsbrelementId(String numreception, String idelement) {
       this.numreception = numreception;
       this.idelement = idelement;
    }
   
    public String getNumreception() {
        return this.numreception;
    }
    
    public void setNumreception(String numreception) {
        this.numreception = numreception;
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
		 if ( !(other instanceof DetailsbrelementId) ) return false;
		 DetailsbrelementId castOther = ( DetailsbrelementId ) other; 
         
		 return ( (this.getNumreception()==castOther.getNumreception()) || ( this.getNumreception()!=null && castOther.getNumreception()!=null && this.getNumreception().equals(castOther.getNumreception()) ) )
 && ( (this.getIdelement()==castOther.getIdelement()) || ( this.getIdelement()!=null && castOther.getIdelement()!=null && this.getIdelement().equals(castOther.getIdelement()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getNumreception() == null ? 0 : this.getNumreception().hashCode() );
         result = 37 * result + ( getIdelement() == null ? 0 : this.getIdelement().hashCode() );
         return result;
   }   


}


