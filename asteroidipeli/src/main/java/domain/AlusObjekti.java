package domain;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AlusObjekti extends PeliObjekti {

    private Node kuva;
    private Point2D nopeus = new Point2D(0.1, 0.1);
    private boolean elossa = true;

    public AlusObjekti(double x, double y) {
        super(x, y);
        this.kuva = new Rectangle(40, 40, Color.BLUE);
        this.kuva.setTranslateY(y);
        this.kuva.setTranslateX(x);
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
    public double getKaanna() {
        return kuva.getRotate();
    }

    @Override
    public void vasemmalle() {
        setNopeus(new Point2D(-0.1, 0));

    }

    @Override
    public void oikealle() {
        setNopeus(new Point2D(0.1, 0));;
    }

    public void kaanna(double x, double y) {

        double viereinen = Math.abs(y - kuva.getTranslateY());
        double vastainen = Math.abs(x - kuva.getTranslateX());

        this.kuva.setRotate(Math.tan(vastainen / viereinen));
    }

    @Override
    public boolean tormaa(PeliObjekti n) {
        return getKuva().getBoundsInParent().intersects(n.getKuva().getBoundsInParent());

    }

    @Override
    public void ylos() {
        setNopeus(new Point2D(0, -0.1));
    }

    @Override
    public void alas() {
        setNopeus(new Point2D(0, 0.1));
    }

}
