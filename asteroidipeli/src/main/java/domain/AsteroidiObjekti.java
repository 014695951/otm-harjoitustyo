package domain;

import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;



public class AsteroidiObjekti extends PeliObjekti {

    private Node kuva;
    private Point2D nopeus;
    private boolean elossa = true;
    private Pane juuri;
    private Random randomi;
    private int koko;
    private Polygon monikulmio;

    public AsteroidiObjekti(Pane juuri) {
        this.randomi = new Random();
        this.juuri = juuri;
        this.nopeus = new Point2D(arvoNopeus(), arvoNopeus());
        this.kuva = luoAsteroidi();
        arvoSijainti();
    }

    @Override
    public boolean ulkona() {

        if (this.kuva.getTranslateX() > this.juuri.getWidth() + 30) {
            this.kuva.setTranslateX(0);
        }

        if (this.kuva.getTranslateX() < -30) {
            this.kuva.setTranslateX(this.juuri.getWidth());
        }

        if (this.kuva.getTranslateY() > this.juuri.getHeight() + 30) {
            this.kuva.setTranslateY(0);
        }

        if (this.kuva.getTranslateY() < -30) {
            this.kuva.setTranslateY(this.juuri.getHeight());
        }

        return true;

    }

    private void arvoSijainti() {

        double random = this.randomi.nextDouble();

        if (random < 0.25) {
            this.kuva.setTranslateX(-30);

            if (random < 0.175) {
                this.kuva.setTranslateY(this.juuri.getHeight() * this.randomi.nextDouble());
            }

        } else if (random < 0.5) {
            this.kuva.setTranslateX(this.juuri.getWidth() + 30);

            if (random < 0.375) {
                this.kuva.setTranslateY(this.juuri.getHeight() * this.randomi.nextDouble());
            }

        } else if (random < 0.75) {
            this.kuva.setTranslateY(-30);

            if (random < 0.675) {
                this.kuva.setTranslateX(this.juuri.getWidth() * this.randomi.nextDouble());
            }

        } else {
            this.kuva.setTranslateY(this.juuri.getHeight() + 30);

            if (random < 0.875) {
                this.kuva.setTranslateX(this.juuri.getWidth() * this.randomi.nextDouble());
            } else {
                this.kuva.setTranslateX(-30);
            }
        }

    }

    private double arvoNopeus() {

        double random = this.randomi.nextDouble();

        if (random < 0.5) {
            return -random / 10;
        }

        return random / 10;
    }

    @Override
    public double getRajat() {
        return 0;
    }

    public Node luoAsteroidi() {

        Random randomi = new Random();

        double ala = randomi.nextInt(10);

        if (koko <= 1) {

            ala = +10;

        } else if (koko <= 2) {
            ala = +20;
        } else {
            ala = +30;
        }

        Polygon monikulmio = new Polygon();

        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI * 4 / 5);

        monikulmio.getPoints().addAll(
                ala, 0.0,
                ala * c1, -1 * ala * s1,
                -1 * ala * c2, -1 * ala * s2,
                -1 * ala * c2, ala * s2,
                ala * c1, ala * s1);

        for (int i = 0; i < monikulmio.getPoints().size(); i++) {
            int muutos = randomi.nextInt(5) - 2;
            monikulmio.getPoints().set(i, monikulmio.getPoints().get(i) + muutos);
        }

        return monikulmio;

    }

    public int getKoko() {
        return this.koko;
    }

    public double setKoko() {
        return this.koko;
    }

    public void paivita() {
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
