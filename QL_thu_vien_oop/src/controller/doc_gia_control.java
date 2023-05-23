/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import dao.*;
import java.time.chrono.ThaiBuddhistEra;
import javax.management.monitor.StringMonitorMBean;
/**
 *
 * @author minh0
 */
public class doc_gia_control {
    private static doc_gia_control docgiacon;
    private DefaultTableModel tblmodel;
    
    public doc_gia getdocgia(String ma){
        return doc_gia_dao.getdocgia_dao().kt_ma(ma);
    }
    
    public static doc_gia_control getdg_con(){
        if(docgiacon==null){
            docgiacon=new doc_gia_control();
        }
        return docgiacon;
    }
    
    public void load_list_tbl(JTable tbl,List<doc_gia> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                String gioitinh ;
                if(ds.get(i).getGioi_tinh()==1){
                    gioitinh = "Nam";
                }else{
                    gioitinh = "Nữ";
                }
                tblmodel.addRow(new Object[]{ds.get(i).getMa_doc_gia(),ds.get(i).getTen_doc_gia(),ds.get(i).getSo_CCCD(),
                gioitinh,ds.get(i).getNgay_sinh(),ds.get(i).getSDT(),ds.get(i).getDia_chi(),ds.get(i).getTrang_thai()});
                
            }
        }
        tbl.setRowHeight(20);
    }
    
    public void load_list_tblmini(JTable tbl,List<doc_gia> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                tblmodel.addRow(new Object[]{ds.get(i).getMa_doc_gia(),ds.get(i).getTen_doc_gia(),ds.get(i).getSo_CCCD(),ds.get(i).getTrang_thai()});
            }
        }
        tbl.setRowHeight(20);
    }
    
    public void load_list_tblpm(JTable tbl , List<listpm> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for (int i = 0; i < ds.size(); i++) {
                tblmodel.addRow(new Object[]{ds.get(i).getMapm(),ds.get(i).getNgaymuon(),
                    ds.get(i).getNgaytra(),ds.get(i).getSoluong(),ds.get(i).getTrangthai()});
            }
        }
    }
    
    public void load_cb_tt(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("");
        cb.addItem("Được mượn sách");
        cb.addItem("Đang mượn sách");
        cb.addItem("Quá hạn mượn");
        cb.addItem("Không cho mượn");
    }
    public void load_cb_tt2(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("Được mượn sách");
        cb.addItem("Đang mượn sách");
        cb.addItem("Quá hạn mượn");
        cb.addItem("Không cho mượn");
    }
    public void load_cb_gt(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("");
        cb.addItem("Nam");
        cb.addItem("Nữ");
    }
    /**
     * @return
     * 1 la them thanh cong 
     * 2 la them khong thanh cong
     * 3 ma doc gia da ton tai
     * 4 so cccd da tong tai
     * 5 ko xac dinh
     */
    public int themdg(String ma_doc_gia, String ten_doc_gia, String so_CCCD, int gioi_tinh, Date ngay_sinh, String dia_chi, String SDT, String trang_thai){
        int i =0;
        java.sql.Date ngaysinh = new java.sql.Date(ngay_sinh.getTime());
        if(doc_gia_dao.getdocgia_dao().kt_ma(ma_doc_gia)==null&&doc_gia_dao.getdocgia_dao().kt_cccd(so_CCCD)==null){
            doc_gia dg =new doc_gia(ma_doc_gia, ten_doc_gia, so_CCCD, gioi_tinh, ngaysinh, dia_chi, SDT, trang_thai);
            if(doc_gia_dao.getdocgia_dao().them_dg(dg)){
                i=1;
            }else{
                i=2;
            }
        }else if(doc_gia_dao.getdocgia_dao().kt_ma(ma_doc_gia)!=null&&doc_gia_dao.getdocgia_dao().kt_cccd(so_CCCD)==null){
            i=3;
        }else if(doc_gia_dao.getdocgia_dao().kt_ma(ma_doc_gia)==null&&doc_gia_dao.getdocgia_dao().kt_cccd(so_CCCD)!=null){
            i=4;
        }else{
            i=5;
        }
        return i;
    }
    /**
    *1 them thanh cong
    *2 them ko thanh cong
    *3  ma doc gia khong ton tai
    *4,7 sua thanh cong
    *5,8 sua ko thanh cong
    *6 lol
    */
    public int luudg(String ma_doc_gia, String ten_doc_gia, String so_CCCD, int gioi_tinh, Date ngay_sinh, String dia_chi, String SDT, String trang_thai){
        int i=0;
        java.sql.Date ngaysinh = new java.sql.Date(ngay_sinh.getTime());
        if(doc_gia_dao.getdocgia_dao().kt_ma(ma_doc_gia)==null&&doc_gia_dao.getdocgia_dao().kt_cccd(so_CCCD)==null){
            doc_gia dg =new doc_gia(ma_doc_gia, ten_doc_gia, so_CCCD, gioi_tinh, ngaysinh, dia_chi, SDT, trang_thai);
            if(doc_gia_dao.getdocgia_dao().them_dg(dg)){
                i=1;
            }else{
                i=2;
            }
        }else if(doc_gia_dao.getdocgia_dao().kt_ma(ma_doc_gia)!=null&&doc_gia_dao.getdocgia_dao().kt_cccd(so_CCCD)==null){
            doc_gia dg =new doc_gia(ma_doc_gia, ten_doc_gia, so_CCCD, gioi_tinh, ngaysinh, dia_chi, SDT, trang_thai);
            if(doc_gia_dao.getdocgia_dao().sua_dg(dg)){
                i=4;
            }else{
                i=5;
            }
        }else if(doc_gia_dao.getdocgia_dao().kt_ma(ma_doc_gia)==null&&doc_gia_dao.getdocgia_dao().kt_cccd(so_CCCD)!=null){
                i=3;
        }else{
            if(doc_gia_dao.getdocgia_dao().ktdg(ma_doc_gia, so_CCCD)==null){
                i=6;
            }else{
                doc_gia dg =new doc_gia(ma_doc_gia, ten_doc_gia, so_CCCD, gioi_tinh, ngaysinh, dia_chi, SDT, trang_thai);
                if(doc_gia_dao.getdocgia_dao().sua_dg(dg)){
                    i=7;
                }else{
                    i=8;
                }
            }
        }
        return i;
    }
    /**
     * 
     * @param ma
     * @return
     * 1 ma doc gia ko ton tai
     * 2 xoa thanh cong
     * 3 xoa khong thanh cong
     */
    public int xoadg(String ma){
        int i=0;
        if(doc_gia_dao.getdocgia_dao().kt_ma(ma)==null){
            i=1;
        }else{
            if(doc_gia_dao.getdocgia_dao().xoa(ma)){
                i=2;
            }else{
                i=3;
            }
        }
        return i;
    }
    
    public List<doc_gia> timkiemdg(String ma_doc_gia, String ten_doc_gia, String so_CCCD, int gioi_tinh, String ngay_sinh, String dia_chi, String SDT, String trang_thai){
        doc_gia dg = new doc_gia(ma_doc_gia, ten_doc_gia, so_CCCD, gioi_tinh, null , dia_chi, SDT, trang_thai);
        return doc_gia_dao.getdocgia_dao().tim_kiem(dg, ngay_sinh);
    }
    
    public List<listpm> timpm(String ma){
        return phieu_muon_dao.getPM_dao().timpm_dg(ma);
    }
}
