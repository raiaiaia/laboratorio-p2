import org.junit.jupiter.api.BeforeEach;
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
    void testaCodigoTimeNulo(){
        try{
            Aposta apostaTest1 = new Aposta(null, "CAMPINENSE", "RAPOSA", "Paraibano 2023", 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO CÓDIGO TIME É NULO", e.getMessage());
        }
    }
    @Test
    void testaNomeTimeNulo(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", null, "RAPOSA", "Paraibano 2023", 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME TIME É NULO", e.getMessage());
        }
    }
    @Test
    void testaMascoteNulo(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", null, "Paraibano 2023", 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO MASCOTE TIME É NULO", e.getMessage());
        }
    }
    @Test
    void testaNomeCampeonatoNulo(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "RAPOSA", null, 10, 1, 250);
        } catch (NullPointerException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME CAMPEONATO É NULO", e.getMessage());
        }
    }
    @Test
    void testaCodigoTimeVazio(){
        try{
            Aposta apostaTest1 = new Aposta("", "CAMPINENSE", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO CÓDIGO TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    void testaCodigoTimeEspaco(){
        try{
            Aposta apostaTest1 = new Aposta(" ", "CAMPINENSE", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO CÓDIGO TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    void testaNomeTimeVazio(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    void testaNomeTimeEspaco(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", " ", "RAPOSA","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    void testaMascoteVazio(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO MASCOTE TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    void testaMascoteEspaco(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", " ","Paraibano 2023" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO MASCOTE TIME ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    void testaNomeCampeonatoVazio(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "RAPOSA","" , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME CAMPEONATO ESTÁ VAZIO", e.getMessage());
        }
    }
    @Test
    void testaNomeCampeonatoEspaco(){
        try{
            Aposta apostaTest1 = new Aposta("250_PB", "CAMPINENSE", "RAPOSA"," " , 10, 1, 250);
        } catch (IllegalArgumentException e){
            assertEquals("APOSTA INVÁLIDA - CAMPO NOME CAMPEONATO ESTÁ VAZIO", e.getMessage());
        }
    }


    @Test
    void testaEqualsCompleto(){
        assert apostaTest.equals(apostaTest);
    }

    @Test
    void testaNotEquals(){
        Aposta a1 = new Aposta("260_PB", "CAMPINENSE", "RAPOSA", "Paraibano 2023", 10, 1, 250);
        assert !apostaTest.equals(a1);
    }

    @Test
    void testaEqualsObjetosDiferentes(){
        String compara = "Campeonato Paraibano 23";
        assert !apostaTest.equals(compara);
    }

    @Test
    void testaToString(){
        assertEquals("""
                [250_PB] CAMPINENSE / RAPOSA
                Paraibano 2023
                1/10
                R$ 250,00""", apostaTest.toString());
    }
}
