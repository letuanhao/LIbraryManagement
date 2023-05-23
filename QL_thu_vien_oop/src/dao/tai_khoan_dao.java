/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
import ket_noi_db.DB_conn;
import model.tai_khoan;
import java.util.*;
import model.tai_khoan_model;
/**
 *
 * @author minh0
 */
public class tai_khoan_dao {
    protected static final String bang="tai_khoan";
    
    protected static final String id="ID";
    protected static final String ten="ten_dang_nhap";
    protected static final String tk="tai_khoan";
    protected static final String mk="mat_khau";
    protected static final String chucvu="chuc_vu";
    protected static final String quyen="quyen_truy_cap";
    
    private static String themtk=" INSERT INTO tai_khoan (ten_dang_nhap,tai_khoan,mat_khau,chuc_vu,quyen_truy_cap) VALUES( ? , ? , ? , ? , ? )";
    private static String suatk="UPDATE "+bang+" SET "+mk+" = ? WHERE "+id+" = ? ";
    private static String sua="UPDATE "+bang+" SET "+mk+" = ? , "+chucvu+" = ? , "+quyen+" = ? WHERE "+ten+" = ? ";
    private static String xoatk="DELETE FROM "+bang+" WHERE "+id+" = ? ";
    private static String timtk=" SELECT * FROM "+bang+" WHERE "+tk+" = ? AND "+mk+" = ? ";
    private static String dstk=" SELECT * FROM "+bang+" order by "+id;
    private static String kttk=" SELECT * FROM "+bang+" WHERE "+tk+" like ? ";
    private static String kttdn=" SELECT * FROM "+bang+" WHERE "+ten+" like ? ";
    private static String kttt=" SELECT * FROM "+bang+" WHERE "+ten+" like ? and "+tk+" like ? ";
    private static tai_khoan_dao tkdao;
    public static tai_khoan_dao gettk_dao(){
        if(tkdao==null){
            tkdao = new tai_khoan_dao();
        }
        return tkdao;
    }
    
    private static tai_khoan_model cre_tk(ResultSet rs) throws SQLException{
        return new tai_khoan_model(rs.getInt(id), rs.getString(ten), rs.getString(tk), rs.getString(mk), rs.getString(chucvu), rs.getInt(quyen));
    }
    
    public void dangnhap(String taikhoan , String matkhau){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement dn = c.prepareStatement(timtk);
            dn.setString(1, taikhoan);
            dn.setString(2, matkhau);
            ResultSet rs = dn.executeQuery();
            if(rs.next()){
                tai_khoan.setId(rs.getInt(id));
                tai_khoan.setTendangnhap(rs.getString(ten));
                tai_khoan.setTaikhoan(rs.getString(tk));
                tai_khoan.setMatkhau(rs.getString(mk));
                tai_khoan.setChucvu(rs.getString(chucvu));
                tai_khoan.setQuyen(rs.getInt(quyen));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public tai_khoan_model doiMK(String taikhoan,String matkhau){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement dn = c.prepareStatement(timtk);
            dn.setString(1, taikhoan);
            dn.setString(2, matkhau);
            ResultSet rs = dn.executeQuery();
            if(rs.next()){
                return cre_tk(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean them(String tenDN,String taikhoan,String matkhau,String chucvu,int quyen){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement add = c.prepareStatement(themtk);
            add.setString(1, tenDN);
            add.setString(2, taikhoan);
            add.setString(3, matkhau);
            add.setString(4, chucvu);
            add.setInt(5, quyen);
            if(add.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean sua(int id ,String mkmoi){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement fix = c.prepareStatement(suatk);
            fix.setInt(2, id);
            fix.setString(1, mkmoi);
            if(fix.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suatt(String matkhau,String chucvu,int quyentc,String tenDN){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement sua = c.prepareStatement(tai_khoan_dao.sua);
            sua.setString(1, matkhau);
            sua.setString(2, chucvu);
            sua.setInt(3, quyentc);
            sua.setString(4, tenDN);
            if(sua.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(int id){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement delete = c.prepareStatement(xoatk);
            delete.setInt(1, id);
            if(delete.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public List<tai_khoan_model> taikhoanList(){
        List<tai_khoan_model> ds = new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn();
            Statement getall = c.createStatement();
            ResultSet rs = getall.executeQuery(dstk);
            while(rs.next()){
                ds.add(cre_tk(rs));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public tai_khoan_model kt_tai_khoan(String taikhoan){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kttk);
            kt.setString(1, taikhoan);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_tk(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public tai_khoan_model kt_ten_dn(String tendn){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kttdn);
            kt.setString(1, tendn);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_tk(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    
    public tai_khoan_model kt_ten_tk(String taikhoan,String tendn){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kttt);
            kt.setString(1, tendn);
            kt.setString(2, taikhoan);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_tk(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    
    public static void main(String[] args) {
        gettk_dao().dangnhap("admin", "admin");
        tai_khoan_model tk1 = gettk_dao().kt_tai_khoan("admin");
        tai_khoan_model tk2 = gettk_dao().kt_ten_dn("minh");
        tai_khoan_model tk3 = gettk_dao().kt_ten_tk("admin", "minh");
        System.out.print(tk1.getId()+"|"+tk2.getId()+"|"+tk3.getId());
    }
}
