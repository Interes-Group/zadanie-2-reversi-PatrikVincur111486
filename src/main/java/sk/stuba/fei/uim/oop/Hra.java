package sk.stuba.fei.uim.oop;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Hra extends UniversalAdapter {
    int velkostHracejPlochy = 6;
    HraciaPlocha plocha;

    public Hra() {
        plocha = new HraciaPlocha(velkostHracejPlochy);
        pozriMozneTahy(1);

    }


    public void pozriMozneTahy(int hracNaRade) {

        Policko[][] policka = new Policko[velkostHracejPlochy][velkostHracejPlochy];
        policka = plocha.getPolicka();
        for (int i = 0; i < velkostHracejPlochy; i++) {
            Smer[] poleSmerov= new Smer[]{Smer.HORE, Smer.DOLE, Smer.VLAVO, Smer.VPRAVO, Smer.HOREVPRAVO, Smer.DOLEVPRAVO,Smer.DOLEVLAVO, Smer.HOREVLAVO};
            for (int j = 0; j < velkostHracejPlochy; j++) {
                if (policka[i][j].hrac == hracNaRade) {
                    for(int k=0;k<8;k++) {
                    pozriNaStranu(policka[i][j], poleSmerov[k], policka);
                    //pozriNaStranu(policka[2][2], poleSmerov[k], policka);
                    }

                }
            }
       }

    }

    public void pozriNaStranu(Policko policko,Smer smer,Policko[][] policka){
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
    }


}
