package modelo.utilizador;
import java.io.Serializable;

public class Utilizador implements Serializable{
    private static final long serialVersionUID = 1L;

    protected String nick;
    protected String senha;
    protected boolean bloqueado;

    public Utilizador(String nick, String senha) {
        this.nick = nick;
        this.senha = senha;
        this.bloqueado = false;
    }

    public boolean login(String nick, String senha) {
        return this.nick.equals(nick) && this.senha.equals(senha) && !bloqueado; //Verifica se nick e senha correspondem para fazer o login.
    }

    public String getNick() {
        return nick;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void bloquear() {
        bloqueado = true;
    }

    public void desbloquear() {
        bloqueado = false;
    }
}
