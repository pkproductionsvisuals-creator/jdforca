package telas;

import modelo.utilizador.Jogador;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import dados.DadosJogadores;

public class TelaCadastro extends JFrame{
    private JTextField campoNick;
    private JPasswordField campoSenha;
    private JPasswordField campoConfirmar;
    private JButton botaoGuardar;
    private JButton botaoVoltar;

    public static ArrayList<Jogador> jogadores = DadosJogadores.carregarJogadores();

    public TelaCadastro(){
        setTitle("Jogo da Forca- Criar Perfil");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(70, 40, 300, 230);
        painel.setBackground(new Color(240,240,240));
        add(painel);

        JLabel titulo = new JLabel("Criar Perfil");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(95, 20, 150, 25);
        painel.add(titulo);

        JLabel labelNick = new JLabel("Nick");
        labelNick.setBounds(40, 56, 80, 25);
        painel.add(labelNick);

        campoNick = new JTextField();
        campoNick.setBounds(120, 65, 130, 25);
        painel.add(campoNick);

        JLabel labelSenha = new JLabel("Senha");
        labelSenha.setBounds(40, 100, 80, 25 );
        painel.add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(120, 100, 130, 25);
        painel.add(campoSenha);

        JLabel labelConfirmar = new JLabel("Confirmar");
        labelConfirmar.setBounds(40, 135, 80, 25);
        painel.add(labelConfirmar);

        campoConfirmar = new JPasswordField();
        campoConfirmar.setBounds(120, 135, 130, 25);
        painel.add(campoConfirmar);

        botaoGuardar = new JButton("Guardar");
        botaoGuardar.setBounds(55, 175, 90, 30);
        painel.add(botaoGuardar);

        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(160, 175, 90, 30);
        painel.add(botaoVoltar);


        botaoGuardar.addActionListener(e -> guardarJogador());
        botaoVoltar.addActionListener(e -> {
            dispose();
            new TelaLogin().setVisible(true);
        });

    }

    private void guardarJogador(){
        String nick = campoNick.getText();
        String senha = new String(campoSenha.getPassword());
        String confirmar = new String(campoConfirmar.getPassword());

        if(nick.isEmpty() || senha.isEmpty() || confirmar.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha todos os campos");
            return;
        }
        if(!senha.equals(confirmar)){
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