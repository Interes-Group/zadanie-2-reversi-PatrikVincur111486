package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class HraciaPlocha extends JPanel{

    public HraciaPlocha(int velkostHracejPlochy, Policko[][] policka, Hra hra) {
        vytvorPlochu(velkostHracejPlochy, policka, hra);
    }

    public void vytvorPlochu(int velkostHracejPlochy, Policko[][] policka, Hra hra) {
        this.setLayout(new GridLayout(velkostHracejPlochy,velkostHracejPlochy,5,5));
        this.setBackground(Color.BLACK);
        for (int riadok = 0; riadok < velkostHracejPlochy; riadok++) {
            for(int stlpec = 0; stlpec <velkostHracejPlochy; stlpec++){
            Policko policko = new Policko(0,riadok, stlpec, hra);
            this.add(policko);
            policka[riadok][stlpec]=policko;
            }
        }
        policka[velkostHracejPlochy/2-1][velkostHracejPlochy/2-1].setHrac(1);
        policka[velkostHracejPlochy/2][velkostHracejPlochy/2].setHrac(1);
        policka[velkostHracejPlochy/2-1][velkostHracejPlochy/2].setHrac(2);
        policka[velkostHracejPlochy/2][velkostHracejPlochy/2-1].setHrac(2);
        this.repaint();
    }
}
