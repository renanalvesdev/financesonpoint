package br.com.renanlabs.mvc.financesonpoint.exception;

public class ValorDespesaMaiorQueBudgetException extends FinancesOnPointException{

	public ValorDespesaMaiorQueBudgetException() {
		super("O valor é maior do que o budget estabelecido para esse planejamento");
		// TODO Auto-generated constructor stub
	}

}
