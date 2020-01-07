package slagalica.model.konvertovanje;

import slagalica.data.SlovaRepository;
import java.util.HashMap;
import java.util.Map;


public class KonvertorRec {

    private String konverzija;
    private static Map<String, Character> mapiranje = new HashMap<>();

    static {
        for (int i=0; i < SlovaRepository.vratiCirilica().length; i++) {
            mapiranje.put(SlovaRepository.vratiLatinica()[i], SlovaRepository.vratiCirilica()[i]);
        }
    }


    public KonvertorRec(String rec) {
        latinToCyrillic(velikaSlova(rec));
    }

    public KonvertorRec(Character slovo) {
        latinToCyrillic(velikaSlova(slovo.toString()));
    }

    public KonvertorRec(String tip, String rec) {
        latinToCyrillic(malaSlova(rec));
    }


    public String vratiKonverzija() {
        return konverzija;
    }

    private String velikaSlova (String rec){
        return this.konverzija = rec.toUpperCase();
    }

    private String malaSlova (String rec){
        return this.konverzija = rec.toLowerCase();
    }

    private String latinToCyrillic (String rec){
        StringBuilder latbuffer = new StringBuilder(rec);
        StringBuilder cirbuffer = new StringBuilder();

        for (int i = 0; i < latbuffer.length(); i++) {
            String s = latbuffer.substring(i,i+1);
            if( i < latbuffer.length() - 1) {
                char c = latbuffer.charAt(i+1);
                if((s.equals("L") || s.equals("N") || s.equals("D")) && (c == 'J')) {
                    s = s + 'J';
                    i++;
                }
                else if ((s.equals("D")  && (c == 'Ž'))) {
                    s = s + 'Ž';
                    i++;
                }
            }
            if (mapiranje.containsKey(s)) {
                cirbuffer.append(mapiranje.get(s).charValue());
            }
            else {
                cirbuffer.append(s);
            }
        }
        return this.konverzija = cirbuffer.toString();
    }

}
