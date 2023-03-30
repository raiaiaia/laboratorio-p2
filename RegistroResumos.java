public class RegistroResumos {
    private int numeroDeResumos;
    private String[][] resumos = new String[numeroDeResumos][2];
    private int indice = 0;
    public RegistroResumos(int numeroDeResumos){
        this.numeroDeResumos = numeroDeResumos;
    }
    public void adiciona(String tema, String resumo){
        while(resumos.length < numeroDeResumos){
            resumos[indice][0] = tema;
            resumos[indice][1] = resumo;
            indice++;
        }

    }

    /*
    public String[] pegaResumos() {
        return;
    }

    public String imprimeResumos(){
        return;
    }

    public int conta(){
        return;
    }

    public boolean temResumo(String tema){
        return;
    }

     */


}
