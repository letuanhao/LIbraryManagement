/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.*;
import java.util.*;
import javax.swing.table.*;
import model.*;
import dao.*;
/**
 *
 * @author minh0
 */
public class NXB_control {
    private static NXB_control NXBcon;
    private DefaultTableModel tableModel;
    public void load_list_cb(JComboBox cb,List<NXB> ds){
        cb.removeAllItems();
        cb.addItem("");
        for(int i=0;i<ds.size();i++){
            cb.addItem(ds.get(i).getTen_NXB());
        }
    }
    public NXB get_NXB(String ma){
        return NXB_dao.getNXB_dao().kt_NXB(ma);
    }
    public static NXB_control getNXB_control(){
        if(NXBcon==null){
            NXBcon=new NXB_control();
        }
        return NXBcon;
    }
    public void load_list_tbl(JTable tbl , List<NXB> ds){
        tableModel = (DefaultTableModel) tbl.getModel();
        tableModel.setRowCount(0);
        if(ds==null){
            
        }else{
            for (int i = 0; i < ds.size(); i++) {
                tableModel.addRow(new Object[]{ds.get(i).getMa_NXB(),ds.get(i).getTen_NXB() });
            }
        }
        tbl.setRowHeight(20);
    }
    public int them(String maNXB,String tenNXB){
        int t= 0;
        if(NXB_dao.getNXB_dao().kt_NXB(maNXB)==null){
            if(NXB_dao.getNXB_dao().them(maNXB, tenNXB)){
                t=1;//theem thanh cong
            }else{
                t=2;//them khong thanh cong
            }
        }else{
            t=3;//ma da ton tai
        }
        return t;
    }
    
    public int luu(String maNXB,String tenNXB){
        int t=0;
        if(NXB_dao.getNXB_dao().kt_NXB(maNXB)==null){
            if(NXB_dao.getNXB_dao().them(maNXB, tenNXB)){
                t=1;//theem thanh cong
            }else{
                t=2;//them khong thanh cong
            }
        }else{
            if(NXB_dao.getNXB_dao().sua(maNXB, tenNXB)){
                t=3;//sua thanh cong
            }else{
                t=4;//sua khong thanh cong
            }
        }
        return t;
    }
    
    public List<NXB> getall(){
        return NXB_dao.getNXB_dao().ds_NXB();
    }
    public boolean xoa(String ma){
        return NXB_dao.getNXB_dao().xoa(ma);
    }
}
