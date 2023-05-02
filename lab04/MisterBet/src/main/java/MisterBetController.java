import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MisterBetController {
    private HashSet<Campeonato> campeonatos;
    private HashMap<String, Time> times;
    public MisterBetController(){
        this.campeonatos = new HashSet<>();
        this.times = new HashMap<>();
    }
    public String cadastraTime(String codigo, String nome, String mascote){
        String saida = "";

        if(times.containsKey(codigo.toUpperCase())){
            return "TIME JÁ EXISTE!";
        } else {
            Time novoTime = new Time(codigo, nome, mascote);
            times.put(codigo.toUpperCase(), novoTime);
            saida = "INCLUSÃO REALIZADA!";
        }
        return saida;
    }

    public String recuperaTime(String codigo){

        if(times.get(codigo) == null) {
            return "TIME NÃO EXISTE!";
        }
        return this.times.get(codigo).toString();
    }

    public String adicionaCampeonato(String campeonato, int participantes){
        Campeonato novoCampeonato = new Campeonato(campeonato.toUpperCase(), participantes);

        if(campeonatos.contains(novoCampeonato)){
            return "CAMPEONATO JÁ EXISTE!";
        }
        campeonatos.add(novoCampeonato);
        return "CAMPEONATO ADIICIONADO!";
    }


}
