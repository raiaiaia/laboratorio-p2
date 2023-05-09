import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *  Classe que implementa o Sistema Mr.Bet.
 */

public class MisterBetController {
    private HashSet<Campeonato> campeonatos;
    private HashMap<String, Time> times;
    private ArrayList<Aposta> apostas;
    public MisterBetController(){
        this.campeonatos = new HashSet<>();
        this.times = new HashMap<>();
        this.apostas = new ArrayList<Aposta>();
    }

    /**
     * Cadastra um time no sistema.
     * @param codigo - o codigo de identificação do time.
     * @param nome - nome do time.
     * @param mascote - mascote do time.
     * @return
     */
    public String cadastraTime(String codigo, String nome, String mascote){
        if(times.containsKey(codigo.toUpperCase())) {
            return "TIME JÁ EXISTE!";
        }
        Time novoTime = new Time(codigo, nome, mascote);
        times.put(codigo.toUpperCase(), novoTime);

        return "INCLUSÃO REALIZADA!";
    }

    public Time getTime(String codigo){
        return this.times.get(codigo);
    }

    /**
     * Exibe o time por meio de seu código.
     * @param codigo - o código de identificação do time.
     * @return a representação em String do time
     */
    public String recuperaTime(String codigo){
        Time time = getTime(codigo);

        if(time == null){
            return "TIME NÃO EXISTE!";
        }
        return time.toString();
    }

    /**
     * Adiciona um novo campeonato no sistema.
     * @param campeonato - o nome do campeonato.
     * @param participantes - a quantidade de participantes.
     * @return uma String mostrando se o campeonato foi ou não adicionado.
     */
    public String adicionaCampeonato(String campeonato, int participantes){
        Campeonato novoCampeonato = new Campeonato(campeonato.toUpperCase(), participantes);
        if(campeonatos.contains(novoCampeonato)){
            return "CAMPEONATO JÁ EXISTE!";
        }
        campeonatos.add(novoCampeonato);
        return "CAMPEONATO ADICIONADO!";
    }

    private Campeonato getCampeonato(String nome){
        Campeonato c1 = null;
        for(Campeonato c: campeonatos){
            if(c.getNome().toUpperCase().equals(nome)){
                c1 = c;
            }
        }
        return c1;
    }

    /**
     * Faz a inclusão de um time em um campeonato.
     * @param campeonato - o nome do campeonato.
     * @param codigo - o código de identificação de um time.
     * @return uma String mostrando se o time foi ou não adicionado ao campeonato.
     */
    public String incluiTime(String campeonato, String codigo){
        Campeonato c1 = getCampeonato(campeonato);
        if(c1 == null){
            throw new NullPointerException("CAMPEONATO NÃO EXISTE!");
        }
        if(times.get(codigo) == null){
            throw new NullPointerException("TIME NÃO EXISTE!");
        }
        return c1.adicionaTime(c1, times.get(codigo));
    }

    /**
     * Verifica se o time faz parte do campeonato.
     * @param codigo - o código de identificação do time.
     * @param campeonato - o nome do campeonato.
     * @return uma String mostrando se o time pertence ou não ao campeonato.
     */
    public  String verificaTimeCampeonato(String codigo, String campeonato){
        Campeonato c1 = getCampeonato(campeonato);
        if(c1 == null){
            throw new NullPointerException("CAMPEONATO NÃO EXISTE!");
        }
        if(times.get(codigo) == null){
            throw new NullPointerException("TIME NÃO EXISTE!");
        }
        return c1.verificaTime(times.get(codigo));
    }

    /**
     * Exibe todos os campeonatos que um time participa.
     * @param codigo - o código de identificação do time.
     * @return uma String com todos os campeonatos aos quais o time pertence.
     */
    public String exibeCampeonatosTime(String codigo){
        if(times.get(codigo) == null){
            return "TIME NÃO EXISTE!";
        }
        Time time = times.get(codigo);
        ArrayList<Campeonato> campeonatosTime = time.getCampeonatos();
        String saida = "Campeonatos do " + time.getNome() + ":\n";

        for(Campeonato c: campeonatosTime){
            saida += c.toString() + "\n";
        }
        return saida;
    }

