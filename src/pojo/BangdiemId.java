package pojo;
// Generated Jun 12, 2020 11:24:48 AM by Hibernate Tools 4.3.1



/**
 * BangdiemId generated by hbm2java
 */
public class BangdiemId  implements java.io.Serializable {


     private String masv;
     private String malop;
     private String mamon;

    public BangdiemId() {
    }

    public BangdiemId(String masv, String malop, String mamon) {
       this.masv = masv;
       this.malop = malop;
       this.mamon = mamon;
    }
   
    public String getMasv() {
        return this.masv;
    }
    
    public void setMasv(String masv) {
        this.masv = masv;
    }
    public String getMalop() {
        return this.malop;
    }
    
    public void setMalop(String malop) {
        this.malop = malop;
    }
    public String getMamon() {
        return this.mamon;
    }
    
    public void setMamon(String mamon) {
        this.mamon = mamon;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BangdiemId) ) return false;
		 BangdiemId castOther = ( BangdiemId ) other; 
         
		 return ( (this.getMasv()==castOther.getMasv()) || ( this.getMasv()!=null && castOther.getMasv()!=null && this.getMasv().equals(castOther.getMasv()) ) )
 && ( (this.getMalop()==castOther.getMalop()) || ( this.getMalop()!=null && castOther.getMalop()!=null && this.getMalop().equals(castOther.getMalop()) ) )
 && ( (this.getMamon()==castOther.getMamon()) || ( this.getMamon()!=null && castOther.getMamon()!=null && this.getMamon().equals(castOther.getMamon()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMasv() == null ? 0 : this.getMasv().hashCode() );
         result = 37 * result + ( getMalop() == null ? 0 : this.getMalop().hashCode() );
         result = 37 * result + ( getMamon() == null ? 0 : this.getMamon().hashCode() );
         return result;
   }   


}


