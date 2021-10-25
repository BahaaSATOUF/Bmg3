/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.oda;
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
public class odaDAO {

    private Connector connector;
    private Connection connection;

    public List<oda> getCategories() {
        List<oda> CategoryList = new ArrayList();
        try {
           
            Statement st =  this.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from oda");
            while (rs.next()) {
                // System.out.println( rs.getString("name"));
                oda tmp = new oda(rs.getInt("oda_numarasi"),rs.getInt("yatak_sayisi"), rs.getInt("kat_numarasi"));
                CategoryList.add(tmp);
                System.out.println(tmp);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return CategoryList;
    }

    public void insert(oda oda) {
        try {
            Statement st =  this.getConnection().createStatement();
            st.executeUpdate("insert into oda (oda_numarasi,yatak_sayisi,kat_numarasi)"
                    + " values (" + oda.getOda_numarasi() + "," + oda.getYatak_sayisi()+ "," + oda.getKat_numarasi() + ")");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(oda cat) {
        try {
            Statement st =  this.getConnection().createStatement();
            st.executeUpdate("delete from oda where oda_numarasi=" + cat.getOda_numarasi());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(oda oda) {
        try {

            Statement st =  this.getConnection().createStatement();
            st.executeUpdate("update oda set yatak_sayisi='" + oda.getYatak_sayisi() + "'where oda_numarasi=" + oda.getOda_numarasi());
            st.executeUpdate("update oda set kat_numarasi='" + oda.getKat_numarasi()+ "'where oda_numarasi=" + oda.getOda_numarasi());
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
