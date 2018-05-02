package domain;

import java.util.Timer;
import java.util.TimerTask;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class AlusObjekti extends PeliObjekti {

    private Node kuva;
    private Point2D nopeus = new Point2D(0.01, 0.01);
    private boolean elossa = true;
    private Pane juuri;

    public AlusObjekti(Pane juuri) {
        this.juuri = juuri;
        this.kuva = new Rectangle(40, 40, Color.BLUE);
        this.kuva.setTranslateY(juuri.getHeight() / 2);
        this.kuva.setTranslateX(juuri.getWidth() / 2);
    }

    @Override
    public void paivita() {
        laskeNopeutta(0.9998);
        this.kuva.setTranslateX(this.kuva.getTranslateX() + this.nopeus.getX());
        this.kuva.setTranslateY(this.kuva.getTranslateY() + this.nopeus.getY());
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

    @Override
    public boolean ulkona() {

        if (this.kuva.getTranslateX() > this.juuri.getWidth()) {
            this.kuva.setTranslateX(0);
        }

        if (this.kuva.getTranslateX() < 0) {
            this.kuva.setTranslateX(this.juuri.getWidth());
        }

        if (this.kuva.getTranslateY() > this.juuri.getHeight()) {
            this.kuva.setTranslateY(0);
        }

        if (this.kuva.getTranslateY() < 0) {
            this.kuva.setTranslateY(this.juuri.getHeight());
        }

        return true;

    }

    @Override
    public double getRajat() {
        return 0;
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

    public boolean tormaa(Node kuva) {

        return this.kuva.getBoundsInParent().intersects(kuva.getBoundsInParent());

    }

    public void laskeNopeutta(double kerroin) {
        this.nopeus = this.nopeus.multiply(0.9995);
    }

    public boolean sisalla() {
        return this.kuva.getBoundsInParent().intersects(this.juuri.getBoundsInParent());
    }

}
