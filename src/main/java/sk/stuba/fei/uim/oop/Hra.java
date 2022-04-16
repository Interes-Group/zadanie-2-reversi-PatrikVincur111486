package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Hra implements KeyListener, MouseListener, MouseMotionListener {
    private int velkostHracejPlochy = 6;
    private Okno okno;
    private Policko[][] policka;
    private HraciaPlocha plocha;
    private int hracNaRade;

    public Hra() {
        hracNaRade=1;
        this.okno = new Okno(velkostHracejPlochy);
        this.policka = new Policko[velkostHracejPlochy][velkostHracejPlochy];
        this.plocha = new HraciaPlocha(velkostHracejPlochy,policka,this);
        this.okno.add(plocha);
        this.okno.addKeyListener(this);
        priebehHry();
        this.okno.setVisible(true);
    }


    public void priebehHry(){
        pozriMozneTahy(hracNaRade);
    }

    public int pozriMozneTahy(int hracNaRade) {
        int pocetMoznychTahov=0;int pocetMoznychTahovVSmere=0;
        for (int i = 0; i < velkostHracejPlochy; i++) {
            Smer[] poleSmerov= new Smer[]{Smer.HORE, Smer.DOLE, Smer.VLAVO, Smer.VPRAVO, Smer.HOREVPRAVO, Smer.DOLEVPRAVO,Smer.DOLEVLAVO, Smer.HOREVLAVO};
            for (int j = 0; j < velkostHracejPlochy; j++) {
                if (policka[i][j].hrac == hracNaRade) {
                    for(int k=0;k<8;k++) {
                    pozriNaStranu(policka[i][j], poleSmerov[k], policka);
                    if(pozriNaStranu(policka[i][j], poleSmerov[k], policka)!=0){
                        pocetMoznychTahovVSmere++;
                        }
                    }
                }
            }
            if(pocetMoznychTahovVSmere!=0){
                pocetMoznychTahov++;
            }
       }
        if(pocetMoznychTahov==0) return -1;
        return 1;
    }

    public int pozriNaStranu(Policko policko,Smer smer,Policko[][] policka){
        int riadok=policko.riadok;
        int stlpec=policko.stlpec;
        List<Policko> polickaVSmere=new ArrayList<>();
        switch (smer){
            case DOLE:
                while(riadok<5){
                    riadok=riadok+1;
                    polickaVSmere.add(policka[riadok][stlpec]);
                }
                break;
            case HORE:
                while(riadok>0){
                    riadok=riadok-1;
                    polickaVSmere.add(policka[riadok][stlpec]);
                }
                break;
            case VLAVO:
                while(stlpec>0){
                    stlpec=stlpec-1;
                    polickaVSmere.add(policka[riadok][stlpec]);
                }
                break;
            case VPRAVO:
                while(stlpec<5){
                    stlpec=stlpec+1;
                    polickaVSmere.add(policka[riadok][stlpec]);
                }
                break;
            case DOLEVLAVO:
                while(riadok<5 && stlpec>0){
                    riadok=riadok+1;stlpec=stlpec-1;
                    polickaVSmere.add(policka[riadok][stlpec]);
                }
                break;
            case HOREVLAVO:
                while(riadok>0 && stlpec>0){
                    riadok=riadok-1;stlpec=stlpec-1;
                    polickaVSmere.add(policka[riadok][stlpec]);
                }
                break;
            case DOLEVPRAVO:
                while(riadok<5 && stlpec<5){
                    stlpec=stlpec+1;riadok=riadok+1;
                    polickaVSmere.add(policka[riadok][stlpec]);
                }
                break;
            case HOREVPRAVO:
                while(riadok>0 && stlpec<5){
                riadok=riadok-1;stlpec=stlpec+1;
                }
                break;
            default:
                break;}
        for(int l=0;l< polickaVSmere.size();l++){
            if(polickaVSmere.get(l).hrac == policko.hrac || polickaVSmere.get(0).hrac == 0) break;
            else{
                if(polickaVSmere.get(l).hrac==0){
                    polickaVSmere.get(l).viemZahrat=true;
                    break;
                }

            }
        }
        return polickaVSmere.size();
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if(((Policko) e.getSource()).viemZahrat){
            ((Policko) e.getSource()).setHrac(hracNaRade);
        }
        ((Policko) e.getSource()).repaint();

    }
    @Override
    public void mouseExited(MouseEvent e) {
        ((Policko) e.getSource()).setBackground (new Color(0, 128, 0));
        ((Policko) e.getSource()).repaint();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.okno.dispose();
        }
        else if(e.getKeyCode()==KeyEvent.VK_R){
            System.out.println("ani tento reset mi nefunguje");
            this.plocha = new HraciaPlocha(velkostHracejPlochy,policka, this);
            this.okno.add(plocha);
        }
        /*this.okno.setFocusable(true);
        this.okno.requestFocus();*/
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(((Policko) e.getSource()).viemZahrat){
            ((Policko) e.getSource()).setBackground(Color.YELLOW);
        }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
