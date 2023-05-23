/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author minh0
 */
public class dau_sach {
    private String ma_dau_sach;
    private String ten_dau_sach;
    private String ma_NXB;
    private String ma_TL;
    private String tac_gia;
    private String vi_tri;
    private String trang_thai;
    private int soluong;

    public dau_sach(String ma_dau_sach, String ten_dau_sach, String ma_NXB, String ma_TL, String tac_gia, String vi_tri,String trangthai,int soluong) {
        this.ma_dau_sach = ma_dau_sach;
        this.ten_dau_sach = ten_dau_sach;
        this.ma_NXB = ma_NXB;
        this.ma_TL = ma_TL;
        this.tac_gia = tac_gia;
        this.vi_tri = vi_tri;
        this.trang_thai = trangthai;
        this.soluong=soluong;
    }
    
    public String getMa_dau_sach() {
        return ma_dau_sach;
    }

    public void setMa_dau_sach(String ma_dau_sach) {
        this.ma_dau_sach = ma_dau_sach;
    }

    public String getTen_dau_sach() {
        return ten_dau_sach;
    }

    public void setTen_dau_sach(String ten_dau_sach) {
        this.ten_dau_sach = ten_dau_sach;
    }

    public String getMa_NXB() {
        return ma_NXB;
    }

    public void setMa_NXB(String ma_NXB) {
        this.ma_NXB = ma_NXB;
    }

    public String getMa_TL() {
        return ma_TL;
    }

    public void setMa_TL(String ma_TL) {
        this.ma_TL = ma_TL;
    }

    public String getTac_gia() {
        return tac_gia;
    }

    public void setTac_gia(String tac_gia) {
        this.tac_gia = tac_gia;
    }

    public String getVi_tri() {
        return vi_tri;
    }

    public void setVi_tri(String vi_tri) {
        this.vi_tri = vi_tri;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    public String getMaTenSach(){
        return this.ma_dau_sach+"-"+this.ten_dau_sach;
    }
}
