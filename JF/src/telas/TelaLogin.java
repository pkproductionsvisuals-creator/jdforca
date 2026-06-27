package telas;

import modelo.utilizador.Jogador;
import javax.swing.*;

import componentes.Fontes;

import java.awt.*;
import java.util.ArrayList;

import dados.DadosJogadores;

public class TelaLogin extends JFrame {
    private JTextField campoNick;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;
    private JButton botaoCriarPerfil;
    private JButton botaoAdmin;

    private ArrayList<Jogador> jogadores;

    public TelaLogin() {
        jogadores = DadosJogadores.carregarJogadores();

        setTitle("Jogo da Forca  - Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 600, 400);
        painel.setBackground(new Color(18, 112, 78));
        add(painel);

        JLabel titulo = new JLabel("JOGO DA FORCA");
        titulo.setFont(Fontes.tW(32f));
        titulo.setBounds(170, 35, 260, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(titulo);

        JLabel labelNick = new JLabel("NICK");
        labelNick.setBounds(285, 92, 80, 20);
        labelNick.setForeground(Color.WHITE);
        labelNick.setFont(Fontes.tW(14f));
        painel.add(labelNick);

        campoNick = new JTextField();
        campoNick.setBounds(180, 115, 240, 45);
        campoNick.setBackground(Color.WHITE);
        campoNick.setForeground(Color.BLACK);
        campoNick.setFont(Fontes.tW(18f));
        painel.add(campoNick);

        JLabel labelSenha = new JLabel("PASS");
        labelSenha.setBounds(285, 170, 80, 20);
        labelSenha.setForeground(Color.WHITE);
        labelSenha.setFont(Fontes.tW(14f));
        painel.add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(180, 193, 240, 45);
        campoSenha.setBackground(Color.WHITE);
        campoSenha.setForeground(Color.BLACK);
        campoSenha.setFont(Fontes.tW(18f));
        painel.add(campoSenha);

        botaoEntrar = new JButton("SignIn");
        botaoEntrar.setBounds(180, 260, 110, 45);
        botaoEntrar.setBackground(new Color(223, 223, 223));
        botaoEntrar.setForeground(new Color(15, 106, 76));
        botaoEntrar.setFont(Fontes.tW(17f));
        botaoEntrar.setFocusPainted(false);
        botaoEntrar.setBorderPainted(false);
        painel.add(botaoEntrar);

        botaoCriarPerfil = new JButton("SignUp");
        botaoCriarPerfil.setBounds(310, 260, 110, 45);
        botaoCriarPerfil.setBackground(new Color(223, 223, 223));
        botaoCriarPerfil.setForeground(new Color(15, 106, 76));
        botaoCriarPerfil.setFont(Fontes.tW(17f));
        botaoCriarPerfil.setFocusPainted(false);
        botaoCriarPerfil.setBorderPainted(false);
        painel.add(botaoCriarPerfil);

        botaoAdmin = new JButton("ADM");
        botaoAdmin.setBounds(180, 325, 240, 45);
        botaoAdmin.setBackground(new Color(223, 223, 223));
        botaoAdmin.setForeground(new Color(15, 106, 76));
        botaoAdmin.setFont(Fontes.tW(18f));
        botaoAdmin.setFocusPainted(false);
        botaoAdmin.setBorderPainted(false);
        painel.add(botaoAdmin);

        botaoEntrar.addActionListener(e -> fazerLogin());

        botaoCriarPerfil.addActionListener(e -> {
            dispose();
            new TelaCadastro().setVisible(true);
        });

        botaoAdmin.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Tela ADMIN sera criada em breve");
        });
    }

    private void fazerLogin() {
        String nick = campoNick.getText();
        String senha = new String(campoSenha.getPassword());

        if (nick.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha nick e senha");
            return;
        }

        jogadores = DadosJogadores.carregarJogadores();

        for (Jogador jogador : jogadores) {
            if (jogador.getNick().equals(nick) && jogador.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(this, "Login efetuado com sucesso!");
                dispose();

                new TelaMenu(jogador).setVisible(true);
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Nick ou senha incorretos!");
    }
}