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
public class kat {
    private int kat_numarasi;
     private int oda_sayisi;

    public kat() {
    }

    public kat(int kat_numarasi, int oda_sayisi) {
        this.kat_numarasi = kat_numarasi;
        this.oda_sayisi = oda_sayisi;
    }

    public int getKat_numarasi() {
        return kat_numarasi;
    }

    public void setKat_numarasi(int kat_numarasi) {
        this.kat_numarasi = kat_numarasi;
    }

    public int getOda_sayisi() {
        return oda_sayisi;
    }

    public void setOda_sayisi(int oda_sayisi) {
        this.oda_sayisi = oda_sayisi;
    }

    @Override
    public String toString() {
        return "kat{" + "kat_numarasi=" + kat_numarasi + ", oda_sayisi=" + oda_sayisi + '}';
    }
     
     
    
}
