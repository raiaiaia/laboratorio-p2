package agenda;

import java.util.Locale;
import java.util.Objects;

public class Contato {
    private String nome;
    private String sobrenome;
    private String numero;
    private int posicao;


    public Contato() {
        posicao = 0;
        nome = "";
        sobrenome = "";
        numero = "";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }
    public String getNumero(){ return numero; }

    public boolean equals(String nome, String sobrenome) {
        return getNome().equals(nome.toLowerCase()) && getSobrenome().equals(sobrenome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), sobrenome);
    }

    @Override
    public String toString(){
        return nome + " " + sobrenome + "\n" + numero;
    }


}
