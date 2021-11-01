/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yonetim_personeli;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;


public class yonetim_personeliDAO {

    private Connector connector;
    private Connection connection;

    
      public List<yonetim_personeli> getCategories() {
        List<yonetim_personeli> CategoryList = new ArrayList();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from yonetim_personeli");
            while (rs.next()) {              
                yonetim_personeli tmp = new yonetim_personeli(rs.getString("tc"), rs.getString("isim"), rs.getString("telefon_no"), rs.getInt("maas"),rs.getString("muhasip_tc"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }
   

    public void insert(yonetim_personeli yonetim_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into yonetim_personeli "
                    + "(tc,isim,telefon_no,maas,muhasip_tc) values(?,?,?,?,?)");

            pst.setString(1, yonetim_personeli.getTc());
            pst.setString(2, yonetim_personeli.getIsim());
            pst.setString(3, yonetim_personeli.getTelefon_no());
            pst.setInt(4, yonetim_personeli.getMaas());
            pst.setString(5, yonetim_personeli.getmuhasip_tc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(yonetim_personeli cat) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from yonetim_personeli where tc=?");
            pst.setString(1, cat.getTc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(yonetim_personeli yonetim_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update yonetim_personeli"
                    + " set  isim=?, telefon_no=? ,maas=? ,muhasip_tc=?  where tc=?");
            pst.setString(1, yonetim_personeli.getIsim());
            pst.setString(2, yonetim_personeli.getTelefon_no());
            pst.setInt(3, yonetim_personeli.getMaas());
            pst.setString(4, yonetim_personeli.getmuhasip_tc());
            pst.setString(5, yonetim_personeli.getTc());
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
