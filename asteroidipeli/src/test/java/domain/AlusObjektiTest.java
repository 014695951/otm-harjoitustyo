package domain;

import domain.AlusObjekti;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

    }

    @After
    public void tearDown() {
    }

    @Test
    public void ovatkoAloitusKoordinaatitOikein() {
        AlusObjekti alus = new AlusObjekti(500, 500);

        assertEquals((double) 500, alus.getKuva().getTranslateX(), 0.01);
        assertEquals((double) 500, alus.getKuva().getTranslateY(), 0.01);
    }

    @Test
    public void toimiikoUpdate() {

    }

    @Test
    public void toimiikoYlos() {
        AlusObjekti alus = new AlusObjekti(500, 500);
        alus.ylos();

        assertEquals(new Point2D(0, -0.1), alus.getNopeus());

    }

    @Test
    public void toimiikoAlas() {
        AlusObjekti alus = new AlusObjekti(500, 500);
        alus.alas();

        assertEquals(new Point2D(0, 0.1), alus.getNopeus());

    }

    @Test
    public void toimiikoVasen() {
        AlusObjekti alus = new AlusObjekti(500, 500);
        alus.vasemmalle();

        assertEquals(new Point2D(-0.1, 0), alus.getNopeus());

    }

    @Test
    public void toimiikoOikea() {
        AlusObjekti alus = new AlusObjekti(500, 500);
        alus.oikealle();
        assertEquals(new Point2D(0.1, 0), alus.getNopeus());

    }

}
