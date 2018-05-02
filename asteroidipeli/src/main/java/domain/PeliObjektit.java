package domain;

import domain.PeliObjekti;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;

public class PeliObjektit extends PeliObjekti {
    

    private List<AsteroidiObjekti> asteroidit;
    private List<AmmusObjekti> ammukset;
    private List<PeliObjekti> objektit;
    private AlusObjekti alus;

    private Pane juuri;

    public PeliObjektit(Pane juuri) {
        this.juuri = juuri;
        this.asteroidit = new ArrayList();
        this.ammukset = new ArrayList();
        this.objektit = new ArrayList();
    }

    public void lisaaAsteroidi(AsteroidiObjekti asteroidi) {
        this.asteroidit.add(asteroidi);
    }

    public void lisaaAmmus(AmmusObjekti ammus) {
        this.ammukset.add(ammus);
    }

    public void lisaaAlus(AlusObjekti alus) {
        this.alus = alus;
    }
    
    /**
     * Käy läpi asteroidit ja selvittää törmäävätkö ne toisiin PeliObjekteihin (myös asteroideihin) ja törmätessään PeliObjektit merkitään kuolleiksi.         
     */

    public void tormaako() {

        for (PeliObjekti objekti : this.objektit) {

            for (AsteroidiObjekti asteroidi : this.asteroidit) {

                if (objekti != asteroidi) {

                    if (asteroidi.tormaa(objekti.getKuva()) && (asteroidi.sisalla() == true && objekti.sisalla() == true)) {

                        asteroidi.setElossa(false);
                        objekti.setElossa(false);
                        this.juuri.getChildren().removeAll(asteroidi.getKuva(), objekti.getKuva());

                    }
                }
            }

        }

    }

    public Pane update() {
        
        List<PeliObjekti> poistettavat = new ArrayList();
 
        for (AsteroidiObjekti asteroidi : this.asteroidit) {
            if (asteroidi.kuollut()) {
                this.asteroidit.remove(asteroidi);
                this.juuri.getChildren().remove(asteroidi);
            } else {
                asteroidi.paivita();
            }
        }

        for (AmmusObjekti ammus : this.ammukset) {
            if (ammus.kuollut()) {
                this.asteroidit.remove(ammus);
                this.juuri.getChildren().remove(ammus);
            } else {
                ammus.paivita();
            }
        }
               
        this.alus.paivita();
        
        this.juuri.getChildren().removeAll(poistettavat);

        return this.juuri;

    }

    public AlusObjekti getAlus() {
        return this.alus;
    }

    public void setAlus(AlusObjekti alus) {
        this.alus = alus;
    }

    public Pane getPane() {
        return this.juuri;
    }

}
