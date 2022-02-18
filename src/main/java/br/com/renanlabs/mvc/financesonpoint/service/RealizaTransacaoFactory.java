package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.model.TipoTransacao;

@Service
public class RealizaTransacaoFactory {
	
	@Autowired
	private RealizaTransacaoTransferencia realizaTransacaoTransferencia;
	
	@Autowired
	private RealizaTransacaoDebito realizaTransacaoDebito;
	
	@Autowired
	private RealizaTransacaoSaque realizaTransacaoSaque;
	
	public RealizaTransacaoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public RealizadorTransacao getTransacao(TipoTransacao tipo) {
		
		if(tipo.equals(TipoTransacao.TRANSFERENCIA)) {
			return realizaTransacaoTransferencia;
		}
		
		if(tipo.equals(TipoTransacao.DEBITO)) {
			return realizaTransacaoDebito;
		}
		
		if(tipo.equals(TipoTransacao.SAQUE)) {
			return realizaTransacaoSaque;
		}
		
		throw new RuntimeException("No transaction type was defined.");
	}

}
