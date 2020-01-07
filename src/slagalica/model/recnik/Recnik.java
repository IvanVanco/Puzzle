package slagalica.model.recnik;

import slagalica.data.RecnikRepository;
import slagalica.model.konvertovanje.KonvertorRec;
import java.util.ArrayList;


public class Recnik {

    private RecnikRepository recnikRepository;
    private ArrayList<Rec> recnik;
    private int velicina;


    public Recnik(RecnikRepository recnikRepository) {
        this.recnikRepository = recnikRepository;
        inicijalizacija();
        this.velicina = recnik.size();
    }


    public int vratiVelicina() {
        return velicina;
    }

    public ArrayList<Rec> vratiRecnik() {
        return recnik;
    }

    public RecnikRepository vratiRecnikRepository() {
        return recnikRepository;
    }

    private void inicijalizacija(){
        this.recnik = new ArrayList<>();
        for (String recnikRec : this.recnikRepository.vratiRepo()) {
            KonvertorRec konvertorRec = new KonvertorRec(recnikRec);
            Rec rec = new Rec(konvertorRec.vratiKonverzija());
            this.recnik.add(rec);
        }
    }

    public void izbaciRec(Rec rec){
        if(this.recnik.contains(rec)){
            this.recnik.remove(rec);
            this.velicina = recnik.size();
        }
    }

}
