/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ogrenciDAO;
import entity.ogrenci;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



/**
 *
 * @author nabilo
 */
@Named
@SessionScoped
public class ogrenciController implements Serializable {

    private List<ogrenci> cList;
    private ogrenciDAO cdao;
    private ogrenci ogrenci;

    public void updateFrom(ogrenci cat) {
        this.ogrenci = cat;
    }

    public void update() {
        this.getCdao().update(this.ogrenci);
        this.ogrenci = new ogrenci();
    }

    public String clearForm() {
        this.ogrenci = new ogrenci();
        return "ogrenci";
    }

    public String delete() {
        this.getCdao().delete(this.ogrenci);
        this.ogrenci = new ogrenci();
        return "ogrenci";
    }

    public void create() {
        this.getCdao().insert(this.ogrenci);
        this.ogrenci = new ogrenci();

    }
    
    public String deleteConfirm(ogrenci cat) {
        this.ogrenci = cat;
        return "delete_ogrenci";
    }

    public ogrenciController() {
        this.cList = new ArrayList();
        cdao = new ogrenciDAO();
    }

    public List<ogrenci> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<ogrenci> cList) {
        this.cList = cList;
    }

    public ogrenciDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new ogrenciDAO();
        }
        return cdao;
    }

    public void setCdao(ogrenciDAO cdao) {
        this.cdao = cdao;
    }

    public ogrenci getCategory() {
        if (this.ogrenci == null) {
            this.ogrenci = new ogrenci();
        }
        return ogrenci;
    }

    public void setCategory(ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

}
