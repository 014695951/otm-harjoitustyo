package kayttoliittyma;

import domain.AlusObjekti;
import domain.AmmusObjekti;
import domain.AsteroidiObjekti;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Kayttoliittyma extends Application {

    private Pane juuri;

    private List<AmmusObjekti> ammukset = new ArrayList<>();
    private List<AsteroidiObjekti> asteroidit = new ArrayList<>();
    private AlusObjekti alus;

    private Parent sisalto() {

        this.juuri = new Pane();
        juuri.setPrefSize(1000, 1000);

        this.alus = new AlusObjekti(500, 500);

        this.juuri.getChildren().add(this.alus.getKuva());

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                paivita();
            }
        };

        timer.start();

        return juuri;
    }

    private void paivita() {

        for (AmmusObjekti ammus : ammukset) {
            for (AsteroidiObjekti asteroidi : asteroidit) {
                if (ammus.tormaa(asteroidi)) {
                    ammus.setElossa(false);
                    asteroidi.setElossa(false);

                    juuri.getChildren().removeAll(ammus.getKuva(), asteroidi.getKuva());
                }

                if (asteroidi.tormaa(alus)) {
                    juuri.getChildren().remove(alus.getKuva());
                }
            }
        }

        ammukset.removeIf(AmmusObjekti::kuollut);
        asteroidit.removeIf(AsteroidiObjekti::kuollut);

        ammukset.forEach(AmmusObjekti::paivita);
        asteroidit.forEach(AsteroidiObjekti::paivita);

        alus.paivita();

        if (Math.random() < 0.001) {
            this.juuri.getChildren().add(new AsteroidiObjekti(Math.random() * 1000, Math.random() * 1000).getKuva());
        }
    }

    @Override
    public void start(Stage ikkuna) throws Exception {

        ikkuna.setScene(new Scene(sisalto()));
        ikkuna.getScene().setOnKeyPressed(eventti -> {

            switch (eventti.getCode()) {
                case A:
                    alus.vasemmalle();
                    break;
                case D:
                    alus.oikealle();
                    break;
                case W:
                    alus.ylos();
                    break;
                case S:
                    alus.alas();
                    break;
            }

        });

        ikkuna.getScene().setOnMouseMoved(eventti -> {
            alus.kaanna(eventti.getX(), eventti.getY());

        });

        ikkuna.getScene().setOnMouseClicked(eventti -> {
            AmmusObjekti ammus = new AmmusObjekti(alus.getKuva().getTranslateX(), alus.getKuva().getTranslateY());
            this.juuri.getChildren().add(ammus.getKuva());
        });

        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(Kayttoliittyma.class);
    }

}
