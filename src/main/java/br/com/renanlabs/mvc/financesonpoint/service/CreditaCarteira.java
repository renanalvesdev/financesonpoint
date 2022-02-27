package br.com.renanlabs.mvc.financesonpoint.service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;

public class CreditaCarteira implements OperacaoBasica{


	@Override
	public void efetua(Carteira carteira, Double valor) {
		
		carteira.setValor(carteira.getValor() + valor);
		
	}

}
