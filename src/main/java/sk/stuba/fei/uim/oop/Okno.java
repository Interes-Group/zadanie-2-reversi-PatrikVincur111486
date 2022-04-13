package sk.stuba.fei.uim.oop;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class Okno extends JPanel {

    public Okno(int velkostHracejPlochy) {
        JFrame okno = new JFrame("Reversi");
        okno.setLayout(new BorderLayout());
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

        okno.setVisible(true);
    }




}
