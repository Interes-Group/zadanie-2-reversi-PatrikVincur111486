package sk.stuba.fei.uim.oop;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Hra {

    public Hra() {
        JFrame okno = new JFrame("Reversi");
        okno.setSize(800,800);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);

        JPanel menu = new JPanel(new FlowLayout());
        String[] poleVelkostiHracejPlochy={"6","8","10","12"};
        JComboBox vyberVelkostiPlochy = new JComboBox(poleVelkostiHracejPlochy);
        menu.add(vyberVelkostiPlochy);
        JButton reset = new JButton("Reset");
        menu.add(reset);
        okno.add(menu,BorderLayout.PAGE_START);

        int velkostHracejPlochy=6;
        JPanel panel = new JPanel(new GridLayout(velkostHracejPlochy,velkostHracejPlochy,5,5));
        for(int i=0,p=0;i<velkostHracejPlochy*velkostHracejPlochy;i++){
            JPanel policko=new JPanel();
            panel.add(policko);
            if(i%6==0) p++;

            if(p%2==0) {
                policko.setBackground(new Color(0, 128, 0));
            }
            else if(p%2!=0) {
                policko.setBackground(new Color(102, 124, 38));
            }
            p++;
        }


        panel.setBackground(Color.BLACK);
        okno.add(panel);






        okno.setVisible(true);
    }


}
