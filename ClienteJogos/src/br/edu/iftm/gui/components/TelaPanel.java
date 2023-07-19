package br.edu.iftm.gui.components;

import br.edu.iftm.gui.components.Imagem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPanel extends JPanel implements ActionListener {
    private JPanel telas;
    private CardLayout controleTela;
    private JFrame janela;
    public TelaPanel(JPanel telas, JFrame janela) {

        this.telas = telas;
        this.controleTela = (CardLayout) telas.getLayout();
        this.janela = janela;
        this.setBackground(Color.decode("#202028"));
        this.setLayout(null);

        Imagem botaoFechar = new Imagem("window-close-custom.png");
        botaoFechar.setBounds(1400, 0, 36, 36);

        Imagem botaoMinimizar = new Imagem("window-minimize-custom.png");
        botaoMinimizar.setBounds(1366, 0, 36, 36);

        botaoFechar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                janela.dispose();
            }
        });
        botaoMinimizar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                janela.setState(JFrame.ICONIFIED);
            }
        });

        this.add(botaoFechar);
        this.add(botaoMinimizar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        executarBotao(e);
    }

    protected void executarBotao(ActionEvent e) {

    }

    protected void trocarTela(String identificador) {
        controleTela.show(telas,identificador);
    }
























}
