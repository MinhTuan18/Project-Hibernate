package pojo;
// Generated Jun 12, 2020 11:24:48 AM by Hibernate Tools 4.3.1



/**
 * Sinhvien generated by hbm2java
 */
public class Sinhvien  implements java.io.Serializable {


     private String masv;
     private String hoten;
     private String gioitinh;
     private String cmnd;
     private Lop lop;

    public Sinhvien() {
        this.lop = new Lop();
    }

    public Sinhvien(String masv, String hoten, String gioitinh, String cmnd, Lop lop) {
        this.masv = masv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.cmnd = cmnd;
        this.lop = lop;
    }
     
     
    public String getMasv() {
        return masv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public Lop getLop() {
        return lop;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public void setLop(Lop lop) {
        this.lop = lop;
    }

    

	
    




}


