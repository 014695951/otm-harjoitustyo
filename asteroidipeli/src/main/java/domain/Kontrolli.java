package domain;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import static javafx.scene.input.MouseEvent.MOUSE_MOVED;

public class Kontrolli {

    private KeyEvent nappain;
    private MouseEvent klikkaus;
    private MouseEvent liikutus;
    
    public Kontrolli(KeyEvent nappain) {
        this.nappain = nappain;
    }
    
    public Kontrolli(MouseEvent a) {
        if(a.getEventType() == MOUSE_CLICKED) {
            this.klikkaus = a;
        }
        
        if(a.getEventType() == MOUSE_MOVED) {
            this.liikutus = a;
        }     
        
    }
    
     
     
    
}
