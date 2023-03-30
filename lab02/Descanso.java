package lab02;

/**
 * Classe que contabiliza e registra as horas de descanso do aluno no coISA.
 */
public class Descanso {
    /**
     * Status de descanso do aluno.
     */
    private String statusGeral;
    /**
     *  Quantidade de horas descansadas do aluno.
     */
    private int horasDescanso;
    /**
     *  Números de semanas de descanso para ter a relação horas/semanas de descanso do aluno.
     */
    private int numeroSemanas;

    /**
     * Atribuição de valor ao atributo.
     * @param horasDescanso
     */
    void defineHorasDescanso(int horasDescanso){
        this.horasDescanso = horasDescanso;
    }

    /**
     * Atriibuição de valor ao atributo.
     * @param numeroSemanas
     */
    void defineNumeroSemanas(int numeroSemanas){
        this.numeroSemanas = numeroSemanas;
    }

    /**
     *  Retorna o status de descanso a depender das horas semanais descansadas.
     * @return String com o estado de descanso.
     */
    String getStatusGeral(){
        if(horasDescanso == 0){
            statusGeral = "cansado";
        }
        if(numeroSemanas > 0){
            if((horasDescanso/numeroSemanas) < 26){
                statusGeral = "cansado";
            }else if((horasDescanso/numeroSemanas) >= 26) {
                statusGeral = "descansado";
            }
        }
        return statusGeral;
    }
}
