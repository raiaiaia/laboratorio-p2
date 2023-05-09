import java.util.Objects;

/**
 *  Classe responsável pela implementação dos Campeonatos no sistema Mr.Bet
 */
public class Campeonato {
    private Time[] times;
    private int participantes;
    private String nome;
    private int qtdAtualParticipantes = 0;

    public Campeonato(String nome, int participantes){
        if(nome == null){
            throw new NullPointerException("CAMPEONATO INVÁLIDO - CAMPO NOME NULO");
        }
        if(nome.isBlank()){
            throw new IllegalArgumentException("CAMPEONATO INVÁLIDO - CAMPO NOME VAZIO");
        }
        if(participantes <= 0){
            throw new IllegalArgumentException("QUANTIDADE DE PARTICIPANTES INVÁLIDA");
        }
        this.nome = nome;
        this.participantes = participantes;
        this.times = new Time[participantes];
    }

    public String getNome() {
        return this.nome;
    }

    public int getParticipantes() {
        return this.participantes;
    }

    /**
     * Método que adiciona um time a um campeonato.
     * @param campeonato - o nome do campeonato.
     * @param time - o código identificador do time.
     * @return uma 'String' identificando se um time foi ou não incluído em um campeonato.
     */
    public String adicionaTime(Campeonato campeonato, Time time){
        if(qtdAtualParticipantes > participantes - 1 ){
            return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS";
        }

        if(verificaTime(time).equals("O TIME NÃO ESTÁ NO CAMPEONATO!")){
            times[qtdAtualParticipantes++] = time;
            time.adicionaCampeonato(campeonato);
        }

        return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    /**
     * Verifica se um time está em um campeonato.
     * @param time - código identificador do time.
     * @return uma 'String' identificando se o time está ou não adicionado no campeonato.
     */
    public String verificaTime(Time time){
        for(Time t: times){
            if (t != null && t.equals(time)) {
                return "O TIME ESTÁ NO CAMPEONATO!";
            }
        }
        return "O TIME NÃO ESTÁ NO CAMPEONATO!";
    }

    /**
     * Método que compara dois campeonatos por meio do nome deles.
     * @param o - objeto da classe Objects a ser identificado.
     * @return true or false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campeonato campeonato)) return false;
        return Objects.equals(nome, campeonato.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    /**
     * Representação em 'String' de um campeonato.
     * @return nome, quantidade de participantes cadastrados e número de participantes total.
     */
    @Override
    public String toString() {
        return "* CAMPEONATO " + this.nome + " - " + qtdAtualParticipantes + "/" + this.participantes;
    }
}
