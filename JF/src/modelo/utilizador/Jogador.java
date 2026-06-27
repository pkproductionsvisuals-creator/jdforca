package modelo.utilizador;

import modelo.jogo.Partida;

import java.util.ArrayList;

public class Jogador extends Utilizador {
    private int pontuacao;
    private ArrayList<Partida> partidas;

    public Jogador(String nick, String senha) {
        super(nick, senha);
        this.pontuacao = 0;
        this.partidas = new ArrayList<>();
    }

    public void adicionarPontuacao(int pontos) {
        this.pontuacao += pontos;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void adicionarPartida(Partida partida) {
        partidas.add(partida);
    }

    public void logout() {
        System.out.println("Jogador saiu do jogo.");
    }
}