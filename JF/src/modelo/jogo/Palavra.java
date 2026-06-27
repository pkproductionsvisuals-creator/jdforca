package modelo.jogo;

public class Palavra {
    private String texto;
    private String tema;
    private String dica;

    public Palavra(String texto, String tema, String dica){
        this.texto = texto.toUpperCase();
        this.tema = tema;
        this.dica = dica;
    }

    public String getTexto(){
        return texto;
    }
    public String getTema(){
        return tema;
    }
    public String getDica(){
        return dica;
    }

    public int getTamanho(){
        return texto.length();
    }
    public char getPrimeiraLetra(){
        return texto.charAt(0);
    }
    public char getUltimaLetra(){
        return texto.charAt(texto.length()-1);
    }
}
