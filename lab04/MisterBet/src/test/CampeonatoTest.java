import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CampeonatoTest {

    private Campeonato campeonatoTest;
    private Time timeTest1;
    private Time timeTest2;
    private Time timeTest3;

    @BeforeEach
    void setup() {
        this.campeonatoTest = new Campeonato("Brasileirão Série A 2023", 10);
        this.timeTest1 = new Time("250_PB", "CAMPINENSE", "RAPOSA");
        this.timeTest2 = new Time("260_PB", "TREZE", "GALO");
        this.timeTest3 = new Time("270_PB", "SPORT LAGOA SECA", "CANÁRIO");
    }

    @Test
    @DisplayName("Campeonato com nome nulo")
    void testaNomeNulo() {
        try {
            Campeonato campeonato1 = new Campeonato(null, 10);
        } catch (NullPointerException e) {
            assertEquals("CAMPEONATO INVÁLIDO - CAMPO NOME NULO", e.getMessage());
        }

    }

    @Test
    @DisplayName("Campeonato com nome vazio")
    void testaNomeVazio() {
        try {
            Campeonato campeonato1 = new Campeonato("", 10);
        } catch (IllegalArgumentException e) {
            assertEquals("CAMPEONATO INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }

    @Test
    @DisplayName("Campeonato com nome vazio (espaço)")
    void testaNomeEspaco() {
        try {
            Campeonato campeonato1 = new Campeonato(" ", 10);
        } catch (IllegalArgumentException e) {
            assertEquals("CAMPEONATO INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }

    @Test
    @DisplayName("Campeonato com número de participantes inválido (nulo)")
    void testaNumeroParticipantesNulo() {
        try {
            Campeonato campeonato1 = new Campeonato("Campeonato Paraibano 23", 0);
        } catch (IllegalArgumentException e) {
            assertEquals("QUANTIDADE DE PARTICIPANTES INVÁLIDA", e.getMessage());
        }
    }

    @Test
    @DisplayName("Campeonato com número de participantes inválido (negativo)")
    void testaNumeroParticipantesNegativo() {
        try {
            Campeonato campeonato1 = new Campeonato("Campeonato Paraibano 23", -2);
        } catch (IllegalArgumentException e) {
            assertEquals("QUANTIDADE DE PARTICIPANTES INVÁLIDA", e.getMessage());
        }
    }

    @Test
    @DisplayName("Adiciona time excedendo o limite da quantidade de participantes")
    void testaAdicionaTimeExcedeParticipantes() {
        Campeonato c1 = new Campeonato("Campeonato Paraibano 23", 3);
        Time timeTest4 = new Time("290_PB", "SPORT BARAÚNA", "TATU");

        c1.adicionaTime(c1, timeTest1);
        c1.adicionaTime(c1, timeTest2);
        c1.adicionaTime(c1, timeTest3);
        assertEquals("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS", c1.adicionaTime(c1, timeTest4));

    }

    @Test
    @DisplayName("Adiciona time no limite da quantidade de participantes")
    void testaAdicionaTimeLimiteParticipantes() {
        Campeonato c1 = new Campeonato("Campeonato Paraibano 23", 3);
        Time timeTest4 = new Time("290_PB", "SPORT BARAÚNA", "TATU");

        c1.adicionaTime(c1, timeTest1);
        c1.adicionaTime(c1, timeTest2);
        assertEquals("TIME INCLUÍDO NO CAMPEONATO!", c1.adicionaTime(c1, timeTest4));

    }

    @Test
    @DisplayName("Verifica time adicionado no campeonato")
    void verificaTimeAdicionado(){
        campeonatoTest.adicionaTime(campeonatoTest, timeTest1);
        assertEquals("O TIME ESTÁ NO CAMPEONATO!", campeonatoTest.verificaTime(timeTest1));
    }

    @Test
    @DisplayName("Verifica time que não está adicionado no campeonato")
    void verificaTimeNaoAdicionado(){
        assertEquals("O TIME NÃO ESTÁ NO CAMPEONATO!", campeonatoTest.verificaTime(timeTest1));
    }

    @Test
    @DisplayName("Testa equals")
    void testaEqualsCompleto(){
        assert campeonatoTest.equals(campeonatoTest);
    }

    @Test
    @DisplayName("Testa not equals")
    void testaNotEquals(){
        Campeonato c1 = new Campeonato("Campeonato Paraibano 23", 3);
        assert !campeonatoTest.equals(c1);
    }

    @Test
    @DisplayName("Testa equals objetos diferentes")
    void testaEqualsObjetosDiferentes(){
        String compara = "Campeonato Paraibano 23";
        assert !campeonatoTest.equals(compara);
    }

    @Test
    @DisplayName("Testa toString de campeonato")
    void testaToString(){
        assertEquals("* CAMPEONATO Brasileirão Série A 2023 - 0/10",campeonatoTest.toString());
    }

}

