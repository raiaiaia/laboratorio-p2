import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeTest {
    private Time timeTeste;

    @BeforeEach
    void setup(){
        this.timeTeste = new Time("250_PB","CAMPINENSE","RAPOSA");
    }
    @Test
    void testaCodigoTimeNulo(){

        try{
            Time timeTeste1 = new Time(null,"CAMPINENSE","RAPOSA");
        }catch (NullPointerException e){
            assertEquals("TIME INVÁLIDO - CAMPO CÓDIGO TIME NULO", e.getMessage());
        }
    }
    @Test
    void testaNomeNulo(){
        try{
            Time timeTeste1 = new Time("250_PB",null,"RAPOSA");
        }catch (NullPointerException e){
            assertEquals("TIME INVÁLIDO - CAMPO NOME NULO", e.getMessage());
        }

    }
    @Test
    void testaMascoteNulo(){
        try{
            Time timeTeste1 = new Time("250_PB","CAMPINENSE",null);
        }catch (NullPointerException e){
            assertEquals("TIME INVÁLIDO - CAMPO MASCOTE NULO", e.getMessage());
        }

    }

    @Test
    void testaCodigoTimeVazio(){
        try{
            Time timeTeste1 = new Time("","CAMPINENSE","RAPOSA");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO CÓDIGO TIME VAZIO", e.getMessage());
        }

    }
    @Test
    void testaNomeVazio(){
        try{
            Time timeTeste1 = new Time("250_PB","","RAPOSA");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }

    }
    @Test
    void testaMascoteVazio(){

        try{
            Time timeTeste1 = new Time("250_PB","CAMPINENSE","");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO MASCOTE VAZIO", e.getMessage());
        }

    }
    @Test
    void testaCodigoTimeEspaco(){
        try{
            Time timeTeste1 = new Time(" ","CAMPINENSE","RAPOSA");
        } catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO CÓDIGO TIME VAZIO", e.getMessage());
        }
    }
    @Test
    void testaNomeEspaco(){
        try{
            Time timeTeste1 = new Time("250_PB"," ","RAPOSA");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }

    }
    @Test
    void testaMascoteEspaco(){
        try{
            Time timeTeste1 = new Time("250_PB","CAMPINENSE"," ");
        }catch (IllegalArgumentException e){
            assertEquals("TIME INVÁLIDO - CAMPO MASCOTE VAZIO", e.getMessage());
        }

    }

}
