/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;
import ket_noi_db.*;
/**
 *
 * @author minh0
 */
public class dong_phieu_dao {
    private static final String bang="tt_PM";
    private static final String mapm="ma_PM";
    private static final String masach="ma_sach";
    private static final String coc="tien_coc";
    private static final String phat="tien_phat";
    private static final String giamuon="gia_cho_muon";
    private static final String ngaytra="ngay_tra_sach";
    private static final String datra="da_tra_sach";
    private static final String datt="da_thanh_toan";
    private static final String ghichu="ghi_chu";
    
    private static String them="INSERT INTO tt_PM ( ma_PM , ma_sach , gia_cho_muon , tien_coc , tien_phat , da_thanh_toan , da_tra_sach) "
            + " VALUES ( ? , ? , ? , ? , ? , ? , ?  ) ";
    private static String sua_muon=" UPDATE "+bang+" SET "+coc+" = ? , "+giamuon+" = ? WHERE "+mapm+" = ? AND "+masach+" = ? ";//update lai thong tin luc muon
    private static String sua_tra=" UPDATE "+bang+" SET "+phat+" = ? , "+ngaytra+" = ? , "+datra+" = ? , "
            +ghichu+" = ? WHERE "+mapm+" = ? AND "+masach+" = ? ";//update tt luc tra
    private static String thanhtoan=" UPDATE "+bang+" SET "+datt+" = ? WHERE "+mapm+" = ? AND "+masach+" = ? ";//update tt luc thanh toan
    private static String ttsachmat="";
    private static String xoa=" DELETE FROM "+bang+" WHERE "+mapm+" = ? AND "+masach+" = ? ";
    private static String xoaall = " DELETE FROM "+bang+" WHERE "+mapm+" = ? ";
    private static String tim =" SELECT * FROM "+bang+" WHERE "+mapm+" = ? ";
    private static String kt_dong_phieu ="SELECT * FROM "+bang+" WHERE "+mapm+" = ? AND "+masach+" = ? ";
    
//tinh tong cac loai tien
    private static String tongcoc =" SELECT [dbo].[Fn_tong_tien_coc] ( ? ) as tongtiencoc ";
    private static String tongmuon=" SELECT [dbo].[Fn_tong_tien_muon] ( ? ) as tongtienmuon ";
    private static String tongmuondd=" SELECT [dbo].[Fn_tong_tien_muon_dd] ( ? ) as tongtienmuondd ";
    private static String tongphat=" SELECT [dbo].[Fn_tong_tien_phat] ( ? ) as tongtienphat ";
    private static String tongphatdd=" SELECT [dbo].[Fn_tong_tien_phat_dd] ( ? ) as tongtienphatdd";
    
    private static dong_phieu_dao dongpm;
    
    public static dong_phieu_dao getttpm_dao(){
        if(dongpm==null){
            dongpm = new dong_phieu_dao();
        }
        return dongpm;
    }
    
    public boolean them(String mapm,String masach,float giamuon,float tiencoc,float tienphat,int datt,int datra){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement add = c.prepareStatement(them);
            add.setString(1, mapm);
            add.setString(2, masach);
            add.setFloat(3, giamuon);
            add.setFloat(4, tiencoc);
            add.setFloat(5, tienphat);
            add.setInt(6, datt);
            add.setInt(7, datra);
            if(add.executeUpdate()>0)
            {
                return true;
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(String mapm,String masach){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement delete = c.prepareStatement(xoa);
            delete.setString(1, mapm);
            delete.setString(2, masach);
            if(delete.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean sua_muon(String mapm,String masach,float coc,float giamuon){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement fix = c.prepareStatement(sua_muon);
            fix.setFloat(1, coc);
            fix.setFloat(2, giamuon);
            fix.setString(3, mapm);
            fix.setString(4, masach);
            if(fix.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean sua_tra(String mapm , String masach , float phat ,Date ngaytra , int datra , String ghichu){
        java.sql.Date ngaytra1 = new java.sql.Date(ngaytra.getTime());
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement fix = c.prepareStatement(sua_tra);
            fix.setFloat(1, phat);
            fix.setDate(2, (java.sql.Date) ngaytra1);
            fix.setInt(3, datra);
            fix.setString(4, ghichu);
            fix.setString(5,mapm);
            fix.setString(6,masach);
            if(fix.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean sua_tt(String mapm,String masach,int datt){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement fix = c.prepareStatement(thanhtoan);
            fix.setInt(1, datt);
            fix.setString(2, mapm);
            fix.setString(3, masach);
            if(fix.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private static dong_phieu cre_dong_pm(ResultSet rs) throws SQLException{
        return new dong_phieu(rs.getString(mapm), rs.getString(masach), rs.getFloat(coc), rs.getFloat(phat), 
                rs.getFloat(giamuon), rs.getDate(ngaytra), rs.getInt(datra), rs.getInt(datt), rs.getString(ghichu));
    }
    
    public List<dong_phieu> tim(String ma){
        List<dong_phieu> ds = new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement search = c.prepareStatement(tim);
            search.setString(1, ma);
            ResultSet rs = search.executeQuery();
            while (rs.next()) {                
                ds.add(cre_dong_pm(rs));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public dong_phieu kt_dong_phieu(String mapm,String masach){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kt_dong_phieu);
            kt.setString(1, mapm);
            kt.setString(2, masach);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_dong_pm(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean xoa_all(String ma){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement xoa = c.prepareStatement(xoaall);
            xoa.setString(1, ma);
            if(xoa.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public float tong_coc(String mapm){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement tong = c.prepareStatement(tongcoc);
            tong.setString(1, mapm);
            ResultSet rs = tong.executeQuery();
            if (rs.next()) {
                return rs.getFloat("tongtiencoc");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public float tong_phat(String mapm){
        
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement tong = c.prepareStatement(tongphat);
            tong.setString(1, mapm);
            ResultSet rs = tong.executeQuery();
            if (rs.next()) {
                return rs.getFloat("tongtienphat");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public float tong_muon(String mapm){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement tong = c.prepareStatement(tongmuon);
            tong.setString(1, mapm);
            ResultSet rs = tong.executeQuery();
            if (rs.next()) {
                return rs.getFloat("tongtienmuon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public float tong_muon_dd(String ma){
        
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement tong = c.prepareStatement(tongmuondd);
            tong.setString(1, ma);
            ResultSet rs = tong.executeQuery();
            if (rs.next()) {
                return rs.getFloat("tongtienmuondd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public float tong_phat_dd(String mapm){
        
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement tong = c.prepareStatement(tongphatdd);
            tong.setString(1, mapm);
            ResultSet rs = tong.executeQuery();
            if (rs.next()) {
                return rs.getFloat("tongtienphatdd");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        //getttpm_dao().them("PM00001", "S001SLOVE13", 50000, 5000, 0, 0, 0);
        System.out.println(getttpm_dao().tong_coc("PM00001"));
        System.out.println(getttpm_dao().tong_muon("PM00001"));
        System.out.println(getttpm_dao().tong_muon_dd("PM00001"));
        System.out.println(getttpm_dao().tong_phat("PM00001"));
        System.out.println(getttpm_dao().tong_phat_dd("PM00001"));
    }
}
