package br.edu.iftm.gui;

import javax.swing.*;
import java.awt.*;

public class Janela extends JFrame {
    public Janela() {
        this.setBounds(0,0,1440, 900);


        CardLayout controleTela = new CardLayout();
        JPanel telas = new JPanel(controleTela);

        LoginPanel loginPanel = new LoginPanel(telas, this);
        BibliotecaPanel principalPanel = new BibliotecaPanel(telas, this);

        telas.add(loginPanel, "Tela Login");
        telas.add(principalPanel, "Tela Principal");

        this.add(telas);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);



        this.setVisible(true);

        // janela - TV
        // login - canal 1
        // principal canal 2
    }
}
