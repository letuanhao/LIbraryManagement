/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ket_noi_db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh0
 */
public class DB_infor {
    private static String taikhoan;
    private static String matkhau;

    public static String getTaikhoan() {
        return taikhoan;
    }

    public static void setTaikhoan(String taikhoan) {
        DB_infor.taikhoan = taikhoan;
    }

    public static String getMatkhau() {
        return matkhau;
    }

    public static void setMatkhau(String matkhau) {
        DB_infor.matkhau = matkhau;
    }
    
    public static void main(String[] args) {
        ReadFileTxt rd = new ReadFileTxt();
        rd.readfile();
        System.out.println(DB_infor.getTaikhoan());
        System.out.println(DB_infor.getMatkhau());
    }
}
