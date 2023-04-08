package lab02;
import java.util.*;

/**
 * Classe que cadastra horas de estudo e notas dos alunos, além retornar o estado de aprovação.
 */

public class Disciplina {
    private String nomeDisciplina;
    private int horasCadastradas;
    private double[] notas;
    boolean aprovado;
    private int[] pesos;
    /**
     * Variável responsável por receber a quantidade de notas a serem cadastradas,
     * quando esta for recebida como um parâmetro.
     */
    private int numNotas;
    double somaNotas;
    double mediaAluno;

    /**
     * Implementação para cadastro de uma nova disciplina e seu
     * sistema de notas, no caso, por média aritmética de quatro notas.
     * Atribui o nome da disciplina cadastrada;
     * Inicializa o array de notas com a quantidade das notas (que por default é 4);
     * Inicializa a variável numNotas como sendo igual a 0.
     * @param nomeDisciplina
     */
    public Disciplina(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
        this.numNotas = 0;
    }

    /**
     * Implementação para cadastro de uma nova disciplina e seu sistema
     * de notas, no caso, por média aritmética, mas com o número de notas
     * que vier como parâmetro na hora da criação da disciplina.
     * Atribui o nome da disciplina cadastrada;
     * Inicializa o array de notas com o valor numNotas;
     * Atribui valor a variável numNotas.
     * @param nomeDisciplina
     * @param numNotas
     */
    public Disciplina(String nomeDisciplina, int numNotas) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numNotas];
        this.numNotas = numNotas;
    }
    /**
     * Implementação para cadastro de uma nova disciplina e seu sistema de notas,
     * no caso, por média ponderada e com o número de notas(e seus pesos) que
     * vierem como parâmetro na hora da criação da disciplina.
     * Atribui o nome da disciplina cadastrada;
     * Armazena a quantidade das notas;
     * Inicializa o array de notas com o valor numNotas;
     * Atribui valor ao array pesos;
     * Atribui valor a variável numNotas.
     * @param nomeDisciplina
     * @param numNotas
     * @param pesos
     */
    public Disciplina(String nomeDisciplina, int numNotas, int[] pesos){
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[numNotas];
        this.pesos = pesos;
        this.numNotas = numNotas;
    }

    /**
     * Cadastro das horas.
     * @param horasCadastradas
     */
    void cadastraHoras(int horasCadastradas){
        this.horasCadastradas = horasCadastradas;
    }

    /**
     * Cadastro de notas.
     * @param nota
     * @param valorNota
     */
    void cadastraNota(int nota, double valorNota){
        notas[nota - 1] = valorNota;
    }

    /**
     * Calcula a média da disciplina a depender se for aritmética ou ponderada.
     * Caso numNotas for igual a zero, a média será aritmética. E, caso numNotas
     * for maior que 0, a média será ponderada.
     */
    void calculaMedia(){

        if(numNotas == 0){
            for(int i=0; i<4; i++){
               somaNotas += notas[i];
            }
            mediaAluno = somaNotas/4;

        }else if(numNotas > 0){
            for(int i=0; i<numNotas; i++){
                somaNotas += notas[i];
            }
            mediaAluno = somaNotas/numNotas;

        }else if(numNotas > 0 && pesos != null){
            for(int i=0; i<numNotas; i++){
                somaNotas += notas[i] * pesos[i];
            }
            mediaAluno = somaNotas/numNotas;
        }
    }

    /**
     * Retorna o status de aprovado do aluno a depender de sua média.
     * Caso o aluno atinja média maior ou igual a sete ele estará aprovado.
     * @return boolean aprovado
     */
    boolean aprovado(){
        calculaMedia();

        if(mediaAluno >= 7){
            aprovado = true;
        }else if(mediaAluno < 7){
            aprovado = false;
        }
        return aprovado;
    }
    /**
     * Método toString() sobrescrito que imprime
     * o "status" da disciplina.
     */
    @Override
    public String toString(){
        return nomeDisciplina + " " + horasCadastradas + " " + mediaAluno + " " + Arrays.toString(notas);
    }
}
