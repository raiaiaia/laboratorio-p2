package lab02;

/**
 * Classe que registra o tempo passado online dedicado a cada disciplina.
 */
public class RegistroTempoOnline{
    private int tempoOnlineEsperado;
    private String nomeDisciplina;
    private boolean atingiuMetaTempoOnline;
    private int tempoOnlineCadastrado;

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }
    public RegistroTempoOnline(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        tempoOnlineEsperado = 60 * 2;
    }

    void adicionaTempoOnline(int tempoOnlineCadastrado){
        this.tempoOnlineCadastrado += tempoOnlineCadastrado;
    }

    boolean atingiuMetaTempoOnline(){

        if(tempoOnlineCadastrado >= tempoOnlineEsperado){
            atingiuMetaTempoOnline = true;
        }else{
            atingiuMetaTempoOnline = false;
        }

        return atingiuMetaTempoOnline;

    }
    public String toString(){
        return nomeDisciplina + " " + tempoOnlineCadastrado + " " + tempoOnlineEsperado;
    }
}
