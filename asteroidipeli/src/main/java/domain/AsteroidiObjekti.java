package domain;

import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AsteroidiObjekti extends PeliObjekti {

    private Node kuva;
    private Point2D nopeus = new Point2D(new Random().nextDouble(), new Random().nextDouble());
    private boolean elossa = true;

    public AsteroidiObjekti(double x, double y) {
        super(x, y);
        this.kuva = new Circle(x, y, 30, Color.PURPLE);
    }

    @Override
    public void paivita() {
        kuva.setTranslateX(kuva.getTranslateX() + nopeus.getX());
        kuva.setTranslateY(kuva.getTranslateY() + nopeus.getY());
    }

    @Override
    public void setNopeus(Point2D nopeus) {
        this.nopeus = nopeus;
    }

    @Override
    public Point2D getNopeus() {
        return nopeus;
    }

    @Override
    public Node getKuva() {
        return kuva;
    }

    @Override
    public boolean elossa() {
        return elossa;
    }

    @Override
    public boolean kuollut() {
        return !elossa;
    }

    @Override
    public void setElossa(boolean elossa) {
        this.elossa = elossa;
    }

    public boolean tormaa(PeliObjekti n) {
        return getKuva().getBoundsInLocal().intersects(n.getKuva().getBoundsInParent());
    }

}

