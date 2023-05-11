import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApostaTest {

    private Aposta apostaTest;
    private Campeonato campeonatoTest;
    private Time timeTest;

    @BeforeEach
    void setup(){
        this.apostaTest = new Aposta("250_PB", "CAMPINENSE", "RAPOSA", "Paraibano 2023", 10, 1, 250);
        this.campeonatoTest = new Campeonato("Paraibano 2023", 10);
        this.timeTest = new Time("250_PB", "CAMPINENSE", "RAPOSA");

    }

    @Test
    @DisplayName("Codigo time nulo")
    void testaCodigoTimeNulo(){
        try{
            Aposta apostaTest1 = new Aposta(null, "CAMPINENSE", "RAPOSA", "Paraibano 2023", 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO CÓDIGO TIME É NULO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Nome time nulo")
    void testaNomeTimeNulo(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", null, "RAPOSA", "Paraibano 2023", 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME TIME É NULO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Mascote time nulo")
    void testaMascoteNulo(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", null, "Paraibano 2023", 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO MASCOTE TIME É NULO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Nome campeonato nulo")
    void testaNomeCampeonatoNulo(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "RAPOSA", null, 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME CAMPEONATO É NULO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Código time vazio")
    void testaCodigoTimeVazio(){
        try{
            Aposta apostaTest1 = new Aposta("", "CAMPINENSE", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO CÓDIGO TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Código time vazio (espaço)")
    void testaCodigoTimeEspaco(){
        try{
            Aposta apostaTest1 = new Aposta(" ", "CAMPINENSE", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO CÓDIGO TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Nome time vazio")
    void testaNomeTimeVazio(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Nome time vazio (espaço)")
    void testaNomeTimeEspaco(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", " ", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Mascote time vazio")
    void testaMascoteVazio(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO MASCOTE TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Mascote time vazio (espaço)")
    void testaMascoteEspaco(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", " ","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO MASCOTE TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Campeonato time vazio")
    void testaNomeCampeonatoVazio(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "RAPOSA","" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME CAMPEONATO ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    @DisplayName("Campeonato time vazio (espaço)")
    void testaNomeCampeonatoEspaco(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "RAPOSA"," " , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME CAMPEONATO ESTÁ VAZIO", e.getMessage());
        }
    }

    @Test
    @DisplayName("Testa equals")
    void testaEqualsCompleto(){
        assert apostaTest.equals(apostaTest);
    }

    @Test
    @DisplayName("Testa not equals")
    void testaNotEquals(){
        Aposta a1 = new Aposta("260_PB", "CAMPINENSE", "RAPOSA", "Paraibano 2023", 10, 1, 250);
        assert !apostaTest.equals(a1);
    }

    @Test
    @DisplayName("Testa equals objetos diferentes")
    void testaEqualsObjetosDiferentes(){
        String compara = "Campeonato Paraibano 23";
        assert !apostaTest.equals(compara);
    }

    @Test
    @DisplayName("Testa toString de aposta")
    void testaToString(){
        assertEquals("""
                [250_PB] CAMPINENSE / RAPOSA
                Paraibano 2023
                1/10
                R$ 250,00""", apostaTest.toString());
    }
}
