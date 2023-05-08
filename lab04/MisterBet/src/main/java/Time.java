import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe responsável pela implementação dos Times no sistema do Mr.Bet
 */

public class Time {
    private String codigo;
    private String nome;
    private String mascote;
    private ArrayList<Campeonato> campeonatos;

    public Time(String codigo, String nome, String mascote){
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
        this.campeonatos = new ArrayList<Campeonato>();
    }

    public void adicionaCampeonato(Campeonato campeonato){
        campeonatos.add(campeonato);
    }

    public String getCodigo() { return codigo; }

    public String getMascote() { return this.mascote;}

    public String getNome() {
        return nome;
    }

    public ArrayList<Campeonato> getCampeonatos() {
        return campeonatos;
    }

    public int getQtdCampeonatos(){ return this.campeonatos.size();}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time time)) return false;
        return Objects.equals(codigo, time.codigo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return  "[" + this.codigo + "] " + this.nome + " / " + this.mascote;
    }

}
