package asteroidipeli;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;

public class AmmusObjekti extends PeliObjekti {

    private double x;
    private double y;
    private Canvas kanvaasi;
    private GraphicsContext piirturi;

    public AmmusObjekti(GraphicsContext piirturi) {
        super(piirturi);
        this.kanvaasi = piirturi.getCanvas();
        this.piirturi = piirturi;
    }

    

}
