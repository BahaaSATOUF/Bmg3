
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.yemekhaneDAO;
import entity.yemekhane;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;




@Named
@SessionScoped
public class yemekhaneController implements Serializable {

    private List<yemekhane> cList;
    private yemekhaneDAO cdao;
    private yemekhane yemekhane;

    public void updateFrom(yemekhane cat) {
        this.yemekhane = cat;
    }

    public void update() {
        this.getCdao().update(this.yemekhane);
        this.yemekhane = new yemekhane();
    }

    public String clearForm() {
        this.yemekhane = new yemekhane();
        return "yemekhane";
    }

    public String delete() {
        this.getCdao().delete(this.yemekhane);
        this.yemekhane = new yemekhane();
        return "yemekhane";
    }

    public void create() {
        this.getCdao().insert(this.yemekhane);
        this.yemekhane = new yemekhane();

    }
    
    public String deleteConfirm(yemekhane cat) {
        this.yemekhane = cat;
        return "delete_yemekhane";
    }

    public yemekhaneController() {
        this.cList = new ArrayList();
        cdao = new yemekhaneDAO();
    }

    public List<yemekhane> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<yemekhane> cList) {
        this.cList = cList;
    }

    public yemekhaneDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new yemekhaneDAO();
        }
        return cdao;
    }

    public void setCdao(yemekhaneDAO cdao) {
        this.cdao = cdao;
    }

    public yemekhane getCategory() {
        if (this.yemekhane == null) {
            this.yemekhane = new yemekhane();
        }
        return yemekhane;
    }

    public void setCategory(yemekhane yemekhane) {
        this.yemekhane = yemekhane;
    }

}
