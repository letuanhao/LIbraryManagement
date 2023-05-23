/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.tai_khoan_dao;
import java.util.List;
import javax.swing.*;
import model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author minh0
 */
public class tai_khoan_control {
    private DefaultTableModel tblmodel;
    public void load_cb_chucvu(JComboBox cb){
        cb.removeAllItems();
        cb.addItem("");
        cb.addItem("admin");
        cb.addItem("Thủ thư");
    }
    
    public void load_list_tbl(JTable tbl ,List<tai_khoan_model> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for (int i = 0; i < ds.size(); i++) {
                tblmodel.addRow(new Object[]{ds.get(i).getTendangnhap() , ds.get(i).getTaikhoan() , ds.get(i).getChucvu()});
            }
        }
        tbl.setRowHeight(20);
    }
    
    public int themTK(String tenDN,String taikhoan,String matkhau,String chucvu,int quyen){
        int i=0;
        if(tai_khoan_dao.gettk_dao().kt_tai_khoan(taikhoan)==null&&tai_khoan_dao.gettk_dao().kt_ten_dn(tenDN)==null){
            if(tai_khoan_dao.gettk_dao().them(tenDN, taikhoan, matkhau, chucvu, quyen)){
                i=1;
            }else{
                i=2;
            }
        }else if(tai_khoan_dao.gettk_dao().kt_tai_khoan(taikhoan)==null&&tai_khoan_dao.gettk_dao().kt_ten_dn(tenDN)!=null) {
            i=3;
        }else if(tai_khoan_dao.gettk_dao().kt_tai_khoan(taikhoan)!=null&&tai_khoan_dao.gettk_dao().kt_ten_dn(tenDN)==null){
            i=4;
        }
        return i;
    }
    
    public int luuTK(String tenDN,String taikhoan,String matkhau,String chucvu,int quyen){
        int i=0;
        if(tai_khoan_dao.gettk_dao().kt_tai_khoan(taikhoan)==null&&tai_khoan_dao.gettk_dao().kt_ten_dn(tenDN)==null){
            if(tai_khoan_dao.gettk_dao().them(tenDN, taikhoan, matkhau, chucvu, quyen)){
                i=1;
            }else{
                i=2;
            }
        }else if(tai_khoan_dao.gettk_dao().kt_tai_khoan(taikhoan)==null&&tai_khoan_dao.gettk_dao().kt_ten_dn(tenDN)!=null) {
            i=3;
        }else if(tai_khoan_dao.gettk_dao().kt_tai_khoan(taikhoan)!=null&&tai_khoan_dao.gettk_dao().kt_ten_dn(tenDN)==null){
            i=4;
        }else{
            if(tai_khoan_dao.gettk_dao().kt_ten_tk(taikhoan, tenDN)==null){
                i=5;
            }else{
                if(tai_khoan_dao.gettk_dao().suatt(matkhau, chucvu, quyen, tenDN)){
                    i=6;
                }else{
                    i=7;
                }
            }
        }
        return i;
    }
    public boolean xoaTK(int id){
        return tai_khoan_dao.gettk_dao().xoa(id);
    }
    
    private static tai_khoan_control tkcon;
    public static tai_khoan_control getTKcon(){
        if(tkcon==null){
            tkcon=new tai_khoan_control();
                    
        }
        return tkcon;
    }
}
