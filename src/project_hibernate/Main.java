/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_hibernate;

import dao.*;
import java.util.List;
import pojo.*;

/**
 *
 * @author HP
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lop lop = LopDAO.layThongTinLop("17CTT7");
        if (lop != null) {
            System.out.println(lop.getMalop());
        }
    } 
}