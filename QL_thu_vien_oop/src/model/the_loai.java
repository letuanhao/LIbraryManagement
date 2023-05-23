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
public class the_loai {
    private String ma_TL;
    private String ten_TL;

    public the_loai(String ma_TL, String ten_TL) {
        this.ma_TL = ma_TL;
        this.ten_TL = ten_TL;
    }

    
    public String getMa_TL() {
        return ma_TL;
    }

    public void setMa_TL(String ma_TL) {
        this.ma_TL = ma_TL;
    }

    public String getTen_TL() {
        return ten_TL;
    }

    public void setTen_TL(String ten_TL) {
        this.ten_TL = ten_TL;
    }
    public String get_ma_ten_TL(){
        return ma_TL+ " - " +ten_TL;
    }
    
}
