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
			return saida;}

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
		if(nome == null  || telefone == null) {
			throw new NullPointerException("CONTATO INVÁLIDO");
		}
		for(Contato c: getContatos()){
			if(c != null && c.equals(nome, sobrenome)){
				throw new IllegalCallerException("CONTATO JÁ CADASTRADO");
			}
		}
		Contato novoContato = new Contato(posicao, nome, sobrenome, telefone);
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
		if( !(favoritado(contatoPosicao)) ){
			favoritos[posicaoFavorito] = contatos[corrigePosicao];
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
		if(favoritos[posicaoFavorito] == null){
			throw new NullPointerException("POSIÇÃO INVALIDA");
		}
		favoritos[posicaoFavorito] = null;
	}

	/**
	 * Retorna a lista de contatos favoritos cadastrados.
	 * @return o Array de favoritos.
	 */
	public ArrayList<String> listaFavoritos(){
		Contato[] favoritos = getFavoritos();
		ArrayList<String> favoritosExistentes = new ArrayList<>();
		for(int i=0; i < favoritos.length; i++){
			if(favoritos[i] != null){
				favoritosExistentes.add(formataFavorito("❤", favoritos[i].getNome(), favoritos[i].getSobrenome(), favoritos[i].getNumero()));
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
	public String exibeContato(int posicao){
		Contato contato = getContato(posicao -1);

		if(contato == null){
			throw new NullPointerException("POSIÇÃO INVÁLIDA");
		}
		if(posicao < 1 || posicao > 100){
			throw new ArrayIndexOutOfBoundsException("POSIÇÃO INVÁLIDA");
		}

		if(contato != null && (favoritado(posicao))) {
			return formataFavorito("❤", contato.getNome(), contato.getSobrenome(), contato.getNumero());
		}

		return formataContato(posicao, contato.getNome(), contato.getSobrenome(), contato.getNumero());
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
				contatosExistentes.add(formataContato(i + 1, contatos[i].getNome(), contatos[i].getSobrenome(), contatos[i].getNumero()));
			}
		}
		return contatosExistentes;
	}

	/**
	 * Formata um contato para impressão na interface.
	 *
	 * @param posicao A posição do contato (que é exibida).
	 * @param nome O nome do contato a ser exibido.
	 * @param sobrenome O sobrenome do contato a ser exibido.
	 * @param numero O telefone do contato a ser exibido.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String nome, String sobrenome, String numero) {
		return posicao + " - " + nome + " " + sobrenome + "\n" + numero;
	}
	/**
	 * Formata um contato favoritado para impressão na interface.
	 *
	 * @param coracao O emoji de um coração, que indica que este contato é favoritado.
	 * @param nome O nome do contato a ser exibido.
	 * @param sobrenome O sobrenome do contato a ser exibido.
	 * @param numero O telefone do contato a ser exibido.
	 * @return A String formatada.
	 */
	private static String formataFavorito(String coracao, String nome, String sobrenome, String numero){
		return coracao + " " + nome + " " + sobrenome + "\n" + numero;
	}


}
