package br.com.renanlabs.mvc.financesonpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraTransacaoRepository;

@Service
public class CarteiraTransacaoService {
	
	@Autowired
	private CarteiraTransacaoRepository carteiraTransacaoRepository;
	
	public void save(CarteiraTransacao carteiraTransacao) {
		carteiraTransacaoRepository.save(carteiraTransacao);
	}
	
	public List<CarteiraTransacao> transacoesPorCarteira(Carteira carteira){
		return carteiraTransacaoRepository.findByCarteira(carteira);
	}
	

}
