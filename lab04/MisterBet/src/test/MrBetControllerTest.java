import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    @DisplayName("Cadastra time com sucesso")
    void cadastraTimeInexistente(){
        assertEquals("INCLUSÃO REALIZADA!", mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO"));
    }

    @Test
    @DisplayName("Cadastra time existente")
    void cadastraTimeExistente(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        assertEquals("TIME JÁ EXISTE!", mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO"));
    }
    @Test
    @DisplayName("Verifica campeonatos time (to string)")
    void verificaTime(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.adicionaCampeonato("Brasileirão Série A", 10);

        mrBetTest.incluiTime("Brasileirão Série A", "250_PB");
        mrBetTest.incluiTime("Paraibano 2023", "250_PB");

        assertEquals("""
                Campeonatos do NACIONAL DE PATOS:
                * CAMPEONATO BRASILEIRÃO SÉRIE A - 1/10
                * CAMPEONATO PARAIBANO 2023 - 1/10
                """, mrBetTest.exibeCampeonatosTime("250_PB"));

    }

    @Test
    @DisplayName("Cadastra aposta com sucesso")
    void cadastraApostaSemRestricao(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.incluiTime("Paraibano 2023", "250_PB");

        assertEquals("APOSTA REGISTRADA!", mrBetTest.aposta("250_PB", "PARAIBANO 2023", 1, 250));
    }

    @Test
    @DisplayName("Cadastra aposta campeonato inexistente")
    void cadastraApostaCampeonatoInexistente(){
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");
        assertEquals("CAMPEONATO NÃO EXISTE!", mrBetTest.aposta("252_PB", "Brasileirão 2023", 1, 250));
    }

    @Test
    @DisplayName("Cadastra aposta time inexistente")
    void cadastraApostaTimeInexistente(){
        assertEquals("TIME NÃO EXISTE!", mrBetTest.aposta("250_PB", "PARAIBANO 2023", 1, 250));
    }

    @Test
    @DisplayName("Exibe Status de apostas")
    void testaStatusAposta(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");

        mrBetTest.incluiTime("Paraibano 2023", "252_PB");
        mrBetTest.incluiTime("Paraibano 2023", "250_PB");

        mrBetTest.aposta("250_PB", "PARAIBANO 2023", 1, 250);
        mrBetTest.aposta("252_PB", "PARAIBANO 2023", 2, 20);

        assertEquals("""
                Apostas:
                1. [250_PB] NACIONAL DE PATOS / CANÁRIO
                PARAIBANO 2023
                1/10
                R$ 250,00
                2. [252_PB] SPORT LAGOA SECA / CARNEIRO
                PARAIBANO 2023
                2/10
                R$ 20,00
                """, mrBetTest.statusApostas());
    }

    @Test
    @DisplayName("Exibe participação mais frequente")
    void participacaoMaisFrequente(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.adicionaCampeonato("Brasileirão Série A", 10);

        mrBetTest.incluiTime("Paraibano 2023", "250_PB");
        mrBetTest.incluiTime("Brasileirão Série A", "250_PB");

        assertEquals("""
                [250_PB] NACIONAL DE PATOS / CANÁRIO  - 2 campeonatos
                """, mrBetTest.participacaoMaisFrequente());
    }

    @Test
    @DisplayName("Exibe times que não participam de nenhum campeonato")
    void testaNaoParticipou(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        assertEquals("""
                [250_PB] NACIONAL DE PATOS / CANÁRIO
                """, mrBetTest.naoParticipouDeCampeonato());
    }

    @Test
    @DisplayName("Exibe popularidade em apostas")
    void testaPopularidade(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        mrBetTest.cadastraTime("252_PB", "SPORT LAGOA SECA", "CARNEIRO");

        mrBetTest.adicionaCampeonato("Brasileirão Série A", 10);
        mrBetTest.adicionaCampeonato("Paraibano 2023", 10);
        mrBetTest.adicionaCampeonato("Copinha 2023", 10);

        mrBetTest.incluiTime("Brasileirão Série A", "250_PB");
        mrBetTest.incluiTime("Paraibano 2023", "252_PB");
        mrBetTest.incluiTime("Copinha 2023", "252_PB");

        mrBetTest.aposta("250_PB", "BRASILEIRÃO SÉRIE A", 1, 250);
        mrBetTest.aposta("252_PB", "PARAIBANO 2023", 1, 20);
        mrBetTest.aposta("252_PB", "COPINHA 2023", 1, 20);
        assertEquals("""
                NACIONAL DE PATOS / 1
                SPORT LAGOA SECA / 2
                """, mrBetTest.popularidadeEmApostas());
    }
}
