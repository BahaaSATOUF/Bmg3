


package controller;

import dao.muhasebe_personeliDAO;
import entity.muhasebe_personeli;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;





@Named
@SessionScoped
public class muhasebe_personeliController implements Serializable {

    private List<muhasebe_personeli> cList;
    private muhasebe_personeliDAO cdao;
    private muhasebe_personeli muhasebe_personeli;

    public void updateFrom(muhasebe_personeli cat) {
        this.muhasebe_personeli = cat;
    }

    public void update() {
        this.getCdao().update(this.muhasebe_personeli);
        this.muhasebe_personeli = new muhasebe_personeli();
    }

    public String clearForm() {
        this.muhasebe_personeli = new muhasebe_personeli();
        return "muhasebe_personeli";
    }

    public String delete() {
        this.getCdao().delete(this.muhasebe_personeli);
        this.muhasebe_personeli = new muhasebe_personeli();
        return "muhasebe_personeli";
    }

    public void create() {
      this.getCdao().insert(this.muhasebe_personeli);
        this.muhasebe_personeli = new muhasebe_personeli();
    }
    
     public String deleteConfirm(muhasebe_personeli cat) {
        this.muhasebe_personeli = cat;
        return "delete_muhasebe_personeli";
    }

    public muhasebe_personeliController() {
        this.cList = new ArrayList();
        cdao = new muhasebe_personeliDAO();
    }

    public List<muhasebe_personeli> getCList() {
        this.cList = this.getCdao().getCategories();
        return cList;
    }

    public void setcList(List<muhasebe_personeli> cList) {
        this.cList = cList;
    }

    public muhasebe_personeliDAO getCdao() {
        if (this.cdao == null) {
            this.cdao = new muhasebe_personeliDAO();
        }
        return cdao;
    }

    public void setCdao(muhasebe_personeliDAO cdao) {
        this.cdao = cdao;
    }

    public muhasebe_personeli getCategory() {
        if (this.muhasebe_personeli == null) {
            this.muhasebe_personeli = new muhasebe_personeli();
        }
        return muhasebe_personeli;
    }

    public void setCategory(muhasebe_personeli muhasebe_personeli) {
        this.muhasebe_personeli = muhasebe_personeli;
    }

}
