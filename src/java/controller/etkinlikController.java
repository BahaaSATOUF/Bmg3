

package controller;

import dao.etkinlikDAO;
import entity.etkinlik;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class etkinlikController implements Serializable {

    private List<etkinlik> cList;
    private etkinlikDAO cdao;
    private etkinlik etkinlik;

    public void updateFrom(etkinlik cat) {
        this.etkinlik = cat;
    }

    public void update() {
        this.getCdao().update(this.etkinlik);
        this.etkinlik = new etkinlik();
    }

    public String clearForm() {
        this.etkinlik = new etkinlik();
        return "etkinlik";
    }

    public String delete() {
        this.getCdao().delete(this.etkinlik);
        this.etkinlik = new etkinlik();
        return "etkinlik";
    }

    public void create() {
        this.getCdao().insert(this.etkinlik);
        this.etkinlik = new etkinlik();

    }

    public String deleteConfirm(etkinlik cat) {
        this.etkinlik = cat;
        return "delete_etkinlik";
    }

    public etkinlikController() {
        this.cList = new ArrayList();
        cdao = new etkinlikDAO();
    }

    public List<etkinlik> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<etkinlik> cList) {
        this.cList = cList;
    }

    public etkinlikDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new etkinlikDAO();
        }
        return cdao;
    }

    public void setCdao(etkinlikDAO cdao) {
        this.cdao = cdao;
    }

    public etkinlik getCategory() {
        if (this.etkinlik == null) {
            this.etkinlik = new etkinlik();
        }
        return etkinlik;
    }

    public void setCategory(etkinlik etkinlik) {
        this.etkinlik = etkinlik;
    }

}
