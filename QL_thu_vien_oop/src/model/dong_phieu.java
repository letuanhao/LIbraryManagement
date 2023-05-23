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
public class dong_phieu {
    private String maPM;
    private String maSach;
    private float tiencoc;
    private float tienphat;
    private float giachomuon;
    private Date ngaytra;
    private int datra;
    private int dathanhtoan;
    private String ghichu;

    public dong_phieu(String maPM, String maSach, float tiencoc, float tienphat, float giachomuon, Date ngaytra, int datra, int dathanhtoan, String ghichu) {
        this.maPM = maPM;
        this.maSach = maSach;
        this.tiencoc = tiencoc;
        this.tienphat = tienphat;
        this.giachomuon = giachomuon;
        this.ngaytra = ngaytra;
        this.datra = datra;
        this.dathanhtoan = dathanhtoan;
        this.ghichu = ghichu;
    }

    public String getMaPM() {
        return maPM;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public float getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(float tiencoc) {
        this.tiencoc = tiencoc;
    }

    public float getTienphat() {
        return tienphat;
    }

    public void setTienphat(float tienphat) {
        this.tienphat = tienphat;
    }

    public float getGiachomuon() {
        return giachomuon;
    }

    public void setGiachomuon(float giachomuon) {
        this.giachomuon = giachomuon;
    }

    public Date getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(Date ngaytra) {
        this.ngaytra = ngaytra;
    }

    public int getDatra() {
        return datra;
    }

    public void setDatra(int datra) {
        this.datra = datra;
    }

    public int getDathanhtoan() {
        return dathanhtoan;
    }

    public void setDathanhtoan(int dathanhtoan) {
        this.dathanhtoan = dathanhtoan;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
}
