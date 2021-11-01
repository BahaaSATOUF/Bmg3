
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.etkinlik;
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
public class etkinlikDAO {

    private Connector connector;
    private Connection connection;

    public List<etkinlik> getCategories() {
        List<etkinlik> CategoryList = new ArrayList();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from etkinlik");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                etkinlik tmp = new etkinlik(rs.getInt("etkinlik_id"), rs.getString("sunan_hoca"), rs.getString("etkinlik_turu"), rs.getString("aciklama"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(etkinlik etkinlik) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into etkinlik"
                    + " (etkinlik_id,sunan_hoca,etkinlik_turu,aciklama) values(?,?,?,?)");
            pst.setInt(1, etkinlik.getEtkinlik_id());
            pst.setString(2, etkinlik.getSunan_hoca());
            pst.setString(3, etkinlik.getEtkinlik_turu());
            pst.setString(4, etkinlik.getAciklama());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(etkinlik cat) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from etkinlik where etkinlik_id=" + cat.getEtkinlik_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(etkinlik etkinlik) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update etkinlik"
                    + " set etkinlik_id=?, sunan_hoca=?, etkinlik_turu=? ,aciklama=? where etkinlik_id=?");
            pst.setInt(1, etkinlik.getEtkinlik_id());
            pst.setString(2, etkinlik.getSunan_hoca());
            pst.setString(3, etkinlik.getEtkinlik_turu());
            pst.setString(4, etkinlik.getAciklama());
            pst.setInt(5, etkinlik.getEtkinlik_id());

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
