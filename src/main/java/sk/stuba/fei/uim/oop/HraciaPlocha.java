package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class HraciaPlocha extends JPanel implements ActionListener, KeyListener {
    private JPanel panel;
    @Getter
    private Policko[][] policka;
    private int velkostHracejPlochy;
    private JFrame okno;
    private JPanel menu;

    public HraciaPlocha(int velkostHracejPlochy) {
        this.velkostHracejPlochy = velkostHracejPlochy;
        this.panel =  new JPanel(new GridLayout(velkostHracejPlochy,velkostHracejPlochy,5,5));
        this.policka = new Policko[velkostHracejPlochy][velkostHracejPlochy];
        //this.okno = new JFrame("Reversi");
        this.okno = new Okno();
        this.menu = new JPanel(new FlowLayout());
        vytvorMenu();
        vykresliPolicka();
        //vytvorOkno();
        this.add(menu,BorderLayout.PAGE_START);
        this.add(panel);
        okno.setVisible(true);

    }

    /*public void vytvorOkno(){
        this.okno.addKeyListener(this);
        this.okno.setLayout(new BorderLayout());
        this.okno.setSize(800,800);
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.setResizable(false);
        this.okno.add(menu,BorderLayout.PAGE_START);
        this.okno.add(panel);
    }*/


    public void vytvorMenu(){
        String[] poleVelkostiHracejPlochy={"6","8","10","12"};
        JComboBox vyberVelkostiPlochy = new JComboBox(poleVelkostiHracejPlochy);
        vyberVelkostiPlochy.setFocusable(false);
        this.menu.add(vyberVelkostiPlochy);
        JButton reset = new JButton("Reset");
        reset.setFocusable(false);
        JLabel velkost = new JLabel(String.valueOf(velkostHracejPlochy)+"x"+String.valueOf(velkostHracejPlochy));
        reset.addActionListener(this);
        this.menu.add(reset);
        this.menu.add(velkost);
        JLabel hracNaRade = new JLabel("Hrac 1 - Biely");
        this.menu.add(hracNaRade);
        this.add(menu,BorderLayout.PAGE_START);
        this.add(panel);

    }

    public void vykresliPolicka() {
        this.panel.setBackground(Color.BLACK);
        for (int riadok = 0; riadok < velkostHracejPlochy; riadok++) {
            for(int stlpec = 0; stlpec <velkostHracejPlochy; stlpec++){
            Policko policko = new Policko(0,riadok, stlpec);
            this.panel.add(policko);
            this.policka[riadok][stlpec]=policko;
            }
        }
        this.policka[velkostHracejPlochy/2-1][velkostHracejPlochy/2-1].setHrac(1);
        this.policka[velkostHracejPlochy/2][velkostHracejPlochy/2].setHrac(1);
        this.policka[velkostHracejPlochy/2-1][velkostHracejPlochy/2].setHrac(2);
        this.policka[velkostHracejPlochy/2][velkostHracejPlochy/2-1].setHrac(2);


        this.panel.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        okno.remove(this); //dorobit
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("aaaa");
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
