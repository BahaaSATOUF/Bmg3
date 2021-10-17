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
public class etkinlik {

    private int etkinlik_id;
    private String sunan_hoca;
    private String etkinlik_turu;
    private String aciklama;

    public etkinlik() {
    }

    public etkinlik(int etkinlik_id, String sunan_hoca, String etkinlik_turu, String aciklama) {
        this.etkinlik_id = etkinlik_id;
        this.sunan_hoca = sunan_hoca;
        this.etkinlik_turu = etkinlik_turu;
        this.aciklama = aciklama;
    }

    public int getEtkinlik_id() {
        return etkinlik_id;
    }

    public void setEtkinlik_id(int etkinlik_id) {
        this.etkinlik_id = etkinlik_id;
    }

    public String getSunan_hoca() {
        return sunan_hoca;
    }

    public void setSunan_hoca(String sunan_hoca) {
        this.sunan_hoca = sunan_hoca;
    }

    public String getEtkinlik_turu() {
        return etkinlik_turu;
    }

    public void setEtkinlik_turu(String etkinlik_turu) {
        this.etkinlik_turu = etkinlik_turu;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "etkinlik{" + "etkinlik_id=" + etkinlik_id + ", sunan_hoca=" + sunan_hoca + ", etkinlik_turu=" + etkinlik_turu + ", aciklama=" + aciklama + '}';
    }
    
    
    
    
    
    
    
    
    
}
