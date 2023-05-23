/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.*;
import dao.*;
import java.util.*;
import model.*;
import javax.swing.table.*;
/**
 *
 * @author minh0
 */
public class dau_sach_control {
    private DefaultTableModel tblmodel;
    private static dau_sach_control dauSachCon;
    public static dau_sach_control getDauSachControl(){
        if(dauSachCon==null){
            dauSachCon=new dau_sach_control();
        }
        return dauSachCon;
    }
    public void load_cb_tt(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("");
        cb.addItem("Có thể mượn");
        cb.addItem("Đã mượn hết");
        cb.addItem("Chưa có sách");
    }
    public void load_list_cb(JComboBox cb , List<dau_sach> ds){
        cb.removeAllItems();
        cb.addItem("");
        for(int i=0;i<ds.size();i++){
            cb.addItem(ds.get(i).getMaTenSach());
        }
    }
    public void load_list_table(JTable tbl, List<dau_sach> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            tblmodel.addRow(new Object[]{"khong co sach nao dc tim thay"});
        }else{
        for(int i=0;i<ds.size();i++){
            dau_sach dausach =ds.get(i);
            the_loai TL=the_loai_control.get_TLc().get_TL(dausach.getMa_TL());
            NXB nxb = NXB_control.getNXB_control().get_NXB(dausach.getMa_NXB());
            tblmodel.addRow(new Object[]{dausach.getMa_dau_sach(),dausach.getTen_dau_sach(),dausach.getTac_gia(),
                TL.getTen_TL(),nxb.getTen_NXB(),dausach.getVi_tri(),dausach.getSoluong(),dausach.getTrang_thai()});
        }
        }
        tbl.setRowHeight(20);
    }
    //1 la them thanh cong
    //2 la them that bai
    //3 la trung ma
    public int themdausach(String ma,String ten,String NXB,String TL,String tacgia,String vitri,String trangthai){
        int i=0;
        if(dau_sach_dao.getdausach_dao().kt_dau_sach(ma)==null){
            if(dau_sach_dao.getdausach_dao().them(ma, ten, NXB, TL, tacgia, vitri, trangthai)){
                i = 1;
            }else i=2;
        }else{
            i=3;
        }
        return i;
    }
    //tra ve 1 la them thanh cong
    //tra ve 0 la them that bai
    //tra va 2 la luu thanh cong
    //tra ve 3 la luu that bai
    public int nutluuDauSach(String ma,String ten,String NXB,String TL,String tacgia,String vitri,String trangthai){
        int i = 0;
        if(dau_sach_dao.getdausach_dao().kt_dau_sach(ma)==null){
            if(dau_sach_dao.getdausach_dao().them(ma, ten, NXB, TL, tacgia, vitri, trangthai)){
                i = 1;
            }else i=2;
        }else{
            if(dau_sach_dao.getdausach_dao().sua(ma, ten, NXB, TL, tacgia, vitri)){
                i = 3;
            }else i=4;
        }
        return i;
    }
    public boolean xoaDauSach(String ma){
        if(dau_sach_dao.getdausach_dao().kt_dau_sach(ma)==null){
            return false;
        }else
            if(dau_sach_dao.getdausach_dao().xoa(ma)){
                return true;
            }
         return false;
    }
    public List<dau_sach> timDauSach(String ma,String ten,String NXB,String TL,String tacgia,String vitri,String trangthai){
        List<dau_sach> dsList = dau_sach_dao.getdausach_dao().tim(ma, ten, NXB, TL, tacgia, vitri, trangthai);
        return dsList;
    }
    public dau_sach getdausach(String ma){
        return dau_sach_dao.getdausach_dao().kt_dau_sach(ma);
    }
    
}
