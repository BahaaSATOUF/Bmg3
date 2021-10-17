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
public class odeme {
      private int ogrenci_no;
    private String muhsip_tc;
    private String odeme_miktari;
   
    public odeme() {
    }

    public odeme(int ogrenci_no, String muhsip_tc, String odeme_miktari) {
        this.ogrenci_no = ogrenci_no;
        this.muhsip_tc = muhsip_tc;
        this.odeme_miktari = odeme_miktari;
     
    }

    public int getOgrenci_no() {
        return ogrenci_no;
    }

    public void setOgrenci_no(int ogrenci_no) {
        this.ogrenci_no = ogrenci_no;
    }

    public String getMuhsip_tc() {
        return muhsip_tc;
    }

    public void setMuhsip_tc(String muhsip_tc) {
        this.muhsip_tc = muhsip_tc;
    }

    public String getOdeme_miktari() {
        return odeme_miktari;
    }

    public void setOdeme_miktari(String odeme_miktari) {
        this.odeme_miktari = odeme_miktari;
    }

    @Override
    public String toString() {
        return "odeme{" + "ogrenci_no=" + ogrenci_no + ", muhsip_tc=" + muhsip_tc + ", odeme_miktari=" + odeme_miktari +  '}';
    }
    
    
    
}
