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
        System.out.println("""
                         
                ---------- MENU ----------
                (M)inha inclusão de times
                (R)ecuperar time
                (.)Adicionar campeonato
                (B)ora incluir time em campeonato e Verificar se time está em campeonato
                (E)xibir campeonatos que o time participa
                (T)entar a sorte e status
                (!)Já pode fechar o programa!
                (H) Histórico
                  
                Opção>""");
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
                subMenu1(mrBet, scanner);
                break;
            case "E":
                exibeCampeonatosDoTime(mrBet, scanner);
                break;
            case "T":
                subMenu2(mrBet, scanner);
                break;
            case "H":
                historico(mrBet);
                break;
            case "!":
                sai();
                break;
            default:
                System.err.println("OPÇÃO INVÁLIDA");
        }
    }

    public static void cadastraTime(MisterBetController mrBet, Scanner scanner){
        System.out.println("\nCódigo: ");
        scanner = new Scanner(System.in);
        String codigo = scanner.nextLine().toUpperCase();
        System.out.println("\nNome: ");
        String nome = scanner.next();
        System.out.println("\nMascote: ");
        scanner = new Scanner(System.in);
        String mascote = scanner.nextLine();

        try{
            System.out.println(mrBet.cadastraTime(codigo, nome, mascote));
        }catch (IllegalArgumentException e ){
            System.out.println(e.getMessage());
        }

    }

    public static void recuperaTime(MisterBetController mrBet, Scanner scanner){
        System.out.println("\nCódigo: ");
        String codigo = scanner.next().toUpperCase();

        try{
            System.out.println(mrBet.recuperaTime(codigo));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public static void adicionaCampeonato(MisterBetController mrBet, Scanner scanner){
        scanner = new Scanner(System.in);
        System.out.println("\nCampeonato: ");
        String campeonato = scanner.nextLine().toUpperCase();
        System.out.println("\nParticipantes: ");
        int participantes = scanner.nextInt();

        try{
            System.out.println(mrBet.adicionaCampeonato(campeonato, participantes));
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    public static void subMenu1(MisterBetController mrBet, Scanner scanner){
        System.out.println("\n(I)ncluir time em campeonato ou (V)erificar se time está em campeonato? ");
        scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();

        if(opcao.equals("I") || opcao.equals("i")){
            System.out.println("\nCampeonato: ");
            String campeonato = scanner.nextLine().toUpperCase();
            System.out.println("\nCódigo do Time: ");
            String codigo = scanner.nextLine().toUpperCase();

            try{
                System.out.println(mrBet.incluiTime(campeonato, codigo));
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }

        } else if(opcao.equals("V") || opcao.equals("v")){
            System.out.println("\nCódigo do Time: ");
            String codigo = scanner.nextLine().toUpperCase();
            System.out.println("\nCampeonato: ");
            String campeonato = scanner.nextLine().toUpperCase();

            try{
                System.out.println(mrBet.verificaTimeCampeonato(codigo, campeonato));
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
            }

        }
    }

    public static void exibeCampeonatosDoTime(MisterBetController mrBet, Scanner scanner){
        System.out.println("\nTime: ");
        String time = scanner.next().toUpperCase();

        try{
            System.out.println(mrBet.exibeCampeonatosTime(time));
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    private static void subMenu2(MisterBetController mrBet, Scanner scanner){
        System.out.println("\n(A)postar ou (S)tatus de Apostas? ");
        scanner = new Scanner(System.in);
        String opcao = scanner.next();

        if(opcao.equals("A") || opcao.equals("a")){
            System.out.println("\nCódigo: ");
            String codigo = scanner.next().toUpperCase();
            System.out.println("\nCampeonato: ");
            scanner = new Scanner(System.in);
            String campeonato = scanner.nextLine().toUpperCase();
            System.out.println("\nColocação: ");
            scanner = new Scanner(System.in);
            int colocacao = scanner.nextInt();
            System.out.println("\nValor da aposta: ");
            double valor = scanner.nextDouble();

            try{
                System.out.println(mrBet.aposta(codigo, campeonato, colocacao, valor));
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }

        if(opcao.equals("S") || opcao.equals("s")){
            try{
                System.out.println(mrBet.statusApostas());
            } catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void historico(MisterBetController mrBet){

        try {
            System.out.println("Participação mais frequente em campeonatos");
            System.out.println(mrBet.participacaoMaisFrequente());

            System.out.println("Ainda não participou de campoenato");
            System.out.println(mrBet.naoParticipouDeCampeonato());

            System.out.println("Popularidade em apostas");
            System.out.println(mrBet.popularidadeEmApostas());

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public static void sai(){
        System.out.println("Por hoje é só pessoal!");
        System.exit(0);
    }
}
