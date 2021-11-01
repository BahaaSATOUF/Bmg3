
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.yemekhane_personeliDAO;
import entity.yemekhane_personeli;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;



@Named
@SessionScoped
public class yemekhane_personeliController implements Serializable {

    private List<yemekhane_personeli> cList;
    private yemekhane_personeliDAO cdao;
    private yemekhane_personeli yemekhane_personeli;

    public void updateFrom(yemekhane_personeli cat) {
        this.yemekhane_personeli = cat;
    }

    public void update() {
        this.getCdao().update(this.yemekhane_personeli);
        this.yemekhane_personeli = new yemekhane_personeli();
    }

    public String clearForm() {
        this.yemekhane_personeli = new yemekhane_personeli();
        return "yemekhane_personeli";
    }

    public String delete() {
        this.getCdao().delete(this.yemekhane_personeli);
        this.yemekhane_personeli = new yemekhane_personeli();
        return "yemekhane_personeli";
    }

    public void create() {
        this.getCdao().insert(this.yemekhane_personeli);
        this.yemekhane_personeli = new yemekhane_personeli();

    }
    
    public String deleteConfirm(yemekhane_personeli cat) {
        this.yemekhane_personeli = cat;
        return "delete_yemekhane_personeli";
    }

    public yemekhane_personeliController() {
        this.cList = new ArrayList();
        cdao = new yemekhane_personeliDAO();
    }

    public List<yemekhane_personeli> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<yemekhane_personeli> cList) {
        this.cList = cList;
    }

    public yemekhane_personeliDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new yemekhane_personeliDAO();
        }
        return cdao;
    }

    public void setCdao(yemekhane_personeliDAO cdao) {
        this.cdao = cdao;
    }

    public yemekhane_personeli getCategory() {
        if (this.yemekhane_personeli == null) {
            this.yemekhane_personeli = new yemekhane_personeli();
        }
        return yemekhane_personeli;
    }

    public void setCategory(yemekhane_personeli yemekhane_personeli) {
        this.yemekhane_personeli = yemekhane_personeli;
    }

}
