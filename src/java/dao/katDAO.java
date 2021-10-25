/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.kat;
import java.sql.Connection;
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
public class katDAO {

    private Connector connector;
    private Connection connection;

    public List<kat> getCategories() {
        List<kat> CategoryList = new ArrayList();
        try {
           
            Statement st =  this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from kat");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                kat tmp = new kat(rs.getInt("kat_numarasi"),rs.getInt("oda_sayisi"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(kat kat) {
        try {
            Statement st =  this.getConnection().createStatement();
            st.executeUpdate("insert into kat (kat_numarasi,oda_sayisi)"
                    + " values (" + kat.getKat_numarasi() + "," + kat.getOda_sayisi()  + ")");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(kat cat) {
        try {
            Statement st =  this.getConnection().createStatement();
            st.executeUpdate("delete from kat where kat_numarasi=" + cat.getKat_numarasi());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(kat kat) {
        try {

            Statement st =  this.getConnection().createStatement();
            st.executeUpdate("update kat set oda_sayisi='" + kat.getOda_sayisi() + "'where kat_numarasi=" + kat.getKat_numarasi());
           
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
