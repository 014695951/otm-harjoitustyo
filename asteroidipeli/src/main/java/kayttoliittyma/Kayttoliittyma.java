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
import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Kayttoliittyma extends Application {

    private Pane juuri = new Pane();

    private List<AmmusObjekti> ammukset = new ArrayList<>();
    private List<AsteroidiObjekti> asteroidit = new ArrayList<>();
    private AlusObjekti alus;

    private int vaikeusaste = 1;

    private Parent peli() {

        this.juuri.setPrefSize(1000, 1000);

        Text teksti = new Text(10, 20, "Pisteet: 0");

        this.juuri.getChildren().add(teksti);

        AtomicInteger pisteet = new AtomicInteger();

        this.alus = uusiAlusObjekti(300, 300);

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                paivita(teksti, pisteet);
            }
        };

        timer.start();

        return juuri;
    }

    private Parent alkuruutu(Scene peli, Stage ikkuna) {

        Button helppo = new Button("helppo");
        Button vaikea = new Button("vaikea");
        Button aloita = new Button("aloita");

        vaikea.setOnAction((eventti) -> this.vaikeusaste = 2);
        helppo.setOnAction((eventti) -> this.vaikeusaste = 1);
        aloita.setOnAction((eventti) -> ikkuna.setScene(peli));

        HBox valikko = new HBox(vaikea);

        valikko.setPadding(new Insets(20, 20, 20, 20));
        valikko.setSpacing(10);

        return valikko;
    }

    private Parent loppuruutu() {

        return juuri;
    }

    private void paivita(Text teksti, AtomicInteger pisteet) {

        List<AmmusObjekti> ammukset = this.ammukset;
        List<AsteroidiObjekti> asteroidit = this.asteroidit;

        for (AsteroidiObjekti asteroidi : asteroidit) {

            for (AsteroidiObjekti a : asteroidit) {

                if (a != asteroidi) {
                    if (asteroidi.tormaa(a.getKuva()) && (a.sisalla() == true && asteroidi.sisalla() == true)) {

                        asteroidi.setElossa(false);
                        a.setElossa(false);

                        this.juuri.getChildren().removeAll(a.getKuva(), asteroidi.getKuva());

                    }
                }
            }

            if (this.alus.tormaa(asteroidi.getKuva()) && asteroidi.elossa() == true) {

                this.alus.setElossa(false);
                this.juuri.getChildren().removeAll(this.alus.getKuva(), asteroidi.getKuva());
            }

            //    Shape.intersect(shape1, shape2)
            for (AmmusObjekti ammus : ammukset) {

                if (ammus.ulkona() == true) {
                    this.juuri.getChildren().remove(ammus.getKuva());
                }

                if (ammus.tormaa(asteroidi.getKuva()) && asteroidi.elossa() == true) {

//                    int koko = asteroidi.getKoko();
//
//                    if (koko > 1) {
//
//                        for (int i = koko; i > 0; i++) {
//                            uusiAsteroidiObjekti(koko - 1);
//                        }
//                    }
                    ammus.setElossa(false);
                    asteroidi.setElossa(false);

                    teksti.setText("Points: " + pisteet.addAndGet(100 * asteroidi.getKoko()));

                    this.juuri.getChildren().removeAll(ammus.getKuva(), asteroidi.getKuva());
                }

            }
        }

        this.ammukset.removeIf(AmmusObjekti::kuollut);
        this.asteroidit.removeIf(AsteroidiObjekti::kuollut);

        this.ammukset.forEach(AmmusObjekti::paivita);
        this.asteroidit.forEach(AsteroidiObjekti::paivita);

        this.alus.ulkona(this.juuri);

        this.alus.paivita();

        if (Math.random() < 0.005 * this.vaikeusaste) {
            uusiAsteroidiObjekti(3);
        }
    }

    @Override
    public void start(Stage ikkuna) throws Exception {

        Scene peli = new Scene(peli());
//      Scene menu = new Scene(alkuruutu(peli, ikkuna));
//      Scene loppu = new Scene(loppuruutu());

//      ikkuna.setScene(menu);
        ikkuna.setScene(peli);

        peli.setOnKeyPressed(eventti -> {

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

        peli.setOnMouseMoved(eventti -> {
            this.alus.kaanna(eventti.getX(), eventti.getY());

        });

        peli.setOnMouseClicked(eventti -> {
            uusiAmmusObjekti();
        });

        ikkuna.show();
    }

    public AlusObjekti uusiAlusObjekti(double x, double y) {
        AlusObjekti alus = new AlusObjekti(x, y);

        this.juuri.getChildren().add(alus.getKuva());

        return alus;
    }

    public AsteroidiObjekti uusiAsteroidiObjekti(int koko) {
        AsteroidiObjekti asteroidi = new AsteroidiObjekti(this.juuri, koko);

        this.asteroidit.add(asteroidi);

        this.juuri.getChildren().add(asteroidi.getKuva());

        return asteroidi;
    }

    public AmmusObjekti uusiAmmusObjekti() {
        AmmusObjekti ammus = new AmmusObjekti(this.juuri);
        ammus.setSijainti(this.alus.getKuva().getTranslateX(), this.alus.getKuva().getTranslateY());
        ammus.setNopeus(this.alus.getNopeus().normalize().multiply(1.03));

        this.ammukset.add(ammus);

        this.juuri.getChildren().add(ammus.getKuva());

        return ammus;
    }

}
