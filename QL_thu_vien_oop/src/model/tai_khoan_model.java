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
public class tai_khoan_model {
    private int id;
    private String tendangnhap;
    private String taikhoan;
    private String matkhau;
    private String chucvu;
    private int quyen;

    public tai_khoan_model(int id, String tendangnhap, String taikhoan, String matkhau, String chucvu, int quyen) {
        this.id = id;
        this.tendangnhap = tendangnhap;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.chucvu = chucvu;
        this.quyen = quyen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public int getQuyen() {
        return quyen;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }
    
}
