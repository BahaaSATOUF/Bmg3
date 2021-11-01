/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.yonetim_personeliDAO;
import entity.yonetim_personeli;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class yonetim_personeliController implements Serializable {

    private List<yonetim_personeli> cList;
    private yonetim_personeliDAO cdao;
    private yonetim_personeli yonetim_personeli;

    public void updateFrom(yonetim_personeli cat) {
        this.yonetim_personeli = cat;
    }

    public void update() {
        this.getCdao().update(this.yonetim_personeli);
        this.yonetim_personeli = new yonetim_personeli();
    }

    public String clearForm() {
        this.yonetim_personeli = new yonetim_personeli();
        return "yonetim_personeli";
    }

    public String delete() {
        this.getCdao().delete(this.yonetim_personeli);
        this.yonetim_personeli = new yonetim_personeli();
        return "yonetim_personeli";
    }

    public void create() {
        this.getCdao().insert(this.yonetim_personeli);
        this.yonetim_personeli = new yonetim_personeli();

    }
    
    public String deleteConfirm(yonetim_personeli cat) {
        this.yonetim_personeli = cat;
        return "delete_yonetim_personeli";
    }

    public yonetim_personeliController() {
        this.cList = new ArrayList();
        cdao = new yonetim_personeliDAO();
    }

    public List<yonetim_personeli> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<yonetim_personeli> cList) {
        this.cList = cList;
    }

    public yonetim_personeliDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new yonetim_personeliDAO();
        }
        return cdao;
    }

    public void setCdao(yonetim_personeliDAO cdao) {
        this.cdao = cdao;
    }

    public yonetim_personeli getCategory() {
        if (this.yonetim_personeli == null) {
            this.yonetim_personeli = new yonetim_personeli();
        }
        return yonetim_personeli;
    }

    public void setCategory(yonetim_personeli yonetim_personeli) {
        this.yonetim_personeli = yonetim_personeli;
    }

}
