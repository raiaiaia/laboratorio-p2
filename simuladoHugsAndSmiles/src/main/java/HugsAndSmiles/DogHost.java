package HugsAndSmiles;


import java.util.ArrayList;

public class DogHost {
    private String nomeAnfitriao;
    private int qtdMaxDogs;
    private int qtdMaxRacao;
    private Dog[] doguinhos;
    private final double valorDia = 0.4;
    private int totalDiarioRacao = 0;
    private double totalDiarioValorHospedagens = 0;
    private int numCachorros = 0;

    public DogHost(String nomeAnfitriao, int qtdMaxDogs, int qtdMaxRacao){
        this.nomeAnfitriao = nomeAnfitriao;
        this.qtdMaxRacao = qtdMaxRacao;
        this.qtdMaxDogs = qtdMaxDogs;
        this.doguinhos = new Dog[qtdMaxDogs];

    }

    public boolean adicionaDog(String nomePet, String nomeDono, int qtdRacao){
        if(nomePet == null || nomeDono == null){
            throw new NullPointerException("Campo nulo");
        }
        if(nomePet.isBlank() || nomeDono.isBlank()){
            throw new IllegalArgumentException("Campo vazio");
        }
        if(qtdRacao > qtdMaxRacao){
            throw new IllegalArgumentException("Quantidade de ração máxima diária excedida");
        }
        for (Dog d: doguinhos) {
            if(d != null && d.equals(nomePet, nomeDono)){
                throw new IllegalArgumentException("Cachorro já cadastrado");
            }
        }
        if(qtdMaxRacao >= 0 && numCachorros <= qtdMaxDogs){
            Dog novoDog = new Dog(nomePet, nomeDono, qtdRacao);
            doguinhos[numCachorros] = novoDog;
            numCachorros++;
            qtdMaxRacao -= qtdRacao;
            return true;
        }
        return false;
    }

    public boolean adicionaDog(String nomePet, String nomeDono, int qtdRacao, String restricao){
        if(nomePet == null || nomeDono == null){
            throw new NullPointerException("Campo nulo");
        }
        if(nomePet.isBlank() || nomeDono.isBlank()){
            throw new IllegalArgumentException("Campo vazio");
        }
        if(qtdRacao > qtdMaxRacao){
            throw new IllegalArgumentException("Quantidade de ração máxima diária excedida");
        }
        for (Dog d: doguinhos) {
            if(d != null && d.equals(nomePet, nomeDono)){
                throw new IllegalArgumentException("Cachorro já cadastrado");
            }
        }
        if(qtdMaxRacao >= 0 && numCachorros <= qtdMaxDogs) {
            Dog novoDog = new Dog(nomePet, nomeDono, qtdRacao, restricao);
            doguinhos[numCachorros] = novoDog;
            numCachorros++;
            qtdMaxRacao -= qtdRacao;
            return true;
        }
        return false;
    }

    public String listaDogs(){
        String dogsExistentes = nomeAnfitriao + ":\n";

        for(Dog d: doguinhos){
            if(d != null){
                dogsExistentes += d.toString();
            }
        }

        return dogsExistentes;
    }
    public int totalDiarioRacao(){
        for(Dog d: doguinhos){
            totalDiarioRacao += d.getQtdRacao();
        }
        return totalDiarioRacao;
    }

    public double consultaValorHospedagem(Dog doguinho, int dias){
        boolean cachorroAdicionado = buscaCachorro(doguinho);

        if(!cachorroAdicionado){
            throw new IllegalArgumentException("Cachorro não existe");
        }

        double valorHospedagem = (valorDia * doguinho.getQtdRacao()) * dias;
        return valorHospedagem;
    }

    public double totalDiarioValorHospedagens(){
        for(Dog d: doguinhos){
            if(d != null){
                totalDiarioValorHospedagens += d.getQtdRacao() * valorDia;
            }
        }
        return totalDiarioValorHospedagens;
    }

    private boolean buscaCachorro(Dog doguinho){
        boolean temDoguinho = false;
        for(Dog d: doguinhos){
            if(d != null && d.equals(doguinho.getNomePet(), doguinho.getNomeDono())){
                temDoguinho = true;
            }
        }
        return temDoguinho;
    }


}
