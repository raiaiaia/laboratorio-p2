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
	private String[] favoritos = new String[TAMANHO_FAVORITOS];
	int numContatos = 0;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		contatos = new Contato[TAMANHO_AGENDA];
		for(int i=0; i<contatos.length; i++){
			contatos[i] = new Contato();
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
	public void adicionaFavorito(int contatoPosicao, int posicaoFavorito)throws IllegalArgumentException{

		for(int i=0; i<favoritos.length; i++){
			if(favoritos[i] == null){
				favoritos[i] = " ";
			}
		}
		Contato contato = contatos[contatoPosicao];
		favoritos[posicaoFavorito] =  formataFavorito("❤", contato.getNome(), contato.getSobrenome(), contato.getNumero());
	}


	public String[] listaFavoritos(){
		return favoritos;
	}

	public void exibeContato(Contato contato) throws IllegalArgumentException{

		if(contato.getNome().isBlank()){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
	}

	public ArrayList<String> listaContatos(){
		Contato[] contatos = getContatos();
		ArrayList<String> contatosExistentes = new ArrayList<>();

		for(int i = 0; i < contatos.length; i++) {
			if (!contatos[i].getNome().isBlank()) {
				contatosExistentes.add(formataContato(i, contatos[i].getNome()));
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
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, String contato) {
		return posicao + " - " + contato;
	}

	private static String formataFavorito(String coracao, String nome, String sobrenome, String numero){
		return coracao + " " + nome + " " + sobrenome + "\n" + numero;
	}
}
