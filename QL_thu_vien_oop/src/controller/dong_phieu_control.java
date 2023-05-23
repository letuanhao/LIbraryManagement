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
public class dong_phieu_control {
    
    private DefaultTableModel tblmodel;
    private static dong_phieu_control dongpmcon;
    
    public void load_list_tblmuon(JTable tbl,List<dong_phieu> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                dong_phieu dp = ds.get(i);
                sach s= sach_dao.getsach_dao().kt_ma_sach(dp.getMaSach());
                dau_sach s1 = dau_sach_dao.getdausach_dao().kt_dau_sach(s.getMa_dau_sach());
                tblmodel.addRow(new Object[]{dp.getMaPM(),dp.getMaSach(),s1.getTen_dau_sach(),dp.getTiencoc(),dp.getGiachomuon()});
            }
        }
    }
    
    public void load_list_tblmuonmni(JTable tbl,List<dong_phieu> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                dong_phieu dp = ds.get(i);
                sach s= sach_dao.getsach_dao().kt_ma_sach(dp.getMaSach());
                dau_sach s1 = dau_sach_dao.getdausach_dao().kt_dau_sach(s.getMa_dau_sach());
                tblmodel.addRow(new Object[]{dp.getMaSach(),s1.getTen_dau_sach(),dp.getTiencoc(),dp.getGiachomuon()});
            }
        }
    }
    public int lapphieumuon(phieu_muon pm , List<dong_phieu> ds){
        int kt=  phieu_muon_control.getpm_con().them(pm.getMa_PM(), pm.getMa_doc_gia(), pm.getNgay_muon(), pm.getNgay_tra(), pm.getTrang_thai());
        if(kt==1){
            int count =0 ;
            for(int i =0;i<ds.size();i++){
                if(dong_phieu_dao.getttpm_dao().them(ds.get(i).getMaPM(), ds.get(i).getMaSach(), ds.get(i).getGiachomuon(), 
                        ds.get(i).getTiencoc(), ds.get(i).getTienphat(), ds.get(i).getDathanhtoan(), ds.get(i).getDatra())){
                    count++;
                }
            }
            return count;
        }else{
            return 0;
        }
    }
    public void load_list_tbltra(JTable tbl , List<dong_phieu> ds){
        tblmodel = (DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                dong_phieu dp = ds.get(i);
                sach s= sach_dao.getsach_dao().kt_ma_sach(dp.getMaSach());
                dau_sach s1 = dau_sach_dao.getdausach_dao().kt_dau_sach(s.getMa_dau_sach());
                String trangthai;
                if(dp.getDatra()==0&&dp.getDathanhtoan()==0){
                    if(s.getTinh_trang().compareTo("Đã mất")==0){
                        trangthai ="Mất sách";
                    }else{
                        trangthai ="Đang mượn";
                    }
                }else if(dp.getDatra()==1&&dp.getDathanhtoan()==0){
                    trangthai ="Đã trả";
                }else if(dp.getDatra()==1&&dp.getDathanhtoan()==1){
                    trangthai ="Đã thanh toán";
                }else{
                    trangthai ="Đã thanh toán sách";
                }
                tblmodel.addRow(new Object[]{dp.getMaSach(),s1.getTen_dau_sach(),dp.getTiencoc(),dp.getGiachomuon(),
                    dp.getNgaytra(),dp.getTienphat(),trangthai });
            }
        }
    }
    
    //1 ma phieu hoac ma sach ko ton tai
    //2 them thanh cong
    //3 loi khi them
    //4 dong phieu da ton tai
    public int them(String mapm,String masach,float giamuon,float tiencoc){
        int i=0;
        if(phieu_muon_dao.getPM_dao().kt_mapm(mapm)==null){
            i=1;
        }else{
            if(dong_phieu_dao.getttpm_dao().kt_dong_phieu(mapm, masach)==null){
                if(dong_phieu_dao.getttpm_dao().them(mapm, masach, giamuon, tiencoc, 0, 0, 0)){
                    i=2;
                }else{
                    i=3;
                }
                
            }else{
                i=4;
            }
        }
        
        return i;
    }
    
    //1 ma phieu hoac ma sach ko ton tai
    //2 them thanh cong
    //3 co loi khi them
    //4 luu thanh cong
    //5 luu khong thanh cong
    public int luu_muon(String mapm,String masach,float giamuon,float tiencoc){
        int i=0;
        if(phieu_muon_dao.getPM_dao().kt_mapm(mapm)==null){
            i=1;
        }else{
            if(dong_phieu_dao.getttpm_dao().kt_dong_phieu(mapm, masach)==null){
                if(dong_phieu_dao.getttpm_dao().them(mapm, masach, giamuon, tiencoc, 0, 0, 0)){
                    i=2;
                }else{
                    i=3;
                }
                
            }else{
                if(dong_phieu_dao.getttpm_dao().sua_muon(mapm, masach, tiencoc, giamuon)){
                    i=4;
                }else{
                    i=5;
                }
            }
        }
        return i;
    }
    
    public boolean xoa_dp(String mapm,String masach){
         if(dong_phieu_dao.getttpm_dao().kt_dong_phieu(mapm, masach)!=null){
             if(dong_phieu_dao.getttpm_dao().xoa(mapm, masach)){
                 return true;
             }else{
                 return false;
             }
         }else{
             return false;
         }
     }
    
    public List<dong_phieu> tim_dp(String ma){
        return dong_phieu_dao.getttpm_dao().tim(ma);
    }
    
    //1 dong phieu ko ton tai
    //2 luu thanh cong
    //3 luu ko thanh cong
    public int tra_sach(String mapm , String masach , float phat ,Date ngaytra , int datra , String ghichu){
        int i=0;
        if(dong_phieu_dao.getttpm_dao().kt_dong_phieu(mapm, masach)==null){
            i=1;
        }else{
            if(dong_phieu_dao.getttpm_dao().sua_tra(mapm, masach, phat, ngaytra, datra, ghichu)){
                i=2;
            }else{
                i=3;
            }
        }
        return i;
    }
    
    public void thanh_toan(List<dong_phieu> ds,int dathanhtoan){
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++) {
                if(dong_phieu_dao.getttpm_dao().kt_dong_phieu(ds.get(i).getMaPM(), ds.get(i).getMaSach())==null){
                    
                }else{
                    sach s= sach_dao.getsach_dao().kt_ma_sach(ds.get(i).getMaSach());
                    if(ds.get(i).getDatra()==1){
                        dong_phieu_dao.getttpm_dao().sua_tt(ds.get(i).getMaPM(),ds.get(i).getMaSach(), dathanhtoan);
                    }
                    
                    if(s.getTinh_trang().compareTo("Đã mất")==0&&ds.get(i).getDatra()==0){
                        dong_phieu_dao.getttpm_dao().sua_tt(ds.get(i).getMaPM(),ds.get(i).getMaSach(), dathanhtoan);
                    }
                }
            }
        }
    }
    
    public void matsach(String mapm , String masach , float phat ,Date ngaytra , int datra , String ghichu,int datt){
        
        sach_dao.getsach_dao().sua_tt(masach, "Đã mất");
        dong_phieu_dao.getttpm_dao().sua_tra(mapm, masach, phat, ngaytra, datra, ghichu);
        dong_phieu_dao.getttpm_dao().sua_tt(mapm, masach, datt);
    }
    //1 la tong tien coc;
    //2 la tong tien muon
    //3 la tong tien phat
    //4 la tong tien muon da dong
    //5 la tong tien phat da dong
    public float tongtien(String ma,int kt){
        
        if(kt==1){
            return dong_phieu_dao.getttpm_dao().tong_coc(ma);
        }else if(kt==2){
            return dong_phieu_dao.getttpm_dao().tong_muon(ma);
        }else if(kt==3){
            return dong_phieu_dao.getttpm_dao().tong_phat(ma);
        }else if(kt==4){
            return dong_phieu_dao.getttpm_dao().tong_muon_dd(ma);
        }else{
            return dong_phieu_dao.getttpm_dao().tong_phat_dd(ma);
        }
    }
    
    public boolean huytt(dong_phieu dp){
        if(dong_phieu_dao.getttpm_dao().sua_tt(dp.getMaPM(), dp.getMaSach(), 0)&&
                dong_phieu_dao.getttpm_dao().sua_tra(dp.getMaPM(), dp.getMaSach(), dp.getTienphat(), dp.getNgaytra(), 0, dp.getGhichu())
                ){
            return true;
        }
        return false;
    }
    
    public int tratoanbo(List<dong_phieu> ds,Date ngaytra){
        int sosach =0;
        for(int i=0;i<ds.size();i++){
            if(dong_phieu_dao.getttpm_dao().sua_tra(ds.get(i).getMaPM(), ds.get(i).getMaSach(), 0, ngaytra, 1, "")){
                sosach++;
            }
        }
        return sosach;
    }
    
    public static dong_phieu_control get_dpcon(){
        if (dongpmcon==null) {
            dongpmcon = new dong_phieu_control();
        }
        return dongpmcon;
    }
    
    
}
