/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Bahaa
 */
public class yemekhane {
    String yemek_listesi;
    Date tarih;

    public yemekhane() {
    }

    public yemekhane(String yemek_listesi, Date tarih) {
        this.yemek_listesi = yemek_listesi;
        this.tarih = tarih;
    }

    public String getYemek_listesi() {
        return yemek_listesi;
    }

    public void setYemek_listesi(String yemek_listesi) {
        this.yemek_listesi = yemek_listesi;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "yemekhane{" + "yemek_listesi=" + yemek_listesi + ", tarih=" + tarih + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
