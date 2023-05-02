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
                //cadastraTime();
                break;
            case "R":
                //recuperaTime();
                break;
            case ".":
                //adicionaCampeonato();
                break;
            case "B":
                //incluiTime();
                break;
            case "E":
                //exibeCampeonatosDoTime();
                break;
            case "T":
                //aposta();
                break;
            case "!":
                sai();
                break;
            default:
                System.out.println("OPÇÃO INVÁLIDA");
        }
    }

    public static void cadastraTime(Scanner scanner){
        System.out.println("\nCódigo: ");
        String codigo = scanner.nextLine();
        System.out.println("\nNome: ");
        String nome = scanner.nextLine();
        System.out.println("\nMascote: ");
        String mascote = scanner.nextLine();

        //.cadastraTime(codigo, nome, mascote);

    }
    public static void recuperaTime(Scanner scanner){
        System.out.println("\nCódigo: ");
        String codigo = scanner.nextLine();
    }
    public static void adicionaCampeonato(Scanner scanner){
        System.out.println("\nCampeonato: ");
        String campeonato = scanner.nextLine();
        System.out.println("\nParticipantes: ");
        int participantes = scanner.nextInt();
    }
    public static void incluiTime(Scanner scanner){
        System.out.println("\n(I)ncluir time em campeonato ou (V)erificar se time está em campeonato? ");
        String opcao = scanner.nextLine();

        if(opcao.equals("I")){
            System.out.println("\nCampeonato: ");
            String campeonato = scanner.nextLine();
            System.out.println("\nCódigo do Time: ");
            String time = scanner.nextLine();
        } else if(opcao.equals("V")){
            System.out.println("\nCódigo do Time: ");
            String time = scanner.nextLine();
            System.out.println("\nCampeonato: ");
            String campeonato = scanner.nextLine();
        }

    }
    public static void exibeCampeonatosDoTime(Scanner scanner){
        System.out.println("\nTime: ");
        String time = scanner.nextLine();
    }
    public static void aposta(Scanner scanner){
        System.out.println("(A)postar ou (S)tatus das Apostas? ");
        String opcao = scanner.nextLine();

        if(opcao.equals("A")){
            System.out.println("\nCódigo do Time: ");
            String time = scanner.nextLine();
            System.out.println('\nCampeonato: ');
            String campeonato = scanner.nextLine();
            System.out.println("\nColocação: ");
            int colocacao = scanner.nextInt();
            System.out.println("\nValor da aposta: ");
            double valor = scanner.nextDouble();
        }else if (opcao.equals("S")){

        }
    }

    public static void sai(){
        System.out.println("Por hoje é só pessoal!");
        System.exit(0);
    }
}
