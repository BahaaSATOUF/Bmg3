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
public class calisan {

    private String tc;
    private String isim; 
    private String telefon_no;
    private int maas;
 

    public calisan() {
    }

    public calisan(String tc, String isim, String telefon_no, int maas) {
        this.tc = tc;
        this.isim = isim;
        this.telefon_no = telefon_no;
        this.maas = maas;
 
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

    @Override
    public String toString() {
        return "calisan{" + "tc=" + tc + ", isim=" + isim + ", telefon_no=" + telefon_no + ", maas=" + maas + '}';
    }

   

}
