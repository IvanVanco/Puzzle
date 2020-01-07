package slagalica.controller;

import slagalica.model.poruka.ProveravacSlovo;
import slagalica.view.poruke.IstekVremenaView;


public class IstekVremenaController {

    private ProveravacSlovo model;
    private IstekVremenaView view;


    public IstekVremenaController(ProveravacSlovo model, IstekVremenaView view) {
        this.model = model;
        this.view = view;
    }


    public IstekVremenaView vratiView() {
        return view;
    }

    public ProveravacSlovo vratiModel() {
        return model;
    }

    public int vratiPitanje() {
        return view.vratiPitanje();
    }


    public void istekVremena(){
        view.postaviIstekVremenaRec();
        if (view.vratiRec() == null) {
            view.postaviIstekVremenaKraj();
            System.exit(0);
        }
        model.vratiUnesenaslova().popuniNizUnesenomRecju(view.vratiRec());
        model.proveriSlaganje();
        view.istekVremena(model.daLiSuPraznaPogresnoUnesenaSlova(), model.napraviPogresnoUnesenuRec());
        if(view.vratiPitanje() == 1){
            System.exit(0);
        }
    }
}
