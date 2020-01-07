package slagalica.engine;

import slagalica.model.izvlacenje.Generator;
import slagalica.model.izvlacenje.PozicijaSlovo;
import slagalica.view.main.MainView;


public class SlagalicaEngine {

    private MainView view;
    private Generator generator;
    private SatEngine satEngine;


    public SlagalicaEngine(MainView view, Generator generator, SatEngine satEngine){
        this.view = view;
        this.satEngine = satEngine;
        this.generator = generator;
    }


    public void osposobiKomponente(boolean dailine){
        view.vratiUnesenoPolje().setEditable(dailine);
        view.vratiPotvrdiRec().setEnabled(dailine);
    }

    //Logika za slova!!!!
    public void slova() {

        Thread t = new Thread(() -> {
            try {
                while(PozicijaSlovo.vratiPoziciju() < 12){
                    Thread.sleep(40);

                    if(!(view.vratiUnesenText().equals("Unesite pronađenu reč na ćirilici"))){
                        osposobiKomponente(false);
                        view.postaviFormatUnosenjaReci();
                        view.postaviUnesenText("Prvo zaustavite sva slova, pa unesite reč");
                    }
                    if(PozicijaSlovo.vratiPoziciju() == 12) {
                        satEngine.pokreniVreme();
                        osposobiKomponente(true);
                        view.postaviFormatUnosenjaReci2();
                        view.postaviUnesenText("");
                        break;
                    }
                    if(!(generator.mapaIzbacenihSlova().isEmpty()))
                        generator.vratiRaspodelu(PozicijaSlovo.vratiPoziciju());

                    if(PozicijaSlovo.vratiPoziciju() > 0) {
                        generator.izbaciRaspodelu(view.pregledajTextPrethodnogPoljaSlova(PozicijaSlovo.vratiPoziciju()), PozicijaSlovo.smanjiPoziciju());
                        PozicijaSlovo.povecajPoziciju();
                    }
                    view.postaviTextNaPoljeSlova(PozicijaSlovo.vratiPoziciju(), String.valueOf(generator.izvuciRandomSlovo()));
                }
            } catch (InterruptedException ex) {
                PozicijaSlovo.postaviPoziciju(12);
            }
        });
        t.start();
    }
}