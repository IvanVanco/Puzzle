package slagalica.model.izvlacenje;

import slagalica.model.konvertovanje.KonvertorRec;
import java.util.ArrayList;

public class UnesenoSlovo {

    private KonvertorRec konvertorRec;
    private String unesenarec;
    private ArrayList<Character> unesenaslova = new ArrayList<Character>();



    public ArrayList<Character> vratiUnesenaSlova(){
        return unesenaslova;
    }

    public String vratiUnesenuRec(){
        return unesenarec;
    }


    public String napraviRecOdUnesenihSlova(){
        StringBuilder build = new StringBuilder();
        for (Character slovo : this.unesenaslova ) {
            build.append(slovo);
        }
        konvertorRec = new KonvertorRec(build.toString());
        this.unesenarec = konvertorRec.vratiKonverzija();
        return this.unesenarec;
    }


    public void popuniNizUnesenomRecju(String rec){
        this.unesenaslova.clear();
        konvertorRec = new KonvertorRec(rec);
        for(int i = 0; i< konvertorRec.vratiKonverzija().length(); i++){
            this.unesenaslova.add(konvertorRec.vratiKonverzija().charAt(i));
        }
    }

    public void ocistiNizUnesenimSlovima(int index){
        this.unesenaslova.remove(index);
    }

    public void popuniNizUnesenimSlovima(int index, char slovo){
        this.unesenaslova.add(index, slovo);
    }

    public void ocistiCeoNizUnesenimSlovima(int index) {
        if (index < 12) {
            this.unesenaslova.clear();
        }
    }

}
