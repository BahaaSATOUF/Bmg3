/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.kural;
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
 * @author nabilo
 */
public class kuralDAO {

    private Connector connector;
    private Connection connection;

    public List<kural> getCategories() {
        List<kural> CategoryList = new ArrayList();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kural");
            while (rs.next()) {

                kural tmp = new kural(rs.getInt("kural_id"), rs.getString("aciklama"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(kural kural) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into kural "
                    + "(kural_id,aciklama) values(?,?)");
            pst.setInt(1, kural.getKural_id());
            pst.setString(2, kural.getAciklama());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(kural cat) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from kural where kural_id=?");
            pst.setInt(1, cat.getKural_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(kural kural) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update kural"
                    + " set  aciklama=?  where kural_id=?");
            pst.setString(1, kural.getAciklama());
            pst.setInt(2, kural.getKural_id());
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
