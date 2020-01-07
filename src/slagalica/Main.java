package slagalica;

import slagalica.engine.PorukeEngine;
import slagalica.controller.RecnikController;
import slagalica.data.RecnikRepository;
import slagalica.data.SupervizijaRepository;
import slagalica.model.izvlacenje.Generator;
import slagalica.engine.EventEngine;
import slagalica.engine.SlagalicaEngine;
import slagalica.engine.SatEngine;
import slagalica.model.poruka.ProveravacRec;
import slagalica.model.recnik.Recnik;
import slagalica.controller.IstekVremenaController;
import slagalica.model.izvlacenje.IzvucenoSlovo;
import slagalica.model.poruka.ProveravacSlovo;
import slagalica.model.izvlacenje.UnesenoSlovo;
import slagalica.controller.PotvrdaReciController;
import slagalica.view.main.MainView;
import slagalica.model.vreme.Sat;
import slagalica.view.poruke.IstekVremenaView;
import slagalica.view.poruke.PotvrdaReciView;
import slagalica.view.poruke.RecnikView;


public class Main {

    public static void main(String[] args) {


        Runnable r = new Runnable() {

            @Override
            public void run() {
                /**************VIEWS*************/
                MainView mainview = new MainView();
                RecnikView recnikView = new RecnikView();
                PotvrdaReciView potvrdaReciView = new PotvrdaReciView();
                IstekVremenaView istekVremenaView = new IstekVremenaView();

                /**************DATA*************/
                RecnikRepository recnikRepository = new RecnikRepository();
                SupervizijaRepository supervizijaRepository = new SupervizijaRepository();

                /**************MODELS*************/
                Generator generator = new Generator();
                Sat timerModel = new Sat();
                Recnik recnik = new Recnik(recnikRepository);
                IzvucenoSlovo izvucenoSlovo = new IzvucenoSlovo();
                UnesenoSlovo unesenoSlovo = new UnesenoSlovo();
                ProveravacSlovo proveravacSlovo = new ProveravacSlovo(izvucenoSlovo, unesenoSlovo);
                ProveravacRec proveravacRec = new ProveravacRec(recnik, unesenoSlovo);

                /**************CONTROLLERS*************/
                PotvrdaReciController potvrdaReciController = new PotvrdaReciController(proveravacSlovo, potvrdaReciView);
                RecnikController recnikController = new RecnikController(recnikView, proveravacRec);
                IstekVremenaController istekVremenaController = new IstekVremenaController(proveravacSlovo, istekVremenaView);

                /**************ENGINES*************/
                PorukeEngine porukeEngine = new PorukeEngine(istekVremenaController, potvrdaReciController, recnikController, mainview, supervizijaRepository);
                SatEngine satEngine = new SatEngine(timerModel, mainview, porukeEngine);
                SlagalicaEngine slagalicaEngine = new SlagalicaEngine(mainview, generator, satEngine);
                EventEngine eventEngine = new EventEngine(mainview, izvucenoSlovo, unesenoSlovo, satEngine, slagalicaEngine, porukeEngine);

                mainview.setVisible(true);

                /**************POKRECEMO IGRU*************/
                slagalicaEngine.slova();

            }
        };

        javax.swing.SwingUtilities.invokeLater(r);
    }
}
