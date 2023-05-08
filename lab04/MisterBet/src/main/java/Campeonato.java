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

    public String adicionaTime(Campeonato campeonato, Time time){
        if(qtdAtualParticipantes > participantes - 1 ){
            return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS";
        }

        times[qtdAtualParticipantes++] = time;
        time.adicionaCampeonato(campeonato);
        return "TIME INCLUÍDO NO CAMPEONATO!";
    }

    public String verificaTime(Time time){
        for(Time t: times){
            if (t != null && t.equals(time)) {
                return "O TIME ESTÁ NO CAMPEONATO!";
            }
        }
        return "O TIME NÃO ESTÁ NO CAMPEONATO!";
    }

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
    @Override
    public String toString() {
        return "* CAMPEONATO " + this.nome + " - " + qtdAtualParticipantes + "/" + this.participantes;
    }
}
