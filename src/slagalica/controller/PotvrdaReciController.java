package slagalica.controller;

import slagalica.model.poruka.ProveravacSlovo;
import slagalica.view.poruke.PotvrdaReciView;


public class PotvrdaReciController {

    private ProveravacSlovo model;
    private PotvrdaReciView view;


    public PotvrdaReciController(ProveravacSlovo model, PotvrdaReciView view){
        this.model = model;
        this.view = view;
    }

    public PotvrdaReciView vratiView() {
        return view;
    }

    public ProveravacSlovo vratiModel() {
        return model;
    }

    public void potvrdaReci(){
        model.proveriSlaganje();
        view.potvrdaReci(model.daLiSuPraznaPogresnoUnesenaSlova(), model.vratiUnesenaslova().napraviRecOdUnesenihSlova(), model.napraviPogresnoUnesenuRec());
    }


}
