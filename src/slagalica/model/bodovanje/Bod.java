package slagalica.model.bodovanje;

import slagalica.model.izvlacenje.UnesenoSlovo;
import slagalica.model.kompjuter.KompjuterRec;


public class Bod {

    private UnesenoSlovo korisnikrec;
    private KompjuterRec kompjuterRec;
    private int bodovi = 0;


    public Bod(UnesenoSlovo korisnikrec, KompjuterRec kompjuterRec) {
        this.korisnikrec = korisnikrec;
        this.kompjuterRec = kompjuterRec;
        bodovanje(korisnikrec.vratiUnesenuRec(), kompjuterRec.vratiKompjuterrec());
    }

    public int vratiBrojbodova() {
        return this.bodovi;
    }


    private int bodovanje(String korisnikrec, String kompjuterrec){
        int korisnikduzina = korisnikrec.length();
        int kompjuterduzina = kompjuterrec.length();
        int bodovi = korisnikduzina * 2;

        if(korisnikduzina == kompjuterduzina && korisnikrec.equals(kompjuterrec))
            bodovi = korisnikduzina * 2 + 5;

        if(korisnikduzina == kompjuterduzina && !korisnikrec.equals(kompjuterrec))
            bodovi = korisnikduzina * 3;

        this.bodovi = bodovi;
        return this.bodovi;
    }

}
