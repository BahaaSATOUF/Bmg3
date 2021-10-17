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
public class oda {

    private int oda_numarasi;
    private int yatak_sayisi;
    private int kat_numarasi;

    public oda() {
    }

    public oda(int oda_numarasi, int yatak_sayisi, int kat_numarasi) {
        this.oda_numarasi = oda_numarasi;
        this.yatak_sayisi = yatak_sayisi;
        this.kat_numarasi = kat_numarasi;
    }

    public int getOda_numarasi() {
        return oda_numarasi;
    }

    public void setOda_numarasi(int oda_numarasi) {
        this.oda_numarasi = oda_numarasi;
    }

    public int getYatak_sayisi() {
        return yatak_sayisi;
    }

    public void setYatak_sayisi(int yatak_sayisi) {
        this.yatak_sayisi = yatak_sayisi;
    }

    public int getKat_numarasi() {
        return kat_numarasi;
    }

    public void setKat_numarasi(int kat_numarasi) {
        this.kat_numarasi = kat_numarasi;
    }

    @Override
    public String toString() {
        return "oda{" + "oda_numarasi=" + oda_numarasi + ", yatak_sayisi=" + yatak_sayisi + ", kat_numarasi=" + kat_numarasi + '}';
    }
    
    

}
