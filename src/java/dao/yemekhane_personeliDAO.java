

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.yemekhane_personeli;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Connector;


public class yemekhane_personeliDAO {
    

    private Connector connector;
    private Connection connection;

    
      public List<yemekhane_personeli> getCategories() {
        List<yemekhane_personeli> CategoryList = new ArrayList();
        try {
            Statement st = this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from yemekhane_personeli");
            while (rs.next()) {              
                yemekhane_personeli tmp = new yemekhane_personeli(rs.getString("tc"), rs.getString("isim"), rs.getString("telefon_no"), rs.getInt("maas"),rs.getString("muhasip_tc"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }
   

    public void insert(yemekhane_personeli yemekhane_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("insert into yemekhane_personeli "
                    + "(tc,isim,telefon_no,maas,muhasip_tc) values(?,?,?,?,?)");

            pst.setString(1, yemekhane_personeli.getTc());
            pst.setString(2, yemekhane_personeli.getIsim());
            pst.setString(3, yemekhane_personeli.getTelefon_no());
            pst.setInt(4, yemekhane_personeli.getMaas());
            pst.setString(5, yemekhane_personeli.getmuhasip_tc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(yemekhane_personeli cat) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("delete from yemekhane_personeli where tc=?");
            pst.setString(1, cat.getTc());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(yemekhane_personeli yemekhane_personeli) {

        try {
            PreparedStatement pst = this.getConnection().prepareStatement("update yemekhane_personeli"
                    + " set  isim=?, telefon_no=? ,maas=? ,muhasip_tc=?  where tc=?");
            pst.setString(1, yemekhane_personeli.getIsim());
            pst.setString(2, yemekhane_personeli.getTelefon_no());
            pst.setInt(3, yemekhane_personeli.getMaas());
            pst.setString(4, yemekhane_personeli.getmuhasip_tc());
            pst.setString(5, yemekhane_personeli.getTc());
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
