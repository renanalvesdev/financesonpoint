package br.com.renanlabs.mvc.financesonpoint.service;

import br.com.renanlabs.mvc.financesonpoint.exception.FinancesOnPointException;
import br.com.renanlabs.mvc.financesonpoint.model.Carteira;

public class DebitaCarteira implements OperacaoBasica{


	@Override
	public void efetua(Carteira carteira, Double valor) {
		
		//'valor' should be 'saldo'
		
		if(valor > carteira.getValor())
			throw new FinancesOnPointException("Operação impossíel, pois o valor do saque supera o saldo da carteira");
		
		carteira.setValor(carteira.getValor() - valor);
		
	}

}
