package domain;

import domain.AlusObjekti;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AlusObjektiTest {

    AlusObjekti alus;
    Pane juuri;

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
        this.juuri = new Pane();
        this.juuri.setPrefSize(1000, 1000);
//        this.alus = new AlusObjekti(500, 500);
        alus.setNopeus(new Point2D(Math.random(), Math.random()));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ovatkoAloitusKoordinaatitOikein() {

        assertEquals((double) 500, alus.getKuva().getTranslateX(), 0.01);
        assertEquals((double) 500, alus.getKuva().getTranslateY(), 0.01);
    }

    public void toimiikoUpdate() {

    }

    @Test
    public void toimiikoYlos() {
        Point2D nopeus = alus.getNopeus();

        alus.ylos();

        assertEquals(new Point2D(nopeus.getX(), nopeus.getY() - 0.07), alus.getNopeus());

    }

    @Test
    public void toimiikoAlas() {
        Point2D nopeus = alus.getNopeus();

        alus.alas();

        assertEquals(new Point2D(nopeus.getX(), 0.07 + nopeus.getY()), alus.getNopeus());

    }

    @Test
    public void toimiikoVasen() {
        Point2D nopeus = alus.getNopeus();

        alus.vasemmalle();

        assertEquals(new Point2D(-0.07 + nopeus.getX(), nopeus.getY()), alus.getNopeus());

    }

    @Test
    public void toimiikoOikea() {
        Point2D nopeus = alus.getNopeus();

        alus.oikealle();
        assertEquals(new Point2D(0.07 + nopeus.getX(), nopeus.getY()), alus.getNopeus());

    }

    @Test
    public void toimiikoUlkona() {
//        this.alus.getKuva().setTranslateX(this.juuri.getWidth() + 1);
//        this.alus.ulkona(this.juuri);
//        assertEquals(0, this.alus.getKuva().getTranslateX(), 0.01);
//
//        this.alus.getKuva().setTranslateX(-1);
//        this.alus.ulkona(this.juuri);
//        assertEquals(this.juuri.getWidth(), this.alus.getKuva().getTranslateX(), 0.01);
//
//        this.alus.getKuva().setTranslateY(1 + this.juuri.getHeight());
//        this.alus.ulkona(this.juuri);
//        assertEquals(0, this.alus.getKuva().getTranslateY(), 0.01);
//
//        this.alus.getKuva().setTranslateY(-1);
//        this.alus.ulkona(this.juuri);
//        assertEquals(this.juuri.getHeight(), this.alus.getKuva().getTranslateX(), 0.01);

    }

}