    /**
     * Realiza a aposta de um time em um campeonato.
     * @param codigo - o código de identificação do time.
     * @param campeonato - o nome do campeonato.
     * @param colocacao - a colocação do time no campeonato a ser apostado.
     * @param valor - o valor da aposta.
     * @return uma String identificando se a aposta foi ou não registrada.
     */

    public String aposta(String codigo, String campeonato, int colocacao, double valor) {
        if(getTime(codigo) == null){
            return "TIME NÃO EXISTE!";
        }
        Time time = getTime(codigo);
        String codigoTime = time.getCodigo();
        String nomeTime = time.getNome();
        String mascoteTime = time.getMascote();

        if(getCampeonato(campeonato) == null){
            return "CAMPEONATO NÃO EXISTE!";
        }
        Campeonato c = getCampeonato(campeonato);
        String nomeCampeonato = c.getNome();
        int participantesCampeonato = c.getParticipantes();

        if(colocacao > participantesCampeonato){
            return "APOSTA NÃO REGITRADA!";
        }
        if(colocacao == 1){
            time.setPopularidadeApostas();
        }

        Aposta novaAposta = new Aposta(codigoTime, nomeTime, mascoteTime, nomeCampeonato, participantesCampeonato, colocacao, valor);
        apostas.add(novaAposta);

        return "APOSTA REGISTRADA!";
    }

    /**
     * Exibe o status de todas as apostas feitas.
     * @return uma lista com todas as apostas.
     */
    public String statusApostas(){
        String saidaApostas = "Apostas:\n";
        int numAposta = 1;

        for(Aposta a: apostas){
            saidaApostas += numAposta + ". " + a.toString() + "\n";
            numAposta ++;
        }
        return saidaApostas;
    }

    /**
     * Método que compõe o Histórico.
     * Exibe o(s) time(s) que estão em mais campeonatos.
     * @return uma lista com todos os times que possuem mais frequência em campeonatos.
     */
    public String participacaoMaisFrequente(){
        String saida = "";
        Time maiorFrequencia = null;
        int maiorAtual = 0;
        for(Time t: times.values()){
            if(t.getQtdCampeonatos() > 0 && t.getQtdCampeonatos() >= maiorAtual){
                maiorAtual = t.getQtdCampeonatos();
                maiorFrequencia =  t;
                saida = t + "  - " + t.getQtdCampeonatos() +" campeonatos" + "\n";
            }
        }

        for(Time t: times.values()){
            if(t.getQtdCampeonatos() == maiorAtual && !(t.equals(maiorFrequencia))){
                saida += t + "  - " + t.getQtdCampeonatos() + " campeonatos"+ "\n";
            }
        }

        return saida;
    }

    /**
     * Método que compõe o Histórico.
     * Exibe o(s) time(s) que não estão participando de nenhum campeonato.
     * @return uma lista com os times que não estão em nenhum campeonato.
     */
    public String naoParticipouDeCampeonato(){
        String saida = "";

        for(Time t: times.values()){
            if(t.getQtdCampeonatos() == 0){
                saida += t + "\n";
            }
        }
        return saida;
    }

    /**
     * Método que compõe o Histórico.
     * Exibe o(s) time(s) que mais tiveram apostas em primeira colocação
     * e a quantidade de vezes que foram adicionados a esta posição.
     * @return uma lista com todos os times que tiveram maior popularidade.
     */
    public String popularidadeEmApostas(){
        String saida = "";

        for(Time t: times.values()){
            if(t.getPopularidadeApostas() >= 1){
                saida += t.getNome() + " / " + t.getPopularidadeApostas() + "\n";
            }
        }
        return saida;
    }

}
