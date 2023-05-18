package documin;

import documin.document.DocumentController;

public class Facade {
    private DocumentController documentoController;

    public Facade() {
        this.documentoController = new DocumentController();
    }
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }
    boolean criarDocumento(String titulo, int tamanhoMaximo){
        return false;
    }
    void removerDocumento(String titulo){}

    int contarElementos(String titulo){
        return 0;
    }
    String[] exibirDocumento(String titulo){
        return new String[0];
    }

}
