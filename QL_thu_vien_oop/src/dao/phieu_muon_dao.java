/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.*;
import ket_noi_db.*;
/**
 *
 * @author minh0
 */
public class phieu_muon_dao {
    private static final String bang="phieu_muon";
    private static final String ma="ma_PM";
    private static final String doc_gia="ma_doc_gia";
    private static final String ngaymuon="ngay_muon";
    private static final String ngaytra="ngay_tra";
    private static final String tt="trang_thai";
    
    private static String them=" INSERT INTO "+bang+" VALUES ( ? , ? , ? , ? , ? )";
    private static String sua=" UPDATE "+bang+" SET "+ngaymuon+" = ?  , "+ngaytra+" = ?  WHERE "+ma+" = ? ";
    private static String xoa=" DELETE FROM "+bang+" WHERE "+ma+" = ? ";
    
    //tim kiếm phiếu mượn theo ngày mượn
    private static String tim_nm = "SELECT * FROM [dbo].[Fn_tim_kiem_pm_nm] ( ? , ? , ? , ? , ? ) ";
    //tìm kiếm phiếu mượn theo ngày trả
    private static String tim_nt = " SELECT * FROM [dbo].[Fn_tim_kiem_pm_nt] ( ? , ? , ? , ? , ? ) ";
    
    //tim kiem phieu muon
    private static String timpm=" SELECT * FROM "+bang+" WHERE "+ma+" LIKE ? OR "+doc_gia+" LIKE ? ";
    //kiem tra ma phieu muon
    private static String kt_ma=" SELECT * FROM "+bang+" WHERE "+ma +" = ? ";
    
    private static String timpm_dg="SELECT * FROM [dbo].[Fn_lich_su_muon]( ? )";
    
    private static String suach=" update phieu_muon set trang_thai = N'Còn hạn' where ngay_tra > GETDATE() and trang_thai not like N'Đã trả hết' or DATEDIFF(DAY,ngay_tra,getDate()) = 0 and trang_thai not like N'Đã trả hết' " ;
    private static String suaqh=" UPDATE phieu_muon SET trang_thai = N'Quá hạn'  WHERE ngay_tra < GETDATE() AND trang_thai not like N'Đã trả hết' ";
    private static phieu_muon_dao pmdao;
    
    public static  phieu_muon_dao getPM_dao(){
        if(pmdao==null){
            pmdao = new phieu_muon_dao();
        }
        return pmdao;
    }    
    public boolean them(String mapm , String madocgia , Date ngaymuon , Date ngaytra , String trangthai ){
        java.sql.Date ngaymuon1 = new java.sql.Date(ngaymuon.getTime());
        java.sql.Date ngaytra1 = new java.sql.Date(ngaytra.getTime());
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement add = c.prepareStatement(them);
            add.setString(1, mapm);
            add.setString(2,madocgia);
            add.setDate(3, (java.sql.Date) ngaymuon1);
            add.setDate(4, (java.sql.Date) ngaytra1);
            add.setString(5,trangthai);
            if(add.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean sua(String mapm,Date ngaymuon,Date ngaytra){
        java.sql.Date ngaymuon1 = new java.sql.Date(ngaymuon.getTime());
        java.sql.Date ngaytra1 = new java.sql.Date(ngaytra.getTime());
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement fix = c.prepareStatement(sua);
            fix.setDate(1, (java.sql.Date) ngaymuon1);
            fix.setDate(2, (java.sql.Date) ngaytra1);
            fix.setString(3,mapm);
            if(fix.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(String ma){
        try {
            Connection c =DB_conn.getDBconn().getconn();
            PreparedStatement delete = c.prepareStatement(xoa);
            delete.setString(1, ma);
            if(delete.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private static phieu_muon cre_pm(ResultSet rs) throws SQLException{
        return new phieu_muon(rs.getString(ma), rs.getString(doc_gia), rs.getDate(ngaymuon), rs.getDate(ngaytra), rs.getString(tt));
    }
    
    private static model.listpm cre_listpm(ResultSet rs) throws SQLException{
        return new model.listpm(rs.getString(ma), rs.getDate(ngaymuon), rs.getDate(ngaytra),rs.getString(tt), rs.getInt("soluong"));
    }
    public List<phieu_muon> tim_pm(String bien){
        List<phieu_muon> ds = new ArrayList<>();    
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement search = c.prepareStatement(timpm);
            search.setString(1,"%"+bien+"%");
            search.setString(2,"%"+bien+"%");
            ResultSet rs = search.executeQuery();
            while(rs.next()){
                ds.add(cre_pm(rs));
            }
            return ds;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public phieu_muon kt_mapm(String ma){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kt_ma);
            kt.setString(1, ma);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_pm(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<phieu_muon> tim_pm_nm(String madg , String mapm , String trangthai , Date ngaybd , Date ngaykt ){
        java.sql.Date ngaybd1 = new java.sql.Date(ngaybd.getTime());
        java.sql.Date ngaykt1 = new java.sql.Date(ngaykt.getTime());
        List<phieu_muon> ds = new ArrayList<>();
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement tim = c.prepareStatement(tim_nm);
            tim.setString(1,"%"+madg+"%");
            tim.setString(2,"%"+mapm+"%");
            tim.setString(3,"%"+trangthai+"%");
            tim.setDate(4, ngaybd1);
            tim.setDate(5, ngaykt1);
            ResultSet rs = tim.executeQuery();
            while(rs.next()){
                ds.add(cre_pm(rs));
            }
            return ds;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public List<phieu_muon> tim_pm_nt(String madg , String mapm,String trangthai , Date ngaybd , Date ngaykt){
        java.sql.Date ngaybd1 = new java.sql.Date(ngaybd.getTime());
        java.sql.Date ngaykt1 = new java.sql.Date(ngaykt.getTime());
        List<phieu_muon> ds = new ArrayList<>();
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement tim = c.prepareStatement(tim_nt);
            tim.setString(1,"%"+madg+"%");
            tim.setString(2,"%"+mapm+"%");
            tim.setString(3,"%"+trangthai+"%");
            tim.setDate(4, ngaybd1);
            tim.setDate(5, ngaykt1);
            ResultSet rs = tim.executeQuery();
            while(rs.next()){
                ds.add(cre_pm(rs));
            }
            return ds;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public List<model.listpm> timpm_dg(String madg){
        List<model.listpm> ds = new ArrayList<>();
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement tim = c.prepareStatement(timpm_dg);
            tim.setString(1, madg);
            ResultSet rs = tim.executeQuery();
            while(rs.next()){
                ds.add(cre_listpm(rs));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean suattpm(){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            Statement sua1 = c.createStatement();
            int s2 = sua1.executeUpdate(suaqh);
            int s1 = sua1.executeUpdate(suach);
            
            if(s1>0||s2>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
        boolean t = getPM_dao().suattpm();
        System.out.println(t);
        
    }
}
