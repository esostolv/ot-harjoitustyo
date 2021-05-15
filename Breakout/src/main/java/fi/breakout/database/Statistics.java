/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.database;
import fi.breakout.logics.Breakout;
import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.Properties;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author Oskari
 */
public class Statistics {
    private Connection connection;
    
    
    public void createDatabase() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            DatabaseMetaData meta = connection.getMetaData();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        String createDatabase = "CREATE TABLE IF NOT EXISTS Statistics(name STRING PRIMARY KEY, score INTEGER);";
        try (Statement statement = this.connection.createStatement()) {
            statement.execute(createDatabase);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addResult(String name, int score) throws SQLException {
        try (Connection db = DriverManager.getConnection("jdbc:sqlite:collection.db")) {
            PreparedStatement prep = db.prepareStatement("INSERT INTO Statistics(name, score) VALUES(?,?)");
            prep.setString(1, name);
            prep.setInt(2, score);
            prep.executeUpdate();
        } catch (Exception e) {
            System.out.println("Tallennus epäonnistui. ");
        }
    }
    
    public void read() throws SQLException {
        try (Connection db = DriverManager.getConnection("jdbc:sqlite:collection.db")) {
            PreparedStatement prep = db.prepareStatement("SELECT * FROM Statistics \n"
                    + "ORDER BY score DESC");
        }
    }
    
    
    
    public double getMean() {
        DescriptiveStatistics stats = new DescriptiveStatistics();
        double mean = stats.getMean();
        return mean;
    }
    
    
}


