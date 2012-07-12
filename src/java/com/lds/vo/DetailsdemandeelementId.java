package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA



/**
 * DetailsdemandeelementId generated by hbm2java
 */
public class DetailsdemandeelementId  implements java.io.Serializable {


     private String referencedemande;
     private String idelement;

    public DetailsdemandeelementId() {
    }

    public DetailsdemandeelementId(String referencedemande, String idelement) {
       this.referencedemande = referencedemande;
       this.idelement = idelement;
    }
   
    public String getReferencedemande() {
        return this.referencedemande;
    }
    
    public void setReferencedemande(String referencedemande) {
        this.referencedemande = referencedemande;
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
		 if ( !(other instanceof DetailsdemandeelementId) ) return false;
		 DetailsdemandeelementId castOther = ( DetailsdemandeelementId ) other; 
         
		 return ( (this.getReferencedemande()==castOther.getReferencedemande()) || ( this.getReferencedemande()!=null && castOther.getReferencedemande()!=null && this.getReferencedemande().equals(castOther.getReferencedemande()) ) )
 && ( (this.getIdelement()==castOther.getIdelement()) || ( this.getIdelement()!=null && castOther.getIdelement()!=null && this.getIdelement().equals(castOther.getIdelement()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getReferencedemande() == null ? 0 : this.getReferencedemande().hashCode() );
         result = 37 * result + ( getIdelement() == null ? 0 : this.getIdelement().hashCode() );
         return result;
   }   


}


