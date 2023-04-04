package lab02;

/**
 *
 */

public class Resumos {
    /**
     * Recebe o conteúdo do resumo.
     */
    private String resumo;
    /**
     * Recebe o título do resumo.
     */
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

    public String getTitulo() {
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
