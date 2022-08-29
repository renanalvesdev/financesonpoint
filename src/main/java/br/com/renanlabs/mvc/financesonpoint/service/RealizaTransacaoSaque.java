package br.com.renanlabs.mvc.financesonpoint.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraTransacaoRepository;


@Service
public class RealizaTransacaoSaque implements RealizadorTransacao{
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private CarteiraTransacaoRepository carteiraTransacaoRepository;
	
	
	public RealizaTransacaoSaque() {
		
	}

	@Override
	public void efetua(CarteiraTransacao carteiraTransacao) {
		
		//atualiza carteira
		Carteira carteira = carteiraTransacao.getCarteira();
		carteira.setValor(carteira.getValor().subtract(carteiraTransacao.getValor()));
		carteiraRepository.save(carteira);

		//salva transacao
		carteiraTransacao.setValorRoot(carteiraTransacao.getValor().negate());
		carteiraTransacao.setData(LocalDate.now());
		carteiraTransacaoRepository.save(carteiraTransacao);
		
	}

}
