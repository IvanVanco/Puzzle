package slagalica.model.poruka;

import slagalica.model.izvlacenje.UnesenoSlovo;
import slagalica.model.konvertovanje.KonvertorRec;
import slagalica.model.recnik.Recnik;


public class ProveravacRec {

    private Recnik recnik;
    private UnesenoSlovo unesenoSlovo;
    private KonvertorRec konvertorRec;
    private boolean pronadjenaRecURecniku = false;


    public ProveravacRec(Recnik recnik, UnesenoSlovo unesenoSlovo) {
        this.recnik = recnik;
        this.unesenoSlovo = unesenoSlovo;
    }


    public boolean daLiJePronadjenaRecURecniku() {
        return pronadjenaRecURecniku;
    }

    public UnesenoSlovo vratiUnesenaSlova() {
        return unesenoSlovo;
    }

    public Recnik vratiRecnik() {
        return recnik;
    }

    public boolean pronadjiRec() {
        konvertorRec = new KonvertorRec("recnik", this.unesenoSlovo.napraviRecOdUnesenihSlova());
        if(recnik.vratiRecnikRepository().vratiRepo().contains(konvertorRec.vratiKonverzija())){
            return this.pronadjenaRecURecniku = true;
        }
        else
            return this.pronadjenaRecURecniku = false;
    }

}
