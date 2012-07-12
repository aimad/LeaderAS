package com.lds.vo;
// Generated 11 juil. 2012 11:29:27 by Hibernate Tools 3.2.1.GA



/**
 * FournitureId generated by hbm2java
 */
public class FournitureId  implements java.io.Serializable {


     private String idelement;
     private String numfourniture;

    public FournitureId() {
    }

    public FournitureId(String idelement, String numfourniture) {
       this.idelement = idelement;
       this.numfourniture = numfourniture;
    }
   
    public String getIdelement() {
        return this.idelement;
    }
    
    public void setIdelement(String idelement) {
        this.idelement = idelement;
    }
    public String getNumfourniture() {
        return this.numfourniture;
    }
    
    public void setNumfourniture(String numfourniture) {
        this.numfourniture = numfourniture;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FournitureId) ) return false;
		 FournitureId castOther = ( FournitureId ) other; 
         
		 return ( (this.getIdelement()==castOther.getIdelement()) || ( this.getIdelement()!=null && castOther.getIdelement()!=null && this.getIdelement().equals(castOther.getIdelement()) ) )
 && ( (this.getNumfourniture()==castOther.getNumfourniture()) || ( this.getNumfourniture()!=null && castOther.getNumfourniture()!=null && this.getNumfourniture().equals(castOther.getNumfourniture()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdelement() == null ? 0 : this.getIdelement().hashCode() );
         result = 37 * result + ( getNumfourniture() == null ? 0 : this.getNumfourniture().hashCode() );
         return result;
   }   


}


