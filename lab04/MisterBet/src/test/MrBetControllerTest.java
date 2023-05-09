import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class MrBetControllerTest {

    MisterBetController mrBetTest;
    private Time timeTeste1;
    private Time timeTeste2;
    private Time timeTeste3;
    private Time timeTeste4;

    @BeforeEach
    void setup(){
        this.mrBetTest = new MisterBetController();
        this.timeTeste1 = new Time("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        this.timeTeste2 = new Time("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        this.timeTeste3 = new Time("002_RJ","CLUBE REGATAS DO FLAMENGO","URUBU");
        this.timeTeste4 = new Time("105_PB","SOCIEDADE RECREATIVA DE MONTEIRO (SOCREMO)","GAVIÃO");
        mrBetTest.adicionaCampeonato("Paraibano 2023", 10);
    }

    @Test
    @DisplayName("Cadastra campeonato com sucesso")
    void cadastraCampeonatoSemRestricao(){
        assertEquals("CAMPEONATO ADICIONADO!", mrBetTest.adicionaCampeonato("Brasileirão Série A", 10));
    }
    @Test
    @DisplayName("Cadastra campeonato já existente")
    void cadastraCampeonatoNomeExistente(){
        assertEquals("CAMPEONATO JÁ EXISTE!", mrBetTest.adicionaCampeonato("Paraibano 2023", 10));
    }

    @Test
    @DisplayName("Inclui time em campeonato com sucesso")
    void incluiTimeCampeonato(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        mrBetTest.adicionaCampeonato("Brasileirão Série A", 10);

        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.incluiTime("Brasileirão Série A", "250_PB"));
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.incluiTime("Brasileirão Série A", "252_PB"));
    }

    @Test
    @DisplayName("Inclui time que já está em um campeonato")
    void incluiTimeCampeonatoNovamente(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        mrBetTest.adicionaCampeonato("Brasileirão Série A", 10);

        mrBetTest.incluiTime("Brasileirão Série A", "250_PB");
        mrBetTest.incluiTime("Brasileirão Série A", "252_PB");

        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.incluiTime("Brasileirão Série A", "250_PB"));
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", mrBetTest.incluiTime("Brasileirão Série A", "252_PB"));
    }

    @Test
    @DisplayName("Inclui time campeonato inexistente")
    void incluiTimeCampeonatoInexistente(){
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        assertEquals("CAMPEONATO NÃO EXISTE!", mrBetTest.incluiTime("Brasileirão Série A", "250_PB"));
    }
}
