package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Tietokanta {

    private String osoite;

    public Tietokanta(String osoite) throws ClassNotFoundException {
        this.osoite = osoite;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.osoite);
    }
}
