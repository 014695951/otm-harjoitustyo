package domain;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class PeliObjekti {

    private Node kuva;
    private Point2D nopeus = new Point2D(0.01, 0.01);

    private boolean elossa = true;

    public PeliObjekti(double x, double y) {
        this.kuva = new Node() {
            @Override
            protected NGNode impl_createPeer() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected boolean impl_computeContains(double localX, double localY) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        this.kuva.setTranslateY(y);
        this.kuva.setTranslateX(x);
    }

    public void paivita() {
        kuva.setTranslateX(kuva.getTranslateX() + nopeus.getX());
        kuva.setTranslateY(kuva.getTranslateY() + nopeus.getY());
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

    }

    public void oikealle() {

    }

    public boolean tormaa(PeliObjekti n) {
        return getKuva().getBoundsInParent().intersects(n.getKuva().getBoundsInParent());
    }

    public void ylos() {

    }

    public void alas() {

    }

}
