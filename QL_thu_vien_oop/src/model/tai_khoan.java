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
public class tai_khoan {
    protected static int id;
    private static String tendangnhap;
    private static String taikhoan;
    private static String matkhau;
    private static String chucvu;
    private static int quyen;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        tai_khoan.id = id;
    }

    public static String getTendangnhap() {
        return tendangnhap;
    }

    public static void setTendangnhap(String tendangnhap) {
        tai_khoan.tendangnhap = tendangnhap;
    }

    public static String getTaikhoan() {
        return taikhoan;
    }

    public static void setTaikhoan(String taikhoan) {
        tai_khoan.taikhoan = taikhoan;
    }

    public static String getMatkhau() {
        return matkhau;
    }

    public static void setMatkhau(String matkhau) {
        tai_khoan.matkhau = matkhau;
    }

    public static String getChucvu() {
        return chucvu;
    }

    public static void setChucvu(String chucvu) {
        tai_khoan.chucvu = chucvu;
    }

    public static int getQuyen() {
        return quyen;
    }

    public static void setQuyen(int quyen) {
        tai_khoan.quyen = quyen;
    }
}
