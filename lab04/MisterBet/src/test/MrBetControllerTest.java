import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MrBetControllerTest {

    MisterBetController mrBetTest;
    private Time timeTeste1;
    private Time timeTeste2;
    private Time timeTeste3;
    private Time timeTeste4;
    private Campeonato campeonatoTeste;

    @BeforeEach
    void setup(){
        this.mrBetTest = new MisterBetController();
        this.timeTeste1 = new Time("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        this.timeTeste2 = new Time("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        this.timeTeste3 = new Time("002_RJ","CLUBE REGATAS DO FLAMENGO","URUBU");
        this.timeTeste4 = new Time("105_PB","SOCIEDADE RECREATIVA DE MONTEIRO (SOCREMO)","GAVIÃO");
    }

    @Test
    void adicionaTime(){}
}
