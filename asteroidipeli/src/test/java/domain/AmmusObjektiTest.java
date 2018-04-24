package domain;

import javafx.scene.layout.Pane;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AmmusObjektiTest {

    Pane juuri;
    AmmusObjekti ammus;

    public AmmusObjektiTest() {
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

        this.ammus = new AmmusObjekti(this.juuri);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void toimiikoUpdate() {

    }

    @Test
    public void onkoElossaAlussa() {
        assertEquals(true, this.ammus.elossa());
    }

    @Test
    public void toimiikoUlkona() {
        this.ammus.getKuva().setTranslateX(1 + this.juuri.getWidth());
        this.ammus.ulkona();
        assertEquals(false, this.ammus.elossa());

        this.ammus.getKuva().setTranslateX(-1);
        this.ammus.ulkona();
        assertEquals(false, this.ammus.elossa());

        this.ammus.getKuva().setTranslateY(31 + this.juuri.getHeight());
        this.ammus.ulkona();
        assertEquals(false, this.ammus.elossa());

        this.ammus.getKuva().setTranslateY(-31);
        this.ammus.ulkona();
        assertEquals(false, this.ammus.elossa());
    }

}
