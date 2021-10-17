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
public class kitablik {
    private int kitap_id;
    private String kitap_adi;
    private String yazar ;

    public kitablik() {
    }
    
public kitablik(int kitap_id, String kitap_adi, String yazar) {
        this.kitap_id = kitap_id;
        this.kitap_adi = kitap_adi;
        this.yazar = yazar;
    }
    public int getKitap_id() {
        return kitap_id;
    }

    public void setKitap_id(int kitap_id) {
        this.kitap_id = kitap_id;
    }

    public String getKitap_adi() {
        return kitap_adi;
    }

    public void setKitap_adi(String kitap_adi) {
        this.kitap_adi = kitap_adi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    

    @Override
    public String toString() {
        return "kitablik{" + "kitap_id=" + kitap_id + ", kitap_adi=" + kitap_adi + ", yazar=" + yazar + '}';
    }

    
}
