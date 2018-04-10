
import asteroidipeli.AlusObjekti;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class AlusObjektiTest {
    AlusObjekti alus;
    
    public AlusObjektiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Canvas kanvaasi = new Canvas(700, 700);
        GraphicsContext piirturi = kanvaasi.getGraphicsContext2D();
        this.alus = new AlusObjekti(piirturi);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void ovatkoAloitusKoordinaatitOikein() {
        assertEquals((double) 300, alus.getX(), 0.01);
        assertEquals((double) 300, alus.getY(), 0.01);       
    }
}
