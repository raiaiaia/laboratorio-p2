package lab02;
/**
 *  Laboratório de Programação 2
 *  @author Danielly Rayanne Macedo Lima
 *  Matrícula - 122110702
 *  Classe Main responsável pelo Coisa Bônus.
 */
public class CoisaBonus {
    public static void main(String[] args) {
        calcularMedia();
        System.out.println("-----");
        registrarDescanso();
    }
    public static void calcularMedia(){
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2", 2);
        Disciplina lprog2 = new Disciplina(" LABORATÓRIO DE PROGRAMACAO 2", 2, new int[] {6,4});

        prog2.cadastraNota(1, 7.7);
        System.out.println(prog2.aprovado());
        prog2.cadastraNota(2, 8.8);
        System.out.println(prog2.aprovado());
        lprog2.cadastraNota(1, 8.0);
        lprog2.cadastraNota(2, 9.0);
        System.out.println(prog2.aprovado());
    }

    public static void registrarDescanso(){
        Descanso descanso = new Descanso();

        System.out.println(descanso.getStatusGeral());
        descanso.defineHorasDescanso(30);
        descanso.defineNumeroSemanas(1);
        descanso.definirEmoji("*_*");
        System.out.println(descanso.getStatusGeral());
        descanso.defineNumeroSemanas(2);
        descanso.definirEmoji(":(");
        System.out.println(descanso.getStatusGeral());
    }
}
