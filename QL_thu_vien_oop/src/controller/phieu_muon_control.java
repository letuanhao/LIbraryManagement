/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.*;
import dao.*;
import java.text.SimpleDateFormat;
import java.util.*;
import model.*;
import javax.swing.table.*;
/**
 *
 * @author minh0
 */
public class phieu_muon_control {
    private DefaultTableModel tblmodel;
    private static phieu_muon_control pmcon;
    public void load_cb_tt(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("");
        cb.addItem("Còn hạn");
        cb.addItem("Quá hạn");
        cb.addItem("Đã trả hết");
    }
    
    public void load_list_tbl(JTable tbl,List<phieu_muon> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                phieu_muon pm = ds.get(i);
                doc_gia dg = doc_gia_dao.getdocgia_dao().kt_ma(pm.getMa_doc_gia());
                tblmodel.addRow(new Object[]{ pm.getMa_PM(), pm.getMa_doc_gia(),
                    dg.getTen_doc_gia(),pm.getNgay_muon(),pm.getNgay_tra(), pm.getTrang_thai()});
            }
            tbl.setRowHeight(20);
        }
    }
    //1 la them thanh conh
    //2 la co loi
    //3 la ma da ton tai
    public int them(String mapm , String madocgia , Date ngaymuon , Date ngaytra , String trangthai){
        int i=0;
        if(phieu_muon_dao.getPM_dao().kt_mapm(mapm)==null){
            if(phieu_muon_dao.getPM_dao().them(mapm, madocgia, ngaymuon, ngaytra, "")){
                i=1;
            }else{
                i=2;
            }
        }else{
            i=3;
        }
        phieu_muon_dao.getPM_dao().suattpm();
        return i;
    }
    //1 la them thanh cong
    //2 la co loi khi them
    //3 la luu thanh cong
    //4 la co loi khi luu
    public int luu(String mapm , String madocgia , Date ngaymuon , Date ngaytra , String trangthai ){
        int i=0;
        if(phieu_muon_dao.getPM_dao().kt_mapm(mapm)==null){
            if(phieu_muon_dao.getPM_dao().them(mapm, madocgia, ngaymuon, ngaytra, "")){
                i=1;
            }else{
                i=2;
            }
        }else{
            if(phieu_muon_dao.getPM_dao().sua(mapm, ngaymuon, ngaytra)){
                i=3;
            }else{
                i=4;
            }
        }
        phieu_muon_dao.getPM_dao().suattpm();
        return i;
    }
    
    public List<phieu_muon> tim_pm(String madg , String mapm,String trangthai , Date ngaybd , Date ngaykt , boolean kt){
        phieu_muon_dao.getPM_dao().suattpm();
        if(kt){
            return phieu_muon_dao.getPM_dao().tim_pm_nm(madg, mapm, trangthai, ngaybd, ngaykt);
        }else{
            return phieu_muon_dao.getPM_dao().tim_pm_nt(madg, mapm, trangthai, ngaybd, ngaykt);
        }
        
    }
    
    public boolean xoa(String ma){
        dong_phieu_dao.getttpm_dao().xoa_all(ma);
        return phieu_muon_dao.getPM_dao().xoa(ma);
    }
    
    public List<phieu_muon> tim(String bien){
        phieu_muon_dao.getPM_dao().suattpm();
        return phieu_muon_dao.getPM_dao().tim_pm(bien);
    }
    
    public phieu_muon laypm(String ma){
        return phieu_muon_dao.getPM_dao().kt_mapm(ma);
    }
    
    public static phieu_muon_control getpm_con(){
        if(pmcon==null){
            pmcon=new phieu_muon_control();
        }
        return pmcon;
    }
    
    public String taomaPM(int stt){
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");
        Date date = new Date();
        String dateFormat = formatter.format(date);
        String id = String.valueOf(tai_khoan.getId());
        String st = String.valueOf(stt);
        String tong = dateFormat + id + st;
        
        return tong;
    }
    public static void main(String[] args) {
        System.out.println(getpm_con().taomaPM(0));
    }
}
