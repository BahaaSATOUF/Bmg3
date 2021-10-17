/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Bahaa
 */
public class spor_salonu {

    int id_spor;
    Date gun;
    Time saat;
    String spor_turu;

    public spor_salonu() {
    }

    public spor_salonu(int id_spor, Date gun, Time saat, String spor_turu) {
        this.id_spor = id_spor;
        this.gun = gun;
        this.saat = saat;
        this.spor_turu = spor_turu;
    }

    public int getId_spor() {
        return id_spor;
    }

    public void setId_spor(int id_spor) {
        this.id_spor = id_spor;
    }

    public Date getGun() {
        return gun;
    }

    public void setGun(Date gun) {
        this.gun = gun;
    }

    public Time getSaat() {
        return saat;
    }

    public void setSaat(Time saat) {
        this.saat = saat;
    }

    public String getSpor_turu() {
        return spor_turu;
    }

    public void setSpor_turu(String spor_turu) {
        this.spor_turu = spor_turu;
    }

    @Override
    public String toString() {
        return "spor_salonu{" + "id_spor=" + id_spor + ", gun=" + gun + ", saat=" + saat + ", spor_turu=" + spor_turu + '}';
    }

}
