package lab02;

/**
 *
 */

public class Resumos {

    private String resumo;
    private String titulo;

    /**
     * Construtor de resumos que inicializa vazio.
     */
    public Resumos(){
        resumo = "";
        titulo = "";
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getTitulo(String titulo) {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Método toString() sobrescrito que imprime o
     * título e o resumo na formatação esperada.
     * @return
     */
    @Override
    public String toString() {
        return titulo + ": " + resumo;
    }
}
