package domain;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AmmusObjekti extends PeliObjekti {

    private Node kuva;
    private Point2D nopeus;
    private boolean elossa = true;

    public AmmusObjekti(double x, double y) {
        super(x, y);
        this.kuva = new Circle(x, y, 5, Color.YELLOW);
        this.nopeus = new Point2D(5, 5);
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

    @Override
    public boolean tormaa(PeliObjekti n) {
        return getKuva().getBoundsInLocal().intersects(n.getKuva().getBoundsInParent());
    }

}

