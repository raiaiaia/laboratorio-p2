package agenda;

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


    @Override
    public String toString(){
        return nome + " " + sobrenome + "\n" + numero;
    }


}
