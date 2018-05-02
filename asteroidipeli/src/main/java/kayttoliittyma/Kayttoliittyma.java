package kayttoliittyma;

import domain.AlusObjekti;
import domain.AmmusObjekti;
import domain.AsteroidiObjekti;
import domain.PeliObjektit;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Kayttoliittyma extends Application {

    private Pane juuri = new Pane();
    private PeliObjektit objektit = new PeliObjektit(this.juuri);

    private Parent peli() {

        this.juuri.setPrefSize(1000, 1000);

        Text teksti = new Text(10, 20, "Pisteet: 0");

        this.juuri.getChildren().add(teksti);

        AtomicInteger pisteet = new AtomicInteger();

        uusiAlusObjekti();

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                paivita(teksti, pisteet);

                if (gameOver()) {
                    super.stop();

                    loppuruutu();
                }

            }
        };

        timer.start();

        return juuri;
    }

    private Pane loppuruutu() {

        Button aloita = new Button("aloita");

        HBox valikko = new HBox(aloita);

        valikko.setPadding(new Insets(20, 20, 20, 20));

        valikko.setSpacing(10);

        return valikko;
    }

    private void paivita(Text teksti, AtomicInteger pisteet) {

        this.objektit.tormaako();
        this.juuri = this.objektit.update();

        if (Math.random() < 0.005) {
            uusiAsteroidiObjekti();
        }
    }

    @Override
    public void start(Stage ikkuna) throws Exception {

        Scene peli = new Scene(peli());
        Scene loppuruutu = new Scene(loppuruutu());

        ikkuna.setScene(peli);

        AlusObjekti alus = this.objektit.getAlus();

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

            this.objektit.setAlus(alus);

        });

        peli.setOnMouseMoved(eventti -> {
            alus.kaanna(eventti.getX(), eventti.getY());

        });

        peli.setOnMouseClicked(eventti -> {
            uusiAmmusObjekti();
        });

        ikkuna.setOnCloseRequest(eventti -> {

        });

        ikkuna.show();

    }

    public AlusObjekti uusiAlusObjekti() {
        AlusObjekti alus = new AlusObjekti(this.juuri);

        this.objektit.lisaaAlus(alus);

        this.juuri.getChildren().add(alus.getKuva());

        return alus;
    }

    public AsteroidiObjekti uusiAsteroidiObjekti() {
        AsteroidiObjekti asteroidi = new AsteroidiObjekti(this.juuri);

        this.objektit.lisaaAsteroidi(asteroidi);

        this.juuri.getChildren().add(asteroidi.getKuva());

        return asteroidi;
    }

    public AmmusObjekti uusiAmmusObjekti() {
        AmmusObjekti ammus = new AmmusObjekti(this.juuri);
        ammus.setSijainti(this.objektit.getAlus().getKuva().getTranslateX(), this.objektit.getAlus().getKuva().getTranslateY());
        ammus.setNopeus(this.objektit.getAlus().getNopeus().normalize().multiply(1.03));

        this.objektit.lisaaAmmus(ammus);

        this.juuri.getChildren().add(ammus.getKuva());

        return ammus;
    }

    public boolean gameOver() {

        return this.objektit.getAlus().kuollut();
    }

}
