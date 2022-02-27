package br.com.renanlabs.mvc.financesonpoint.service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;

public interface OperacaoBasica {

	public void efetua(Carteira carteira, Double valor);
	
}
