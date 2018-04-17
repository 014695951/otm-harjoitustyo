package domain;

import javafx.geometry.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliObjektiTest {

    public PeliObjektiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void onkoElossaAlussa() {
        PeliObjekti objekti = new PeliObjekti(10, 10);        
        assertEquals(true, objekti.elossa());
    }

    @Test
    public void toimiikoSetElossa() {
        PeliObjekti objekti = new PeliObjekti(10, 10);
        objekti.setElossa(false);            
        
        assertEquals(false, objekti.elossa());
    }
    
    @Test
    public void setNopeusToimii() {
        PeliObjekti objekti = new PeliObjekti(10, 10); 
        objekti.setNopeus(new Point2D(10, 10));
        
        assertEquals(new Point2D(10, 10), objekti.getNopeus());
        
    }
    
    @Test
    public void tormaaToimii() {
        PeliObjekti objektiA = new PeliObjekti(10, 10);
        PeliObjekti objektiB = new PeliObjekti(10, 10);        
        
        assertEquals(true, objektiA.tormaa(objektiB));

    }
    
    

}
