package lab02;
/**
 *  Classe que implementa e manipula operações no Registro de Resumos do coISA.
 */

public class RegistroResumos {
    private int numeroDeResumos;
    private Resumos[] resumos;
    private int numResumos = 0;

    /**
     * Implementação para a inicialização do armazenamento de resumos de acordo
     * com o valor recebido no parâmetro.
     * @param numeroDeResumos
     */
    public RegistroResumos(int numeroDeResumos){
        this.numeroDeResumos = numeroDeResumos;
        resumos = new Resumos[numeroDeResumos];

        for(int i=0; i<resumos.length; i++){
            resumos[i] = new Resumos();
        }
    }

    /**
     * Adiciona resumos no array resumos.
     * Caso seja adicionado mais resumos que o suportado pelo array
     * ele começa a sobrescrever nos espaços de memória a partir da
     * posição 0.
     * @param tema
     * @param resumo
     */
    void adiciona(String tema, String resumo){

        if(numResumos < numeroDeResumos){
            resumos[numResumos].setTitulo(tema);
            resumos[numResumos].setResumo(resumo);
        }else{
            numResumos = 0;
            resumos[numResumos].setTitulo(tema);
            resumos[numResumos].setResumo(resumo);
        }
        numResumos++;
    }

    /**
     * Retorna todos os resumos cadastrados na formatação do toString() de Resumos.
     * @return saida
     */
    String[] pegaResumos() {
        String[] saida = new String[numResumos];

        for(int i=0; i< saida.length; i++){
            saida[i] = resumos[i].toString();
        }
        return saida;
    }

    /**
     * Método que imprime a visualização das quantidades de resumos cadastrados e seus respectivos títulos.
     * @return quantidade de resumos e títulos dos resumos.
     */
    String imprimeResumos(){
        String saida = "";

        for(int i = 0; i<numResumos - 1; i++){
            saida += resumos[i].getTitulo() + " | ";
        }
        saida += resumos[numResumos - 1].getTitulo();

        return "- " + numResumos + " resumo(s) cadastrado(s)\n" + "- " + saida;
    }

    /**
     * Retorna o número de resumos cadastrados até então.
     * @return numResumos
     */
    int conta(){return numResumos;}

    /**
     * Verifica se há resumos cadastrados.
     * @param tema
     * @return boolean true or false.
     */
    boolean temResumo(String tema){
        for(int i=0; i<numResumos; i++){
            if(tema.equals(resumos[i].getTitulo())){
                return true;
            }
        }
        return false;
    }



}
