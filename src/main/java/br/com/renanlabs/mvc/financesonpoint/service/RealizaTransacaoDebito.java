package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraTransacaoRepository;


@Service
public class RealizaTransacaoDebito implements RealizadorTransacao{

	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	
	@Autowired
	private CarteiraTransacaoRepository carteiraTransacaoRepository;
	
	public RealizaTransacaoDebito() {
		
	}
	
	@Override
	public void efetua(CarteiraTransacao transacao) {
		
		//doing debit in selected wallet
		Carteira carteira = transacao.getCarteira();
		carteira.setValor(carteira.getValor() - transacao.getValor());

		carteiraRepository.save(carteira);
		carteiraTransacaoRepository.save(transacao);
		
	}
	
	
	
	

}
