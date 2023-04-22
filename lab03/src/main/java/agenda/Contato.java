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
    public Contato(int posicao, String nome, String sobrenome, String numero) throws NullPointerException, IllegalArgumentException {
        if(nome == null){
            throw new NullPointerException("CONTATO INVÁLIDO - NOME NULO");
        }
        if(numero == null){
            throw new NullPointerException("CONTATO INVÁLIDO - TELEFONE NULO");
        }
        if(numero.isBlank()){
            throw new IllegalArgumentException("CONTATO INVÁLIDO - CAMPO TELEFONE VAZIO");
        }
        if(nome.isBlank()){
            throw new IllegalArgumentException("CONTATO INVÁLIDO - CAMPO NOME VAZIO");
        }
        this.posicao = posicao;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }
    public String getSobrenome(){
        return this.sobrenome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Método equals que compara duas Strings.
     * @param nome Nome do contato.
     * @param sobrenome Sobrenome do contato.
     * @return verdadeiro ou falso.
     */
    public boolean equals(String nome, String sobrenome){
        if(nome == null || sobrenome == null){
            throw new NullPointerException("CAMPOS NOME OU SOBRENOME == NULL");
        }
        return getNome().toLowerCase().equals(nome.toLowerCase()) && getSobrenome().toLowerCase().equals(sobrenome.toLowerCase());
    }
    /**
     * Método equals que compara duas Strings.
     * @param nome Nome do contato.
     * @return verdadeiro ou falso.
     */
    public boolean equalsNome(String nome){
        if(nome == null){
            throw new NullPointerException("NOME INVÁLIDO - CAMPO NOME NULO");
        }
        if(nome.isBlank()){
            throw new IllegalArgumentException("NOME INVÁLIDO - CAMPO NOME VAZIO");
        }
        return getNome().toLowerCase().equals(nome.toLowerCase());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getNome(), sobrenome);
    }

    /**
     * Representação em String de um contato.
     * @return nome e sobrenome de um contato.
     */
    public String nomeCompleto() { return this.nome + " " + this.sobrenome;}

    /**
     * Representação em String de um contato.
     * @return nome, sobrenome e telefone de um contato.
     */
    @Override
    public String toString(){
        return this.nome + " " + this.sobrenome + "\n" + this.numero;
    }

}
