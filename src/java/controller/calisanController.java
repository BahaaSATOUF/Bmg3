
package controller;

import dao.calisanDAO;
import entity.calisan;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;





@Named
@SessionScoped
public class calisanController implements Serializable {

    private List<calisan> cList;
    private calisanDAO cdao;
    private calisan calisan;

    public void updateFrom(calisan cat) {
        this.calisan = cat;
    }

    public void update() {
        this.getCdao().update(this.calisan);
        this.calisan = new calisan();
    }

    public String clearForm() {
        this.calisan = new calisan();
        return "calisan";
    }

    public String delete() {
        this.getCdao().delete(this.calisan);
        this.calisan = new calisan();
        return "calisan";
    }

    public void create() {
      this.getCdao().insert(this.calisan);
        this.calisan = new calisan();
    }
    
     public String deleteConfirm(calisan cat) {
        this.calisan = cat;
        return "delete_calisan";
    }

    public calisanController() {
        this.cList = new ArrayList();
        cdao = new calisanDAO();
    }

    public List<calisan> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<calisan> cList) {
        this.cList = cList;
    }

    public calisanDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new calisanDAO();
        }
        return cdao;
    }

    public void setCdao(calisanDAO cdao) {
        this.cdao = cdao;
    }

    public calisan getCategory() {
        if (this.calisan == null) {
            this.calisan = new calisan();
        }
        return calisan;
    }

    public void setCategory(calisan calisan) {
        this.calisan = calisan;
    }

}
