package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Okno extends JFrame {
    public Okno() {
        this.setTitle("Reversi");
       // addKeyListener(this);
        this.setLayout(new BorderLayout());
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

    }


}
