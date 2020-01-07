package slagalica.model.poruka;

import slagalica.model.izvlacenje.IzvucenoSlovo;
import slagalica.model.izvlacenje.UnesenoSlovo;
import java.util.ArrayList;


public class ProveravacSlovo {

    private IzvucenoSlovo izvucenaslova;
    private UnesenoSlovo unesenaslova;
    private ArrayList<Character> tacnounesenaslova = new ArrayList<>();
    private String pogresnaunesenarec;
    private String pogresnaunesenareckonkatenacija;
    private ArrayList<Character> pogresnaunesenaslova = new ArrayList<>();


    public ProveravacSlovo(IzvucenoSlovo izvucenaslova, UnesenoSlovo unesenaslova) {
        this.izvucenaslova = izvucenaslova;
        this.unesenaslova = unesenaslova;
    }


    public UnesenoSlovo vratiUnesenaslova() {
        return unesenaslova;
    }

    public IzvucenoSlovo vratiIzvucenaslova() {
        return izvucenaslova;
    }

    public ArrayList<Character> tacnounesenaslova(){
        return tacnounesenaslova;
    }

    public ArrayList<Character> pogresnaunesenaslova(){
        return pogresnaunesenaslova;
    }

    public String vratiTrenutnuPogresnuRec(){
        return pogresnaunesenarec;
    }

    public boolean daLiSuPraznaPogresnoUnesenaSlova(){
        return pogresnaunesenaslova.isEmpty();
    }

    public String napraviPogresnoUnesenuRec() {
        String konkatenovanarec;
        StringBuilder build = new StringBuilder();
        StringBuilder konkatenacija = new StringBuilder();
        for (Character slovo : this.pogresnaunesenaslova ) {
            build.append(slovo);
            konkatenacija.append(slovo).append(",");
        }
        if (!build.toString().isEmpty()){
            this.pogresnaunesenarec = build.toString();
            this.pogresnaunesenareckonkatenacija = konkatenacija.deleteCharAt(konkatenacija.length() - 1).toString();
        }
        return this.pogresnaunesenareckonkatenacija;
    }


    public void proveriSlaganje() {
        izvucenaslova.vratiIzvucenaSlova().addAll(this.tacnounesenaslova);
        this.tacnounesenaslova.clear();
        this.pogresnaunesenaslova.clear();

        for(int k = 0; k < unesenaslova.vratiUnesenaSlova().size(); k++){
            if(izvucenaslova.vratiIzvucenaSlova().remove(unesenaslova.vratiUnesenaSlova().get(k))){
                this.tacnounesenaslova.add(unesenaslova.vratiUnesenaSlova().get(k));
            }
            else {
                this.pogresnaunesenaslova.add(unesenaslova.vratiUnesenaSlova().get(k));
            }
        }
    }


}
