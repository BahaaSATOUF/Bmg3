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
public class kural {
    private int kural_id;
    private String aciklama;

    public kural() {
    }

    public kural(int kural_id, String aciklama) {
        this.kural_id = kural_id;
        this.aciklama = aciklama;
    }

    public int getKural_id() {
        return kural_id;
    }

    public void setKural_id(int kural_id) {
        this.kural_id = kural_id;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    @Override
    public String toString() {
        return "kural{" + "kural_id=" + kural_id + ", aciklama=" + aciklama + '}';
    }
    
    
    
    
}
