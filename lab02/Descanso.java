package lab02;

/**
 * Classe que contabiliza e registra as horas de descanso do aluno no coISA.
 */
public class Descanso {
    private String statusGeral;
    private int horasDescanso;
    private int numeroSemanas;
    private String valor;
    boolean temEmoji = false;

    /**
     * Inicializa horasDescanso com o valor recebido no parâmetro.
     * @param horasDescanso
     */
    void defineHorasDescanso(int horasDescanso){
        this.horasDescanso = horasDescanso;
    }

    /**
     * Inicializa numeroSemanas com o valor recebido no parâmetro.
     * @param numeroSemanas
     */
    void defineNumeroSemanas(int numeroSemanas){
        this.numeroSemanas = numeroSemanas;
    }

    void definirEmoji(String valor){
        temEmoji = true;
        this.valor = valor;
    }

    /**
     * @return Status de cansado do aluno a depender da quantidade de horas descansadas cadastradas.
     */
    String getStatusGeral(){
        if(horasDescanso == 0 && temEmoji){
            statusGeral = "cansado " + valor;
        }else{
            statusGeral = "cansado ";
        }

        if(numeroSemanas > 0){

            if((horasDescanso/numeroSemanas) < 26 && temEmoji) {
                statusGeral = "cansado " + valor;

            }else if((horasDescanso/numeroSemanas) < 26){
                statusGeral = "cansado";

            }else if((horasDescanso/numeroSemanas) >= 26 && temEmoji) {
                statusGeral = "descansado " + valor;

            }else if((horasDescanso/numeroSemanas) >= 26){
                statusGeral = "descansado";
            }
        }
        return statusGeral;
    }
}
