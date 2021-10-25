/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.odeme;
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
public class odemeDAO {

    private Connector connector;
    private Connection connection;

    public List<odeme> getCategories() {
        List<odeme> CategoryList = new ArrayList();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from odeme");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                odeme tmp = new odeme(rs.getInt("ogrenci_no"), rs.getString("muhsip_tc"), rs.getString("odeme_miktari"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(odeme odeme) {
        System.err.println("00000000000000000000000000000000000000000000000000000000000000000");
        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into odeme"
                    + " (ogrenci_no,muhsip_tc,odeme_miktari) values(?,?,?)");
            pst.setInt(1, odeme.getOgrenci_no());
            pst.setString(2, odeme.getMuhsip_tc());
            pst.setString(3, odeme.getOdeme_miktari());
            

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(odeme cat) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from odeme where ogrenci_no=" + cat.getOgrenci_no());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(odeme odeme) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update odeme"
                    + " set ogrenci_no=?, muhsip_tc=?, odeme_miktari=?  where ogrenci_no=?");
            pst.setInt(1, odeme.getOgrenci_no());
            pst.setString(2, odeme.getMuhsip_tc());
            pst.setString(3, odeme.getOdeme_miktari());
            pst.setInt(4, odeme.getOgrenci_no());
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
