package telas;

import modelo.utilizador.Jogador;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JFrame {
    private  Jogador jogadorLogado;

    private JButton botaoNovoJogo;
    private JButton botaoCarregarPartida;
    private JButton botaoListarPartidas;
    private JButton botaoSair;

    public TelaMenu(Jogador jogadorLogado){
        this.jogadorLogado = jogadorLogado;

        setTitle("Jogo da Forca- Menu Principal");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(120, 20, 280, 220);
        painel.setBackground(new Color(240, 240, 240));
        add(painel);

        JLabel titulo = new JLabel("Menu Principal");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(70, 20, 180, 25);
        painel.add(titulo);

        JLabel boasVindas = new JLabel("Bem-vindo, "+ jogadorLogado.getNick());
        boasVindas.setBounds(75, 45, 180, 25);
        painel.add(boasVindas);

        botaoNovoJogo = new JButton("Iniciar Novo Jogo");
        botaoNovoJogo.setBounds(55, 80, 170, 30);
        painel.add(botaoNovoJogo);

        botaoCarregarPartida = new JButton("Carregar Partida");
        botaoCarregarPartida.setBounds(55, 115, 170, 30);
        painel.add(botaoCarregarPartida);

        botaoListarPartidas= new JButton("Listar Partidas Anteriores");
        botaoListarPartidas.setBounds(55, 150, 170, 30);
        painel.add(botaoListarPartidas);

        botaoSair= new JButton("Sair");
        botaoSair.setBounds(55, 185, 170, 30);
        painel.add(botaoSair);


        botaoNovoJogo.addActionListener(e->{
            //JOptionPane.showMessageDialog(this, "Tela da partida sera criada em breve!");
            dispose();
            new TelaPartida(jogadorLogado).setVisible(true);
        });

        botaoCarregarPartida.addActionListener(e->{
            JOptionPane.showMessageDialog(this, "Carregar Partida sere feito em breve!");
        });

        botaoListarPartidas.addActionListener(e-> {
            JOptionPane.showMessageDialog(this, "Historico de partidas sera criado em breve");
        });

        botaoSair.addActionListener(e-> {
            dispose();
            new TelaLogin().setVisible(true);
        });

    }
}
