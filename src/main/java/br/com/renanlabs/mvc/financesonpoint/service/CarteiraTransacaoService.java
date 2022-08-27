package br.com.renanlabs.mvc.financesonpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraTransacaoRepository;

@Service
public class CarteiraTransacaoService {
	
	@Autowired
	private RealizaTransacaoFactory realizaTransacaoFactory;
	
	
	@Autowired
	private CarteiraTransacaoRepository carteiraTransacaoRepository;
	
	public void save(CarteiraTransacao carteiraTransacao) {
		//cria uma transacao para a carteira dessa transacao do tipo transferencia e seta destino como destino
		// subtrai do saldo do obj. carteira dessa transacao e salva
		//cria uma transacao para carteira destino do tipo transferencia e seta origem como carteira dessa transacao
		//acrescenta do saldo da destino e salva
		
		//do transaction
		RealizadorTransacao realizadorTransacao = realizaTransacaoFactory.getTransacao(carteiraTransacao.getTipo());
		realizadorTransacao.efetua(carteiraTransacao);
	}
	
	public List<CarteiraTransacao> transacoesPorCarteira(Carteira carteira){
		return carteiraTransacaoRepository.findByCarteiraOrderByDataDesc(carteira);
	}
	
	public CarteiraTransacao findById(Integer id) {
		return carteiraTransacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carteira nao encontrada"));
	}
	
	public CarteiraTransacao findByDespesa(Operacao despesa) {
		return carteiraTransacaoRepository.findByDespesa(despesa);
	}
	

}
