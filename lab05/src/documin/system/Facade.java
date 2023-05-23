package documin.system;

import documin.document.DocumentController;

public class Facade {
    private DocumentController documentoController;

    public Facade() {
        this.documentoController = new DocumentController();
    }
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }
    public boolean criarDocumento(String titulo, int tamanhoMaximo){
        return false;
    }
    public void removerDocumento(String titulo){}

    public int contarElementos(String titulo){
        return 0;
    }
    public String[] exibirDocumento(String titulo){
        return new String[0];
    }

}
