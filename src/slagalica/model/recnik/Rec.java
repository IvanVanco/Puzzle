package slagalica.model.recnik;

import java.util.HashMap;
import java.util.Map;


public class Rec {

    private String rec;
    private int duzina;
    private Map<Character, Integer> slovamapa;
    private Map<Character, Boolean> izvucenaslovamapa;


    public Rec(String rec) {
         this.rec = rec;
         napraviMapuOdReci();
         inicijalizacijaIzvucenihSlovaMape();
         this.duzina = rec.length();
    }

    public String vratiRec() {
        return rec;
    }

    public int vratiDuzinu() {
        return duzina;
    }

    public Map<Character, Integer> vratiSlova() {
        return slovamapa;
    }


    public Map<Character, Boolean> vratiIzvucenaSlovamapu() {
        return izvucenaslovamapa;
    }

    public void postaviIzvucenaSlovamapu(char slovo) {
        this.izvucenaslovamapa.put(slovo, true);
    }

    private void napraviMapuOdReci() {
        this.slovamapa = new HashMap<>();
        for (Character c : this.rec.toCharArray()) {
            if(!this.slovamapa.containsKey(c))
                this.slovamapa.put(c, 1);
            else
                this.slovamapa.put(c, this.slovamapa.get(c) + 1);
        }
    }

    public void inicijalizacijaIzvucenihSlovaMape() {
        this.izvucenaslovamapa = new HashMap<>();
        for (Character c : this.rec.toCharArray()) {
            this.izvucenaslovamapa.put(c, false);
        }
    }

}
