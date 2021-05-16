/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.dao;
import fi.breakout.logics.Breakout;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * Luokka pelitilastojen käsittelyyn. 
 * @author Oskari
 */
public class Statistics {
    private Connection connection;
    private String database;
    public DescriptiveStatistics stats;
    
    
    public Statistics(String databaseName) {
        this.database = databaseName;
        this.connection = connect(databaseName);
        this.stats = new DescriptiveStatistics();
        createTable();
    }
    
    /**
     * Metodi lisää pelaajan tuloksen tietokantaan
     * @param username pelaajan antama nimimerkki
     * @param score pelaajan pistemäärä
     * @throws SQLException 
     */
    public void addResult(String username, int score) throws SQLException {
        String statement = "INSERT INTO Statistics (name, score) VALUES (?, ?);";
        try (PreparedStatement pstmt = connection.prepareStatement(statement)) {
            pstmt.setString(1, username);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Metodi laskee keskiarvon talletetuista tuloksista. 
     * @return mean tulosten keskiarvo
     */
    public double getMean() {
        double mean = this.stats.getMean();
        return mean;
    }
    /**
     * Luo uuden yhteyden sovelluksen ja tietokannan välille ja luo tietokantatiedoston.
     * @param database tietokannan nimi
     * @return 
     */
    private Connection connect(String database) {
        Connection c = null;

        try {
            c = DriverManager.getConnection(database);
            DatabaseMetaData meta = c.getMetaData();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return c;
    }
    /**
     * Metodi luo uuden tietokantataulun, mikäli sellaista ei vielä ole olemassa. 
     */
    private void createTable() {
        String createDb = "CREATE TABLE IF NOT EXISTS Statistics (id INTEGER PRIMARY KEY, name TEXT, score INTEGER);";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createDb);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * metodi hakee listaolioon tietokannasta pelitulokset
     * @return list lista, jossa pelaajien nimet ja tulokset merkkijonoina.
     */
    public List<String> getResults() {
        List<String> list = new ArrayList<>();
        this.stats.clear();
        String results = "SELECT name, score FROM Statistics ORDER BY score DESC;";

        try (PreparedStatement pstmt = connection.prepareStatement(results)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int score = rs.getInt("score");
                String player = rs.getString("name");
                list.add(player + "\t" + score);
                this.stats.addValue(score);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
}


