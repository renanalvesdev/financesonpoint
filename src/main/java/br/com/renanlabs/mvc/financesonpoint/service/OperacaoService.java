package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.model.TipoTransacao;
import br.com.renanlabs.mvc.financesonpoint.repository.OperacaoRepository;

@Service
public class OperacaoService {
	
	@Autowired
	private OperacaoRepository operacaoRepository;
	
	@Autowired
	private RealizaTransacaoDebito realizaTransacaoDebito;
	
	
	public void save(Operacao operacao) {

		operacao = operacaoRepository.save(operacao);
		
		//do debit transaction
		realizaTransacaoDebito.efetua(new CarteiraTransacao(operacao.getCarteira(), TipoTransacao.DEBITO, operacao.getValor(), operacao));
	
	}
}
