/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import ket_noi_db.*;
import java.util.List;
import java.util.Date;
/**
 *
 * @author minh0
 */
public class doc_gia_dao {
    
    private static doc_gia_dao dg_dao;
    
    private static final String dg="doc_gia";
    private static final String ma_dg="ma_doc_gia";
    private static final String ten_dg="ten_doc_gia";
    private static final String CCCD= "so_CCCD";
    private static final String gt_dg="gioi_tinh";
    private static final String ns_dg="ngay_sinh";
    private static final String dc_dg="dia_chi";
    private static final String SDT_dg="SDT";
    private static final String tt_dg="tinh_trang";
    
    private static String them_dg=" INSERT INTO doc_gia VALUES ( ? , ? , ? , ?  , ? , ? , ? , ? )";
    private static String sua_dg=" UPDATE "+dg+" SET "+ten_dg+" = ? ,"+CCCD+" = ? ,"+gt_dg+" = ? ,"
            +ns_dg+" = ? ,"+dc_dg+" = ? ,"+SDT_dg+" = ? ,"+tt_dg+" = ?  "+"WHERE "+ma_dg+" = ? ";
    private static String xoa_dg="DELETE FROM "+dg+"WHERE "+ma_dg+" = ? ";
    
    private static String tim_dg="SELECT * FROM "+dg+" WHERE "+ma_dg+" LIKE  ?  AND "+ten_dg+" LIKE  ?  AND "+
            CCCD+" LIKE  ?  AND "+gt_dg+" LIKE  ?  AND "+ns_dg+" LIKE  ?  AND "+dc_dg+" LIKE  ?  AND "+SDT_dg+" LIKE  ?  AND "+
            tt_dg+" LIKE  ?  ";
    private static String kt_ma_dg=" SELECT * FROM "+dg+" WHERE "+ma_dg+" = ? ";
    private static String kt_so_CCCD=" SELECT * FROM "+dg+" WHERE "+CCCD+" = ? ";
    private static String kt_dg =" SELECT * FROM "+dg+" WHERE "+ma_dg+" = ? AND "+CCCD+" = ? ";
    private static String timdgmn = " SELECT * FROM "+dg+" WHERE "+ma_dg+" LIKE ? OR "+CCCD+" LIKE ? ";
    
    private static doc_gia_dao docgiadao;
    public static doc_gia_dao getdocgia_dao(){
        if(docgiadao==null){
            docgiadao=new doc_gia_dao();
        }
        return docgiadao;
    }
    //Thêm thông tin độc giả
    public boolean them_dg(doc_gia DG){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement them = c.prepareStatement(them_dg);
            them.setString(1, DG.getMa_doc_gia());
            them.setString(2, DG.getTen_doc_gia());
            them.setString(3,DG.getSo_CCCD());
            them.setInt(4, DG.getGioi_tinh());
            them.setDate(5, (java.sql.Date) (Date) DG.getNgay_sinh());
            them.setString(6, DG.getDia_chi());
            them.setString(7, DG.getSDT());
            them.setString(8, DG.getTrang_thai());
            if(them.executeUpdate()>0)
            {
                them.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //Sửa thông tin độc giả
    public boolean sua_dg(doc_gia DG){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement sua =c.prepareStatement(sua_dg);
            sua.setString(1, DG.getTen_doc_gia());
            sua.setString(2, DG.getSo_CCCD());
            sua.setInt(3, DG.getGioi_tinh());
            sua.setDate(4, (java.sql.Date) (Date) DG.getNgay_sinh());
            sua.setString(5, DG.getDia_chi());
            sua.setString(6,DG.getSDT());
            sua.setString(7,DG.getTrang_thai());
            sua.setString (8,DG.getMa_doc_gia());
            if(sua.executeUpdate()>0){
                sua.close();
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    //Xóa thông tin độc giả
    public boolean xoa(String DG){
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement xoa =c.prepareStatement(xoa_dg);
            xoa.setString(1, DG);
            if(xoa.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    //tìm kiếm thông tin độc giả
    public List<doc_gia> tim_kiem(doc_gia DG, String ngaysinh){
        List<doc_gia> ds = new ArrayList<>();
        try {
            Connection c =DB_conn.getDBconn().getconn();
            PreparedStatement tim =c.prepareStatement(tim_dg);
            tim.setString(1, "%"+DG.getMa_doc_gia()+"%");
            tim.setString(2, "%"+DG.getTen_doc_gia()+"%");
            tim.setString(3, "%"+DG.getSo_CCCD()+"%");
            tim.setString(6, "%"+DG.getDia_chi()+"%");
            tim.setString(7, "%"+DG.getSDT()+"%");
            tim.setString(8, "%"+DG.getTrang_thai()+"%");
            tim.setString(5, "%"+ngaysinh+"%");
            if(DG.getGioi_tinh()==2){
                tim.setString(4,"%%");
            }
            else if(DG.getGioi_tinh()==1){
                tim.setString(4,"1");
            }
            else{
                tim.setString(4,"0");
            }
            
            ResultSet rs = tim.executeQuery();
            
            while(rs.next()){
                ds.add(cre_doc_gia(rs));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    //tạo đối tượng độc giả
    private static doc_gia cre_doc_gia(ResultSet rs) throws SQLException{
        String ma = rs.getString(ma_dg);
        String ten=rs.getString(ten_dg);
        String CCCD=rs.getString(doc_gia_dao.CCCD);
        int gt= rs.getInt(gt_dg);
        Date ns=rs.getDate(ns_dg);
        String dc=rs.getString(dc_dg);
        String SDT=rs.getString(SDT_dg);
        String tt=rs.getString(tt_dg);
        return new doc_gia(ma,ten,CCCD,gt,ns,dc,SDT,tt);
    }
    //kiểm tra mã độc giả
    public doc_gia kt_ma(String dg){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement ktma =c.prepareStatement(kt_ma_dg);
            ktma.setString(1, dg);
            ResultSet rs=ktma.executeQuery();
            if(rs.next()){
                doc_gia ds=cre_doc_gia(rs);
                return ds;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public doc_gia kt_cccd(String dg){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement ktcc =c.prepareStatement(kt_so_CCCD);
            ktcc.setString(1, dg);
            ResultSet rs=ktcc.executeQuery();
            if(rs.next()){
                doc_gia ds =cre_doc_gia(rs);
                return ds;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public doc_gia ktdg(String madg,String CCCD){
        try {
            Connection c=DB_conn.getDBconn().getconn();
            PreparedStatement kt = c.prepareStatement(kt_dg);
            kt.setString(1, madg);
            kt.setString(2, CCCD);
            ResultSet rs = kt.executeQuery();
            if(rs.next()){
                return cre_doc_gia(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List<doc_gia> timdgmn(String bien){
        List<doc_gia> ds = new ArrayList<>();
        try {
            Connection c = DB_conn.getDBconn().getconn();
            PreparedStatement tim = c.prepareStatement(timdgmn);
            tim.setString(1,"%"+bien+"%");
            tim.setString(2, "%"+bien+"%");
            ResultSet rs = tim.executeQuery();
            while(rs.next()){
                ds.add(cre_doc_gia(rs));
            }
            return ds;
        } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        
    }
}