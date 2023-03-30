package lab02;

/**
 * Classe que contabiliza e registra as horas de descanso do aluno no coISA.
 */
public class Descanso {
    private String status;

    //cansado por default
    private String saida;
    private int horasDescanso;
    private int numeroSemanas;

    void defineHorasDescanso(int horasDescanso){
        this.horasDescanso = horasDescanso;
    }

    void defineNumeroSemanas(int numeroSemanas){
        this.numeroSemanas = numeroSemanas;
    }

    String getStatusGeral(){

        if(horasDescanso == 0){
            saida = "cansado";
        }

        if(numeroSemanas > 0){
            if((horasDescanso/numeroSemanas) < 26){
                saida = "cansado";
            }else if((horasDescanso/numeroSemanas) >= 26) {
                saida = "descansado";
            }
        }

        return saida;
    }

    public int getNumeroSemanas() {
        return horasDescanso/numeroSemanas;
    }
}
