package telas;

import modelo.jogo.Dicionario;
import modelo.jogo.Palavra;
import modelo.utilizador.Jogador;

import javax.swing.*;
import java.awt.*;

public class TelaPartida extends JFrame{
    private Jogador jogadorLogado;
    private Palavra palavraSorteada;

    private JPanel painelLetras;
    private JTextField[] camposLetras;

    private JLabel labelTema;
    private JLabel labelDica;
    private JTextField campoLetra;
    private JButton botaoAdivinhar;
    private JButton botaoSair;

    public TelaPartida (Jogador jogadorLogado){
        this.jogadorLogado = jogadorLogado;

        Dicionario dicionario = new Dicionario();
        palavraSorteada = dicionario.escolherPalavraAleatoria();

        setTitle("Jogo da Forca- Partida");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        criarComponentes();
        preencherLetrasIniciais();
    }

    private void criarComponentes(){
        labelTema = new JLabel("Tema: "+ palavraSorteada.getTema());
        labelTema.setFont(new Font("Arial", Font.BOLD, 16));
        labelTema.setBounds(50, 30, 300, 25);
        add(labelTema);

        labelDica = new JLabel("Dica: "+ palavraSorteada.getDica());
        labelDica.setBounds(50, 60, 450, 25);
        add(labelDica);

        painelLetras = new JPanel();
        painelLetras.setBounds(50, 110, 500, 60);
        painelLetras.setLayout(new FlowLayout());
        add(painelLetras);

        camposLetras = new JTextField[palavraSorteada.getTamanho()];

        for(int i = 0; i < palavraSorteada.getTamanho(); i++){
            camposLetras[i] = new JTextField();
            camposLetras[i].setPreferredSize(new Dimension(40, 40));
            camposLetras[i].setHorizontalAlignment(JTextField.CENTER);
            camposLetras[i].setFont(new Font("Arial", Font.BOLD, 20));
            camposLetras[i].setEditable(false);
            painelLetras.add(camposLetras[i]);
        }

        JLabel labelInserir = new JLabel("Inserir Letra:");
        labelInserir.setBounds(50, 200, 100, 25);
        add(labelInserir);

        campoLetra = new JTextField();
        campoLetra.setBounds(140, 200, 50, 25);
        add(campoLetra);

        botaoAdivinhar = new JButton("Adivinhar");
        botaoAdivinhar.setBounds(210, 198, 100, 30);
        add(botaoAdivinhar);

        botaoSair = new JButton("Sair");
        botaoSair.setBounds(350, 198, 100, 30);
        add(botaoSair);

        botaoAdivinhar.addActionListener(e-> adivinharLetra());

        botaoSair.addActionListener(e-> {
            dispose();
            new TelaMenu(jogadorLogado).setVisible(true);
        });
    }

    private void preencherLetrasIniciais(){
        String palavra = palavraSorteada.getTexto();
        camposLetras[0].setText(String.valueOf(palavra.charAt(0)));

        int ultimaPosicao = palavra.length() - 1;
        camposLetras[ultimaPosicao].setText(String.valueOf(palavra.charAt(ultimaPosicao)));
    }

    private void adivinharLetra(){
        String letraDigitada = campoLetra.getText().toUpperCase();

        if(letraDigitada.isEmpty()){
            JOptionPane.showMessageDialog(this, "Digite antes uma letra!");
            return;
        }

        if(letraDigitada.length() > 1){
            JOptionPane.showMessageDialog(this, "Apenas uma letra!");
            campoLetra.setText("");
            return;
        }

        char letra = letraDigitada.charAt(0);
        String palavra = palavraSorteada.getTexto();

        boolean acertou = false;

        for(int i = 1; i < palavra.length() - 1; i++){
            if(palavra.charAt(i) == letra){
                camposLetras[i].setText(String.valueOf(letra));
                acertou = true;
            }
        }

        if(acertou){
            JOptionPane.showMessageDialog(this, "Boa! Acertaste uma letra!");
        }else{
            JOptionPane.showMessageDialog(this, "Letra errada.");
        }

        campoLetra.setText("");

        verificarVitoria();
    }

    private void verificarVitoria(){
        for (JTextField campo: camposLetras){
            if(campo.getText().isEmpty()){
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "VITORIA! Descobriste a palavra: "+ palavraSorteada.getTexto());
        dispose();
        new TelaMenu(jogadorLogado).setVisible(true);
    }
}