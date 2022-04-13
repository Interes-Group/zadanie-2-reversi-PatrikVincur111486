package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HraciaPlocha {
    ArrayList<JPanel> policka;
    JPanel panel;
    public HraciaPlocha(int velkostHracejPlochy, Okno okno) {

        this.panel = new JPanel(new GridLayout(velkostHracejPlochy,velkostHracejPlochy,5,5));
        this.policka = new ArrayList<>();
        for(int i=0,p=0;i<velkostHracejPlochy*velkostHracejPlochy;i++,p++){
            JPanel policko=new JPanel();
            this.panel.add(policko);
            this.policka.add(policko);
            if(i%6==0) p++;
            if(p%2==0) {
                policko.setBackground(new Color(0, 128, 0));}
            else {
                policko.setBackground(new Color(102, 124, 38));}
        }
        panel.setBackground(Color.BLACK);
        //policka.get(0).repaint(10,10,10,10);
        //policka.get(0).repaint(30,20,50,50);

        okno.add(panel);
    }
}
