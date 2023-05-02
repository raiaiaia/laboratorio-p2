import java.util.Scanner;

/**
 * Classe main para o sistema do Mr. Bet!
 * @author Danielly Rayanne Macedo Lima
 */
public class MainMisterBet {

    public static void main(String[] args) {
        MisterBetController mrBet = new MisterBetController();
        Scanner scanner = new Scanner(System.in);
        String opcao = "";
        while (true) {
            opcao = menu(scanner);
            comando(opcao, mrBet, scanner);
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

    public static void comando(String opcao, MisterBetController mrBet, Scanner scanner){
        switch (opcao){
            case "M":
                cadastraTime(mrBet, scanner);
                break;
            case "R":
                recuperaTime(mrBet, scanner);
                break;
            case ".":
                adicionaCampeonato(mrBet, scanner);
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

    public static void cadastraTime(MisterBetController mrBet, Scanner scanner){
        System.out.println("\nCódigo: ");
        String codigo = scanner.next();
        System.out.println("\nNome: ");
        String nome = scanner.next();
        System.out.println("\nMascote: ");
        String mascote = scanner.next();

        try{
            System.out.println(mrBet.cadastraTime(codigo, nome, mascote));
        }catch (IllegalArgumentException e ){
            System.out.println(e.getMessage());
        }

    }
    public static void recuperaTime(MisterBetController mrBet, Scanner scanner){
        System.out.println("\nCódigo: ");
        String codigo = scanner.next();

        try{
            System.out.println(mrBet.recuperaTime(codigo));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    public static void adicionaCampeonato(MisterBetController mrBet, Scanner scanner){
        scanner = new Scanner(System.in);
        System.out.println("\nCampeonato: ");
        String campeonato = scanner.nextLine();
        System.out.println("\nParticipantes: ");
        int participantes = scanner.nextInt();

        try{
            System.out.println(mrBet.adicionaCampeonato(campeonato, participantes));
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

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
            System.out.println("\nCampeonato: ");
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
