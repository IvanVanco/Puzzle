
package slagalica.model.vreme;


public class Sat {

    private int sekunde = 90;//90
    private static final int POSLEDNJA_SEKUNDA = 0;
    private boolean radi = false;


    public int vratiSekundu(){
        return sekunde;
    }

    public int vratiPoslednjuSekundu(){
        return POSLEDNJA_SEKUNDA;
    }

    public boolean daLiRadi(){
        return radi;
    }

    public void postaviSekundu(int sekunde){
        this.sekunde = sekunde;
    }

    public void postaviRadTimera(boolean radi){
        this.radi = radi;
    }

    public int smanjiSekundu() {
        return sekunde--;
    }



}