/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Bahaa
 */
public class yonetim_personeli {

    private String tc;
    private String isim;
    private String telefon_no;
    private int maas;
    private String muhasip_tc;

    public yonetim_personeli() {
    }

    public yonetim_personeli(String tc, String isim, String telefon_no, int maas, String muhasip_tc) {
        this.tc = tc;
        this.isim = isim;
        this.telefon_no = telefon_no;
        this.maas = maas;
        this.muhasip_tc = muhasip_tc;
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

    public String getmuhasip_tc() {
        return muhasip_tc;
    }

    public void setmuhasip_tc(String muhasip_tc) {
        this.muhasip_tc = muhasip_tc;
    }

    @Override
    public String toString() {
        return "yonetim_personeli{" + "tc=" + tc + ", isim=" + isim + ", telefon_no=" + telefon_no + ", maas=" + maas + ", muhasip_tc=" + muhasip_tc + '}';
    }

}
