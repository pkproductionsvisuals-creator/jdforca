package telas;

import componentes.Fontes;
import modelo.utilizador.Jogador;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {

    private Jogador jogadorLogado;

    private JButton botaoNovoJogo;
    private JButton botaoCarregarPartida;
    private JButton botaoListarPartidas;
    private JButton botaoSair;

    public TelaMenu(Jogador jogadorLogado) {

        this.jogadorLogado = jogadorLogado;

        setTitle("Jogo da Forca - Menu");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 600, 400);
        painel.setBackground(new Color(18, 112, 78));
        add(painel);

        JLabel titulo = new JLabel("MENU");
        titulo.setFont(Fontes.tW(30f));
        titulo.setBounds(170, 40, 260, 35);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        painel.add(titulo);

        JLabel boasVindas = new JLabel("Bem-vindo, " + jogadorLogado.getNick());
        boasVindas.setFont(Fontes.tW(16f));
        boasVindas.setBounds(170, 75, 260, 20);
        boasVindas.setHorizontalAlignment(SwingConstants.CENTER);
        boasVindas.setForeground(Color.WHITE);
        painel.add(boasVindas);

        botaoNovoJogo = new JButton("INICIAR PARTIDA");
        botaoNovoJogo.setBounds(195, 130, 210, 36);
        botaoNovoJogo.setFont(Fontes.tW(15f));
        botaoNovoJogo.setBackground(new Color(223,223,223));
        botaoNovoJogo.setForeground(new Color(18,112,78));
        botaoNovoJogo.setFocusPainted(false);
        botaoNovoJogo.setBorderPainted(false);
        painel.add(botaoNovoJogo);

        botaoListarPartidas = new JButton("HISTÓRICO");
        botaoListarPartidas.setBounds(195, 178, 210, 36);
        botaoListarPartidas.setFont(Fontes.tW(15f));
        botaoListarPartidas.setBackground(new Color(223,223,223));
        botaoListarPartidas.setForeground(new Color(18,112,78));
        botaoListarPartidas.setFocusPainted(false);
        botaoListarPartidas.setBorderPainted(false);
        painel.add(botaoListarPartidas);

        botaoSair = new JButton("SAIR");
        botaoSair.setBounds(195, 226, 210, 36);
        botaoSair.setFont(Fontes.tW(15f));
        botaoSair.setBackground(new Color(223,223,223));
        botaoSair.setForeground(new Color(18,112,78));
        botaoSair.setFocusPainted(false);
        botaoSair.setBorderPainted(false);
        painel.add(botaoSair);

        botaoNovoJogo.addActionListener(e -> {
            dispose();
            new TelaPartida(jogadorLogado).setVisible(true);
        });

        botaoListarPartidas.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Histórico de partidas será criado em breve.");
        });

        botaoSair.addActionListener(e -> {
            dispose();
            new TelaLogin().setVisible(true);
        });
    }
}