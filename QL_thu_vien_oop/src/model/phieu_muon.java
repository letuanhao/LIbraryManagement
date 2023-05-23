/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;
/**
 *
 * @author minh0
 */
public class phieu_muon {
    private String ma_PM;
    private String ma_doc_gia;
    private Date ngay_muon;
    private Date ngay_tra;
    private String trang_thai;

    public phieu_muon(String ma_PM, String ma_doc_gia, Date ngay_muon, Date ngay_tra,String trangthai) {
        this.ma_PM = ma_PM;
        this.ma_doc_gia = ma_doc_gia;
        this.ngay_muon = ngay_muon;
        this.ngay_tra = ngay_tra;
        this.trang_thai = trangthai;
    }

    
    
    public String getMa_PM() {
        return ma_PM;
    }

    public void setMa_PM(String ma_PM) {
        this.ma_PM = ma_PM;
    }

    public String getMa_doc_gia() {
        return ma_doc_gia;
    }

    public void setMa_doc_gia(String ma_doc_gia) {
        this.ma_doc_gia = ma_doc_gia;
    }

    public Date getNgay_muon() {
        return ngay_muon;
    }

    public void setNgay_muon(Date ngay_muon) {
        this.ngay_muon = ngay_muon;
    }

    public Date getNgay_tra() {
        return ngay_tra;
    }

    public void setNgay_tra(Date ngay_tra) {
        this.ngay_tra = ngay_tra;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }
}
