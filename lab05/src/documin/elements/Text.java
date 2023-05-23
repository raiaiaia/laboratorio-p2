package documin.elements;

import documin.elements.Element;

public class Text extends Element {

    public String texto;

    public Text(String texto){
        this.texto = texto;
    }

    @Override
    public String representacaoResumo() {
        return this.texto;
    }
    @Override
    public String representacaoCompleta() {
        return this.texto;
    }
}
