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
    private int popularidadeApostas;

    public Time(String codigo, String nome, String mascote){
        if(codigo == null){
            throw new NullPointerException("TIME INVÁLIDO - CAMPO CÓDIGO TIME NULO");
        }
        if(codigo.isBlank()){
            throw new IllegalArgumentException("TIME INVÁLIDO - CAMPO CÓDIGO TIME VAZIO");
        }
        if(nome == null){
            throw new NullPointerException("TIME INVÁLIDO - CAMPO NOME NULO");
        }
        if(nome.isBlank()){
            throw new IllegalArgumentException("TIME INVÁLIDO - CAMPO NOME VAZIO");
        }
        if(mascote == null){
            throw new NullPointerException("TIME INVÁLIDO - CAMPO MASCOTE NULO");
        }
        if(mascote.isBlank()){
            throw new IllegalArgumentException("TIME INVÁLIDO - CAMPO MASCOTE VAZIO");
        }
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
        this.campeonatos = new ArrayList<Campeonato>();
        this.popularidadeApostas = 0;
    }

    /**
     * Adiciona um campeonato a um time.
     * @param campeonato - o nome do campeonato.
     */
    public void adicionaCampeonato(Campeonato campeonato){
        this.campeonatos.add(campeonato);
    }

    public String getCodigo() { return this.codigo; }

    public String getMascote() { return this.mascote;}

    public String getNome() {
        return this.nome;
    }

    public ArrayList<Campeonato> getCampeonatos() {
        return this.campeonatos;
    }

    public int getQtdCampeonatos(){ return this.campeonatos.size();}

    public void setPopularidadeApostas() {
        this.popularidadeApostas ++;
    }

    public int getPopularidadeApostas(){ return this.popularidadeApostas;}

    /**
     *  Método equals que compara dois times pelo seu código identificador.
     * @param o - objeto da classse Objects a ser identificado.
     * @return true or false.
     */
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

    /**
     *  Representação em String de um time.
     * @return código identificador do time, nome e mascote.
     */
    @Override
    public String toString() {
        return  "[" + this.codigo + "] " + this.nome + " / " + this.mascote;
    }

}
