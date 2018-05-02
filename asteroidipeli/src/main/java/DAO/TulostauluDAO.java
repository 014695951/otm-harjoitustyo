package DAO;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TulostauluDAO implements DAO {

    private Tietokanta tietokanta;
    private List<Nimimerkki> nimerkit;

    public TulostauluDAO(Nimimerkki nimimerkki, Tietokanta tietokanta) {
        this.tietokanta = tietokanta;

    }

    public List<Nimimerkki> getAll() {

        List<Nimimerkki> nimimerkit = new ArrayList();

        try {

            Connection yhteys = this.tietokanta.getConnection();
            PreparedStatement stmt = yhteys.prepareStatement("SELECT * FROM Tulostaulukko");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                nimimerkit.add(new Nimimerkki(rs.getString(1), rs.getInt(2), rs.getInt(0)));

            }

            return nimimerkit;

        } catch (SQLException ex) {
            return null;
        }

    }

    @Override
    public void delete(Integer avain) {

        try {
            Connection yhteys = this.tietokanta.getConnection();
            PreparedStatement stmt = yhteys.prepareStatement("DELETE FROM Tulostaulukko WHERE id = avain");

            stmt.setInt(1, avain);
            stmt.executeUpdate();

            stmt.close();
            yhteys.close();

        } catch (SQLException ex) {

        }

    }

    @Override

    public void create(Nimimerkki nimimerkki) {

        try {
            Connection yhteys = this.tietokanta.getConnection();
            String nimi = nimimerkki.getNimi();
            int pisteet = nimimerkki.getPisteet();

            PreparedStatement stmt = yhteys.prepareStatement("INSERT INTO Tulostaulukko (nimimerkki, pisteet) VALUES ('nimi', pisteet)");

            stmt.close();
            yhteys.close();

        } catch (SQLException ex) {

        }

    }

}
