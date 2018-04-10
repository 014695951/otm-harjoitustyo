package asteroidipeli;

import java.awt.List;
import java.util.ArrayList;
import javafx.scene.input.KeyEvent;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Kayttoliittyma extends Application {

    @Override
    public void start(Stage ikkuna) {
        
        Canvas kanvaasi = new Canvas(700, 700);
        GraphicsContext piirturi = kanvaasi.getGraphicsContext2D();
        
        AlusObjekti alus = new AlusObjekti(piirturi);

        kanvaasi.setOnKeyPressed((KeyEvent eventti) -> {

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

            alus.piirraAlus();

        });

        kanvaasi.setOnMouseClicked((eventti) -> {
            new Kontrolli(eventti, piirturi, alus);
        });

        kanvaasi.setOnMouseMoved((eventti) -> {
            new Kontrolli(eventti, piirturi, alus);
        });

        AnimationTimer ajastin = new AnimationTimer() {

            @Override
            public void handle(long nykyhetki) {

                if (Math.random() < 0.01) {

                    new AsteroidiObjekti(piirturi).generoiAsteroidi(nykyhetki);

                }

            }

        };
        ajastin.start();

        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(kanvaasi);

        Scene nakyma = new Scene(asettelu);

        ikkuna.setScene(nakyma);

        ikkuna.show();

    }

}
