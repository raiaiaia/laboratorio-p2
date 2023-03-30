package lab02;
import java.util.*;

/**
 * Classe que cadastra horas de estudo e notas dos alunos, além retornar o estado de aprovação.
 */
public class Disciplina {
    /**
     *  Nome da disciplina cadastrada pelo aluno.
     */
    private String nomeDisciplina;
    /**
     * Horas de estudo cadastradas.
     */
    private int horasCadastradas;
    /**
     *  Array de números em ponto flutuante que armazenam as notas do aluno.
     */
    private double[] notas = new double[4];
    /**
     * Variável do tipo booleana para verificar o status de aprovado do aluno na disciplina.
     */
    boolean aprovado;
    /**
     * Variável que recebe o valor da média de notas do aluno.
     */
    double mediaAluno;

    /**
     * Atribuição do nome da disciplina cadastrada.
     * @param nomeDisciplina
     */
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Atribuição das horas cadastradas.
     * @param horasCadastradas
     */
    void cadastraHoras(int horasCadastradas){
        this.horasCadastradas = horasCadastradas;
    }

    /**
     * Método que adiciona uma das quatro notas do aluno em um array de posição [nota-1] de 0 a 3.
     * @param nota
     * @param valorNota
     */
    void cadastraNota(int nota, double valorNota){
        notas[nota - 1] = valorNota;
    }

    /**
     * Método que retorna o status de aprovado do aluno por meio de um cálculo de média aritmética.
     * @return boolean aprovado
     */
    boolean aprovado(){
        double somaNotas = 0;
        for(int i=0; i<4; i++){
            somaNotas += notas[i];
        }

        mediaAluno = somaNotas/4;
        if(mediaAluno >= 7){
            aprovado = true;
        }else if(mediaAluno < 7){
            aprovado = false;
        }
        return aprovado;
    }

    @Override
    public String toString(){
        return nomeDisciplina + " " + horasCadastradas + " " + mediaAluno + " " + Arrays.toString(notas);
    }
}
