package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	private static final int TAMANHO_AGENDA = 100;
	private Contato[] contatos;
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
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		contatos[posicao].setNome(nome);
		contatos[posicao].setSobrenome(sobrenome);
		contatos[posicao].setNumero(telefone);
		numContatos++;
	}

	public int getNumContatos(){
		return numContatos;
	}

}
