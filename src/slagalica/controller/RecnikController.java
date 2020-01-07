package slagalica.controller;

import slagalica.model.bodovanje.Bod;
import slagalica.model.kompjuter.KompjuterRec;
import slagalica.model.poruka.ProveravacRec;
import slagalica.view.poruke.RecnikView;


public class RecnikController {

    private RecnikView view;
    private ProveravacRec model;


    public RecnikController(RecnikView view, ProveravacRec model) {
        this.view = view;
        this.model = model;
    }

    public ProveravacRec vratiModel() {
        return model;
    }

    public RecnikView vratiView() {
        return view;
    }


    public void recnikPoruka(KompjuterRec kompjuterRec, Bod bod){
        model.pronadjiRec();
        view.recnikPoruka(model. daLiJePronadjenaRecURecniku(), model.vratiUnesenaSlova().vratiUnesenuRec(),
                          model.vratiUnesenaSlova().vratiUnesenuRec().length(), bod.vratiBrojbodova());
        view.kompjuterRec(kompjuterRec.vratiKompjuterrec(), kompjuterRec.vratiDuzinareci());
    }

}
