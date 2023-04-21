package agenda;

import java.util.Objects;

/**
 *  Contato de uma agenda.
 * @author Danielly Rayanne Macedo Lima.
 */

public class Contato {
    private String nome;
    private String sobrenome;
    private String numero;
    private int posicao;

    /**
     * Cria um contato.
     */
    public Contato(int posicao, String nome, String sobrenome, String numero) {
        this.posicao = posicao;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }
    public String getSobrenome(){
        return sobrenome;
    }
    public String getNumero(){ return numero; }

    /**
     * Método equals que evita um contato ser cadastrado ou adicionado aos favoritos mais de uma vez.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato
     * @return verdadeiro ou falso.
     */
    public boolean equals(String nome, String sobrenome) {
        return getNome().toLowerCase().equals(nome.toLowerCase()) && getSobrenome().toLowerCase().equals(sobrenome.toLowerCase());
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
