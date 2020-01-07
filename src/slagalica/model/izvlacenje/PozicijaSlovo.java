package slagalica.model.izvlacenje;

public class PozicijaSlovo {

    private static int pozicija = 0;

    public static int vratiPoziciju(){
        return pozicija;
    }

    public static int povecajPoziciju(){
        return pozicija++;
    }

    public static int smanjiPoziciju(){
        return pozicija--;
    }

    public static void postaviPoziciju(int poz){
        pozicija = poz;
    }

}
