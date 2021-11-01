/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.temizlik_personeli;
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
public class temizlik_personeliDAO {

    private Connector connector;
    private Connection connection;

    public List<temizlik_personeli> getCategories() {
        List<temizlik_personeli> CategoryList = new ArrayList();
        try {

            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from temizlik_personeli");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                temizlik_personeli tmp = new temizlik_personeli(rs.getString("tc"), rs.getString("isim"), rs.getString("telefon_no"), rs.getInt("maas"), rs.getInt("kat_numarasi"), rs.getString("muhaseip_tc"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(temizlik_personeli temizlik_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into temizlik_personeli "
                    + "(tc,isim,telefon_no,maas,kat_numarasi,muhaseip_tc) values(?,?,?,?,?,?)");

            pst.setString(1, temizlik_personeli.getTc());
            pst.setString(2, temizlik_personeli.getIsim());
            pst.setString(3, temizlik_personeli.getTelefon_no());
            pst.setInt(4, temizlik_personeli.getMaas());
            pst.setInt(5, temizlik_personeli.getKat_numarasi());
            pst.setString(6, temizlik_personeli.getMuhaseip_tc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(temizlik_personeli cat) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from temizlik_personeli where tc=?");
            pst.setString(1, cat.getTc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(temizlik_personeli temizlik_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update temizlik_personeli"
                    + " set  isim=?, telefon_no=? ,maas=? ,kat_numarasi=? ,muhaseip_tc=?  where tc=?");
            pst.setString(1, temizlik_personeli.getIsim());
            pst.setString(2, temizlik_personeli.getTelefon_no());
            pst.setInt(3, temizlik_personeli.getMaas());
            pst.setInt(4, temizlik_personeli.getKat_numarasi());
            pst.setString(5, temizlik_personeli.getMuhaseip_tc());
            pst.setString(6, temizlik_personeli.getTc());
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
