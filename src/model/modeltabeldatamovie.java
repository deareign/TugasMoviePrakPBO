/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class modeltabeldatamovie extends AbstractTableModel{
    
    List<datamovie> data;
    public modeltabeldatamovie(List<datamovie>data) {
        this.data = data;
        
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "JUDUL";
            case 1:
                return "ALUR";
            case 2: 
                return "PENOKOHAN";
            case 3:
                return "AKTING";
            case 4:
                return "NILAI";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return data.get(row).getJudul();
            case 1:
                return data.get(row).getAlur();
            case 2: 
                return data.get(row).getPenokohan();
            case 3:
                return data.get(row).getAkting();
            case 4:
                return data.get(row).getNilai();
            default:
                return null;
        }
    }
    
}
