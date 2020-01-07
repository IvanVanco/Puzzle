package slagalica.view.poruke;

import javax.swing.*;


public class RecnikView {

    private static final String[] opcija = {"Da", "Ne"};
    private int pitanje = 1;


    public int vratiPitanje() {
        return pitanje;
    }

    public void postaviPitanje(int pitanje) {
        this.pitanje = pitanje;
    }


    public void kompjuterRec(String kompjuterrec, int kompjuterduzina) {
        JOptionPane.showMessageDialog(null,
                "Kompjuter je pronašao reč "+kompjuterrec+" sa dužinom "+kompjuterduzina+".",
                "Komjuter reč",JOptionPane.INFORMATION_MESSAGE);
    }


    public void recnikPoruka(boolean uslov, String korisnikrec, int korisnikduzina, int brojbodova) {
        if(uslov){
            JOptionPane.showMessageDialog(null,
                    "Bravo, uneta reč je pronađena u rečniku.\nVaša reč ima dužinu "+korisnikduzina+" slova i iznosi "
                            +brojbodova+" bodova.",
                    "Kraj igre",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            this.pitanje = JOptionPane.showOptionDialog(null,
                    "Nazalost, Vaša reč ne postoji u bazi rečnika.\nDa li želite da pošaljete reč na superviziju i da završite igru?","Greška",
                    JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,
                    null,opcija,opcija[1]);
        }
    }

}
