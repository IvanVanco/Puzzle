package slagalica.view.poruke;

import javax.swing.*;

public class IstekVremenaView {

    private String rec;
    private static final String[] opcija = {"Da", "Ne"};
    private int pitanje = 1;


    public int vratiPitanje() {
        return pitanje;
    }


    public String vratiRec() {
        return rec;
    }


    public void postaviIstekVremenaRec() {
            this.rec = JOptionPane.showInputDialog(null, "Isteklo je vreme.\nMolimo Vas unesite reč.",
                                                    "Kraj igre", JOptionPane.WARNING_MESSAGE);
    }

    public void postaviIstekVremenaKraj() {
        JOptionPane.showMessageDialog(null, "Niste uneli nijednu reč. Više sreće sledeći put.", "Kraj igre", JOptionPane.INFORMATION_MESSAGE);
    }


    public void istekVremena(boolean uslov, String razlika){
        if (this.rec.isEmpty()) {
            postaviIstekVremenaKraj();
        }
        else {
            if(uslov){
                this.pitanje = JOptionPane.showOptionDialog(null,
                        "Bravo, sva uneta slova se poklapaju sa izvučenim slovima.\nDa li želite da potvrdite reč "
                                        +this.rec+" ili da pokušate ponovo?",
                        "Upitnik",JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, opcija, opcija[1]);
                if (this.pitanje == 1) {
                    postaviIstekVremenaKraj();
                }
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Nazalost, ne poklapaju se slova: ["+razlika+"]. Više sreće sledeći put.",
                        "Poruka",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}