package asteroidipeli;

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
        piirturi.fillRect(40, 40, 40, 40);
    }

    public void kaannyVasempaan() {
        this.piirturi.moveTo(x - 11, y);
    }

    public void kaannyOikeaan() {
        this.piirturi.moveTo(x + 1, y);
    }

    public void alas() {
        this.piirturi.moveTo(x, y + 1);
        this.piirturi.fillRect(10, 10, 10, 10);
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

}
