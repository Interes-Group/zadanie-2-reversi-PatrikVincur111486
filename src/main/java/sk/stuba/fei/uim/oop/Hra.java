package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Hra implements KeyListener, MouseListener, MouseMotionListener, ActionListener {
    @Setter
    private int velkostHracejPlochy=6;
    @Getter
    private Okno okno;
    @Getter
    private Policko[][] policka;
    @Getter @Setter
    private HraciaPlocha plocha;
    @Getter
    private int hracNaRade=1;

    public Hra() {
        this.policka = new Policko[velkostHracejPlochy][velkostHracejPlochy];
        this.plocha = new HraciaPlocha(velkostHracejPlochy,policka,this);
        this.okno = new Okno(velkostHracejPlochy, this,plocha);
        this.okno.add(plocha);
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
                        Policko docasnePolicko=policka[i][j];
                        List<Policko> polickaVSmere= pozriNaStranu(docasnePolicko, poleSmerov[k], policka, hracNaRade);
                        vyznacHratelnePolicka(docasnePolicko, polickaVSmere, policka);
                    if(polickaVSmere.size()!=0){
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

    public List<Policko> pozriNaStranu(Policko policko,Smer smer,Policko[][] policka, int hracNaRade){
        int riadok=policko.getRiadok();
        int stlpec=policko.getStlpec();
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
                            polickaVSmere.add(policka[riadok][stlpec]);
                        }
                        break;
                    default:
                        break;}

        return polickaVSmere;
    }

        public void vyznacHratelnePolicka(Policko policko,List<Policko> polickaVSmere, Policko[][] policka){

            for(int l=0;l< polickaVSmere.size();l++){
                if(polickaVSmere.get(l).hrac == policko.hrac || polickaVSmere.get(0).hrac == 0) break;

                else{
                    if(polickaVSmere.get(l).hrac==0){
                        polickaVSmere.get(l).viemZahrat=true;
                        polickaVSmere.get(l).repaint();
                        break;
                    }

                }
            }
        }




    @Override
    public void mouseClicked(MouseEvent e) {
        /*Policko kliknutePolicko= ((Policko) e.getSource());
        Smer[] poleSmerov= new Smer[]{Smer.HORE, Smer.DOLE, Smer.VLAVO, Smer.VPRAVO, Smer.HOREVPRAVO, Smer.DOLEVPRAVO,Smer.DOLEVLAVO, Smer.HOREVLAVO};
        for(int k=0;k<8;k++){
            List<Policko> polickaVSmere=pozriNaStranu(kliknutePolicko,poleSmerov[k],policka, hracNaRade);
            int i=0;

            while(polickaVSmere.get(i).getHrac()!=0 && polickaVSmere.get(i).getHrac()!=hracNaRade){
                i++;
                if(i>=polickaVSmere.size()){
                    i--;
                    break;
                }
            }
            if(i!=0){i--;}
            while(i>0 || polickaVSmere.get(0).getHrac()!=0 && polickaVSmere.get(0).getHrac()!=hracNaRade){
                polickaVSmere.get(i).setHrac(hracNaRade);
                polickaVSmere.get(i).repaint();
                i--;
            }
        }*/
        if(((Policko) e.getSource()).viemZahrat && ((Policko) e.getSource()).hrac==0 ){
            ((Policko) e.getSource()).setHrac(hracNaRade);
            if(hracNaRade==1) {
                hracNaRade=2;
            }
            else{
                hracNaRade=1;
            }
            ((Policko) e.getSource()).repaint();
            priebehHry();
        }

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
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(((Policko) e.getSource()).viemZahrat && ((Policko) e.getSource()).hrac==0){
            ((Policko) e.getSource()).setBackground(Color.YELLOW);
        }
        ((Policko) e.getSource()).repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("ani tento reset mi nefunguje :((" );
        for (int riadok = 0; riadok < velkostHracejPlochy; riadok++) {
            for(int stlpec = 0; stlpec <velkostHracejPlochy; stlpec++){
                this.policka[riadok][stlpec].setHrac(0);
                this.policka[riadok][stlpec].setViemZahrat(false);
            }
        }
        policka[velkostHracejPlochy/2-1][velkostHracejPlochy/2-1].setHrac(1);
        policka[velkostHracejPlochy/2][velkostHracejPlochy/2].setHrac(1);
        policka[velkostHracejPlochy/2-1][velkostHracejPlochy/2].setHrac(2);
        policka[velkostHracejPlochy/2][velkostHracejPlochy/2-1].setHrac(2);
        plocha.repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    @Override
    public void mouseDragged(MouseEvent e) {
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
}

