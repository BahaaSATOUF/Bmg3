/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.muhasebe_personeli;
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
public class muhasebe_personeliDAO {

    private Connector connector;
    private Connection connection;

    public List<muhasebe_personeli> getCategories() {
        List<muhasebe_personeli> CategoryList = new ArrayList();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from muhasebe_personeli");
            while (rs.next()) {

                muhasebe_personeli tmp = new muhasebe_personeli(rs.getString("tc"), rs.getString("isim"), rs.getString("telefon_no"), rs.getInt("maas"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(muhasebe_personeli muhasebe_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into muhasebe_personeli"
                    + " (tc,isim,telefon_no,maas) values(?,?,?,?)");

            pst.setString(1, muhasebe_personeli.getTc());
            pst.setString(2, muhasebe_personeli.getIsim());
            pst.setString(3, muhasebe_personeli.getTelefon_no());
            pst.setInt(4, muhasebe_personeli.getMaas());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(muhasebe_personeli cat) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from muhasebe_personeli where tc =?");
            pst.setString(1, cat.getTc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(muhasebe_personeli muhasebe_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update muhasebe_personeli"
                    + " set isim=?, telefon_no=? ,maas=? where tc=?");
            pst.setString(1, muhasebe_personeli.getIsim());
            pst.setString(2, muhasebe_personeli.getTelefon_no());
            pst.setInt(3, muhasebe_personeli.getMaas());
            pst.setString(4, muhasebe_personeli.getTc());

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
