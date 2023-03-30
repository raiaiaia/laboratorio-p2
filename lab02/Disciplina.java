package lab02;
import java.util.*;
public class Disciplina {
    private String nomeDisciplina;
    private int horasCadastradas;
    private double[] notas = new double[4];
    boolean aprovado;
    double mediaAluno;
    public Disciplina(String nomeDisciplina){

        this.nomeDisciplina = nomeDisciplina;
    }
    void cadastraHoras(int horasCadastradas){

        this.horasCadastradas = horasCadastradas;
    }
    void cadastraNota(int nota, double valorNota){

        notas[nota - 1] = valorNota;
    }
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
