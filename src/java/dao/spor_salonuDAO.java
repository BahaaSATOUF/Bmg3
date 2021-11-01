/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.spor_salonu;
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
public class spor_salonuDAO {

    private Connector connector;
    private Connection connection;

    public List<spor_salonu> getCategories() {
        List<spor_salonu> CategoryList = new ArrayList();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from spor_salonu");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                spor_salonu tmp = new spor_salonu(rs.getInt("id_spor"), rs.getDate("gun"), rs.getTime("saat"), rs.getString("spor_turu"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(spor_salonu spor_salonu) {
        System.err.println("dddddddddddddddddddddd");
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into spor_salonu"
                    + " (id_spor,gun,saat,spor_turu) values(?,?,?,?)");
            pst.setInt(1, spor_salonu.getId_spor());
            pst.setDate(2, spor_salonu.getGun());
            pst.setTime(3, spor_salonu.getSaat());
            pst.setString(4, spor_salonu.getSpor_turu());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(spor_salonu cat) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from spor_salonu where id_spor=" + cat.getId_spor());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(spor_salonu spor_salonu) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update spor_salonu"
                    + " set id_spor=?, gun=?, saat=? ,spor_turu=? where id_spor=?");
            pst.setInt(1, spor_salonu.getId_spor());
            pst.setDate(2, spor_salonu.getGun());
            pst.setTime(3, spor_salonu.getSaat());
            pst.setString(4, spor_salonu.getSpor_turu());
              pst.setInt(5, spor_salonu.getId_spor());
            

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
