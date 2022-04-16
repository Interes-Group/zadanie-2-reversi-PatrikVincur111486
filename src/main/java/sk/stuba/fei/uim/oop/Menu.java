package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    private JComboBox<Integer> vyberVelkostiPlochy;
    private Hra hra;
    public Menu(int velkostHracejPlochy, Hra hra) {
        Integer[] poleVelkostiHracejPlochy={6,8,10,12};
        vyberVelkostiPlochy = new JComboBox(poleVelkostiHracejPlochy);
        this.hra = hra;
        vytvorMenu(velkostHracejPlochy, hra);
    }

    public void vytvorMenu(int velkostHracejPlochy, Hra hra){
        this.setLayout(new FlowLayout());
        vyberVelkostiPlochy.addActionListener(this);
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
        int novaVelkostPola= ((Integer) vyberVelkostiPlochy.getSelectedItem());
        System.out.println("nefunfuje mi reset :(");
    }
}
