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
public class temizlik_personeli {

    private String tc;
    private String isim;
    private String telefon_no;
    private int maas;
    private int kat_numarasi;
    private String muhaseip_tc;

    public temizlik_personeli() {
    }

    public temizlik_personeli(String tc, String isim, String telefon_no, int maas, int kat_numarasi, String muhaseip_tc) {
        this.tc = tc;
        this.isim = isim;
        this.telefon_no = telefon_no;
        this.maas = maas;
        this.kat_numarasi = kat_numarasi;
        this.muhaseip_tc = muhaseip_tc;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTelefon_no() {
        return telefon_no;
    }

    public void setTelefon_no(String telefon_no) {
        this.telefon_no = telefon_no;
    }

    public int getMaas() {
        return maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getKat_numarasi() {
        return kat_numarasi;
    }

    public void setKat_numarasi(int kat_numarasi) {
        this.kat_numarasi = kat_numarasi;
    }

    public String getMuhaseip_tc() {
        return muhaseip_tc;
    }

    public void setMuhaseip_tc(String muhaseip_tc) {
        this.muhaseip_tc = muhaseip_tc;
    }

    @Override
    public String toString() {
        return "temizlik_personeli{" + "tc=" + tc + ", isim=" + isim + ", telefon_no=" + telefon_no + ", maas=" + maas + ", kat_numarasi=" + kat_numarasi + ", muhaseip_tc=" + muhaseip_tc + '}';
    }


    
}
