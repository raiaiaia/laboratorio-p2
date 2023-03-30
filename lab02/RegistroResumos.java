package lab02;
/**
 *  Classe que implementa e manipula operações no Registro de Resumos do coISA.
 */

public class RegistroResumos {
    private int numeroDeResumos;
    private String[] temas;
    private String[] resumos;
    private int indiceTema = 0;

    public RegistroResumos(int numeroDeResumos){
        this.numeroDeResumos = numeroDeResumos;
        this.temas =  new String[numeroDeResumos];
        this.resumos = new String[numeroDeResumos];
    }

    void adiciona(String tema, String resumo){

        if(indiceTema < numeroDeResumos){
            temas[indiceTema] = tema;
            resumos[indiceTema] = tema + ": " + resumo;
        }else{
            indiceTema = 0;
            temas[indiceTema] = tema;
            resumos[indiceTema] = tema + ": " + resumo;
        }
        indiceTema++;

    }

    String[] pegaResumos() {
        return resumos;
    }

    String imprimeResumos(){
        String saida = "", saida1 = "";

        saida += "- " + indiceTema + " resumo(s) cadastrado(s)\n";
        saida1 += "- ";

        for(int i = 0; i<indiceTema - 1; i++){
            saida1 += temas[i] + " | ";
        }

        saida1 += temas[--indiceTema];

        return saida + saida1;
    }

    int conta(){
        return indiceTema;
    }


    boolean temResumo(String tema){

        for(int i=0; i<indiceTema; i++){
            if(tema.equals(temas[i])){
                return true;
            }
        }

        return false;
    }



}
