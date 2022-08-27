package br.com.renanlabs.mvc.financesonpoint.exception;

public class NaoPodeAtualizarDespesaExistenteException extends FinancesOnPointException{

	public NaoPodeAtualizarDespesaExistenteException() {
		super("Não é possivel atualizar uma despesa já existente. Tente excluir e recadastrar os dados");
		// TODO Auto-generated constructor stub
	}

}
