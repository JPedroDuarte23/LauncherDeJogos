package br.edu.iftm.gui.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Imagem extends JLabel  {
    private Image image;
    private int alpha = 255;

    public void setImageAlpha(int alpha) {
        this.alpha = alpha;
        repaint();
    }

    public void setImage(Image image) {
        this.image = image;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha / 255f));
        super.paintComponent(g2d);
        g2d.dispose();
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha / 255f));
        super.paintChildren(g2d);
        g2d.dispose();
    }
    public Imagem(String nome) {
        super();
        ImageIcon icon = new ImageIcon(Imagem.class.getResource("/img/" + nome));
        setIcon(icon);
        repaint();
    }
}
