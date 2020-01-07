package slagalica.engine;

import slagalica.model.izvlacenje.PozicijaSlovo;
import slagalica.model.izvlacenje.IzvucenoSlovo;
import slagalica.model.izvlacenje.UnesenoSlovo;
import slagalica.view.main.MainView;
import java.awt.*;
import java.awt.event.*;


public class EventEngine {

    private MainView view;
    private IzvucenoSlovo izvucenoSlovo;
    private UnesenoSlovo unesenoSlovo;
    private SatEngine satEngine;
    private SlagalicaEngine slagalicaEngine;
    private PorukeEngine porukeEngine;


    public EventEngine(MainView view, IzvucenoSlovo izvucenoSlovo, UnesenoSlovo unesenoSlovo, SatEngine satEngine, SlagalicaEngine slagalicaEngine, PorukeEngine porukeEngine){
        this.view = view;
        this.satEngine = satEngine;
        this.slagalicaEngine = slagalicaEngine;
        this.izvucenoSlovo = izvucenoSlovo;
        this.unesenoSlovo = unesenoSlovo;
        this.porukeEngine = porukeEngine;

        this.view.postaviZaustaviOsluskivac(new MainListener());
        this.view.postaviOcistiOsluskivac(new MainListener());
        this.view.postaviPotvrdiRecOsluskivac(new MainListener());
        this.view.postaviUnosenjeOsluskivac( (KeyListener) new MainListener());
        this.view.postaviUnosenjeOsluskivac( (MouseListener) new MainListener());
    }

    public void zaustaviDugme() {
        if(PozicijaSlovo.vratiPoziciju() < 12){
            PozicijaSlovo.povecajPoziciju();
        }
        if (PozicijaSlovo.vratiPoziciju() == 12){
            izvucenoSlovo.ocistiCeoNizIzvucenihSlova();
            izvucenoSlovo.popuniCeoNizIzvucenimSlovima(view.vratiPolja());
        }
    }

    public void ocistiDugme() {
        satEngine.zaustaviVreme();
        view.ocistiVreme();
        if(PozicijaSlovo.vratiPoziciju() > 0){
            if(PozicijaSlovo.vratiPoziciju() < 12) {
                view.postaviTextNaPoljeSlova(PozicijaSlovo.vratiPoziciju(), "");
                PozicijaSlovo.smanjiPoziciju();
            }
            else {
                PozicijaSlovo.smanjiPoziciju();
                view.postaviTextNaPoljeSlova(PozicijaSlovo.vratiPoziciju(), "");
                slagalicaEngine.slova();
            }
            izvucenoSlovo.ocistiCeoNizIzvucenihSlova();
            unesenoSlovo.ocistiCeoNizUnesenimSlovima(PozicijaSlovo.vratiPoziciju());
        }
    }

    class MainListener implements ActionListener, MouseListener, KeyListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.vratiZaustavi())){
            zaustaviDugme();
        }
        else if (e.getSource().equals(view.vratiPotvrdiRec())){
            porukeEngine.potvrdiRec();
        }
        else if (e.getSource().equals(view.vratiOcisti())) {
            ocistiDugme();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(PozicijaSlovo.vratiPoziciju() < 12){
            view.vratiUnesenoPolje().setEditable(false);
            view.postaviUnesenText("Prvo zaustavite sva slova, pa unesite reč");
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
        char slovo = e.getKeyChar();
        if(!(Character.isAlphabetic(slovo)||slovo==KeyEvent.VK_BACK_SPACE)){
            e.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    }
}
