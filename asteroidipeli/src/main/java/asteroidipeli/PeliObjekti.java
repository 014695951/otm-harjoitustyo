package asteroidipeli;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class PeliObjekti {

    private Canvas kanvaasi;
    private GraphicsContext piirturi;

    public PeliObjekti(GraphicsContext piirturi) {
        this.kanvaasi = piirturi.getCanvas();
        this.piirturi = piirturi;
    }
}
