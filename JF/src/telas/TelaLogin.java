package telas;

import modelo.utilizador.Jogador;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import dados.DadosJogadores;

public class TelaLogin extends JFrame{
    private JTextField campoNick;
    private JPasswordField campoSenha;
    private JButton botaoEntrar;
    private JButton botaoCriarPerfil;
    private JButton botaoAdmin;

    private ArrayList<Jogador> jogadores;

    public TelaLogin(){
        jogadores = DadosJogadores.carregarJogadores();

        setTitle("Jogo da Forca  - Login");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(70, 40, 300, 240);
        painel.setBackground(new Color(240, 240, 240));
        add(painel);

        JLabel titulo =  new JLabel("JOGO DA FORCA");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setBounds(80, 20, 180, 25);
        painel.add(titulo);

        JLabel subtitulo = new JLabel("Acesso ao Jogador");
        subtitulo.setBounds(95, 45, 150, 25);
        painel.add(subtitulo);

        JLabel labelNick = new JLabel("Nick");
        labelNick.setBounds(45, 85, 80, 25);
        painel.add(labelNick);

        campoNick = new JTextField();
        campoNick.setBounds(120, 85, 130, 25);
        painel.add(campoNick);

        JLabel labelSenha = new JLabel("Senha");
        labelSenha.setBounds(45, 120, 80, 25);
        painel.add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(120, 120, 80, 25);
        painel.add(campoSenha);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.setBounds(45, 165, 90, 30);
        painel.add(botaoEntrar);

        botaoCriarPerfil = new JButton("Criar Perfil");
        botaoCriarPerfil.setBounds(145, 165, 110, 30);
        painel. add(botaoCriarPerfil);

        botaoAdmin = new JButton("Entrar como ADMIN");
        botaoAdmin.setBounds(80, 205, 150, 30);
        painel.add(botaoAdmin);

        botaoEntrar.addActionListener(e-> fazerLogin());
        botaoCriarPerfil.addActionListener(e->{
            dispose();
            new TelaCadastro().setVisible(true);
        });
        botaoAdmin.addActionListener(e->{
            JOptionPane.showMessageDialog(this, "Tela ADMIN sera criada em breve");

        });
    }

    private void fazerLogin(){
        String nick = campoNick.getText();
        String senha = new String(campoSenha.getPassword());

        if(nick.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha nick e senha");
            return;
        }

        jogadores = DadosJogadores.carregarJogadores();
        for(Jogador jogador : jogadores){
            if(jogador.getNick().equals(nick) && jogador.getSenha().equals(senha)){
                //colorar a opcao bloqueado depois no if
                JOptionPane.showMessageDialog(this, "Login efetuado com sucesso!");
                dispose();

                new TelaMenu(jogador).setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Nick ou senha incorretos!");
    }
}
