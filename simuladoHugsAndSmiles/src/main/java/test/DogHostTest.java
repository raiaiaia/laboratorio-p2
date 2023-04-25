import HugsAndSmiles.Dog;
import HugsAndSmiles.DogHost;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DogHostTest {

    private DogHost dh1;
    private DogHost dh2;

    @BeforeEach
    void setUp() {
        this.dh1 = new DogHost("Olívia", 3, 500);
        dh1.adicionaDog("Julie", "André", 100);
        dh1.adicionaDog("Toto", "Maty", 100);
    }

    @Test
    void calculaValorHospedagemValida() {
        Dog d1 = new Dog("Julie", "André", 100);
        assertEquals(120.0, dh1.consultaValorHospedagem(d1, 3));
    }

    @Test
    void calculaValorHospedagemZeroDias() {
        Dog d1 = new Dog("Julie", "André", 100);
        assertEquals(0.0, dh1.consultaValorHospedagem(d1, 0));
    }

    @Test
    void calculaValorHospedagemCachorroInvalido() {
        Dog d1 = new Dog("Neca", "André", 100);
        try {
            dh1.consultaValorHospedagem(d1, 0);
            fail("Lança exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Cachorro não existe", e.getMessage());
        }

    }

    @Test
    void adicionarCachorroNulo(){
        try{
            dh1.adicionaDog(null, "André", 100);
        }catch (NullPointerException e){
            assertEquals("Campo nulo", e.getMessage());
        }
    }

    @Test
    void adicionarCachorroNulo2(){
        try{
            dh1.adicionaDog("Toto", null, 100);
        }catch (NullPointerException e){
            assertEquals("Campo nulo", e.getMessage());
        }
    }
    @Test
    void adicionarCachorroVazio(){
        try{
            dh1.adicionaDog("", "André", 100);
        }catch (IllegalArgumentException e){
            assertEquals("Campo vazio", e.getMessage());
        }
    }
    @Test
    void adicionarCachorroVazio2(){
        try{
            dh1.adicionaDog("Toto", "", 100);
        }catch (IllegalArgumentException e){
            assertEquals("Campo vazio", e.getMessage());
        }
    }
    @Test
    void adicionaQtdMaxRacaoExcedida(){
        this.dh2 = new DogHost("Drizia", 3, 400);
        dh2.adicionaDog("Stella", "Rayanne", 150, "obesa");
        dh2.adicionaDog("Carlota", "Rayanne", 100);

        try{
            dh2.adicionaDog("Leonora", "Rayanne", 100, "obeso");
        }catch (IllegalArgumentException e){
            assertEquals("Quantidade de ração máxima diária excedida", e.getMessage());
        }
    }


}