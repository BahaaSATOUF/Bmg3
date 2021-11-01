
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.spor_salonuDAO;
import entity.spor_salonu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;




@Named
@SessionScoped
public class spor_salonuController implements Serializable {

    private List<spor_salonu> cList;
    private spor_salonuDAO cdao;
    private spor_salonu spor_salonu;

    public void updateFrom(spor_salonu cat) {
        this.spor_salonu = cat;
    }

    public void update() {   
        this.getCdao().update(this.spor_salonu);
        this.spor_salonu = new spor_salonu();
    }

    public String clearForm() {
        this.spor_salonu = new spor_salonu();
        return "spor_salonu";
    }

    public String delete() {
        this.getCdao().delete(this.spor_salonu);
        this.spor_salonu = new spor_salonu();
        return "spor_salonu";
    }

    public void create() {
        this.getCdao().insert(this.spor_salonu);
        this.spor_salonu = new spor_salonu();

    }
    
    public String deleteConfirm(spor_salonu cat) {
        this.spor_salonu = cat;
        return "delete_spor_salonu";
    }

    public spor_salonuController() {
        this.cList = new ArrayList();
        cdao = new spor_salonuDAO();
    }

    public List<spor_salonu> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<spor_salonu> cList) {
        this.cList = cList;
    }

    public spor_salonuDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new spor_salonuDAO();
        }
        return cdao;
    }

    public void setCdao(spor_salonuDAO cdao) {
        this.cdao = cdao;
    }

    public spor_salonu getCategory() {
        if (this.spor_salonu == null) {
            this.spor_salonu = new spor_salonu();
        }
        return spor_salonu;
    }

    public void setCategory(spor_salonu spor_salonu) {
        this.spor_salonu = spor_salonu;
    }

}
