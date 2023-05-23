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
public class dau_sach_dao {
    private static final String bang="dau_sach";
    private static final String ma="ma_dau_sach";
    private static final String ten="ten_sach";
    private static final String nxb="ma_NXB";
    private static final String tl="ma_TL";
    private static final String tacgia="tac_gia";
    private static final String vitri="vi_tri";
    private static final String tt="trang_thai";
    private static final String sl="soluong";
    
    private static String them="INSERT INTO "+bang+ " VALUES( ? , ? , ? , ? , ? , ? , ? ) ";
    private static String sua="UPDATE "+bang+ " SET  "+ ten +" =  ?  ,"+nxb+" = ?  ,"+tl+" = ?  ,"+
            tacgia+" = ?  ,"+vitri+" = ?  where "+ ma +" = ? ";
    private static String xoa="DELETE FROM "+bang+" WHERE "+ma+" = ? ";
    //tìm kiếm cả số lượng sách của mỗi đầu sách 
    private static String tim="select * from [dbo].[Fn_danh_sach_dausach](? , ?, ?, ?, ?, ?, ?) order by "+sl;
    private static String kt_ma="select * from [dbo].[Fn_kt_ma_dau_sach]( ? )";
    
    private static dau_sach_dao dausach;
    public static dau_sach_dao getdausach_dao(){
        if(dausach==null){
            dausach=new dau_sach_dao();
        }
        return dausach;
    } 
    public boolean them(String ma,String ten,String NXB,String TL,String tacgia,String vitri,String trangthai){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement them = c.prepareStatement(dau_sach_dao.them);
            them.setString(1, ma);
            them.setString(2, ten);
            them.setString(3, NXB);
            them.setString(4, TL);
            them.setString(5, tacgia);
            them.setString(6, vitri);
            them.setString(7, trangthai);
            if(them.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean sua(String ma,String ten,String NXB,String TL,String tacgia,String vitri){
        try {
            Connection c =DB_conn.getDBconn().getconn();
            PreparedStatement sua = c.prepareStatement(dau_sach_dao.sua);
            sua.setString(1, ten);
            sua.setString(2, NXB);
            sua.setString(3, TL);
            sua.setString(4, tacgia);
            sua.setString(5, vitri);
            sua.setString(6, ma);
            if(sua.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean xoa(String ma){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement xoa = c.prepareStatement(dau_sach_dao.xoa);
            xoa.setString(1, ma);
            if(xoa.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<dau_sach> tim(String ma,String ten,String NXB,String TL,String tacgia,String vitri,String trangthai){
        List<dau_sach> ds=new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement tim = c.prepareStatement(dau_sach_dao.tim);
            tim.setString(1, "%"+ma+"%");
            tim.setString(2, "%"+ten+"%");
            tim.setString(3, "%"+tacgia+"%");
            tim.setString(4, "%"+vitri+"%");
            tim.setString(5, "%"+trangthai+"%");
            tim.setString(6, TL );
            tim.setString(7, NXB );
            ResultSet rs = tim.executeQuery();
            while(rs.next()){
                ds.add(cre_dau_sach(rs));
            }
            return ds;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static dau_sach cre_dau_sach(ResultSet rs) throws SQLException{
        return new dau_sach(rs.getString(ma), rs.getString(ten), rs.getString(nxb), rs.getString(tl),
                rs.getString(tacgia), rs.getString(vitri), rs.getString(tt), rs.getInt(sl));
    }
    public dau_sach kt_dau_sach(String ma){
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kt_ma);
            kt.setString(1, ma);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_dau_sach(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
