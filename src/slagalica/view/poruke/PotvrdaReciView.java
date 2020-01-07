package slagalica.view.poruke;

import javax.swing.*;


public class PotvrdaReciView {

    private static final String[] opcija = {"Da", "Ne"};
    private int pitanje = 1;


    public int vratiPitanje() {
        return pitanje;
    }



    public void potvrdaReci(boolean uslov, String unesenarec, String razlika){
        if(uslov){
            if(!unesenarec.isEmpty()){
                this.pitanje = JOptionPane.showOptionDialog(null,
                        "Bravo, sva uneta slova se poklapaju sa izvučenim slovima.\nDa li želite da potvrdite reč "
                                +unesenarec+" ili da pokušate ponovo?",
                        "Upitnik",JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, opcija, opcija[1]);
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Molim Vas unesite reč i pokušajte ponovo.",
                        "Poruka",JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Nazalost, ne poklapaju se slova: ["+razlika+"]. Pokušajte ponovo.",
                    "Poruka",JOptionPane.ERROR_MESSAGE);
        }
    }
}
