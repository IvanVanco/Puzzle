package slagalica.model.izvlacenje;

import slagalica.data.SlovaRepository;
import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


public class IzvucenoSlovo {

    private ArrayList<Character> izvucenaslova;
    private Map<Character, Integer> izvucenaslovamapa;


    public IzvucenoSlovo() {
        this.izvucenaslova = new ArrayList<>();
        this.izvucenaslovamapa = new LinkedHashMap<>();
        inicijalizacijaMapeSlova();
    }


    private void inicijalizacijaMapeSlova() {
        for (char slovo : SlovaRepository.vratiCirilica()) {
            this.izvucenaslovamapa.put(slovo, 0);
        }
    }

    public ArrayList<Character> vratiIzvucenaSlova(){
        return izvucenaslova;
    }

    public Map<Character, Integer> vratiIzvucenuMapuSlova(){
        return izvucenaslovamapa;
    }

    public void ocistiNizIzvucenimSlovom(int index){
        this.izvucenaslovamapa.put(this.izvucenaslova.get(index), 0);
        this.izvucenaslova.remove(index);
    }

    public void ocistiCeoNizIzvucenihSlova(){
        for (Character slovo : this.izvucenaslovamapa.keySet()) {
            this.izvucenaslovamapa.put(slovo, 0);
        }
        this.izvucenaslova.clear();
    }

    public void popuniCeoNizIzvucenimSlovima(ArrayList<JTextField> polja){
        for (JTextField polje : polja) {
            this.izvucenaslova.add(polje.getText().charAt(0));
            if(!this.izvucenaslovamapa.containsKey(polje.getText().charAt(0)))
                this.izvucenaslovamapa.put(polje.getText().charAt(0), 1);
            else
                this.izvucenaslovamapa.put(polje.getText().charAt(0), this.izvucenaslovamapa.get(polje.getText().charAt(0)) + 1);
        }
    }
}
