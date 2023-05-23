/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.*;
import java.text.*;
/**
 *
 * @author minh0
 */
public class doc_gia {
    private String ma_doc_gia;
    private String ten_doc_gia;
    private String so_CCCD;
    private int gioi_tinh;
    private Date ngay_sinh;
    private String dia_chi;
    private String SDT;
    private String trang_thai;

    public String getMa_doc_gia() {
        return ma_doc_gia;
    }

    public void setMa_doc_gia(String ma_doc_gia) {
        this.ma_doc_gia = ma_doc_gia;
    }

    public String getTen_doc_gia() {
        return ten_doc_gia;
    }

    public void setTen_doc_gia(String ten_doc_gia) {
        this.ten_doc_gia = ten_doc_gia;
    }

    public String getSo_CCCD() {
        return so_CCCD;
    }

    public void setSo_CCCD(String so_CCCD) {
        this.so_CCCD = so_CCCD;
    }

    public int getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(int gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public Date getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(Date ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public doc_gia(String ma_doc_gia, String ten_doc_gia, String so_CCCD, int gioi_tinh, Date ngay_sinh, String dia_chi, String SDT, String trang_thai) {
        this.ma_doc_gia = ma_doc_gia;
        this.ten_doc_gia = ten_doc_gia;
        this.so_CCCD = so_CCCD;
        this.gioi_tinh = gioi_tinh;
        this.ngay_sinh = ngay_sinh;
        this.dia_chi = dia_chi;
        this.SDT = SDT;
        this.trang_thai = trang_thai;
    }
}
