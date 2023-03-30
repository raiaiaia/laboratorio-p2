package lab02;

/**
 * Classe que registra o tempo passado online dedicado a cada disciplina.
 */
public class RegistroTempoOnline{
    /**
     * Tempo de estudo online esperado para a disciplina.
     */
    private int tempoOnlineEsperado;
    /**
     * Nome da disciplina cadastrada.
     */
    private String nomeDisciplina;
    /**
     * Verificador de que o tempo mínimo online foi atingido ou não.
     */
    private boolean atingiuMetaTempoOnline;
    /**
     *  Guarda a soma de todos os registro de temposOnline cadastrados por aluno ao longo do tempo.
     */
    private int tempoOnlineCadastrado;

    /**
     * Atribui valor aos atributos do nome da disciplina e ao tempo online esperado definido pela matéria.
     * @param nomeDisciplina
     * @param tempoOnlineEsperado
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Atribui valor aos atributos do nome da disciplina com tempo online da matéria definido com padrão 120h.
     * @param nomeDisciplina
     */
    public RegistroTempoOnline(String nomeDisciplina){
        this.nomeDisciplina = nomeDisciplina;
        tempoOnlineEsperado = 60 * 2;
    }

    /**
     * Cadastra tempo online.
     * @param tempoOnlineCadastrado
     */
    void adicionaTempoOnline(int tempoOnlineCadastrado){
        this.tempoOnlineCadastrado += tempoOnlineCadastrado;
    }

    /**
     * Verifica se o aluno atingiu o mínimo de horas online cadastradas.
     * @return
     */
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
