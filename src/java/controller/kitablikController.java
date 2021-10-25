/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.kitablikDAO;
import entity.kitablik;
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
public class kitablikController implements Serializable {

    private List<kitablik> cList;
    private kitablikDAO cdao;
    private kitablik kitablik;

    public void updateFrom(kitablik cat) {
        this.kitablik = cat;
    }

    public void update() {
        this.getCdao().update(this.kitablik);
        this.kitablik = new kitablik();
    }

    public String clearForm() {
        this.kitablik = new kitablik();
        return "kitablik";
    }

    public String delete() {
        this.getCdao().delete(this.kitablik);
        this.kitablik = new kitablik();
        return "kitablik";
    }

    public void create() {
        this.getCdao().insert(this.kitablik);
        this.kitablik = new kitablik();

    }
    
    public String deleteConfirm(kitablik cat) {
        this.kitablik = cat;
        return "delete_kitablik";
    }

    public kitablikController() {
        this.cList = new ArrayList();
        cdao = new kitablikDAO();
    }

    public List<kitablik> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<kitablik> cList) {
        this.cList = cList;
    }

    public kitablikDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new kitablikDAO();
        }
        return cdao;
    }

    public void setCdao(kitablikDAO cdao) {
        this.cdao = cdao;
    }

    public kitablik getCategory() {
        if (this.kitablik == null) {
            this.kitablik = new kitablik();
        }
        return kitablik;
    }

    public void setCategory(kitablik kitablik) {
        this.kitablik = kitablik;
    }

}
