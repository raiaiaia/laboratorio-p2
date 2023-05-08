import java.text.DecimalFormat;
import java.util.Objects;

/**
 * Classe que implementa as apostas no sistema do Mr.Bet
 */
public class Aposta {
    private String codigoTime;
    private String nomeTime;
    private String mascote;
    private String nomeCampeonato;
    private int participantesCampeonato;
    private int colocacao;
    private double valorAposta;

    public Aposta(String codigoTime, String nomeTime,  String mascote, String nomeCampeonato, int participantesCampeonato, int colocacao, double valorAposta) {
        this.codigoTime = codigoTime;
        this.nomeTime = nomeTime;
        this.mascote = mascote;
        this.nomeCampeonato = nomeCampeonato;
        this.participantesCampeonato = participantesCampeonato;
        this.colocacao = colocacao;
        this.valorAposta = valorAposta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aposta aposta)) return false;
        return Objects.equals(codigoTime, aposta.codigoTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoTime);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return " [" + codigoTime + "] " + nomeTime + " / " + mascote + "\n"
                + nomeCampeonato + "\n"
                + colocacao + "/" + participantesCampeonato + "\n"
                + "R$ " + df.format(valorAposta);
    }
}
