package lab02;

/**
 *  Classe que cria e retorna os resumos cadastrados nas disciplinas do coISA.
 */

public class Resumos {
    private String resumo;
    private String titulo;

    /**
     * Inicialização de um Resumo com título e conteúdo vazios.
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
     */
    @Override
    public String toString() {
        return titulo + ": " + resumo;
    }
}
