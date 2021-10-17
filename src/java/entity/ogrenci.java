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
public class ogrenci {

    private int ogrenci_no;
    private String ogrenci_adi;
    private String ogrenci_soyad;
    private String telefon_no;
    private int oda_numarasi;

    public ogrenci() {
    }

    public ogrenci(int ogrenci_no, String ogrenci_adi, String ogrenci_soyad, String telefon_no, int oda_numarasi) {
        this.ogrenci_no = ogrenci_no;
        this.ogrenci_adi = ogrenci_adi;
        this.ogrenci_soyad = ogrenci_soyad;

        this.telefon_no = telefon_no;
        this.oda_numarasi = oda_numarasi;
    }

    public int getOgrenci_no() {
        return ogrenci_no;
    }

    public void setOgrenci_no(int ogrenci_no) {
        this.ogrenci_no = ogrenci_no;
    }

    public String getOgrenci_adi() {
        return ogrenci_adi;
    }

    public void setOgrenci_adi(String ogrenci_adi) {
        this.ogrenci_adi = ogrenci_adi;
    }

    public String getOgrenci_soyad() {
        return ogrenci_soyad;
    }

    public void setOgrenci_soyad(String ogrenci_soyad) {
        this.ogrenci_soyad = ogrenci_soyad;
    }


    public String getTelefon_no() {
        return telefon_no;
    }

    public void setTelefon_no(String telefon_no) {
        this.telefon_no = telefon_no;
    }

    public int getOda_numarasi() {
        return oda_numarasi;
    }

    public void setOda_numarasi(int oda_numarasi) {
        this.oda_numarasi = oda_numarasi;
    }

    @Override
    public String toString() {
        return "ogrenci{" + "ogrenci_no=" + ogrenci_no + ", ogrenci_adi=" + ogrenci_adi + ", ogrenci_soyad=" + ogrenci_soyad  + telefon_no + ", oda_numarasi=" + oda_numarasi + '}';
    }
    
    

}
