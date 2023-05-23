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
public class sach {
    private String ma_sach;
    private String ma_dau_sach;
    private String ISBN;
    private String nam_xuat_ban;
    private String tinh_trang;
    private float giatiensach;

    public sach(String ma_sach, String ma_dau_sach, String ISBN, String nam_xuat_ban,String tinhtrang,float gia) {
        this.ma_sach = ma_sach;
        this.ma_dau_sach = ma_dau_sach;
        this.ISBN = ISBN;
        this.nam_xuat_ban = nam_xuat_ban;
        this.tinh_trang= tinhtrang;
        this.giatiensach=gia;
    }

    
    
    public String getMa_sach() {
        return ma_sach;
    }

    public void setMa_sach(String ma_sach) {
        this.ma_sach = ma_sach;
    }

    public String getMa_dau_sach() {
        return ma_dau_sach;
    }

    public void setMa_dau_sach(String ma_dau_sach) {
        this.ma_dau_sach = ma_dau_sach;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getNam_xuat_ban() {
        return nam_xuat_ban;
    }

    public void setNam_xuat_ban(String nam_xuat_ban) {
        this.nam_xuat_ban = nam_xuat_ban;
    }

    public String getTinh_trang() {
        return tinh_trang;
    }

    public void setTinh_trang(String tinh_trang) {
        this.tinh_trang = tinh_trang;
    }

    public float getGiatiensach() {
        return giatiensach;
    }

    public void setGiatiensach(float giatiensach) {
        this.giatiensach = giatiensach;
    }
    
    
}
