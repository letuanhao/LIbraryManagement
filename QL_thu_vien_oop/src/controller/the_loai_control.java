/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import model.*;
import dao.*;
import java.time.chrono.ThaiBuddhistEra;
import javax.management.monitor.StringMonitorMBean;
/**
 *
 * @author minh0
 */
public class the_loai_control {
    private static the_loai_control tlc;
    private DefaultTableModel tblmodel;
    //them du lieu tu list vao combobox
    public void load_combobox(JComboBox jcb,List<the_loai> ds){
        jcb.removeAllItems();
        jcb.addItem("");
        if(ds==null){
            
        }else{
            for (int i = 0; i < ds.size(); i++) {
                jcb.addItem(ds.get(i).getTen_TL());
            }
        }
    }
    //them du lieu tu list vao bang
    public void load_table(JTable tbl,List<the_loai> ds){
        tblmodel=(DefaultTableModel) tbl.getModel();
        tblmodel.setRowCount(0);
        if(ds==null){
            
        }else{
            for(int i=0;i<ds.size();i++){
                the_loai tl=ds.get(i);
                tblmodel.addRow(new Object[]{tl.getMa_TL(),tl.getTen_TL()});
            }
        }
        tbl.setRowHeight(20);
        
    }
    public List<the_loai> getallTL(){
        return the_loai_dao.get_TL_dao().ds_the_loai();
    }
    //kiểm tra ma xem có thỏa mãn thể loại điều kiện 0<ma<6 
    public static boolean check_txt_len(String ma){
        return ma.length()>0&&ma.length()<6;
    }
    
    //kiểm tra xem mã thể loại có thỏa mãn điều kiện ko chứa ký tự dặc biệt ko;
    public static boolean check_txt_format(String ma){
        return ma.matches("[A-Za-z0-9]+");
    }
    //thực hiện câu lệnh thêm sửa xóa tìm kiếm
    
    //them the loai
    public int them_TL(String ma,String ten){
        int kt =0;
        the_loai tl = new the_loai(ma, ten);
        if(the_loai_dao.get_TL_dao().kt_ma_TL(ma)==null){
            if(the_loai_dao.get_TL_dao().them(tl)){
                kt=1;
            }else{
                kt=2;
            }
        }else{
            kt=3;
        }
        return kt;
    }

    public the_loai_control() {
    }
   //luu the loai
    public int luu_TL(String ma,String ten){
        int kt =0;
        the_loai tl = new the_loai(ma, ten);
        if(the_loai_dao.get_TL_dao().kt_ma_TL(ma)==null){
            if(the_loai_dao.get_TL_dao().them(tl)){
                kt=1;
            }else{
                kt=2;
            }
        }else{
            if(the_loai_dao.get_TL_dao().luu(tl)){
                kt=3;
            }else{
                kt=4;
            }
        }
        return kt;
    }
    
    //xoa the loai
    public boolean xoa_TL(String ma,String ten){
        the_loai tl = new the_loai(ma, ten);
        return the_loai_dao.get_TL_dao().xoa(tl);
    }
    //lay ra danh sach the loai
    public List<the_loai> get_allTL(){
        return the_loai_dao.get_TL_dao().ds_the_loai();
    }
    public the_loai get_TL(String ma){
        return new the_loai_dao().kt_ma_TL(ma);
    }        
    public static the_loai_control get_TLc(){
        if(tlc==null){
            tlc=new the_loai_control();
        }
        return tlc;
    }
    public static void main(String[] args) {
        the_loai_control tlc=new the_loai_control();
        List<the_loai> ds;
        String ma="";
        String ten="";
        ds = new ArrayList<the_loai>();
        ds=get_TLc().get_allTL();
        for(int i=0;i<ds.size();i++){
            System.out.println(ds.get(i).get_ma_ten_TL());
        }
        
    }
    
}
