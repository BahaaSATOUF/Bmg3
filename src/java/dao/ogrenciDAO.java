/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.ogrenci;
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
public class ogrenciDAO {

    private Connector connector;
    private Connection connection;

    public List<ogrenci> getCategories() {
        List<ogrenci> CategoryList = new ArrayList();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from ogrenci");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                ogrenci tmp = new ogrenci(rs.getInt("ogrenci_no"), rs.getString("ogrenci_adi"), rs.getString("ogrenci_soyad"), rs.getString("telefon_no"), rs.getInt("oda_numarasi"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(ogrenci ogrenci) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into ogrenci"
                    + " (ogrenci_no,ogrenci_adi,ogrenci_soyad,telefon_no,oda_numarasi) values(?,?,?,?,?)");
            pst.setInt(1, ogrenci.getOgrenci_no());
            pst.setString(2, ogrenci.getOgrenci_adi());
            pst.setString(3, ogrenci.getOgrenci_soyad());
            pst.setString(4, ogrenci.getTelefon_no());
            pst.setInt(5, ogrenci.getOda_numarasi());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(ogrenci cat) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from ogrenci where ogrenci_no=" + cat.getOgrenci_no());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(ogrenci ogrenci) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update ogrenci"
                    + " set ogrenci_no=?, ogrenci_adi=?, ogrenci_soyad=? ,telefon_no=?,oda_numarasi=? where ogrenci_no=?");
            pst.setInt(1, ogrenci.getOgrenci_no());
            pst.setString(2, ogrenci.getOgrenci_adi());
            pst.setString(3, ogrenci.getOgrenci_soyad());
            pst.setString(4, ogrenci.getTelefon_no());
            pst.setInt(5, ogrenci.getOda_numarasi());
            pst.setInt(6, ogrenci.getOgrenci_no());

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
