package documin.document;

import java.util.ArrayList;
import java.util.Objects;

public class Document {

    private int tamanho;
    private String titulo;
    private ArrayList<Element> elementos;

    public Document(String titulo){
        this.titulo = titulo;
        this.elementos = new ArrayList<>();
    }
    public Document(String titulo, int tamanho){
        DocumentValidator.validaTamanho(tamanho);
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>(tamanho);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document documento = (Document) o;
        return titulo.equals(documento.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }
}
