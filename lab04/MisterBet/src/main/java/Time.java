import java.util.Objects;

public class Time {
    private String codigo;
    private String nome;
    private String mascote;

    public Time(String codigo, String nome, String mascote){
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
    }
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
