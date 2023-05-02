public class Time {
    private String codigo;
    private String nome;
    private String mascote;


    public Time(String codigo, String nome, String mascote){
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
    }

    @Override
    public String toString() {
        return  "[" + this.codigo + "] " + this.nome + " / " + this.mascote;
    }

}
