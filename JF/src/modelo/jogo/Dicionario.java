package modelo.jogo;
import java.util.ArrayList;
import java.util.Random;

public class Dicionario {
    private ArrayList<Palavra> palavras;

    public Dicionario(){
        palavras = new ArrayList<>();
        carregarPalavras();
    }

    private void carregarPalavras(){
        //DevOps
        palavras.add(new Palavra("DOCKER", "DevOps", "Ferramenta Usada para containers"));
        palavras.add(new Palavra("JENKINS", "DevOps", "Ferramenta de Integração Contínua"));
        palavras.add(new Palavra("KUBERNETES", "DevOps", "Orquestracao de Containers"));

        // Minecraft
        palavras.add(new Palavra("CREEPER", "Minecraft", "Mob que explode"));
        palavras.add(new Palavra("DIAMANTE", "Minecraft", "Recurso raro do jogo"));
        palavras.add(new Palavra("NETHER", "Minecraft", "Dimensão perigosa do jogo"));

        // Países
        palavras.add(new Palavra("CABOVERDE", "Paises", "País insular africano"));
        palavras.add(new Palavra("BRASIL", "Paises", "Maior país da América do Sul"));
        palavras.add(new Palavra("PORTUGAL", "Paises", "País europeu de língua portuguesa"));
    }

    public Palavra escolherPalavraAleatoria(){
        Random random = new Random();
        int posicao = random.nextInt(palavras.size()); //
        return palavras.get(posicao);
    }

}
