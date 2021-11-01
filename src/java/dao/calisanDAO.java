package dao;

import entity.calisan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;

/**
 *
 * @author Bahaa
 */
public class calisanDAO {

    private Connector connector;
    private Connection connection;

    public List<calisan> getCategories() {
        List<calisan> CategoryList = new ArrayList();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from calisan");
            while (rs.next()) {

                calisan tmp = new calisan(rs.getString("tc"), rs.getString("isim"), rs.getString("telefon_no"), rs.getInt("maas"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(calisan calisan) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into calisan"
                    + " (tc,isim,telefon_no,maas) values(?,?,?,?)");

            pst.setString(1, calisan.getTc());
            pst.setString(2, calisan.getIsim());
            pst.setString(3, calisan.getTelefon_no());
            pst.setInt(4, calisan.getMaas());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(calisan cat) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from calisan where tc =?");
            pst.setString(1, cat.getTc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(calisan calisan) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update calisan"
                    + " set isim=?, telefon_no=? ,maas=? where tc=?");
            pst.setString(1, calisan.getIsim());
            pst.setString(2, calisan.getTelefon_no());
            pst.setInt(3, calisan.getMaas());
            pst.setString(4, calisan.getTc());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Connector getConnector() {
        if (this.connector == null) {
            this.connector = new Connector();
        }
        return connector;
    }

    public Connection getConnection() {
        if (this.connection == null) {
            this.connection = this.getConnector().connect();
        }
        return connection;
    }
}
