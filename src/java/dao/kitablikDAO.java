/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.kitablik;
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
public class kitablikDAO {

    private Connector connector;
    private Connection connection;

    public List<kitablik> getCategories() {
        List<kitablik> CategoryList = new ArrayList();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kitablik");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                kitablik tmp = new kitablik(rs.getInt("kitap_id"), rs.getString("kitap_adi"), rs.getString("yazar"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(kitablik kitablik) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into kitablik"
                    + " (kitap_id,kitap_adi,yazar) values(?,?,?)");
            pst.setInt(1, kitablik.getKitap_id());
            pst.setString(2, kitablik.getKitap_adi());
            pst.setString(3, kitablik.getYazar());

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(kitablik cat) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from kitablik where kitap_id=" + cat.getKitap_id());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(kitablik kitablik) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("update kitablik set kitap_adi='" + kitablik.getKitap_adi() + "'where kitap_id=" + kitablik.getKitap_id());
            st.executeUpdate("update kitablik set yazar='" + kitablik.getYazar() + "'where kitap_id=" + kitablik.getKitap_id());

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
