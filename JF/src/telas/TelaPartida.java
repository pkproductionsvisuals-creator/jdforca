package telas;

import componentes.Fontes;
import modelo.jogo.Dicionario;
import modelo.jogo.Palavra;
import modelo.utilizador.Jogador;

import javax.swing.*;
import java.awt.*;

public class TelaPartida extends JFrame {
    private Jogador jogadorLogado;
    private Palavra palavraSorteada;

    private JPanel painelLetras;
    private JTextField[] camposLetras;

    private JLabel labelTema;
    private JLabel labelDica;
    private JTextField campoLetra;
    private JButton botaoAdivinhar;
    private JButton botaoSair;

    private JLabel labelImagemForca;
    private int erros = 0;
    private final int MAX_ERROS = 6;

    public TelaPartida(Jogador jogadorLogado) {
        this.jogadorLogado = jogadorLogado;

        Dicionario dicionario = new Dicionario();
        palavraSorteada = dicionario.escolherPalavraAleatoria();

        setTitle("Jogo da Forca - Partida");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        criarComponentes();
        preencherLetrasIniciais();
    }

    private void criarComponentes() {
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBounds(0, 0, 600, 400);
        painel.setBackground(new Color(18, 112, 78));
        add(painel);

        labelImagemForca = new JLabel();
        labelImagemForca.setBounds(28, 60, 184, 245);
        labelImagemForca.setOpaque(true);
        labelImagemForca.setBackground(Color.WHITE);
        labelImagemForca.setHorizontalAlignment(JLabel.CENTER);
        painel.add(labelImagemForca);

        atualizarImagemForca();

        labelTema = new JLabel("TEMA: " + palavraSorteada.getTema());
        labelTema.setFont(Fontes.tW(24f));
        labelTema.setBounds(275, 55, 280, 30);
        labelTema.setForeground(Color.WHITE);
        painel.add(labelTema);

        labelDica = new JLabel("Dica: " + palavraSorteada.getDica());
        labelDica.setFont(Fontes.tW(13f));
        labelDica.setBounds(275, 88, 300, 20);
        labelDica.setForeground(Color.WHITE);
        painel.add(labelDica);

        painelLetras = new JPanel();
        painelLetras.setBounds(275, 122, 290, 95);
        painelLetras.setLayout(new FlowLayout(FlowLayout.LEFT, 7, 8));
        painelLetras.setOpaque(false);
        painel.add(painelLetras);

        camposLetras = new JTextField[palavraSorteada.getTamanho()];

        for (int i = 0; i < palavraSorteada.getTamanho(); i++) {
            camposLetras[i] = new JTextField();
            camposLetras[i].setPreferredSize(new Dimension(38, 38));
            camposLetras[i].setHorizontalAlignment(JTextField.CENTER);
            camposLetras[i].setFont(Fontes.tW(22f));
            camposLetras[i].setForeground(Color.WHITE);
            camposLetras[i].setBackground(new Color(18, 112, 78));
            camposLetras[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            camposLetras[i].setEditable(false);
            painelLetras.add(camposLetras[i]);
        }

        campoLetra = new JTextField();
        campoLetra.setBounds(275, 240, 40, 36);
        campoLetra.setFont(Fontes.tW(20f));
        campoLetra.setHorizontalAlignment(JTextField.CENTER);
        campoLetra.setBackground(Color.WHITE);
        campoLetra.setBorder(null);
        painel.add(campoLetra);

        botaoAdivinhar = new JButton("ADIVINHAR");
        botaoAdivinhar.setBounds(329, 240, 218, 36);
        botaoAdivinhar.setFont(Fontes.tW(14f));
        botaoAdivinhar.setBackground(new Color(223, 223, 223));
        botaoAdivinhar.setForeground(new Color(18, 112, 78));
        botaoAdivinhar.setFocusPainted(false);
        botaoAdivinhar.setBorderPainted(false);
        painel.add(botaoAdivinhar);

        JLabel textoAviso = new JLabel("<html>Estas a jogar a versao beta do jogo!<br>Mais atualizacoes serao publicadas em breve!<br>Fica atento e nao perca!</html>");
        textoAviso.setFont(Fontes.tW(8f));
        textoAviso.setBounds(275, 305, 200, 45);
        textoAviso.setForeground(Color.WHITE);
        painel.add(textoAviso);

        botaoSair = new JButton("SAIR");
        botaoSair.setBounds(481, 300, 66, 36);
        botaoSair.setFont(Fontes.tW(14f));
        botaoSair.setBackground(new Color(223, 223, 223));
        botaoSair.setForeground(new Color(18, 112, 78));
        botaoSair.setFocusPainted(false);
        botaoSair.setBorderPainted(false);
        painel.add(botaoSair);

        botaoAdivinhar.addActionListener(e -> adivinharLetra());

        botaoSair.addActionListener(e -> {
            dispose();
            new TelaMenu(jogadorLogado).setVisible(true);
        });
    }

    private void preencherLetrasIniciais() {
        String palavra = palavraSorteada.getTexto();

        camposLetras[0].setText(String.valueOf(palavra.charAt(0)));

        int ultimaPosicao = palavra.length() - 1;
        camposLetras[ultimaPosicao].setText(String.valueOf(palavra.charAt(ultimaPosicao)));
    }

    private void adivinharLetra() {
        String letraDigitada = campoLetra.getText().toUpperCase();

        if (letraDigitada.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite antes uma letra!");
            return;
        }

        if (letraDigitada.length() > 1) {
            JOptionPane.showMessageDialog(this, "Apenas uma letra!");
            campoLetra.setText("");
            return;
        }

        char letra = letraDigitada.charAt(0);
        String palavra = palavraSorteada.getTexto();

        boolean acertou = false;

        for (int i = 1; i < palavra.length() - 1; i++) {
            if (palavra.charAt(i) == letra) {
                camposLetras[i].setText(String.valueOf(letra));
                acertou = true;
            }
        }

        if(!acertou) {
            erros++;
            atualizarImagemForca();

            if (erros >= MAX_ERROS) {
                JOptionPane.showMessageDialog(this, "PERDEU! A palavra era: " + palavraSorteada.getTexto());
                dispose();
                new TelaMenu(jogadorLogado).setVisible(true);
                return;
            }
        }

        campoLetra.setText("");
        verificarVitoria();
    }

    private void verificarVitoria() {
        for (JTextField campo : camposLetras) {
            if (campo.getText().isEmpty()) {
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "VITÓRIA! Descobriste a palavra: " + palavraSorteada.getTexto());
        dispose();
        new TelaMenu(jogadorLogado).setVisible(true);
    }

    private void atualizarImagemForca() {
        String caminho = "/img/" + (erros + 1) + ".png";

        ImageIcon icon = new ImageIcon(getClass().getResource(caminho));

        Image imagem = icon.getImage().getScaledInstance(160, 190, Image.SCALE_SMOOTH);

        labelImagemForca.setIcon(new ImageIcon(imagem));
    }
}