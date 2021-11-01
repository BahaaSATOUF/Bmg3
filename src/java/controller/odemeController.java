


package controller;

import dao.odemeDAO;
import entity.odeme;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class odemeController implements Serializable {

    private List<odeme> cList;
    private odemeDAO cdao;
    private odeme odeme;

    public void updateFrom(odeme cat) {
        this.odeme = cat;
    }

    public void update() {
        this.getCdao().update(this.odeme);
        this.odeme = new odeme();
    }

    public String clearForm() {
        this.odeme = new odeme();
        return "odeme";
    }

    public String delete() {
        this.getCdao().delete(this.odeme);
        this.odeme = new odeme();
        return "odeme";
    }

    public void create() {
        this.getCdao().insert(this.odeme);
        this.odeme = new odeme();

    }

    public String deleteConfirm(odeme cat) {
        this.odeme = cat;
        return "delete_odeme";
    }

    public odemeController() {
        this.cList = new ArrayList();
        cdao = new odemeDAO();
    }

    public List<odeme> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<odeme> cList) {
        this.cList = cList;
    }

    public odemeDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new odemeDAO();
        }
        return cdao;
    }

    public void setCdao(odemeDAO cdao) {
        this.cdao = cdao;
    }

    public odeme getCategory() {
        if (this.odeme == null) {
            this.odeme = new odeme();
        }
        return odeme;
    }

    public void setCategory(odeme odeme) {
        this.odeme = odeme;
    }

}
