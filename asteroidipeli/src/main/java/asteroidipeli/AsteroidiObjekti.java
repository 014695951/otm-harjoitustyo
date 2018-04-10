package asteroidipeli;

import java.util.Random;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

public class AsteroidiObjekti extends PeliObjekti {

    private double x;
    private double y;
    private Canvas kanvaasi;
    private GraphicsContext piirturi;
    double nopeus = 4;

    public AsteroidiObjekti(GraphicsContext piirturi) {
        super(piirturi);
        this.kanvaasi = piirturi.getCanvas();
        this.piirturi = piirturi;
    }  

    public void generoiAsteroidi(long nykyhetki) {

        long edellinen = 0;

        Random arpoja = new Random();

        if (nykyhetki - edellinen < 1000) {
            return;
        }

        int x = arpoja.nextInt(700);
        int y = arpoja.nextInt(700);

        this.piirturi.fillOval(x, y, 25, 25);

        edellinen = nykyhetki;

    }
    

}
