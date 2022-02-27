package br.com.renanlabs.mvc.financesonpoint.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraTransacaoRepository;


@Service
public class RealizaTransacaoDeposito implements RealizadorTransacao{
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private CarteiraTransacaoRepository carteiraTransacaoRepository;
	
	
	public RealizaTransacaoDeposito() {
		
	}

	@Override
	public void efetua(CarteiraTransacao carteiraTransacao) {
		
		Carteira carteira = carteiraTransacao.getCarteira();
		
		//doing debit in selected wallet
		CreditaCarteira creditaCarteira = new CreditaCarteira();
		creditaCarteira.efetua(carteira, carteiraTransacao.getValor());
		
		carteiraRepository.save(carteira);
		carteiraTransacaoRepository.save(carteiraTransacao);
		
	}

}
