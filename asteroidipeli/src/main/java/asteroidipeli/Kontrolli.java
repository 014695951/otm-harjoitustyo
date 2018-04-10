package asteroidipeli;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;

public class Kontrolli {

    private MouseEvent hiiri;
    private KeyEvent nappaimisto;
    private AlusObjekti alus;
    private GraphicsContext piirturi;

    public Kontrolli(MouseEvent eventti, GraphicsContext piirturi, AlusObjekti alus) {
        this.hiiri = eventti;
    }

    public Kontrolli(KeyEvent eventti, GraphicsContext piirturi, AlusObjekti alus) {
        this.nappaimisto = eventti;
    }

    public void hiirenLiikutus(MouseEvent eventti) {

    }

    public void hiirenKlikkaus(MouseEvent eventti) {

    }

    public void nappaimisto(KeyEvent eventti) {
        if (eventti.getCode() == KeyCode.UP) {
            alus.ylos();
        }

        if (eventti.getCode() == KeyCode.DOWN) {
            alus.alas();
        }

        if (eventti.getCode() == KeyCode.LEFT) {

            alus.kaannyVasempaan();
        }

        if (eventti.getCode() == KeyCode.RIGHT) {
            alus.kaannyOikeaan();
        }
    }

}
