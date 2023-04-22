import agenda.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {
    private Agenda agendaTeste;
    @BeforeEach
    void setUp() {
        agendaTeste = new Agenda();
        agendaTeste.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
        agendaTeste.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
        agendaTeste.cadastraContato(3, "Fabio", "Morais", "(83) 98790-1323");
    }
    @Test
    void cadastraPosicaoVazia() {
        int posicaoTeste = 1;
        int corrigePosicao = posicaoTeste - 1;

        assertEquals("Matheus Gaudencio\n(83) 99999-0000", agendaTeste.getContatos()[corrigePosicao].toString());
    }

    @Test
    void cadastraPosicaoExistente(){
        int posicaoTeste = 1;
        int corrigePosicao = posicaoTeste - 1;

        agendaTeste.cadastraContato(posicaoTeste, "Pedro", "Silva", "(84) 98888-1111");
        assertEquals("Pedro Silva\n(84) 98888-1111", agendaTeste.getContatos()[corrigePosicao].toString());
    }

    @Test
    void cadastraContatoExistente(){

        try{
            agendaTeste.cadastraContato(2, "Matheus", "Gaudencio", "(83) 99999-0000");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (IllegalCallerException e) {
            assertEquals("CONTATO JÁ CADASTRADO", e.getMessage());
        }
    }
    @Test
    void cadastraContatoLimite(){
        int posicaoTeste = 100;
        int corrigePosicao = posicaoTeste - 1;

        Agenda agendaMatheus = new Agenda();
        agendaMatheus.cadastraContato(posicaoTeste, "Matheus", "Gaudencio", "(83) 99999-0000");
        assertEquals("Matheus Gaudencio\n(83) 99999-0000", agendaMatheus.getContatos()[corrigePosicao].toString());
    }

    @Test
    void cadastraContatoAcimaLimite(){
        int posicaoTeste = 101;
        Agenda agendaMatheus = new Agenda();

        try{
            agendaMatheus.cadastraContato(posicaoTeste, "Matheus", "Gaudencio", "(83) 99999-0000");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (ArrayIndexOutOfBoundsException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }

    @Test
    void cadastraContatoAbaixoLimite(){
        int posicaoTeste = 0;
        Agenda agendaMatheus = new Agenda();

        try{
            agendaMatheus.cadastraContato(posicaoTeste, "Matheus", "Gaudencio", "(83) 99999-0000");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (ArrayIndexOutOfBoundsException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }

    @Test
    void cadastraNomeVazio(){
        int posicaoTeste = 1;
        Agenda agendaMatheus = new Agenda();

        try{
            agendaMatheus.cadastraContato(posicaoTeste, "", "Gaudencio", "(83) 99999-0000");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (IllegalArgumentException e){
            assertEquals("CONTATO INVÁLIDO - CAMPO NOME VAZIO", e.getMessage());
        }
    }

    @Test
    void cadastraTelefoneVazio(){
        int posicaoTeste = 1;
        Agenda agendaMatheus = new Agenda();

        try{
            agendaMatheus.cadastraContato(posicaoTeste, "Matheus", "Gaudencio", "");
            fail("A agenda não deve ter contato cadastrado com sucesso");
        } catch (IllegalArgumentException e){
            assertEquals("CONTATO INVÁLIDO - CAMPO TELEFONE VAZIO", e.getMessage());
        }
    }

    @Test
    void exibeContatoComTelefone() {
        int posicaoTeste = 1;
        int corrigePosicao = posicaoTeste - 1;

        assertEquals("Matheus Gaudencio\n(83) 99999-0000", agendaTeste.getContatos()[corrigePosicao].toString());
    }
    @Test
    void exibeContatoSemTelefone() {
        int posicaoTeste = 1;
        int corrigePosicao = posicaoTeste - 1;
        Contato contato = agendaTeste.getContato(corrigePosicao);
        String nome = contato.getNome().toString();
        String sobrenome = contato.getSobrenome().toString();

        assertEquals("Matheus Gaudencio", nome + " " + sobrenome);
    }
    @Test
    void exibeContatoPosicaoVazia(){
        int posicaoTeste = 20;  //não existe contato cadastrado nessa posicao

        try{
            agendaTeste.exibeContatoPosicao(posicaoTeste);
            fail("A agenda não tem contato cadastrado");
        }catch (NullPointerException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }
    @Test
    void exibeContatoLimiteInferior(){
        int posicaoTeste = 0;

        try{
            agendaTeste.exibeContatoPosicao(posicaoTeste);
            fail("Ao pegar a representação da agenda na posição 0, o sistema deve dar um erro (ou retornar nada)");
        } catch (ArrayIndexOutOfBoundsException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }

    @Test
    void exibeContatoLimiteSuperior(){
        int posicaoTeste = 101;

        try{
            agendaTeste.exibeContatoPosicao(posicaoTeste);
            fail("Ao pegar a representação da agenda na posição 101, o sistema deve dar um erro (ou retornar nada)");
        } catch (ArrayIndexOutOfBoundsException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }
    @Test
    void exibeContatoNomeNaoExistente(){
        String nome = "rayanne";
        try{
            agendaTeste.exibeContatoNome(nome);
            fail("Deve lançar erro de não existir contatos com esse nome");
        }catch (NullPointerException e){
            assertEquals("NÃO EXISTEM CONTATOS COM ESSE NOME", e.getMessage());
        }
    }

    @Test
    void exibeContatoFavoritado(){
        //adiciona Matheus Gaudencio na lista de favoritos, posicao 1
        agendaTeste.adicionaFavorito(1, 1);
        assertEquals("❤ Matheus Gaudencio\n" + "(83) 99999-0000", agendaTeste.exibeContatoPosicao(1));

    }

    @Test
    void adicionaFavoritoAbaixoLimte() {
        try{
            agendaTeste.adicionaFavorito(1, -1);
        }catch (ArrayIndexOutOfBoundsException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }
    @Test
    void adicionaFavoritoAcimaLimte() {
        try{
            agendaTeste.adicionaFavorito(1, 11);
        }catch (ArrayIndexOutOfBoundsException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }

    @Test
    void adicionaFavoritoLimite(){
        agendaTeste.adicionaFavorito(1, 10);
        assertEquals("Matheus Gaudencio\n" + "(83) 99999-0000", agendaTeste.getFavorito(10).toString(), "O contato deve exibir um coração indicando que ele é favorito");
    }
    @Test
    void adicionaFavoritoPosicaoExistente(){
        agendaTeste.adicionaFavorito(1,1);
        agendaTeste.adicionaFavorito(2,1);
        assertEquals("Livia Sampaio\n" + "(83) 99873-7383", agendaTeste.getFavorito(1).toString());
        assertEquals("1" + "-" + "Matheus Gaudencio\n" + "(83) 99999-0000", agendaTeste.exibeContatoPosicao(1).toString(), "O contato antigo deve deixar de ser favorito");

    }
    @Test
    void removeFavorito() {
        agendaTeste.adicionaFavorito(1,1);
        agendaTeste.removeFavorito(1);
        assertEquals("1" + "-" + "Matheus Gaudencio\n" + "(83) 99999-0000", agendaTeste.exibeContatoPosicao(1).toString(), "O contato deve deixar de ser favorito");
    }

    @Test
    void alteraTelefonePosicaoInvalida() {
        try {
            agendaTeste.alteraTelefone(-1, "(83) 4002-8922");
        } catch (ArrayIndexOutOfBoundsException e){
            assertEquals("POSIÇÃO INVÁLIDA", e.getMessage());
        }
    }

    @Test
    void alteraTelefoneNumeroNulo(){
        try{
            agendaTeste.alteraTelefone(1, null);
        } catch (NullPointerException e){
            assertEquals("NÚMERO INVÁLIDO - CAMPO TELEFONE NULO", e.getMessage());
        }
    }

    @Test
    void alteraTelefoneVazio(){
        try{
            agendaTeste.alteraTelefone(1, "");
        }catch (IllegalArgumentException e){
            assertEquals("NÚMERO INVÁLIDO - CAMPO TELEFONE VAZIO", e.getMessage());
        }
    }
    @Test
    void alteraTelefoneEspaco(){
        try{
            agendaTeste.alteraTelefone(1, "  ");
        }catch (IllegalArgumentException e){
            assertEquals("NÚMERO INVÁLIDO - CAMPO TELEFONE VAZIO", e.getMessage());
        }
    }

    @Test
    void testaListaFavoritos() {
        agendaTeste.adicionaFavorito(1,1); //Matheus Gaudencio
        agendaTeste.adicionaFavorito(2, 9); //Livia Sampaio
        agendaTeste.adicionaFavorito(3, 5); //Fabio Morais
        String[] saidasEsperadas = new String[3];
        saidasEsperadas[0] = "❤ Matheus Gaudencio\n(83) 99999-0000";
        saidasEsperadas[1] = "❤ Fabio Morais\n(83) 98790-1323";
        saidasEsperadas[2] = "❤ Livia Sampaio\n(83) 99873-7383";
        assertEquals(Arrays.toString(saidasEsperadas), agendaTeste.listaFavoritos().toString());
    }

    @Test
    void testaListaContatos() {
        String[] saidasEsperadas = new String[3];
        saidasEsperadas[0] = "1 - Matheus Gaudencio\n(83) 99999-0000";
        saidasEsperadas[1] = "2 - Livia Sampaio\n(83) 99873-7383";
        saidasEsperadas[2] = "3 - Fabio Morais\n(83) 98790-1323";
        assertEquals(Arrays.toString(saidasEsperadas), agendaTeste.listaContatos().toString());
    }

    @Test
    void favoritado() {
        agendaTeste.adicionaFavorito(1,1);
        assertEquals(true, agendaTeste.favoritado(1), "O contato foi adicionado aos favoritos e deve retornar true.");
    }
    @Test
    void formataContatos(){
        int posicao = 1;
        int posicaoCorrigida = posicao - 1;
        Contato contato = agendaTeste.getContato(posicaoCorrigida);
        assertEquals("Matheus Gaudencio\n(83) 99999-0000", contato.toString());
    }

}