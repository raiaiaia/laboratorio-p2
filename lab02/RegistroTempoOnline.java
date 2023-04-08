package lab02;
/**
 * Classe que registra o tempo passado online dedicado a cada disciplina.
 */
public class RegistroTempoOnline{
    private int tempoOnlineEsperado;
    private String nomeDisciplina;
    private boolean atingiuMetaTempoOnline;
    private int tempoOnlineCadastrado;

    /**
     * Inicializa nomeDisciplina e tempoOnlineEsperado com os valores recebidos no parâmetro..
     * @param nomeDisciplina
     * @param tempoOnlineEsperado
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado){
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Inicializa a disciplina cadastrada com o tempo online da matéria definido com padrão 120h.
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
    /**
     * Método toString() sobrescrito que imprime
     * o "status" de tempo esperado e cadastrado
     * de cada disciplina.
     */
    public String toString(){
        return nomeDisciplina + " " + tempoOnlineCadastrado + " " + tempoOnlineEsperado;
    }
}
