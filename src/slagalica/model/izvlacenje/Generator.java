package slagalica.model.izvlacenje;

import slagalica.data.VerovatnoceRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class Generator {

    private LinkedHashMap<Character, List<Double>> odbaceni;            //mapa za izbacena slova
    private List<Double> vrednosti;                                     //lista sa indexima i ponderima izbacenih slova
    private int velicina;                                               //velicina liste odbacenih slova
    private double distSuma;                                            //total suma pondera
    private HashMap<Character, Double> distribucija;                    //mapa za raspodelu verovatnoca


    public LinkedHashMap mapaIzbacenihSlova(){
        return odbaceni;
    }

    public Generator() {
        this.distribucija = new HashMap<>();
        this.odbaceni = new LinkedHashMap<>();
        ubaciRaspodelu();
    }


    private void ubaciRaspodelu() {
        for (VerovatnoceRepository i: VerovatnoceRepository.values()) {
            if (this.distribucija.get(i.vratiSlovo()) != null) {
                this.distSuma -= this.distribucija.get(i.vratiSlovo());
            }
            this.distribucija.put(i.vratiSlovo(), i.vratiPonder());
            this.distSuma += i.vratiPonder();
        }
    }

    public void izbaciRaspodelu(String slovo, double polje) {
        for (VerovatnoceRepository i: VerovatnoceRepository.values()) {
            if(i.daLiIzbaci() == true && slovo.charAt(0) == (i.vratiSlovo())){
                Character slovko = slovo.charAt(0);
                if (!(this.odbaceni.containsKey(slovko))) {
                    this.vrednosti = new ArrayList<>();
                    this.vrednosti.add(polje);
                    this.vrednosti.add(this.distribucija.get(slovko));
                    this.odbaceni.put(slovko, this.vrednosti);
                }
                this.distSuma -= this.distribucija.get(slovko);
                this.distribucija.put(slovko, 0d);
            }
        }
    }

    public void vratiRaspodelu(int i){
        this.velicina = this.odbaceni.size() - 1;
        char prvoslovo = (Character) this.odbaceni.keySet().toArray()[this.velicina];
        if(this.odbaceni.get(prvoslovo).get(0).intValue() == i){
            this.distSuma +=this.odbaceni.get(prvoslovo).get(1);
            this.distribucija.put(prvoslovo, this.odbaceni.get(prvoslovo).get(1));
            this.odbaceni.remove(prvoslovo);
        }
    }

    public char izvuciRandomSlovo() {
        double random = Math.random();
        double racio = 1.0f / this.distSuma;
        double CDFSuma = 0;
        for (Character i : this.distribucija.keySet()) {
            CDFSuma += this.distribucija.get(i);
            if (random / racio <= CDFSuma) {                                //ovaj racio sluzi za normalizaciju, ako imamo pondere vece od 1!!!!
                return i;
            }
        }
        return 0;
    }

}
