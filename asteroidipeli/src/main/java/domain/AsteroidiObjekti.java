package domain;

import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class AsteroidiObjekti {

    private Node kuva;
    private Point2D nopeus;
    private boolean elossa = true;
    private Pane juuri;
    private Random randomi;
    private int koko;

    public AsteroidiObjekti(Pane juuri, int koko) {
        this.randomi = new Random();
        this.juuri = juuri;
        this.nopeus = new Point2D(arvoNopeus(), arvoNopeus());
        this.kuva = luoAsteroidi(koko);
        this.koko = koko;
        arvoSijainti();
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

    public void setX(double x) {
        this.kuva.setTranslateX(x);
    }

    public void setY(double y) {
        this.kuva.setTranslateY(y);
    }

    public boolean ulkona(Pane juuri) {

        if (this.kuva.getTranslateX() > juuri.getWidth() + 30) {
            this.kuva.setTranslateX(0);
        }

        if (this.kuva.getTranslateX() < -30) {
            this.kuva.setTranslateX(juuri.getWidth());
        }

        if (this.kuva.getTranslateY() > juuri.getHeight() + 30) {
            this.kuva.setTranslateY(0);
        }

        if (this.kuva.getTranslateY() < -30) {
            this.kuva.setTranslateY(juuri.getHeight());
        }

        return true;

    }

    private void arvoSijainti() {

        double random = this.randomi.nextDouble();

        if (random < 0.25) {
            setX(-30);

            if (random < 0.175) {
                setY(this.juuri.getHeight() * this.randomi.nextDouble());
            }

        } else if (random < 0.5) {
            setX(this.juuri.getWidth() + 30);

            if (random < 0.375) {
                setY(this.juuri.getHeight() * this.randomi.nextDouble());
            }

        } else if (random < 0.75) {
            setY(-30);

            if (random < 0.675) {
                setX(this.juuri.getWidth() * this.randomi.nextDouble());
            }

        } else {
            setY(this.juuri.getHeight() + 30);

            if (random < 0.875) {
                setX(this.juuri.getWidth() * this.randomi.nextDouble());
            } else {
                setX(-30);
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

    public double getRajat() {
        return 0;
    }

    public Node luoAsteroidi(int koko) {

        double random = this.randomi.nextDouble();
        double ala = 0;

        if (koko < 1) {
            return null;
        }

        if (random < 0.33 && koko >= 1) {
            ala = 10 + random * 10;
            this.koko = 1;

        } else if (random < 0.68 && koko >= 2) {
            ala = 20 + random * 10;
            this.koko = 2;

        } else if (random < 1 && koko >= 3) {
            ala = 30 + random * 10;
            this.koko = 3;
        }

        return new Circle(0, 0, ala, Color.PURPLE);

    }

    public int getKoko() {
        return this.koko;
    }

    public double setKoko() {
        return this.koko;
    }

    public boolean sisalla() {
        return this.kuva.getBoundsInParent().intersects(this.juuri.getBoundsInParent());
    }

}
