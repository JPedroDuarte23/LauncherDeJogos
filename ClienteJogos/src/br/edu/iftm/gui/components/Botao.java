package br.edu.iftm.gui.components;

import javax.swing.*;
import java.awt.*;

public class Botao extends JButton {
    public Botao(String texto) {
        super(texto);
        this.setBounds(620,520,200,60);
        this.setBackground(Color.decode("#6d5dd3"));
        this.setFocusPainted(false);
        this.setBorderPainted(false);
    }

}
