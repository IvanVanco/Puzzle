package slagalica.engine;

import slagalica.controller.IstekVremenaController;
import slagalica.controller.PotvrdaReciController;
import slagalica.controller.RecnikController;
import slagalica.data.SupervizijaRepository;
import slagalica.model.bodovanje.Bod;
import slagalica.model.kompjuter.KompjuterRec;
import slagalica.view.main.MainView;
import java.awt.*;


public class PorukeEngine {

    private IstekVremenaController istekVremenaController;
    private PotvrdaReciController potvrdaReciController;
    private RecnikController recnikController;
    private MainView mainView;
    private SupervizijaRepository supervizijaRepository;
    private Bod bod;


    public PorukeEngine(IstekVremenaController istekVremenaController, PotvrdaReciController potvrdaReciController, RecnikController recnikController,
                        MainView mainView, SupervizijaRepository supervizijaRepository) {
        this.istekVremenaController = istekVremenaController;
        this.potvrdaReciController = potvrdaReciController;
        this.recnikController = recnikController;
        this.mainView = mainView;
        this.supervizijaRepository = supervizijaRepository;
    }

    public void postaviCrniEkran(MainView mainView) {
        mainView.postaviBojuPolja(new Color(0, 0, 0));
    }

    public void sacuvajRec(SupervizijaRepository supervizijaRepository, String korisnikrec) {
        supervizijaRepository.sacuvaj(korisnikrec);
    }

    public void istekVremena(int sekunda){
        if(sekunda == 0) {
            postaviCrniEkran(mainView);
            istekVremenaController.istekVremena();
            if (istekVremenaController.vratiView().vratiPitanje() == 0){
                istekVremenaController.vratiModel().vratiUnesenaslova().popuniNizUnesenomRecju(istekVremenaController.vratiView().vratiRec());
                KompjuterRec kompjuterRec = new KompjuterRec(recnikController.vratiModel().vratiRecnik(), istekVremenaController.vratiModel().vratiIzvucenaslova());
                bod = new Bod(recnikController.vratiModel().vratiUnesenaSlova(), kompjuterRec);
                recnikController.recnikPoruka(kompjuterRec, bod);
                if (recnikController.vratiView().vratiPitanje() == 0){
                    sacuvajRec(supervizijaRepository, recnikController.vratiModel().vratiUnesenaSlova().vratiUnesenuRec());
                }
                System.exit(0);
            }
        }
    }

    public void potvrdiRec(){
        potvrdaReciController.vratiModel().vratiUnesenaslova().popuniNizUnesenomRecju(mainView.vratiUnesenoPolje().getText());
        KompjuterRec kompjuterRec = new KompjuterRec(recnikController.vratiModel().vratiRecnik(), potvrdaReciController.vratiModel().vratiIzvucenaslova());
        potvrdaReciController.potvrdaReci();
        if (potvrdaReciController.vratiView().vratiPitanje() == 0) {
            bod = new Bod(recnikController.vratiModel().vratiUnesenaSlova(), kompjuterRec);
            recnikController.recnikPoruka(kompjuterRec, bod);
            if (recnikController.vratiView().vratiPitanje() == 0){
                sacuvajRec(supervizijaRepository, recnikController.vratiModel().vratiUnesenaSlova().vratiUnesenuRec());
            }
            System.exit(0);
        }
    }
}
