package modelo.utilizador;

public class Admin extends Utilizador {
    private String senhaAdmin;

    public Admin(String nick, String senha, String senhaAdmin) {
        super(nick, senha);
        this.senhaAdmin = senhaAdmin;
    }

    public boolean autenticar(String senhaAdmin) {
        return this.senhaAdmin.equals(senhaAdmin);
    }

    public void bloquearJogador(Jogador jogador) {
        jogador.bloquear();
    }

    public void desbloquearJogador(Jogador jogador) {
        jogador.desbloquear();
    }

    public void eliminarJogador(Jogador jogador) {
        System.out.println("Jogador eliminado: " + jogador.getNick());
    }
}