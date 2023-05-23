/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.*;
import java.sql.*;
import model.*;
import ket_noi_db.*;
/**
 *
 * @author minh0
 */
public class sach_dao {
    private static final String bang="sach";
    private static final String ma="ma_sach";
    private static final String dausach="ma_dau_sach";
    private static final String soISBN="ISBN";
    private static final String namXB="nam_xuat_ban";
    private static final String tt="tinh_trang";
    private static final String gia="Gia_tien_sach";
    
    private static String them="INSERT INTO "+bang +" VALUES ( ? , ? , ? , ? , ? , ? )";
    private static String sua="UPDATE "+bang+" SET "+dausach+" = ?  ,"+soISBN+" = ? ,"+namXB+
            " = ? , "+gia+" = ? ,"+tt+" = ? WHERE "+ma+" = ? ";
    private static String xoa= " DELETE FROM "+bang+" WHERE "+ma+" = ? ";
    private static String tim=" SELECT * FROM "+bang+" WHERE "+dausach+" like ? or "+ma+" like  ? or "+soISBN+" like  ? " ;
    private static String kt_ma=" SELECT * FROM "+bang+" WHERE "+ma+" = ? ";
    private static String kt_isbn=" SELECT * FROM "+bang+" WHERE "+soISBN+" = ? ";
    private static String kt_all=" SELECT * FROM "+bang+" WHERE "+ma+" = ? AND "+soISBN+" = ? ";
    private static String suatt=" UPDATE "+bang+" SET "+tt+" = ? WHERE "+ma+" = ? ";
    private static String timds=" SELECT * FROM "+bang+" WHERE "+dausach+" = ? ";
    private static String maxs = " SELECT [dbo].[Fn_ma_sach_max]( ? ) as maxsach ";
    
    private static String timsach =" SELECT * FROM [dbo].[Fn_tim_kiem_sach]( ? ) ";
    private static String sosach =" select * from [dbo].[Fn_so_luong_tt_sach] ( ? ) ";
    
    private static sach_dao sachdao;
    public static sach_dao getsach_dao(){
        if(sachdao==null){
            sachdao=new sach_dao();
        }
        return sachdao;
    }
    //
    public boolean them(String ma,String mads,String ISBN,String namxb,String tinhtrang,float giatien){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement add = c.prepareStatement(them);
            add.setString(1, ma);
            add.setString(2, mads);
            add.setString(3, ISBN);
            add.setString(4, namxb);
            add.setString(5, tinhtrang);
            add.setFloat (6, giatien);
            if(add.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //
    public boolean sua(String ma,String mads,String ISBN,String namxb,String tinhtrang,float giatien){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement fix = c.prepareStatement(sua);
            fix.setString(1, mads);
            fix.setString(2, ISBN);
            fix.setString(3, namxb);
            fix.setFloat(4, giatien);
            fix.setString(5, tinhtrang);
            fix.setString(6, ma);
            
            if(fix.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //
    public boolean xoa(String ma){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement delete =c.prepareStatement(xoa);
            delete.setString(1, ma);
            if(delete.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //
    public List<sach> tim(String bien){
        List<sach> ds = new ArrayList<>();
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement find =c.prepareStatement(tim);
            find.setString(1, "%"+bien+"%");
            find.setString(2, "%"+bien+"%");
            find.setString(3, "%"+bien+"%");
            ResultSet rs = find.executeQuery();
            while(rs.next()){
                ds.add(cre_sach(rs));
            }
            return ds;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static sach cre_sach(ResultSet rs) throws SQLException{
        return new sach(rs.getString(ma), rs.getString(dausach), rs.getString(soISBN), rs.getString(namXB), rs.getString(tt),rs.getFloat(gia));
    }
    public sach kt_ma_sach(String ma){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement check = c.prepareStatement(kt_ma);
            check.setString(1, ma);
            ResultSet rs = check.executeQuery();
            if(rs.next()){
                return cre_sach(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public sach kt_ISBN(String isbn){
        try {
            Connection c =DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kt_isbn);
            kt.setString(1, isbn);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_sach(rs);
            }
        } catch (Exception e) {
        }
        return null;
    }
    public sach kt_all(String ma,String isbn){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kt_all);
            kt.setString(1, ma);
            kt.setString(2, isbn);
            ResultSet rs= kt.executeQuery();
            if(rs.next()){
                return cre_sach(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean sua_tt(String ma,String trangthai){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement sua = c.prepareStatement(suatt);
            sua.setString(1, trangthai);
            sua.setString(2, ma);
            if(sua.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int sachmax(String madausach){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement max = c.prepareStatement(maxs);
            max.setString(1, madausach);
            ResultSet rs = max.executeQuery();
            if(rs.next()){
                return rs.getInt("maxsach");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public List<sach> dausach_sach(String maDauSach){
        List<sach> ds = new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement tim = c.prepareStatement(timds);
            tim.setString(1, maDauSach);
            ResultSet rs = tim.executeQuery();
            while (rs.next()) {                
                ds.add(cre_sach(rs));
            }
            return ds;
        } catch (SQLException e) {
        }
        return null;
    }
    
    public List<sach> timsachmn(String bien){
        List<sach> ds = new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement tim = c.prepareStatement(timsach);
            tim.setString(1, "%" + bien + "%");
            ResultSet rs = tim.executeQuery();
            while (rs.next()) {
                ds.add(cre_sach(rs));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Integer> ttsoluong(String ma){
        List<Integer> ds = new ArrayList<>();
        try {
            Connection c=  DB_conn.getDBconn().getconn();
            PreparedStatement tt = c.prepareStatement(sosach);
            tt.setString(1, ma);
            ResultSet rs = tt.executeQuery();
            if(rs.next()){
                ds.add(rs.getInt("soctmuon"));
                ds.add(rs.getInt("sodangmuon"));
                ds.add(rs.getInt("sodamat"));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        
        getsach_dao().sua_tt("DEF12346", "Đã mất");
    }
}
