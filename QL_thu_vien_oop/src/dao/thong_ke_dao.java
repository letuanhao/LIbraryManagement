/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import form.fm_muon_tra;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import ket_noi_db.*;
/**
 *
 * @author minh0
 */
public class thong_ke_dao {
    private static final String madsach = "ma_dau_sach";
    private static final String tensach = "ten_sach";
    private static final String somuon = "solmuon";
    
    private static final String madg = "ma_doc_gia";
    private static final String tendg = "ten_doc_gia";
    private static final String sopm = "solanmuon";
    private static final String sosach = "tongsach";
    private static final String sosachqh ="tongsachqh";
    
    private static String tkdausach = " SELECT * FROM [dbo].[Fn_thong_ke_dau_sach] ( ? , ? ) ";
    private static String tkdocgia = " SELECT * FROM [dbo].[Fn_thong_ke_doc_gia] ( ? , ? ) ";
    
    private static thong_ke_dao tkdao;
    public static thong_ke_dao get_TK_dao(){
        if(tkdao==null){
            tkdao=new thong_ke_dao();
        }
        return tkdao;
    }
    private static List<Object> cre_dausach(ResultSet rs) throws SQLException{
        List<Object>  ds =  new ArrayList<>();
        ds.add(rs.getString(madsach));
        ds.add(rs.getString(tensach));
        ds.add(rs.getInt(somuon));
        return ds;
    }
    
    public List<List<Object>> TK_dausach(Date ngaybd,Date ngaykt){
        java.sql.Date ngaybd1 = new java.sql.Date(ngaybd.getTime());
        java.sql.Date ngaykt1 = new java.sql.Date(ngaykt.getTime());
        List< List<Object> > ds = new ArrayList<>();
        
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement tk = c.prepareStatement(tkdausach);
            tk.setDate(1, ngaybd1);
            tk.setDate(2, ngaykt1);
            ResultSet rs = tk.executeQuery();
            while(rs.next()){
                ds.add(cre_dausach(rs));
            }
            return ds;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    
    private static List<Object> cre_doc_gia(ResultSet rs) throws SQLException{
        List<Object> ds = new ArrayList<>();
        ds.add(rs.getString(madg));
        ds.add(rs.getString(tendg));
        ds.add(rs.getInt(sopm));
        ds.add(rs.getInt(sosach));
        ds.add(rs.getInt(sosachqh));
        return ds;
    }
    
    public List<List<Object>> TK_doc_gia(Date ngaybd,Date ngaykt){
        java.sql.Date ngaybd1 = new java.sql.Date(ngaybd.getTime());
        java.sql.Date ngaykt1 = new java.sql.Date(ngaykt.getTime());
        List< List<Object> > ds = new ArrayList<>();
        try {
            Connection c= DB_conn.getDBconn().getconn();
            PreparedStatement tk = c.prepareStatement(tkdocgia);
            tk.setDate(1, ngaybd1);
            tk.setDate(2, ngaykt1);
            ResultSet rs = tk.executeQuery();
            while(rs.next()){
                ds.add(cre_doc_gia(rs));
            }
            return ds;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        Calendar cl =Calendar.getInstance();
        Date ngaybd = new Date();
        Date ngaykt = new Date();
        ngaykt = cl.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String datef = "01-01-2020";
        try {
            ngaybd = dateFormat.parse(datef);
            
        } catch (ParseException ex) {
            Logger.getLogger(fm_muon_tra.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<List<Object>> ds = get_TK_dao().TK_doc_gia(ngaybd, ngaykt);
        
        for(int i=0 ; i < ds.size(); i++){
            
            System.out.println(ds.get(i).get(1));
        }
        System.out.println(ds.size());
    }
}
