package telas;

import modelo.utilizador.Jogador;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import dados.DadosJogadores;
import componentes.Fontes;

public class TelaCadastro extends JFrame {
    private JTextField campoNick;
    private JPasswordField campoSenha;
    private JPasswordField campoConfirmar;
    private JButton botaoGuardar;
    private JButton botaoVoltar;

    public static ArrayList<Jogador> jogadores = DadosJogadores.carregarJogadores();

    public TelaCadastro() {
        setTitle("Jogo da Forca - Criar Perfil");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 600, 400);
        painel.setBackground(new Color(18, 112, 78));
        add(painel);

        JLabel titulo = new JLabel("Crie seu Perfil");
        titulo.setFont(Fontes.tW(32f));
        titulo.setBounds(170, 35, 260, 35);
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(titulo);

        JLabel labelNick = new JLabel("NICK");
        labelNick.setBounds(275, 85, 80, 20);
        labelNick.setForeground(Color.WHITE);
        labelNick.setFont(Fontes.tW(13f));
        painel.add(labelNick);

        campoNick = new JTextField();
        campoNick.setBounds(190, 105, 220, 35);
        campoNick.setBackground(Color.WHITE);
        campoNick.setForeground(Color.BLACK);
        campoNick.setFont(Fontes.tW(16f));
        painel.add(campoNick);

        JLabel labelSenha = new JLabel("PASS");
        labelSenha.setBounds(276, 145, 80, 20);
        labelSenha.setForeground(Color.WHITE);
        labelSenha.setFont(Fontes.tW(13f));
        painel.add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(190, 165, 220, 35);
        campoSenha.setBackground(Color.WHITE);
        campoSenha.setForeground(Color.BLACK);
        campoSenha.setFont(Fontes.tW(16f));
        painel.add(campoSenha);

        JLabel labelConfirmar = new JLabel("CONFIRME");
        labelConfirmar.setBounds(262, 205, 100, 20);
        labelConfirmar.setForeground(Color.WHITE);
        labelConfirmar.setFont(Fontes.tW(13f));
        painel.add(labelConfirmar);

        campoConfirmar = new JPasswordField();
        campoConfirmar.setBounds(190, 225, 220, 35);
        campoConfirmar.setBackground(Color.WHITE);
        campoConfirmar.setForeground(Color.BLACK);
        campoConfirmar.setFont(Fontes.tW(16f));
        painel.add(campoConfirmar);

        botaoGuardar = new JButton("SALVAR");
        botaoGuardar.setBounds(190, 285, 105, 38);
        botaoGuardar.setBackground(new Color(223, 223, 223));
        botaoGuardar.setForeground(new Color(18, 112, 78));
        botaoGuardar.setFont(Fontes.tW(14f));
        botaoGuardar.setFocusPainted(false);
        botaoGuardar.setBorderPainted(false);
        painel.add(botaoGuardar);

        botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(305, 285, 105, 38);
        botaoVoltar.setBackground(new Color(223, 223, 223));
        botaoVoltar.setForeground(new Color(18, 112, 78));
        botaoVoltar.setFont(Fontes.tW(14f));
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setBorderPainted(false);
        painel.add(botaoVoltar);

        botaoGuardar.addActionListener(e -> guardarJogador());

        botaoVoltar.addActionListener(e -> {
            dispose();
            new TelaLogin().setVisible(true);
        });
    }

    private void guardarJogador() {
        String nick = campoNick.getText();
        String senha = new String(campoSenha.getPassword());
        String confirmar = new String(campoConfirmar.getPassword());

        if (nick.isEmpty() || senha.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos");
            return;
        }

        if (!senha.equals(confirmar)) {
            JOptionPane.showMessageDialog(this, "As senhas nao coincidem");
            return;
        }

        Jogador jogador = new Jogador(nick, senha);
        jogadores.add(jogador);
        DadosJogadores.guardarJogadores(jogadores);

        JOptionPane.showMessageDialog(this, "Perfil criado com sucesso!");

        campoNick.setText("");
        campoSenha.setText("");
        campoConfirmar.setText("");
    }
}