package br.com.renanlabs.mvc.financesonpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.exception.FinancesOnPointException;
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

	@Autowired
	private AtualizadorPlanejamento atualizadorPlanejamento;

	public void save(Operacao operacao) {

		if (operacao.getPlanejamentoMensal() != null && operacao.getValor() > operacao.getPlanejamentoMensal().getSaldo()) {
			throw new FinancesOnPointException("O valor é maior do que o budget estabelecido para esse planejamento");
		}

		//salva a despesa
		operacao = operacaoRepository.save(operacao);
		
		//atualiza o planejamento - se tiver
		if(operacao.getPlanejamentoMensal() != null) {
			atualizadorPlanejamento.atualiza(operacao.getPlanejamentoMensal());
		}

		// do debit transaction
		realizaTransacaoDebito.efetua(new CarteiraTransacao(TipoTransacao.DEBITO, operacao));

	}
}
