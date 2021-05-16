/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.test;

import fi.breakout.dao.Statistics;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari
 */
public class StatisticsTest {
    private Statistics stats;
    @Before
    public void setUp() throws Exception {
        this.stats = new Statistics("jdbc:sqlite:testdatabase.db");
        
    }
    
    @Test
    public void databaseSavesResultCorrect() throws SQLException {
        this.stats.addResult("test", 10);
        assertEquals("test" + "\t" + "10", stats.getResults().get(0));
    }
    
    @Test
    public void meanIsCorrect() {
       this.stats.stats.addValue(1);
       this.stats.stats.addValue(3);
       assertEquals(2, this.stats.getMean(), 0.1);
    }
    
   
}
