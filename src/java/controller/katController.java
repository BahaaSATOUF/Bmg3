/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.katDAO;
import entity.kat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



@Named
@SessionScoped
public class katController implements Serializable {

    private List<kat> cList;
    private katDAO cdao;
    private kat kat;

    public void updateFrom(kat cat) {
        this.kat = cat;
    }

    public void update() {
        this.getCdao().update(this.kat);
        this.kat = new kat();
    }

    public String clearForm() {
        this.kat = new kat();
        return "kat";
    }

    public String delete() {
        this.getCdao().delete(this.kat);
        this.kat = new kat();
        return "kat";
    }

    public void create() {
        this.getCdao().insert(this.kat);
        this.kat = new kat();

    }
    
    public String deleteConfirm(kat cat) {
        this.kat = cat;
        return "delete_kat";
    }

    public katController() {
        this.cList = new ArrayList();
        cdao = new katDAO();
    }

    public List<kat> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<kat> cList) {
        this.cList = cList;
    }

    public katDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new katDAO();
        }
        return cdao;
    }

    public void setCdao(katDAO cdao) {
        this.cdao = cdao;
    }

    public kat getCategory() {
        if (this.kat == null) {
            this.kat = new kat();
        }
        return kat;
    }

    public void setCategory(kat kat) {
        this.kat = kat;
    }

}
