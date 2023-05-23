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
public class NXB_dao {
    private static final String bang="NXB";
    private static final String ma="ma_NXB";
    private static final String ten="ten_NXB";
    
    private static String them="INSERT INTO "+bang+" VALUES ( ? , ? )";
    private static String sua=" UPDATE "+bang+" SET "+ten+" = ? WHERE "+ma+" = ? ";
    private static String xoa="DELETE FROM "+bang+" WHERE "+ma+" = ? ";
    private static String getall="SELECT * FROM "+bang+" order by " +ma;
    private static String ktmanxb="SELECT * FROM "+bang+" WHERE "+ma+" = ? ";
    
    private static NXB_dao nxbdao;
    
    private static NXB cre_nxb(ResultSet rs) throws SQLException{
        return new NXB(rs.getString(ma), rs.getString(ten));
    }
    public List<NXB> ds_NXB(){
        List<NXB> ds=new ArrayList<>();
        try {
            Connection c= DB_conn.getDBconn().getconn();
            Statement nxb =c.createStatement();
            ResultSet rs = nxb.executeQuery(getall);
            while(rs.next()){
                ds.add(cre_nxb(rs));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static NXB_dao getNXB_dao(){
        if(nxbdao==null){
            nxbdao=new NXB_dao();
        }
        return nxbdao;
    }
    public NXB kt_NXB(String ma){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(ktmanxb);
            kt.setString(1, ma);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_nxb(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean them(String maNXB,String tenNXB){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement add = c.prepareStatement(them);
            add.setString(1, maNXB);
            add.setString(2, tenNXB);
            if(add.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean sua(String maNXB,String tenNXB){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement fix = c.prepareStatement(sua);
            fix.setString(1, tenNXB);
            fix.setString(2, maNXB);
            if(fix.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoa(String maNXB){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement delete  = c.prepareStatement(xoa);
            delete.setString(1, maNXB);
            if(delete.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
