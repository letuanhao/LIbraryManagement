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
public class listpm {
    String mapm;
    Date ngaymuon;
    Date ngaytra;
    String trangthai;
    int soluong;

    public listpm(String mapm, Date ngaymuon, Date ngaytra, String trangthai, int soluong) {
        this.mapm = mapm;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
        this.trangthai = trangthai;
        this.soluong = soluong;
    }

    public String getMapm() {
        return mapm;
    }

    public void setMapm(String mapm) {
        this.mapm = mapm;
    }

    public Date getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(Date ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
}
