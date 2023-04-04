package lab02;
/**
 *  Classe que implementa e manipula operações no Registro de Resumos do coISA.
 */

public class RegistroResumos {
    /**
     * A quantidade de resumos que podem ser guardadas.
     */
    private int numeroDeResumos;
    /**
     * Array de String com os títulos dos resumos cadastrados e de tamanho numeroDeResumos.
     */
    private String[] temas;

    /**
     * Adiciona resumos a Resumos na formatação título:conteúdo e de tamanho numeroDeResumos.
     */
    private Resumos[] resumos;
    /**
     *  Número de resumos já cadastrados.
     */
    private int indiceTema = 0;

    /**
     * Atribui valor para numeroDeResumos e inicializa os arrays "tema" e "resumos".
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
     * @param tema
     * @param resumo
     */
    void adiciona(String tema, String resumo){

        if(indiceTema < numeroDeResumos){
            resumos[indiceTema].setTitulo(tema);
            resumos[indiceTema].setResumo(resumo);
        }else{
            indiceTema = 0;
            resumos[indiceTema].setTitulo(tema);
            resumos[indiceTema].setResumo(resumo);
        }
        indiceTema++;

    }
    String[] pegaResumos() {
        String[] saida = new String[indiceTema];

        for(int i=0; i< saida.length; i++){
            saida[i] = resumos[i].toString();
        }
        return saida;
    }

    /**
     * Método que imprime uma visualização das quantidades de resumos cadastrados e seus respectivos títulos.
     * @return quantidade de resumos e títulos dos resumos.
     */

    /*
    String imprimeResumos(){
        String saida = "";

        for(int i = 0; i<indiceTema - 1; i++){
            saida += temas[i] + " | ";
        }
        saida += temas[indiceTema - 1];

        return "- " + indiceTema + " resumo(s) cadastrado(s)\n" + "- " + saida;
    }
    */

    /**
     * Método que conta o número de resumos cadastrados.
     * @return
     */
    int conta(){
        return indiceTema;
    }

    /**
     * Verifica se há resumos cadastrados.
     * @param tema
     * @return boolean true or false.
     */

    /*
    boolean temResumo(String tema){

        for(int i=0; i<indiceTema; i++){
            if(tema.equals(temas[i])){
                return true;
            }
        }
        return false;
    }
     */


}
