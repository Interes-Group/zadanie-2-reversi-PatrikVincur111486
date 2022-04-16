package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Okno extends JFrame implements ActionListener, KeyListener {
    private Menu menu;
    public Okno(int velkostHracejPlochy) {
        vytvorOkno();
        this.menu = new Menu(velkostHracejPlochy);
        this.add(menu, BorderLayout.PAGE_START);
    }

    public void vytvorOkno(){
        this.setTitle("Reversi");
        this.setLayout(new BorderLayout());
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
