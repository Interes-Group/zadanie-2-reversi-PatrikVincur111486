package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {

    public Menu(int velkostHracejPlochy) {
        vytvorMenu(velkostHracejPlochy);
    }

    public void vytvorMenu(int velkostHracejPlochy){
        this.setLayout(new FlowLayout());
        String[] poleVelkostiHracejPlochy={"6","8","10","12"};
        JComboBox vyberVelkostiPlochy = new JComboBox(poleVelkostiHracejPlochy);
        vyberVelkostiPlochy.setFocusable(false);
        this.add(vyberVelkostiPlochy);
        JButton reset = new JButton("Reset");
        reset.setFocusable(false);
        JLabel velkost = new JLabel(String.valueOf(velkostHracejPlochy)+"x"+String.valueOf(velkostHracejPlochy));
        reset.addActionListener(this);
        this.add(reset);
        this.add(velkost);
        JLabel hracNaRade = new JLabel("Hrac 1 - Biely");
        this.add(hracNaRade);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nefunguje mi reset");         ///dorobit
    }
}
