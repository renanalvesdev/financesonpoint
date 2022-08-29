package br.com.renanlabs.mvc.financesonpoint.service;

import java.math.BigDecimal;

import br.com.renanlabs.mvc.financesonpoint.exception.FinancesOnPointException;
import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.util.MonetaryUtil;

public class DebitaCarteira implements OperacaoBasica{


	@Override
	public void efetua(Carteira carteira, BigDecimal valor) {
		
		//'valor' should be 'saldo'
		
		if(valor.compareTo(carteira.getSaldo()) > 0)
			throw new FinancesOnPointException("Operação impossíel, pois o valor do saque supera o saldo da carteira");
		
		carteira.setValor(carteira.getSaldo());
		
	}

}
