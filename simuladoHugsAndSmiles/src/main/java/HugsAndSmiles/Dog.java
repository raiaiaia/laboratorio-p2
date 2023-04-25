package HugsAndSmiles;

import java.util.Objects;

public class Dog{
    private String nomePet;
    private String nomeDono;
    private int qtdRacao = 0;
    private String restricao;
    private boolean haRestricao = false;

    public Dog(String nomePet, String nomeDono, int qtdRacao){
        this.nomePet = nomePet;
        this.nomeDono = nomeDono;
        this.qtdRacao = qtdRacao;
    }
    public Dog(String nomePet, String nomeDono, int qtdRacao, String restricao){
        this.nomePet = nomePet;
        this.nomeDono = nomeDono;
        this.qtdRacao = qtdRacao * 2;
        this.restricao = restricao;
        haRestricao = true;
    }
    public int getQtdRacao(){
        return this.qtdRacao;
    }

    public String getNomePet(){
        return this.nomePet;
    }

    public String getNomeDono(){
        return this.nomeDono;
    }

    public boolean equals(Object o, Object b) {
        return nomePet.equals(o) && nomeDono.equals(b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomePet, nomeDono);
    }

    @Override
    public String toString(){
        return "[nome= " + this.nomePet + ", tutor=" + this.nomeDono;
    }

}
