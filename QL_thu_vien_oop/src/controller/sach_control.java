/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.table.*;
import javax.swing.*;
import java.util.*;
import model.*;
import dao.*;
/**
 *
 * @author minh0
 */
public class sach_control {
    private DefaultTableModel tblmodel;
    private static sach_control sachcon;
    public static sach_control getsach_con(){
        if(sachcon==null){
            sachcon = new sach_control();
        }
        return sachcon;
    }
    public void load_tblsach(JTable tbl , List<sach> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                sach s = ds.get(i);
                dau_sach s1 = dau_sach_dao.getdausach_dao().kt_dau_sach(s.getMa_dau_sach());
                tblmodel.addRow(new Object[]{s.getMa_sach(),s1.getMa_dau_sach(),
                    s1.getTen_dau_sach(),s.getNam_xuat_ban(),s.getISBN(),s.getGiatiensach(),s.getTinh_trang()});
            }
        }
        tbl.setRowHeight(20);
    }
    
    public void load_tblsachmini(JTable tbl , List<sach> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                sach s = ds.get(i);
                dau_sach s1 = dau_sach_dao.getdausach_dao().kt_dau_sach(s.getMa_dau_sach());
                tblmodel.addRow(new Object[]{s.getMa_sach(),s1.getTen_dau_sach(),s.getGiatiensach(),s.getTinh_trang()});
            }
        }
        tbl.setRowHeight(20);
    }
    
    public void load_tbl_sach_ds(JTable tbl,String maDauSach){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        List<sach> ds = sach_dao.getsach_dao().dausach_sach(maDauSach);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                sach s = ds.get(i);
                dau_sach s1 = dau_sach_dao.getdausach_dao().kt_dau_sach(s.getMa_dau_sach());
                tblmodel.addRow(new Object[]{s.getMa_sach(),s1.getTen_dau_sach(),s.getNam_xuat_ban(),s.getGiatiensach(),s.getTinh_trang()});
            }
        }
    }
    
    
    public int them_nhieu_sach(String maDausach,String ISBN,float giatien,int soluong,String namXB){
        int kt=0;
        int max = sach_dao.getsach_dao().sachmax(maDausach);
        for (int i=0;i<soluong;i++){
            String masach = maDausach + String.valueOf(max+i+1);
            String ISBN1 = ISBN + String.valueOf(max+i+1);
            if(sach_dao.getsach_dao().them(masach, maDausach, ISBN1, namXB,"Có thể mượn", giatien )){
                kt++;
            }
        }
        return kt;
    }
    
    public void load_cb_dausach(JComboBox cb , List<dau_sach> ds){
        cb.removeAllItems();
        cb.addItem("");
        if(ds==null){
            
        }else{
            for (int i=0; i < ds.size();i++){
                cb.addItem(ds.get(i).getMa_dau_sach());
            }
        }
    }
    //1 la them thanh cong 
    //2 ma sach da ton tai
    //3 ma isbn da ton tai
    //4 ma sach va isbn da ton tai
    public int them_sach(String ma,String mads,String ISBN,String namxb,String tinhtrang,float giatien){
        int i=0;
        if(sach_dao.getsach_dao().kt_ma_sach(ma)==null&&sach_dao.getsach_dao().kt_ISBN(ISBN)==null){
            if (sach_dao.getsach_dao().them(ma, mads, ISBN, namxb, tinhtrang, giatien)) {
                i=1;
            }
        }else if(sach_dao.getsach_dao().kt_ma_sach(ma)!=null && sach_dao.getsach_dao().kt_ISBN(ISBN)==null){
            i=2;
        }else if(sach_dao.getsach_dao().kt_ma_sach(ma)==null && sach_dao.getsach_dao().kt_ISBN(ISBN)!=null ){
            i=3;
        }else{
            i=4;
        }
        return i;
    }
    //1 la them thanh cong
    //2 la luu thanh cong
    //3 la ma isbn da ton tai
    //4 la ma da ton tai
    public int luu_sach(String ma,String mads,String ISBN,String namxb,String tinhtrang,float giatien){
        int i=0;
        if(sach_dao.getsach_dao().kt_ma_sach(ma)==null && sach_dao.getsach_dao().kt_ISBN(ISBN) == null){
            if (sach_dao.getsach_dao().them(ma, mads, ISBN, namxb, tinhtrang, giatien)) {
                i=1;
            }
        }else if(sach_dao.getsach_dao().kt_ma_sach(ma)!=null && sach_dao.getsach_dao().kt_ISBN(ISBN)==null){
            if(sach_dao.getsach_dao().sua(ma, mads, ISBN, namxb, tinhtrang, giatien)){
                i=2;
            }
        }else if(sach_dao.getsach_dao().kt_ma_sach(ma)==null && sach_dao.getsach_dao().kt_ISBN(ISBN)!=null ){
            i=3;
        }else{
            if(sach_dao.getsach_dao().kt_all(ma, ISBN)==null){
                i=4;
            }else{
                if(sach_dao.getsach_dao().sua(ma, mads, ISBN, namxb, tinhtrang, giatien)){
                    i=5;
                }
            }
        }
        return i;
    }
    public boolean xoa_sach(String ma){
        if(sach_dao.getsach_dao().kt_ma_sach(ma)!=null){
            if(sach_dao.getsach_dao().xoa(ma)){
                return true;
            }else{
                return false;
            }
            
        }
        return false;
    }
    
    public List<sach> tim_sach(String bien){
        return sach_dao.getsach_dao().tim(bien);
    }
    
    public void load_cb_tt(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("Có thể mượn");
        cb.addItem("Đang mượn");
        cb.addItem("Đã mất");
    }
    
    public sach getsach(String ma){
        return sach_dao.getsach_dao().kt_ma_sach(ma);
    }
    public static void main(String[] args) {
        int i= getsach_con().them_nhieu_sach("TL002N0019", "77-888-999-66", 50000, 10, "2019");
        System.out.println(i);
    }
}
