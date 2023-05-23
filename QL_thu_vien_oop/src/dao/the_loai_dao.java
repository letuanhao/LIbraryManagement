/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import ket_noi_db.*;
import model.*;
import java.util.*;
import java.sql.*;
/**
 *
 * @author minh0
 */
public class the_loai_dao {
    static the_loai_dao TL_dao;
    //tên cột trong bảng the_loai
    //private static final String the_loai="the_loai";
    private static final String ma_TL="ma_TL";
    private static final String ten_TL="ten_TL";
    
    public static String them_TL="INSERT INTO the_loai VALUES( ? , ? )";
    public static String tim_kiem_TL="SELECT * FROM the_loai WHERE ma_TL LIKE ? AND Ten_TL LIKE ? order by "+ma_TL;
    public static String xoa_TL="DELETE FROM the_loai where ma_TL = ?";
    public static String kiem_tra_ma_TL="SELECT * FROM the_loai WHERE ma_TL=? ";
    public static  String kiem_tra_ten_TL="SELECT * FROM the_loai WHERE ten_TL=?";
    public static String luu_TL = "UPDATE the_loai SET ten_TL = ? WHERE  ma_TL= ? ";
    public static String ds_TL="SELECT * FROM the_loai order by "+ma_TL;
    //Dùng để thêm thông tin thể loại
    public boolean them(the_loai TL){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement them = c.prepareStatement(them_TL);
            them.setString(1, TL.getMa_TL());
            them.setString(2, TL.getTen_TL());
            if(them.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    //xóa thể loại
    public boolean xoa(the_loai TL){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement xoa = c.prepareStatement(xoa_TL);
            xoa.setString(1, TL.getMa_TL());
            if(xoa.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
        }
        return false;
    }
    //lưu chỉnh sửa
    public boolean luu(the_loai TL){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement luu = c.prepareStatement(luu_TL);
            luu.setString(1, TL.getTen_TL());
            luu.setString(2, TL.getMa_TL());
            if(luu.executeUpdate()>0){

                return true;
            }
        } catch (Exception e) {
        }
        return false;
        
    }
    //trả về danh sách thể loại vừa tìm đc
    /**public List<the_loai> ds_the_loai_tk(String ma,String ten){
        List<the_loai> ds = new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn(); 
            PreparedStatement tk = c.prepareStatement(tim_kiem_TL);
            tk.setString(1,"%" + ma.trim() + "%");
            tk.setString(2,"%" + ten.trim() + "%");
            ResultSet rs = tk.executeQuery();
             while(rs.next()){
                
                ds.add(cre_the_loai(rs));
                }
             tk.close();
             //c.close();
            return ds;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }*/
    //trả về lớp the_loai
    private the_loai cre_the_loai(ResultSet rs) throws SQLException{
        return new the_loai(rs.getString(1), rs.getString(2));
    }
    //kiểm tra xem có mã thể loại đó chưa
    public the_loai kt_ma_TL(String ma){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement ktma=c.prepareStatement(kiem_tra_ma_TL);
            ktma.setString(1, ma);
            ResultSet rs=ktma.executeQuery();
            if(rs.next()){
                return cre_the_loai(rs);
            }
        } 
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    //kiểm tra xem tên thể loại đã tồn tại chưa
    public boolean kt_ten_TL(String ten){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement ktma=c.prepareStatement(kiem_tra_ten_TL);
            ktma.setString(1, ten);
            ResultSet rs=ktma.executeQuery();
            if(rs.next()==true){
                ktma.close();
                //c.close();
                return true;
            }
        } 
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public List<the_loai> ds_the_loai(){
        List<the_loai> ds = new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn(); 
            Statement tk = c.createStatement();
            ResultSet rs = tk.executeQuery(ds_TL);
             while(rs.next()==true){
                ds.add(cre_the_loai(rs));
                }
            return ds;
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public static the_loai_dao get_TL_dao(){
        if(TL_dao==null){
            TL_dao =new the_loai_dao();
        }
        return TL_dao;
    }
    public static void main(String[] args) {
    }
}
