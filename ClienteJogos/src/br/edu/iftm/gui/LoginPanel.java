package br.edu.iftm.gui;


import br.edu.iftm.gui.components.Botao;
import br.edu.iftm.gui.components.TelaPanel;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;


public class LoginPanel extends TelaPanel {
    private JButton botaoLogin;
    public LoginPanel(JPanel telas, JFrame janela) {
        super(telas, janela);
        JLabel message = new JLabel("Conteúdo do Login panel");

        JLabel txtLogin = new JLabel("Insira seu Login:");
        txtLogin.setBounds(560, 255, 300, 35);
        txtLogin.setForeground(Color.decode("#dcdcdc"));
        txtLogin.setFont(new Font("Montserrat", Font.BOLD, 20));
        JTextField campoLogin = new JTextField();
        campoLogin.setBounds(570, 300, 300,35);

        JLabel txtSenha = new JLabel("Insira sua Senha:");
        txtSenha.setBounds(560, 345, 300, 35);
        txtSenha.setForeground(Color.decode("#dcdcdc"));
        txtSenha.setFont(new Font("Montserrat", Font.BOLD, 20));
        JTextField campoSenha = new JTextField();
        campoSenha.setBounds(570, 390, 300,35);


        Botao botaoLogin = new Botao("Fazer Login");
        botaoLogin.addActionListener(this);



        this.add(message);
        this.add(botaoLogin);
        this.add(txtLogin);
        this.add(campoLogin);
        this.add(txtSenha);
        this.add(campoSenha);
    }
    public void executarBotao(ActionEvent e){
        trocarTela("Tela Principal");
    }
}
