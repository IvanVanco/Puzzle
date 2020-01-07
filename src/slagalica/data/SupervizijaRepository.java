package slagalica.data;

import slagalica.model.konvertovanje.KonvertorRec;
import java.io.*;


public class SupervizijaRepository {

    private static final File file = new File(".\\resource\\Supervizija.txt");
    private KonvertorRec konvertorRec;


    public SupervizijaRepository(){
    }


    public void sacuvaj(String rec){
        OutputStreamWriter outstreamReader = null;
        try {
            outstreamReader = new OutputStreamWriter(new FileOutputStream(file, true),"UTF-16");
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(outstreamReader);

        try {
            konvertorRec = new KonvertorRec("supervizija", rec);
            bw.write(konvertorRec.vratiKonverzija());
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





