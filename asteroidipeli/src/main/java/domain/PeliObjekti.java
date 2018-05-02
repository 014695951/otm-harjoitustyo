package domain;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class PeliObjekti {

    private Node kuva;
    private Point2D nopeus;
    private boolean elossa;
    private Pane juuri;

    public PeliObjekti() {

    }

    /**
     * Päivittää objektin sijainnin ruudulla.
     */
    
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

    /**
     * palauttaa true, jos kaksi Node-luokan oliota törmäävät.
     * @param kuva Node-luokan muuttuja
     * @return boolean 
     */
    
    public boolean tormaa(Node kuva) {

        return this.kuva.getBoundsInParent().intersects(kuva.getBoundsInParent());

    }

    public double getRajat() {
        return 0;
    }

    public boolean ulkona() {
        return true;
    }

    /**
     * Muuttaa objektin nopeuden = nopeus*kerroin.
     * @param kerroin double
     */
    public void laskeNopeutta(double kerroin) {
        this.nopeus = this.nopeus.multiply(kerroin);
    }

    /**
     * Kertoo onko objekti ruudun sisällä.
     * @return boolean 
     */
    public boolean sisalla() {
        return this.kuva.getBoundsInParent().intersects(this.juuri.getBoundsInParent());
    }

}
