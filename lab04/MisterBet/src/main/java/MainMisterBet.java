import java.util.Scanner;

/**
 * Classe main para o sistema do Mr. Bet!
 * @author Danielly Rayanne Macedo Lima
 */
public class MainMisterBet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        while (true) {
            opcao = menu(scanner);
            comando(opcao);
        }
    }
    public static String menu(Scanner scanner){
        System.out.println("\n---\nMENU\n" +
                           "(M)inha inclusão de times\n" +
                           "(R)ecuperar time\n" +
                           "(.)Adicionar campeonato\n" +
                           "(B)ora incluir time em campeonato e Verificar se time está em campeonato\n"+
                           "(E)xibir campeonatos que o time participa\n"+
                           "(T)entar a sorte e status\n"+
                           "(!)Já pode fechar o programa!\n"+
                           "\n" +
                           "Opção> ");
        return scanner.next().toUpperCase();

    }

    public static void comando(String opcao){
        switch (opcao){
            case "M":
                cadastraTime();
                break;
            case "R":
                recuperaTime();
                break;
            case ".":
                adicionarCampeonato();
                break;
            case "B":
                incluiTime();
                break;
            case "E":
                exibeCampeonatosDoTime();
                break;
            case "T":
                aposta();
                break;
            case "!":
                sai();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA");
        }
    }
    public static void cadastraTime(){}
    public static void recuperaTime(){}
    public static void adicionarCampeonato(){}
    public static void incluiTime(){}
    public static void exibeCampeonatosDoTime(){}
    public static void aposta(){}

    public static void sai(){
        System.out.println("Saindo do Mr.Bet!");
        System.exit(0);
    }
}
