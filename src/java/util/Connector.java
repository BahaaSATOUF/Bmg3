

package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Connector {

    public Connection connect() {
        Connection c = null;

        try {


            Class.forName("org.postgresql.Driver").newInstance();
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/YurtSistemi","postgres","123");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println( ex.getMessage());
        }

        return c;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
