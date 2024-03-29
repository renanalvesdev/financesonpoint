package br.com.renanlabs.mvc.financesonpoint.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.model.TipoTransacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraTransacaoRepository;


@Service
public class RealizaTransacaoTransferencia implements RealizadorTransacao{
	
	
	@Autowired
	private CarteiraRepository carteiraRepository;
	
	@Autowired
	private CarteiraTransacaoRepository carteiraTransacaoRepository;
	
	public RealizaTransacaoTransferencia() {
		
	}
		
	@Override
	public void efetua(CarteiraTransacao carteiraTransacao) {
		
		//cria uma transacao para a carteira dessa transacao do tipo transferencia e seta destino como destino
		// subtrai do saldo do obj. carteira dessa transacao e salva
		//cria uma transacao para carteira destino do tipo transferencia e seta origem como carteira dessa transacao
		//acrescenta do saldo da destino e salva
		
		Carteira origem = carteiraTransacao.getCarteira();
		Carteira destino = carteiraTransacao.getDestino();
		
		//CARTEIRA ORIGEM
		
		//debitando da carteira origem
		DebitaCarteira debitaCarteira = new DebitaCarteira();
		carteiraTransacao.setValorRoot(carteiraTransacao.getValor().negate());
		debitaCarteira.efetua(origem, carteiraTransacao.getValor());
		
		carteiraRepository.save(origem);
		
		//realizando a transacao com destino carteira 2
		carteiraTransacao.setData(LocalDate.now());
		carteiraTransacaoRepository.save(carteiraTransacao);
		
		
		//CARTEIRA DESTINO
		
		//creditando carteira destino
		CreditaCarteira creditaCarteira = new CreditaCarteira();
		creditaCarteira.efetua(destino, carteiraTransacao.getValor());
		carteiraRepository.save(destino);
		
		//realizando a transacao na carteira 'destino' com origem carteira 'origem'
		CarteiraTransacao transacaoDestino = new CarteiraTransacao(destino, TipoTransacao.TRANSFERENCIA, carteiraTransacao.getValor(), origem);
		transacaoDestino.setValorRoot(carteiraTransacao.getValor());
		carteiraTransacaoRepository.save(transacaoDestino);
		
	}


}
