package slagalica.model.kompjuter;

import slagalica.model.izvlacenje.IzvucenoSlovo;
import slagalica.model.recnik.Rec;
import slagalica.model.recnik.Recnik;
import java.util.*;
import java.util.stream.Collectors;


public class KompjuterRec {

    private Recnik recnik;
    private IzvucenoSlovo izvucenoSlovo;
    private Map<String, Integer> kriterijumreci;
    private Map<String, Integer> najduzereci;
    private String kompjuterrec;
    private int duzinareci;
    private static int max = 12;



    public KompjuterRec(Recnik recnik, IzvucenoSlovo izvucenoSlovo) {
        this.recnik = recnik;
        this.izvucenoSlovo = izvucenoSlovo;
        napraviNajduzuRec();
    }

    public Map<String, Integer> vratiNajduzereci() {
        return najduzereci;
    }

    public Map<String, Integer> vratiKriterijumreci() {
        return kriterijumreci;
    }

    public String vratiKompjuterrec() {
        return kompjuterrec;
    }

    public int vratiDuzinareci() {
        return duzinareci;
    }

    public static int vratiMax() {
        return max;
    }

    public static void postaviMax(int max) {
        KompjuterRec.max = max;
    }

    private void napraviNajduzuRec() {
        izbrisiStaruIstinituMapu();
        napraviIstinituMapu();
        napraviKriterijumReciMapu();
        napraviNajduzeReciMapu();

        Random rnd = new Random();
        int random = rnd.nextInt(this.najduzereci.size());
        List<String> reci = new ArrayList<>(this.najduzereci.keySet());
        List<Integer> duzine = new ArrayList<>(this.najduzereci.values());

        this.duzinareci = duzine.get(0);
        this.kompjuterrec = reci.get(random);
    }

    private void izbrisiStaruIstinituMapu(){
        for (Rec r : recnik.vratiRecnik()) {
            r.inicijalizacijaIzvucenihSlovaMape();
        }
    }

    private void napraviIstinituMapu() {
        for (Rec r : recnik.vratiRecnik()) {
            for (Character slovo : r.vratiSlova().keySet()) {
                for (Character izvucenoslovo : izvucenoSlovo.vratiIzvucenuMapuSlova().keySet()) {
                    if (slovo.equals(izvucenoslovo) && r.vratiSlova().get(slovo) <= izvucenoSlovo.vratiIzvucenuMapuSlova().get(izvucenoslovo)) {
                        r.postaviIzvucenaSlovamapu(slovo);
                    }
                }
            }
        }
    }

    private void napraviKriterijumReciMapu() {
        this.kriterijumreci = new HashMap<>();
        for (Rec rec:recnik.vratiRecnik()) {
            Map<Character, Boolean> poredjenje = rec.vratiIzvucenaSlovamapu().entrySet().stream()
                    .filter(map -> map.getValue() == true)
                    .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
            if(rec.vratiIzvucenaSlovamapu().equals(poredjenje))
                this.kriterijumreci.put(rec.vratiRec(), rec.vratiDuzinu());
        }
    }

    private void napraviNajduzeReciMapu() {
        this.najduzereci = new HashMap<>();
        int najvecavrednostmape = (this.max < (Collections.max(this.kriterijumreci.values()))) ? this.max : (Collections.max(this.kriterijumreci.values()));

        for (Map.Entry<String, Integer> entry : this.kriterijumreci.entrySet()) {
            if(entry.getValue() <= this.max){
                if (entry.getValue() == najvecavrednostmape) {
                    this.najduzereci.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

}

