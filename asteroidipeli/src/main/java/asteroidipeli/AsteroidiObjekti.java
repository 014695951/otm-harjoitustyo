package asteroidipeli;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class AsteroidiObjekti extends PeliObjekti {

    private double x;
    private double y;
    private Canvas kanvaasi;
    private GraphicsContext piirturi;

    public AsteroidiObjekti(GraphicsContext piirturi) {
        super(piirturi);
        this.kanvaasi = piirturi.getCanvas();
        this.piirturi = piirturi;
    }
    
    public void generoiAsteroidi() {
        
        piirturi.fillOval(100, 100, 100, 100);

    }

}
