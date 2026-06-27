package dados;

import modelo.utilizador.Jogador;
import java.io.*;
import java.util.ArrayList;


public class DadosJogadores {
    private static final String FICHEIRO = "jogadores.dat";

    public static void guardarJogadores(ArrayList<Jogador> jogadores){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHEIRO))){
            oos.writeObject(jogadores);
        }catch (IOException e){
            System.out.println("Erro ao guardar jogadores: " + e.getLocalizedMessage());
        }
    }

    public static ArrayList<Jogador> carregarJogadores(){
        File ficheiro = new File(FICHEIRO);
        if(!ficheiro.exists()){
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHEIRO))){
            return (ArrayList<Jogador>) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Erro ao Carregar Jogadores: "+ e.getMessage());
            return new ArrayList<>();
        }
    }
}
