/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import pojo.Monhoc;

/**
 *
 * @author HP
 */
public class MonHocTableModel {
    public DefaultTableModel setTableMonhoc(List<Monhoc> dsMH, String[] listCol) {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(listCol);
        int nCol = listCol.length;
        Object[] obj = null;
        int rows = dsMH.size();
        if (rows > 0 ) {
            for (int i = 0; i < rows; i++) {
                Monhoc mh = dsMH.get(i);
                obj = new Object[nCol];
                obj[0] = (i+1);
                obj[1] = mh.getMamon();
                obj[2] = mh.getTenmon();
                obj[3] = mh.getPhong();
                obj[4] = mh.getLop().getMalop();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
