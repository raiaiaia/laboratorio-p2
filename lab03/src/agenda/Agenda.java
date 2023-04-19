package agenda;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	private Contato[] contatos;
	private Contato[] favoritos;
	int numContatos = 0;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];

		for(int i=0; i<contatos.length; i++){
			contatos[i] = new Contato();
		}

		for(int i=0; i<favoritos.length; i++){
			favoritos[i] = new Contato();
		}
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
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) throws IllegalArgumentException{

		if(posicao < 1 || posicao > 100){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if(nome.isBlank() || telefone.isBlank()) {
			throw new IllegalArgumentException("CONTATO INVÁLIDO");
		}
		for(Contato c: getContatos()){
			if(c.getNome().toLowerCase().equals(nome) && c.getSobrenome().toLowerCase().equals(sobrenome)){
				throw new IllegalArgumentException("CONTATO JÁ CADASTRADO");
			}
		}

		contatos[posicao].setNome(nome);
		contatos[posicao].setSobrenome(sobrenome);
		contatos[posicao].setNumero(telefone);
		numContatos++;
	}

	public String adicionaFavorito(int contatoPosicao, int posicaoFavorito)throws IllegalArgumentException{

		if(posicaoFavorito < 1 || posicaoFavorito > 10){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if(favoritado(contatoPosicao)){
			throw new IllegalArgumentException("CONTATO JÁ É FAVORITO");
		}
		if( !(favoritado(contatoPosicao)) ){
			favoritos[posicaoFavorito] = contatos[contatoPosicao];
		}

		return "CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito;
	}

	public ArrayList<String> listaFavoritos(){
		Contato[] favoritos = getFavoritos();
		ArrayList<String> favoritosExistentes = new ArrayList<>();
		for(int i=0; i < favoritos.length; i++){
			if( !(favoritos[i].getNome().isBlank()) ){
				favoritosExistentes.add(formataFavorito("❤", favoritos[i].getNome(), favoritos[i].getSobrenome(), favoritos[i].getNumero()));
			}
		}
		return favoritosExistentes;
	}

	public boolean favoritado(int posicao){
		for(int i=0; i < favoritos.length; i++){
			if( (favoritos[i].getNome()).equals(contatos[posicao].getNome()) ){
				return true;
			}
		}
		return false;
	}

	public String exibeContato(Contato contato, int posicao) throws IllegalArgumentException{

		if( favoritado(posicao) ){
			return formataFavorito("❤", contato.getNome(), contato.getSobrenome(), contato.getNumero());
		}

		if(contato.getNome().isBlank()){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		return formataContato(posicao, contato.getNome(), contato.getSobrenome(), contato.getNumero());
	}

	public ArrayList<String> listaContatos(){
		Contato[] contatos = getContatos();
		ArrayList<String> contatosExistentes = new ArrayList<>();

		for(int i = 0; i < contatos.length; i++) {
			if (!contatos[i].getNome().isBlank()) {
				contatosExistentes.add(formataContato(i, contatos[i].getNome(), contatos[i].getSobrenome(), contatos[i].getNumero()));
			}
		}
		return contatosExistentes;
	}

	public int getNumContatos(){
		return numContatos;
	}

	/**
	 * Formata um contato para impressão na interface.
	 *
	 * @param posicao A posição do contato (que é exibida)/
	 * @param
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String nome, String sobrenome, String numero) {
		return posicao + " - " + nome + " " + sobrenome + "\n" + numero;
	}

	private static String formataFavorito(String coracao, String nome, String sobrenome, String numero){
		return coracao + " " + nome + " " + sobrenome + "\n" + numero;
	}


}
