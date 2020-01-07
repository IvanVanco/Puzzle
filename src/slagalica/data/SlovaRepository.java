package slagalica.data;

public class SlovaRepository {

    private static char[] cirilica =   {'А','Б','В','Г','Д','Ђ','Ђ','Е','Ж','З','И','Ј','К','Л','Љ','М','Н','Њ','О','П','Р','С','Т','Ћ','У','Ф','Х','Ц','Ч','Џ','Ш'};
    private static String[] latinica = {"A","B","V","G","D","DJ","Đ","E","Ž","Z","I","J","K","L","LJ","M","N","NJ","O","P","R","S","T","Ć","U","F","H","C","Č","DŽ","Š"};


    public static char[] vratiCirilica() {
        return cirilica;
    }

    public static String[] vratiLatinica() {
        return latinica;
    }
}
