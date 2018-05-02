package domain;

import javafx.scene.layout.Pane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AsteroidiObjektiTest {

    private AsteroidiObjekti asteroidi;
    private Pane juuri;

    public AsteroidiObjektiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

//    @Before
//    public void setUp() {
//        this.juuri = new Pane();
//        this.juuri.setPrefSize(1000, 1000);
//
//        this.asteroidi = new AsteroidiObjekti(this.juuri, 3);
//
//    }

    @After
    public void tearDown() {
    }

    @Test
    public void toimiikoUpdate() {

    }

//    @Test
//    public void toimiikoTormaaAsteroidiin() {
//
//        AsteroidiObjekti testiA = new AsteroidiObjekti(this.juuri, 3);
//        AsteroidiObjekti testiB = new AsteroidiObjekti(this.juuri, 3);
//        
//        testiA.getKuva().setTranslateX(10);
//        testiB.getKuva().setTranslateX(10);
//        
//        testiA.getKuva().setTranslateY(10);
//        testiB.getKuva().setTranslateY(10);
//        
//        assertEquals(true, testiA.tormaa(testiB.getKuva()));
//    }
//
//    @Test
//    public void toimiikoUlkona() {
//        this.asteroidi.getKuva().setTranslateX(31 + this.juuri.getWidth());
//        this.asteroidi.ulkona(this.juuri);
//        assertEquals(0, this.asteroidi.getKuva().getTranslateX(), 0.01);
//
//        this.asteroidi.getKuva().setTranslateX(-31);
//        this.asteroidi.ulkona(this.juuri);
//        assertEquals(this.juuri.getWidth(), this.asteroidi.getKuva().getTranslateX(), 0.01);
//
//        this.asteroidi.getKuva().setTranslateY(31 + this.juuri.getHeight());
//        this.asteroidi.ulkona(this.juuri);
//        assertEquals(0, this.asteroidi.getKuva().getTranslateY(), 0.01);
//
//        this.asteroidi.getKuva().setTranslateY(-31);
//        this.asteroidi.ulkona(this.juuri);
//        assertEquals(this.juuri.getHeight(), this.asteroidi.getKuva().getTranslateX(), 0.01);
//
//    }

}
