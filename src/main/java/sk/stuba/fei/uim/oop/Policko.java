package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Policko extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        this.vykresliPolicko(g);}

    public void vykresliPolicko(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(30, 30, 50, 50);
    }
}
