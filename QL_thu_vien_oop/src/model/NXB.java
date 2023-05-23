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
public class NXB {
    private String ma_NXB;
    private String Ten_NXB;

    public NXB(String ma_NXB, String Ten_NXB) {
        this.ma_NXB = ma_NXB;
        this.Ten_NXB = Ten_NXB;
    }
    
    public String getMa_NXB() {
        return ma_NXB;
    }

    public void setMa_NXB(String ma_NXB) {
        this.ma_NXB = ma_NXB;
    }

    public String getTen_NXB() {
        return Ten_NXB;
    }

    public void setTen_NXB(String Ten_NXB) {
        this.Ten_NXB = Ten_NXB;
    }
    public String getMaTenNXB(){
        return this.ma_NXB+"-"+this.Ten_NXB;
    }
    
}
