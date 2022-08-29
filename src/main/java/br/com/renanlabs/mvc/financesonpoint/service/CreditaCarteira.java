package br.com.renanlabs.mvc.financesonpoint.service;

import java.math.BigDecimal;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;

public class CreditaCarteira implements OperacaoBasica{


	@Override
	public void efetua(Carteira carteira, BigDecimal valor) {
		
		carteira.setValor(carteira.getValor().add(valor));
		
	}

}
