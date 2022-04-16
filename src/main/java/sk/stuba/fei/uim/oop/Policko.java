package sk.stuba.fei.uim.oop;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Policko extends JPanel implements MouseMotionListener, MouseListener {
    @Setter
    int hrac;
    int riadok;
    int stlpec;
    boolean viemZahrat;

    public Policko(int hrac, int riadok, int stlpec) {
        this.riadok=riadok;
        this.stlpec=stlpec;
        this.hrac=hrac;
        this.viemZahrat=false;
        this.setBackground(new Color(0, 128, 0));
        addMouseMotionListener(this);
        addMouseListener(this);
    }

/// metoda na ziskanie hracanarade
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

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(new Color(0, 128, 0));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.setBackground(Color.YELLOW);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(this.viemZahrat){
            this.hrac=1;
        }
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

}
