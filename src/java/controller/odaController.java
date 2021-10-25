/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.odaDAO;
import entity.oda;
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
public class odaController implements Serializable {

    private List<oda> cList;
    private odaDAO cdao;
    private oda oda;

    public void updateFrom(oda cat) {
        this.oda = cat;
    }

    public void update() {
        this.getCdao().update(this.oda);
        this.oda = new oda();
    }

    public String clearForm() {
        this.oda = new oda();
        return "oda";
    }

    public String delete() {
        this.getCdao().delete(this.oda);
        this.oda = new oda();
        return "oda";
    }

    public void create() {
        this.getCdao().insert(this.oda);
        this.oda = new oda();

    }
    
    public String deleteConfirm(oda cat) {
        this.oda = cat;
        return "delete_oda";
    }

    public odaController() {
        this.cList = new ArrayList();
        cdao = new odaDAO();
    }

    public List<oda> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<oda> cList) {
        this.cList = cList;
    }

    public odaDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new odaDAO();
        }
        return cdao;
    }

    public void setCdao(odaDAO cdao) {
        this.cdao = cdao;
    }

    public oda getCategory() {
        if (this.oda == null) {
            this.oda = new oda();
        }
        return oda;
    }

    public void setCategory(oda oda) {
        this.oda = oda;
    }

}
