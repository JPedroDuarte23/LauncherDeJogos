package br.edu.iftm.gui;

import br.edu.iftm.gui.components.Botao;
import br.edu.iftm.gui.components.Imagem;
import br.edu.iftm.gui.components.TelaPanel;
import br.edu.iftm.modelos.Jogo;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class BibliotecaPanel extends TelaPanel {
    private ArrayList<Jogo> jogos;

    private JPanel grid;

    private Imagem imagemFundo;

    private Jogo jogoSelecionado;
    public BibliotecaPanel(JPanel telas, JFrame janela) {
        super(telas, janela);
        this.jogos = new ArrayList<Jogo>();


        grid = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 20));
        grid.setBackground(Color.decode("#202028"));

        carregarJogos();
        exibirJogos();

        JScrollPane scrollPanel = new JScrollPane(grid);
        scrollPanel.setBounds(60,490, 1340, 360);
        scrollPanel.setBorder(null);
        scrollPanel.setViewportBorder(null);



        Botao botaoJogar = new Botao("Jogar");
        botaoJogar.setBounds(1150,350,200,75);
        botaoJogar.setForeground(Color.white);

        botaoJogar.addActionListener(e -> {
            try {
                executarJogo();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Font newFont = botaoJogar.getFont().deriveFont(22f);

        // Set the new font for the button's text
        botaoJogar.setFont(newFont);




        imagemFundo = new Imagem("lol_big.jpg");
        imagemFundo.setBounds(0, 0, 1440, 900);


        this.add(scrollPanel);
        this.add(botaoJogar);
        this.add(imagemFundo);

    }

    private void exibirJogos() {
        int localizacaoX = 80;
        for(Jogo jogo : jogos) {
            String icone = jogo.getIcone();
            Imagem imagem = new Imagem(icone);
            imagem.setBounds(localizacaoX, 50,240,320);
            grid.add(imagem);
            localizacaoX += 260;
            imagem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selecionarJogo(jogo);
                }
            });
            imagem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    String fundo = jogo.getFundo();
                    fadeInBackgroundImage(fundo);
                }
               // @Override
               // public void mouseExited(MouseEvent e) {
                   // fadeOutBackgroundImage();
                //}
            });
        }
    }

    public void selecionarJogo(Jogo jogo) {
        jogoSelecionado = jogo;
    }

    public void carregarJogos() {
        String jsonString = lerJsonJogos();
        JSONArray jsonArray = new JSONArray(jsonString);

        for(int i = 0; i < jsonArray.length(); i++) {
            JSONObject jogoJsonObject = (JSONObject)jsonArray.get(i);
            jogos.add(new Jogo(jogoJsonObject));
        }
    }


    private void fadeInBackgroundImage(String imagem) {

        Timer timer = new Timer(10, new ActionListener() {
            private int alpha = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 25;
                if (alpha >= 255) {
                    alpha = 255;
                    ((Timer) e.getSource()).stop();
                }

                imagemFundo.setImageAlpha(alpha);
                repaint();
            }
        });

        ImageIcon backgroundIcon = new ImageIcon(Imagem.class.getResource("/img/" + imagem));
        imagemFundo.setIcon(backgroundIcon);
        timer.start();
    }
    private void executarJogo() throws Exception {
        if(jogoSelecionado == null){
            throw new Exception("Não teve nenhum jogo selecionado para executar");
        }
        String caminho = jogoSelecionado.getCaminho();
        File arquivo = new File(caminho);
        String pasta = arquivo.getAbsoluteFile().getParent();
        try {
            Runtime.getRuntime().exec(caminho, null, new File(pasta));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String lerJsonJogos() {
        File arquivoJson = new File("jogos.json");
        StringBuilder conteudoArquivo = new StringBuilder();
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoJson));

            String linha = leitor.readLine();
            while (linha != null) {
                conteudoArquivo.append(linha);

                linha = leitor.readLine();
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conteudoArquivo.toString();
    }

    public void executarBotao(ActionEvent e) {
        trocarTela("Tela Login");
    }
}
