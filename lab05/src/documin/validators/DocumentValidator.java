package documin.validators;

public class DocumentValidator {
    public static void validaTamanho(int tamanho){
        if(tamanho <= 0){
            throw new IllegalArgumentException("TAMANHO INVÁLIDO DE DOCUMENTO");
        }
    }

    public static void validaTitutlo(String titulo){
        if(titulo.isBlank()){
            throw new IllegalArgumentException("TÍTULO VAZIO");
        }
    }

    
}
