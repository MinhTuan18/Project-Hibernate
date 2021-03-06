/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Danhsachlop;
import pojo.DanhsachlopId;
import pojo.Lop;
import pojo.Monhoc;
import pojo.Sinhvien;
import util.HibernateUtil;

/**
 *
 * @author HP
 */
public class MonhocDAO {
    public static List<Monhoc> layDanhSachMonHoc() {
        List<Monhoc> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select * from Monhoc";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
    public static List<Monhoc> layDanhSachMonHoc(String malop) {
        List<Monhoc> ds = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String hql = "select mh from Monhoc mh where mh.lop.malop = :malop";
            Query query = session.createQuery(hql);
            query.setString("malop", malop);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }
    
    public static boolean themMonHocTuFileCSV(String filename, String malop){
        String delimiter = ",";
        List<Monhoc> ds = new ArrayList<Monhoc>();
        List<Sinhvien> dsSV = new ArrayList<Sinhvien>();
        List<Danhsachlop> dsLop = new ArrayList<Danhsachlop>();
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            Lop lop = new Lop(malop);
            dsSV = SinhvienDAO.layDanhSachSinhVien(malop);
            br.readLine();
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                String mamon = tempArr[1];
                String tenmon = tempArr[2];
                String phonghoc = tempArr[3];
                
                Monhoc monhoc = new Monhoc(mamon, tenmon, phonghoc, lop);
                System.out.println(monhoc.getMamon()+ "-" + monhoc.getTenmon() + "-" + monhoc.getPhong() + "-" +  monhoc.getLop().getMalop());
                ds.add(monhoc);
                for (int i = 0; i < dsSV.size(); i++) {
                    Danhsachlop dsl = new Danhsachlop(new DanhsachlopId(mamon, dsSV.get(i).getMasv(), malop));
                    dsLop.add(dsl);
                }
            }
        } catch (IOException ex) {
        }
        if (ds.isEmpty()) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            ds.stream().forEach((sv) -> {
                session.save(sv);
            });
            dsLop.stream().forEach((dsl) -> {
                session.save(dsl);
            });
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
}
