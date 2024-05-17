/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatamovie.datamovieDAO;
import DAOImplement.datamovieimplement;
import javax.swing.JOptionPane;
import model.*;
import View.MainView;
/**
 *
 * @author LENOVO
 */
public class datamoviecontroller {
    MainView frame;
    datamovieimplement impldatamovie;
    List<datamovie> data;
    
    
    
    public datamoviecontroller(MainView frame) {
        this.frame = frame;
        impldatamovie = new datamovieDAO();
        data = impldatamovie.getAll();
    }
    
    public void isitabel(){
        data = impldatamovie.getAll();
        modeltabeldatamovie mm = new modeltabeldatamovie(data);
        frame.getTabelDatamovie().setModel(mm);
        int count = impldatamovie.count();

    }
    
    public void insert(){
    try {
        datamovie data = new datamovie();
        data.setJudul(frame.getJTxtjudul().getText());
        data.setAlur(Double.parseDouble(frame.getJTxtalur().getText()));
        data.setPenokohan(Double.parseDouble(frame.getJTxtpenokohan().getText()));
        data.setAkting(Double.parseDouble(frame.getJTxtakting().getText()));
        impldatamovie.insert(data);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Input tidak valid. Harap masukkan nilai yang sesuai, jangan dikosongkan!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void update(){
    try {
        datamovie data = new datamovie();
        data.setJudul(frame.getJTxtjudul().getText());
        data.setAlur(Double.parseDouble(frame.getJTxtalur().getText()));
        data.setPenokohan(Double.parseDouble(frame.getJTxtpenokohan().getText()));
        data.setAkting(Double.parseDouble(frame.getJTxtakting().getText()));
        impldatamovie.update(data);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Input tidak valid. Harap masukkan nilai yang sesuai, jangan dikosongkan!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    public void delete(){
        try {
        String judul = frame.getJTxtjudul().getText();
            if(judul.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Silakan pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            } else {
                impldatamovie.delete(judul);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void reset() {
        frame.getJTxtjudul().setText(""); 
        frame.getJTxtalur().setText(""); 
        frame.getJTxtpenokohan().setText(""); 
        frame.getJTxtakting().setText("");
        frame.getJTxtnilai().setText("");
    }
    
   

    
}
