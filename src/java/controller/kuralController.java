

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.kuralDAO;
import entity.kural;
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
public class kuralController implements Serializable {

    private List<kural> cList;
    private kuralDAO cdao;
    private kural kural;

    public void updateFrom(kural cat) {
        this.kural = cat;
    }

    public void update() {
        this.getCdao().update(this.kural);
        this.kural = new kural();
    }

    public String clearForm() {
        this.kural = new kural();
        return "kural";
    }

    public String delete() {
        this.getCdao().delete(this.kural);
        this.kural = new kural();
        return "kural";
    }

    public void create() {
        this.getCdao().insert(this.kural);
        this.kural = new kural();

    }
    
    public String deleteConfirm(kural cat) {
        this.kural = cat;
        return "delete_kural";
    }

    public kuralController() {
        this.cList = new ArrayList();
        cdao = new kuralDAO();
    }

    public List<kural> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<kural> cList) {
        this.cList = cList;
    }

    public kuralDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new kuralDAO();
        }
        return cdao;
    }

    public void setCdao(kuralDAO cdao) {
        this.cdao = cdao;
    }

    public kural getCategory() {
        if (this.kural == null) {
            this.kural = new kural();
        }
        return kural;
    }

    public void setCategory(kural kural) {
        this.kural = kural;
    }

}
