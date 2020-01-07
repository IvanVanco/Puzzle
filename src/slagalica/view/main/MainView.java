package slagalica.view.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class MainView extends JFrame{

    private ArrayList<JTextField> polja = new ArrayList<>(12);              //12 Slova
    private JButton zaustavi = new JButton("ZAUSTAVI");
    private JButton ocisti = new JButton("OČISTI");
    private JButton potvrdirec = new JButton("POTVRDI");
    private JTextField vreme = new JTextField();
    private JTextField unosenje = new JTextField("Unesite pronađenu reč na ćirilici");
    private JLabel vremelabela = new JLabel("Vreme:               ", SwingConstants.RIGHT);


    BorderLayout centar = new BorderLayout(10,10);
    JPanel gore = new JPanel(new BorderLayout(10,10));
    JPanel levo = new JPanel(new BorderLayout(10,10));                      //Prazni paneli
    JPanel desno = new JPanel(new BorderLayout(10,10));
    JPanel dole = new JPanel(new BorderLayout(10,10));

    JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,5));        //Flow Lay

    JPanel dugmici = new JPanel(new GridLayout(1, 2, 10, 10));  //Panel za 2 jbuttona
    JPanel textovi = new JPanel(new GridLayout(0, 12, 10, 10)); //Panel za slova


    public MainView() {
        setSize(700, 300);
        setLocationRelativeTo(null);
        setLayout(centar);
        getContentPane().setSize(222, 222);

        /****************SLOVA**********************/
        dodajPolja();
        postaviVelicinuPolja();
        zakljucajTextPolja();
        postaviFormatTextaPolja();

        /****************VELICINE**********************/
        velicinaKomponente(zaustavi,90,90);
        velicinaKomponente(ocisti,90,90);
        velicinaKomponente(vreme,90,90);
        velicinaKomponente(unosenje,560,27);

        /****************FONT********************/
        postaviFont(zaustavi,Font.SERIF, Font.BOLD, 17);
        postaviFont(ocisti,Font.SERIF, Font.BOLD, 17);

        /****************FORMATI********************/
        zakljucajTextVremena();
        postaviFormatVremena();
        postaviFormatUnosenjaReci();
        potvrdirec.setEnabled(false);
        unosenje.setEditable(false);
        //zabranjujem copy i paste
        unosenje.setTransferHandler(null);


        dugmici.add(zaustavi);
        dugmici.add(ocisti);
        dodajPoljaNaPanel();
        desno.add(vreme);
        gore.add(vremelabela);
        flow.add(unosenje);
        flow.add(potvrdirec);
        dole.add(textovi);
        dole.add(flow,BorderLayout.SOUTH);


        add(dugmici,BorderLayout.CENTER);
        add(dole,BorderLayout.SOUTH);
        add(gore,BorderLayout.NORTH);
        add(levo,BorderLayout.WEST);
        add(desno,BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JButton vratiPotvrdiRec(){
        return potvrdirec;
    }

    public JButton vratiZaustavi(){
        return zaustavi;
    }

    public JButton vratiOcisti(){
        return ocisti;
    }


    /**************************************GENERICKI**************************************/

    public void postaviFont(JComponent komponenta, String fontname, int fonttype, int velicina){
        komponenta.setFont(new Font(fontname, fonttype, velicina));
    }

    private void velicinaKomponente(JComponent komponenta, int i, int j){
        komponenta.setPreferredSize(new Dimension(i, j));
    }

    /**************************************SLOVA**************************************/

    public ArrayList<JTextField> vratiPolja(){
        return polja;
    }

    private void dodajPolja(){
        for(int i=0; i<12 ;i++){
            this.polja.add(new JTextField());
        }
    }

    private void dodajPoljaNaPanel(){
        for(int i=0; i<12 ;i++)
            textovi.add(this.polja.get(i));
    }

    private void postaviVelicinuPolja(){
        for(int i=0; i<12 ;i++){
            velicinaKomponente(this.polja.get(i),90,90);
        }
    }

    public void postaviTextNaPoljeSlova(int i, String text){
        this.polja.get(i).setText(text);
    }

    public String pregledajTextPrethodnogPoljaSlova(int trenutniIndex){
        if(trenutniIndex <= 0){
            return "";
        }
        else {
            return this.polja.get(trenutniIndex - 1).getText();
        }
    }

    private void zakljucajTextPolja(){
        for(int i=0; i<12 ;i++){
            this.polja.get(i).setEditable(false);
        }
    }

    private void postaviFormatTextaPolja(){
        for(int i=0; i<12 ;i++){
            this.polja.get(i).setFont(new Font(Font.SERIF, Font.BOLD, 25));
            this.polja.get(i).setForeground(new Color(0,0,0));
            this.polja.get(i).setHorizontalAlignment(JTextField.CENTER);
            postaviBojuPolja(Color.WHITE);
        }
    }

    public void postaviBojuPolja(Color boja){
        for(int i=0; i<12; i++)
            this.polja.get(i).setBackground(boja);
    }

    /**************************************VREME**************************************/

    public JTextField vratiVreme(){ return vreme; }

    public void ocistiVreme(){
        this.vreme.setText("");
    }

    public void postaviVreme(String text){
        vreme.setText(text);
    }

    private void zakljucajTextVremena(){
        this.vreme.setEditable(false);
    }

    private void postaviFormatVremena(){
        this.vreme.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        this.vreme.setForeground(new Color(0,0,0));
        this.vreme.setHorizontalAlignment(JTextField.CENTER);
        this.vreme.setBackground(Color.WHITE);
    }

    /**************************************UNOSENJE**************************************/

    public JTextField vratiUnesenoPolje(){
        return unosenje;
    }

    public String vratiUnesenText(){
        return unosenje.getText();
    }

    public void postaviUnesenText(String text){
        this.unosenje.setText(text);
    }

    public void postaviFormatUnosenjaReci(){
        this.unosenje.setFont(new Font(Font.SERIF, Font.ITALIC, 20));
        this.unosenje.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void postaviFormatUnosenjaReci2(){
        this.unosenje.setFont(new Font(Font.SERIF, Font.PLAIN, 20));
        this.unosenje.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**************************************LISTENERI**************************************/

    public void postaviZaustaviOsluskivac(ActionListener ZaustaviOsluskivac){
        this.zaustavi.addActionListener(ZaustaviOsluskivac);
    }

    public void postaviOcistiOsluskivac(ActionListener OcistiOsluskivac){
        this.ocisti.addActionListener(OcistiOsluskivac);
    }

    public void postaviPotvrdiRecOsluskivac(ActionListener PotvrdiRecOsluskivac){
        this.potvrdirec.addActionListener(PotvrdiRecOsluskivac);
    }

    public void postaviUnosenjeOsluskivac(MouseListener UnosenjeMouseOsluskivac){
        this.unosenje.addMouseListener(UnosenjeMouseOsluskivac);
    }

    public void postaviUnosenjeOsluskivac(KeyListener UnosenjeKeyOsluskivac){
        this.unosenje.addKeyListener(UnosenjeKeyOsluskivac);
    }


    }