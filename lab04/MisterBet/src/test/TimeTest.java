import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeTest {
    private Time timeTeste;
    private MisterBetController mrBetTest;

    @BeforeEach
    void setup(){
        this.mrBetTest = new MisterBetController();
        this.timeTeste = new Time("250_PB","CAMPINENSE","RAPOSA");
    }

    @Test
    @DisplayName("Código time nulo")
    void testaCodigoTimeNulo(){

        try{
            Time timeTeste1 = new Time(null,"CAMPINENSE","RAPOSA");
        }catch (NullPointerException e){
            assertEquals("TIME INVÁLIDO - CAMPO CÓDIGO TIME NULO", e.getMessage());
        }
    }

    @Test
    @DisplayName("Nome time nulo")
    void testaNomeNulo(){
        try{
            Time timeTeste1 = new Time("250_PB",null,"RAPOSA");
        }catch (NullPointerException e){
            assertEquals("TIME INVÁLIDO - CAMPO NOME NULO", e.getMessage());
        }

    }

    @Test
    @DisplayName("Mascote time nulo")
    void testaMascoteNulo(){
        try{
            Time timeTeste1 = new Time("250_PB","CAMPINENSE",null);
        }catch (NullPointerException e){
            assertEquals("TIME INVÁLIDO - CAMPO MASCOTE NULO", e.getMessage());
        }

    }

    @Test
    @DisplayName("Código time vazio")
    void testaCodigoTimeVazio(){
        try{
            Time timeTeste1 = new Time("","CAMPINENSE","RAPOSA");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO CÓDIGO TIME VAZIO", e.getMessage());
        }

    }

    @Test
    @DisplayName("Nome time vazio")
    void testaNomeVazio(){
        try{
            Time timeTeste1 = new Time("250_PB","","RAPOSA");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }

    @Test
    @DisplayName("Mascote time vazio")
    void testaMascoteVazio(){
        try{
            Time timeTeste1 = new Time("250_PB","CAMPINENSE","");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO MASCOTE VAZIO", e.getMessage());
        }
    }

    @Test
    @DisplayName("Código time vazio (espaço)")
    void testaCodigoTimeEspaco(){
        try{
            Time timeTeste1 = new Time(" ","CAMPINENSE","RAPOSA");
        } catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO CÓDIGO TIME VAZIO", e.getMessage());
        }
    }

    @Test
    @DisplayName("Nome time vazio (espaço)")
    void testaNomeEspaco(){
        try{
            Time timeTeste1 = new Time("250_PB"," ","RAPOSA");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }

    }

    @Test
    @DisplayName("Mascote time vazio (espaço)")
    void testaMascoteEspaco(){
        try{
            Time timeTeste1 = new Time("250_PB","CAMPINENSE"," ");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO MASCOTE VAZIO", e.getMessage());
        }

    }

    @Test
    @DisplayName("Representação gráfica de time")
    void testaToString(){
        mrBetTest.cadastraTime("250_PB", "NACIONAL DE PATOS", "CANÁRIO");
        //recuperaTime retorna toString
        assertEquals("[250_PB] NACIONAL DE PATOS / CANÁRIO", mrBetTest.recuperaTime("250_PB"));
    }

}
