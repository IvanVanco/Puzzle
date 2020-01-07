package slagalica.data;


public enum VerovatnoceRepository {

    А('А', 2d / 30, false),
    Е('Е', 2d / 30, false),
    И('И', 2d / 30, false),
    О('О', 2d / 30, false),
    У('У', 2d / 30, false),
    Р('Р',2d/30, false),
    Џ('Џ', 0.165d / 30, true),
    Ф('Ф', 0.165d / 30, true),
    Ч('Ч', 0.19d / 30, true),
    Ђ('Ђ', 0.19d / 30, true),
    Ћ('Ћ', 0.19d / 30, true),
    Љ('Љ', 0.2d / 30, true),
    Њ('Њ', 0.2d / 30, true),
    Ж('Ж', 0.2d / 30, true),
    Х('Х', 0.25d / 30, true),
    Ш('Ш', 0.25d / 30, true),
    Ц('Ц', 0.5d / 30, true),
    З('З', 0.5d / 30, false),
    Д('Д', 1d / 30, false),
    Л('Л', 1d / 30, false),
    Г('Г', 1d / 30, false),
    М('М', 1.33d / 30, false),
    Н('Н', 1.33d / 30, false),
    С('С', 1.33d / 30, false),
    П('П', 1.33d / 30, false),
    Т('Т', 1.33d / 30, false),
    Б('Б', 1.33d / 30, false),
    К('К', 1.33d / 30, false),
    Ј('Ј', 1.33d / 30, false),
    В('В', 1.33d / 30, false);


    private final double ponder;
    private final char slovo;
    private final boolean izbaci;


    VerovatnoceRepository(char slovo, double ponder, boolean izbaci) {
        this.slovo = slovo;
        this.ponder = ponder;
        this.izbaci = izbaci;
    }


    public char vratiSlovo() {
        return slovo;
    }

    public double vratiPonder() {
        return ponder;
    }

    public boolean daLiIzbaci() {
        return izbaci;
    }

}