package domain;

import java.util.Timer;
import java.util.TimerTask;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AlusObjekti {

    private Node kuva;
    private Point2D nopeus = new Point2D(0.01, 0.01);
    private boolean elossa = true;

    public AlusObjekti(double x, double y) {
        this.kuva = new Rectangle(40, 40, Color.BLUE);
        this.kuva.setTranslateY(y);
        this.kuva.setTranslateX(x);
    }

    public void paivita() {
        laskeNopeutta();
        this.kuva.setTranslateX(this.kuva.getTranslateX() + this.nopeus.getX());
        this.kuva.setTranslateY(this.kuva.getTranslateY() + this.nopeus.getY());
    }

    public void setNopeus(Point2D nopeus) {
        this.nopeus = nopeus;
    }

    public Point2D getNopeus() {
        return nopeus;
    }

    public Node getKuva() {
        return kuva;
    }

    public boolean elossa() {
        return elossa;
    }

    public boolean kuollut() {
        return !elossa;
    }

    public void setElossa(boolean elossa) {
        this.elossa = elossa;
    }

    public double getKaanna() {
        return kuva.getRotate();
    }

    public void vasemmalle() {

        this.nopeus = this.nopeus.add(-0.07, 0);
    }

    public void oikealle() {
        this.nopeus = this.nopeus.add(0.07, 0);
    }

    public void ylos() {
        this.nopeus = this.nopeus.add(0, -0.07);

    }

    public void alas() {
        this.nopeus = this.nopeus.add(0, 0.07);

    }

    public void kaanna(double x, double y) {

        double kateettiA = Math.abs(y - this.kuva.getLayoutY());
        double kateettiB = Math.abs(x - this.kuva.getLayoutX());

        if (x < this.kuva.getLayoutX()) {

            if (y < this.kuva.getLayoutY()) {
                this.kuva.setRotate(Math.tan(kateettiB / kateettiA) + 270);
            } else {
                this.kuva.setRotate(Math.tan(kateettiA / kateettiB));
            }

        } else {

            if (y < this.kuva.getLayoutY()) {
                this.kuva.setRotate(Math.tan(kateettiA / kateettiB) + 180);
            } else {
                this.kuva.setRotate(Math.tan(kateettiA / kateettiB) + 90);
            }

        }

    }

    public boolean tormaa(Node kuva) {

        return this.kuva.getBoundsInParent().intersects(kuva.getBoundsInParent());

    }

    public boolean ulkona(Pane juuri) {
        if (this.kuva.getTranslateX() > juuri.getWidth()) {
            this.kuva.setTranslateX(0);
        }

        if (this.kuva.getTranslateX() < 0) {
            this.kuva.setTranslateX(juuri.getWidth());
        }

        if (this.kuva.getTranslateY() > juuri.getHeight()) {
            this.kuva.setTranslateY(0);
        }

        if (this.kuva.getTranslateY() < 0) {
            this.kuva.setTranslateY(juuri.getHeight());
        }

        return true;

    }

    public double getRajat() {
        return 0;
    }

    public void laskeNopeutta() {

        this.nopeus = this.nopeus.multiply(0.9995);

    }

}
