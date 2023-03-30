package lab02;
public class RegistroResumos {
    private int numeroDeResumos;
    private String[] temas;
    private String[] resumos;
    private int indiceTema;

    public RegistroResumos(int numeroDeResumos){
        this.numeroDeResumos = numeroDeResumos;
        this.temas =  new String[numeroDeResumos];
        this.resumos = new String[numeroDeResumos];
    }

    void adiciona(String tema, String resumo){

        indiceTema = 0;

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

    String[] imprimeResumos(){
        String[] concatenada = new String[2];
        String saida = "", saida1 = "";

        saida += "- " + indiceTema + "resumo(s) cadastrado(s)";
        saida1 += "- ";

        for(int i = 0; i<indiceTema - 1; i++){
            saida1 += temas[i] + " | ";
        }

        saida1 += temas[indiceTema];

        concatenada[0] = saida;
        concatenada[1] = saida1;


        return concatenada;
    }

    int conta(){
        return indiceTema;
    }


    boolean temResumo(String tema){
        return false;
    }



}
