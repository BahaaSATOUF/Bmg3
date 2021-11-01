/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.temizlik_personeliDAO;
import entity.temizlik_personeli;
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
public class temizlik_personeliController implements Serializable {

    private List<temizlik_personeli> cList;
    private temizlik_personeliDAO cdao;
    private temizlik_personeli temizlik_personeli;

    public void updateFrom(temizlik_personeli cat) {
        this.temizlik_personeli = cat;
    }

    public void update() {
        this.getCdao().update(this.temizlik_personeli);
        this.temizlik_personeli = new temizlik_personeli();
    }

    public String clearForm() {
        this.temizlik_personeli = new temizlik_personeli();
        return "temizlik_personeli";
    }

    public String delete() {
        this.getCdao().delete(this.temizlik_personeli);
        this.temizlik_personeli = new temizlik_personeli();
        return "temizlik_personeli";
    }

    public void create() {
        this.getCdao().insert(this.temizlik_personeli);
        this.temizlik_personeli = new temizlik_personeli();

    }
    
    public String deleteConfirm(temizlik_personeli cat) {
        this.temizlik_personeli = cat;
        return "delete_temizlik_personeli";
    }

    public temizlik_personeliController() {
        this.cList = new ArrayList();
        cdao = new temizlik_personeliDAO();
    }

    public List<temizlik_personeli> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<temizlik_personeli> cList) {
        this.cList = cList;
    }

    public temizlik_personeliDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new temizlik_personeliDAO();
        }
        return cdao;
    }

    public void setCdao(temizlik_personeliDAO cdao) {
        this.cdao = cdao;
    }

    public temizlik_personeli getCategory() {
        if (this.temizlik_personeli == null) {
            this.temizlik_personeli = new temizlik_personeli();
        }
        return temizlik_personeli;
    }

    public void setCategory(temizlik_personeli temizlik_personeli) {
        this.temizlik_personeli = temizlik_personeli;
    }

}
