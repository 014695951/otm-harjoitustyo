package asteroidipeli;

import java.awt.geom.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;

public class AlusObjekti extends PeliObjekti {

    private double x;
    private double y;
    private Canvas kanvaasi;
    private GraphicsContext piirturi;

    public AlusObjekti(GraphicsContext piirturi) {
        super(piirturi);
        this.kanvaasi = piirturi.getCanvas();
        this.piirturi = piirturi;
        this.x = (double) 300;
        this.y = (double) 300;
    }

    public void kaannyVasempaan() {
        this.piirturi.moveTo(x - 11, y);
    }

    public void kaannyOikeaan() {
        this.piirturi.moveTo(x + 1, y);
    }

    public void alas() {
        this.piirturi.moveTo(x, y + 1);
    }

    public void ylos() {
        this.piirturi.moveTo(x, y - 1);
    }

    public GraphicsContext getPiirturi() {
        return this.piirturi;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
    
    public void piirraAlus() {
        
    }

}
