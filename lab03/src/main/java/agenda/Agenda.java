package agenda;

import java.util.ArrayList;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author Nazareno Andrade
 * @author Danielly Rayanne Macedo Lima
 *
 */
public class Agenda {
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];

	}

	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		Contato[] saida = new Contato[TAMANHO_AGENDA];

		for(int i=0; i< saida.length; i++){
			saida[i] = contatos[i];
		}
		return saida;
	}
	/**
	 * Acessa a lista de favoritos mantida.
	 * @return O array de favoritos.
	 */
	public Contato[] getFavoritos() {
		Contato[] saida = new Contato[TAMANHO_FAVORITOS];

		for(int i=0; i < saida.length; i++){
			saida[i] = favoritos[i];
		}
			return saida;
	}

	public Contato getFavorito(int posicao){
		return favoritos[posicao-1];
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior.
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone){

		if(posicao < 1 || posicao > 100){
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}

		for(Contato c: getContatos()){
			if(c != null && c.equals(nome, sobrenome)){
				throw new IllegalCallerException("CONTATO JÁ CADASTRADO");
			}
		}

		Contato novoContato = new Contato(posicao, nome, sobrenome, telefone);

		if(nome.isBlank() || telefone.isBlank()){
			throw new IllegalArgumentException("CONTATO INVÁLIDO - CAMPO TELEFONE VAZIO");
		}

		int corrigePosicao = posicao -1;
		this.contatos[corrigePosicao] = novoContato;
	}

	/**
	 * Adiciona um contato aos favoritos em uma posição.
	 * @param contatoPosicao Posição do contato para saber qual contato adicionar na lista de favoritos.
	 * @param posicaoFavorito Posição na lista de favoritos para adicionar o contato favoritado.
	 * @return
	 */
	public String adicionaFavorito(int contatoPosicao, int posicaoFavorito){
		int corrigePosicao = contatoPosicao - 1;

		if(posicaoFavorito < 1 || posicaoFavorito > 10){
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		if(contatos[corrigePosicao] ==  null){
			throw new NullPointerException("POSIÇÃO INVÁLIDA");
		}
		if(favoritado(contatoPosicao)){
			throw new IllegalCallerException("\nCONTATO JÁ É FAVORITO");
		}
		if(favoritos[posicaoFavorito-1] == null && !(favoritado(contatoPosicao)) ){
			favoritos[posicaoFavorito - 1] = contatos[corrigePosicao];
		}
		if(favoritos[posicaoFavorito - 1] != null && !(favoritado(contatoPosicao)) ){
			removeFavorito(posicaoFavorito);
			favoritos[posicaoFavorito - 1] = contatos[corrigePosicao];
		}
		return "CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito;
	}

	/**
	 * Remove um favorito adicionado.
	 * @param posicaoFavorito Posição do favorito para remover.
	 */
	public void removeFavorito(int posicaoFavorito){

		if(posicaoFavorito < 1 || posicaoFavorito > 10){
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		if(favoritos[posicaoFavorito - 1] == null){
			throw new NullPointerException("POSIÇÃO INVALIDA");
		}
		favoritos[posicaoFavorito - 1] = null;
	}

	public void alteraTelefone(int posicaoContato, String novoNumero){
		int posicaoCorrigida = posicaoContato - 1;

		if(posicaoContato < 1 || posicaoContato > 100){
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}
		if(novoNumero == null){
			throw new NullPointerException("NÚMERO INVÁLIDO - CAMPO TELEFONE NULO");
		}
		if(novoNumero.isBlank()){
			throw new IllegalArgumentException("NÚMERO INVÁLIDO - CAMPO TELEFONE VAZIO");
		}

		contatos[posicaoCorrigida].setNumero(novoNumero);

	}

	/**
	 * Retorna a lista de contatos favoritos cadastrados.
	 * @return o Array de favoritos.
	 */
	public ArrayList<String> listaFavoritos(){
		Contato[] favoritos = getFavoritos();
		ArrayList<String> favoritosExistentes = new ArrayList<>();
		for(Contato f: favoritos){
			if(f!= null){
				favoritosExistentes.add("❤" + " " + f.toString());
			}
		}
		return favoritosExistentes;
	}

	/**
	 * Verifica se um contato é ou não favorito.
	 * @param posicao Posição do contato.
	 * @return verdadeiro ou falso.
	 */
	public boolean favoritado(int posicao){
		Contato contato = getContato(posicao-1);
		Contato[] favoritos = getFavoritos();
		for(Contato f: favoritos){
			if(f != null && f.equals(contato.getNome(), contato.getSobrenome())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Exibe um contato por meio de sua posição.
	 * @param posicao Posição do contato a ser exibido.
	 * @return uma String com nome, sobrenome e telefone. Além de se esse contato é favorito ou não.
	 */
	public String exibeContatoPosicao(int posicao){
		int corrigePosicao = posicao - 1;

		if(posicao < 1 || posicao > 100){
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}

		Contato contato = getContato(corrigePosicao);
		if(contato == null){
			throw new NullPointerException("POSIÇÃO INVÁLIDA");
		}
		if(contato != null && (favoritado(posicao))) {
			return "❤" + " " + contato;
		}

		return posicao + "-" + contato;
	}

	public ArrayList<String> exibeContatoNome(String nome){
		Contato[] contatos = getContatos();
		ArrayList<String> nomesIguais = new ArrayList<>();

		for(Contato c: contatos){
			if(c != null && c.equalsNome(nome)){
				nomesIguais.add(c.toString());
			}
		}

		if(nomesIguais.size() == 0){
			throw new NullPointerException("NÃO EXISTEM CONTATOS COM ESSE NOME");
		}

		return nomesIguais;
	}

	/**
	 * Retorna a lista de contatos da Agenda.
	 * @return Array de contatos.
	 */
	public ArrayList<String> listaContatos(){
		Contato[] contatos = getContatos();
		ArrayList<String> contatosExistentes = new ArrayList<>();

		for(int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				contatosExistentes.add(formataContato(i + 1, contatos[i]));
			}
		}
		return contatosExistentes;
	}

	/**
	 * Formata um contato para impressão na interface.
	 *
	 * @param posicao A posição do contato (que é exibida).
	 * @param contato O contato que será exibido.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + " - " + contato.toString();
	}
}
