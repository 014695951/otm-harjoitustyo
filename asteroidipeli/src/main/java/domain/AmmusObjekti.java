package domain;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AmmusObjekti {

    private Node kuva;
    private Point2D nopeus;
    private boolean elossa = true;
    private Pane juuri;

    public AmmusObjekti(Pane juuri) {
        this.juuri = juuri;
        this.kuva = new Circle(0, 0, 5, Color.BLACK);

    }

    public void paivita() {
        this.kuva.setTranslateX(this.kuva.getTranslateX() + this.nopeus.getX());
        this.kuva.setTranslateY(this.kuva.getTranslateY() + this.nopeus.getY());

    }

    public void setNopeus(Point2D nopeus) {
        this.nopeus = nopeus;
    }

    public Point2D getNopeus() {
        return this.nopeus;
    }

    public Node getKuva() {
        return this.kuva;
    }

    public boolean elossa() {
        return this.elossa;
    }

    public boolean kuollut() {
        return !this.elossa;
    }

    public void setElossa(boolean elossa) {
        this.elossa = elossa;
    }

    public boolean tormaa(Node kuva) {
        return this.kuva.getBoundsInParent().intersects(kuva.getBoundsInParent());
    }

    public void setSijainti(double x, double y) {
        this.kuva.setTranslateX(x);
        this.kuva.setTranslateY(y);
    }

    public boolean ulkona() {

        setElossa(false);

        if (this.kuva.getTranslateX() > this.juuri.getWidth()) {
            return true;
        }

        if (this.kuva.getTranslateX() < 0) {
            return true;
        }

        if (this.kuva.getTranslateY() > this.juuri.getHeight()) {
            return true;

        }

        if (this.kuva.getTranslateY() < 0) {
            return true;

        }

        setElossa(true);

        return false;
    }

    public double getRajat() {
        return 0;
    }

}
