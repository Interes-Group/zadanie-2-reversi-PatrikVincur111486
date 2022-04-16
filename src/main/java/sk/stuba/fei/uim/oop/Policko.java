package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class Policko extends JPanel {
    @Setter @Getter
    int hrac;
    @Getter
    int riadok;
    @Getter
    int stlpec;
    @Setter
    boolean viemZahrat;


    public Policko(int riadok, int stlpec, Hra hra) {
        this.riadok=riadok;
        this.stlpec=stlpec;
        this.hrac=0;
        this.viemZahrat=false;

        this.setBackground(new Color(0, 128, 0));
        this.addMouseListener(hra);
        this.addMouseMotionListener( hra);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.hrac==1) {
            g.setColor(Color.WHITE);
            g.fillOval(5, 5, this.getWidth() -10, this.getHeight() -10);
        }
        else if(this.hrac==2) {
            g.setColor(Color.BLACK);
            g.fillOval(5, 5, this.getWidth() -10, this.getHeight() -10);
        }
        if(this.viemZahrat){
            g.setColor(Color.BLUE);
            g.drawOval(5, 5, this.getWidth() -10, this.getHeight() -10);
        }
    }
}
