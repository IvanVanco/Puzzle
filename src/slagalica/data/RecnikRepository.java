package slagalica.data;

import java.io.*;
import java.util.ArrayList;


public class RecnikRepository {

    private static final File file = new File(".\\resource\\Recnik cirilica.txt");;
    private ArrayList<String> repo;

    public RecnikRepository(){
        inicijalizacijaRecnika();
    }


    private void inicijalizacijaRecnika(){
        InputStreamReader istreamReader = null;
        try {
            istreamReader = new InputStreamReader(new FileInputStream(file),"UTF-16");
        }
        catch (UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(istreamReader);
        try {
            repo = new ArrayList<>();
            String str;
            while ((str = br.readLine()) != null) {
                repo.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> vratiRepo() {
        return repo;
    }
}