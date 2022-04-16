package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame{
    private Menu menu;
    public Okno(int velkostHracejPlochy, Hra hra, HraciaPlocha plocha) {
        vytvorOkno();
        this.menu = new Menu(velkostHracejPlochy, hra);
        this.add(menu, BorderLayout.PAGE_START);
        this.addKeyListener(hra);
    }
    public void vytvorOkno(){
        this.setTitle("Reversi");
        this.setLayout(new BorderLayout());
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
