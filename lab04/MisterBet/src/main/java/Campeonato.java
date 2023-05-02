import java.util.Objects;

public class Campeonato {
    private Time[] times;
    private int participantes;
    private String nome;

    public Campeonato(String nome, int participantes){
        this.nome = nome;
        this.participantes = participantes;
        this.times = new Time[participantes];
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campeonato that)) return false;
        return Objects.equals(nome, that.nome);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
