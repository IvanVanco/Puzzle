package slagalica.engine;

import slagalica.view.main.MainView;
import slagalica.model.vreme.Sat;
import java.awt.*;

public class SatEngine {

    private Sat model;
    private MainView view;
    private PorukeEngine porukeEngine;


    public SatEngine(Sat model, MainView view, PorukeEngine porukeEngine) {
        this.model = model;
        this.view = view;
        this.porukeEngine = porukeEngine;
    }

    public void kriticnaBoja(){
        if(model.vratiSekundu() < 11)
            view.vratiVreme().setForeground(new Color(255,0,0));
        else
            view.vratiVreme().setForeground(new Color(0,0,0));
    }


    public void pokreniVreme() {
        model.postaviRadTimera(true);
        pokreniTimer();
    }

    public void zaustaviVreme() {
        model.postaviSekundu(90);
        model.postaviRadTimera(false);
    }


    //Logika za sat!!!!
    public Thread pokreniTimer() {
        Thread v = new Thread() {
            public void run() {
                try {
                    while (model.vratiSekundu() > model.vratiPoslednjuSekundu() && model.daLiRadi()) {
                        sleep(1000);
 //             Kao i kod slova, desava se da nastavi da radi iako je radi = false
                        // || istekVremenaController.vratiPitanje() == 0
                        if (!model.daLiRadi() ) {
                            break;
                        }
                        model.smanjiSekundu();
                        kriticnaBoja();
                        view.postaviVreme(Integer.toString(model.vratiSekundu()));
                        porukeEngine.istekVremena(model.vratiSekundu());
                    }
                }
                catch (InterruptedException ex) {
                }
            }
        };
        v.start();
        return v;
    }
}
