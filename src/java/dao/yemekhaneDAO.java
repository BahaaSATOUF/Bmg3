/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yemekhane;
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
public class yemekhaneDAO {

    private Connector connector;
    private Connection connection;

    public List<yemekhane> getCategories() {
        List<yemekhane> CategoryList = new ArrayList();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from yemekhane");
            while (rs.next()) {

                yemekhane tmp = new yemekhane(rs.getString("yemek_listesi"), rs.getDate("tarih"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(yemekhane yemekhane) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into yemekhane "
                    + "(yemek_listesi,tarih) values(?,?)");
            pst.setString(1, yemekhane.getYemek_listesi());
            pst.setDate(2, yemekhane.getTarih());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(yemekhane cat) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from yemekhane where tarih=?");
            pst.setDate(1, cat.getTarih());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(yemekhane yemekhane) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update yemekhane"
                    + " set  yemek_listesi=? ,tarih=?  where tarih=?");
            pst.setString(1, yemekhane.getYemek_listesi());
            pst.setDate(2, yemekhane.getTarih());
            pst.setDate(3, yemekhane.getTarih());
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
