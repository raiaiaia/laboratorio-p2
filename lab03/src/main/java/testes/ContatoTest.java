import agenda.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ContatoTest {
    private Contato contatoTeste;

    @BeforeEach
    void setUp() {
        this.contatoTeste = new Contato(1,"Matheus", "Gaudencio", "(83) 99999-0000");

    }

    @Test
    void testeNomeCompleto(){
        assertEquals("Matheus Gaudencio", this.contatoTeste.nomeCompleto());
    }

    @Test
    void toStringClasse(){
        assertEquals("Matheus Gaudencio\n(83) 99999-0000", contatoTeste.toString());
    }
    @Test
    void telefoneVazio(){

        try{
            Contato contatoMatheus = new Contato(1, "Matheus", "Gaudencio", "");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (IllegalArgumentException e){
            assertEquals("CONTATO INVÁLIDO - CAMPO TELEFONE VAZIO", e.getMessage());
        }
    }
    @Test
    void nomeVazio(){

        try{
            Contato contatoMatheus = new Contato(1, "", "Gaudencio", "(83) 99999-0000");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (IllegalArgumentException e){
            assertEquals("CONTATO INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }
    @Test
    void nomeEspaços(){

        try{
            Contato contatoMatheus = new Contato(1, "  ", "Gaudencio", "(83) 99999-0000");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (IllegalArgumentException e){
            assertEquals("CONTATO INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }

    @Test
    void nomeNulo(){
        try{
            Contato contatoMatheus = new Contato(1, null, "Gaudencio", "(83) 99999-0000");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (NullPointerException e){
            assertEquals("CONTATO INVÁLIDO - NOME NULO", e.getMessage());
        }
    }
    @Test
    void telefoneNulo(){
        try{
            Contato contatoMatheus = new Contato(1, "Matheus", "Gaudencio", null);
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (NullPointerException e){
            assertEquals("CONTATO INVÁLIDO - TELEFONE NULO", e.getMessage());
        }
    }

    @Test
    void testaEquals() {
        String nome = "matheus";
        String sobrenome = "gaudencio";
        assert contatoTeste.equals(nome, sobrenome);
    }

    @Test
    void testaEqualsDiferentes(){
        Contato contatoDiferente = new Contato(2, "Rayanne", "Macedo", "(83) 98877-1234");
        assert !(contatoTeste.equals(contatoDiferente.getNome(), contatoDiferente.getSobrenome()));
    }

    @Test
    void testaEqualsNulo(){
        try {
            assert contatoTeste.equals(null, null);
        } catch (NullPointerException e){
            assertEquals("CAMPOS NOME OU SOBRENOME == NULL", e.getMessage());
        }
    }

    @Test
    void testaEqualsNome(){
        String nome = "matheus";
        assert contatoTeste.equalsNome(nome);
    }

    @Test
    void testaEqualsNomeDiferente(){
        String nome = "rayanne";
        assert !(contatoTeste.equalsNome(nome));
    }
    @Test
    void testaEqualsNomeNulo() {
        try {
            assert contatoTeste.equalsNome(null);
        } catch (NullPointerException e) {
            assertEquals("NOME INVÁLIDO - CAMPO NOME NULO", e.getMessage());
        }
    }

    @Test
    void testaEqualsNomeVazio() {
        try {
            assert contatoTeste.equalsNome("");
        } catch (IllegalArgumentException e) {
            assertEquals("NOME INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }

    @Test
    void testaEqualsNomeEspaco() {
        try {
            assert contatoTeste.equalsNome(" ");
        } catch (IllegalArgumentException e) {
            assertEquals("NOME INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }

}