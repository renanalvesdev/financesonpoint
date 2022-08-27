package br.com.renanlabs.mvc.financesonpoint.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.renanlabs.mvc.financesonpoint.exception.FinancesOnPointException;
import br.com.renanlabs.mvc.financesonpoint.exception.NaoPodeAtualizarDespesaExistenteException;
import br.com.renanlabs.mvc.financesonpoint.exception.ValorDespesaMaiorQueBudgetException;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.model.TipoTransacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraTransacaoRepository;
import br.com.renanlabs.mvc.financesonpoint.repository.OperacaoRepository;

@Service
public class OperacaoService {

	@Autowired
	private OperacaoRepository operacaoRepository;

	@Autowired
	private CarteiraTransacaoRepository carteiraTransacaoRepository;
	
	@Autowired
	private RealizaTransacaoDebito realizaTransacaoDebito;

	@Autowired
	private AtualizadorPlanejamento atualizadorPlanejamento;

	public void save(Operacao operacao) {

		if(operacao.isJaCadastrado()) {
			throw new NaoPodeAtualizarDespesaExistenteException();
		}
		
		if (operacao.getPlanejamentoMensal() != null && operacao.getValor() > operacao.saldoPlanejamentoMensal()) {
			throw new ValorDespesaMaiorQueBudgetException();
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
	
	public Operacao buscaPorId(Integer id) {
		return operacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Operacao nao encontrada"));
	}

	@Transactional
	public void delete(Integer id) {
		Operacao operacaoEncontrada = buscaPorId(id);
		CarteiraTransacao carteiraTransacaoOperacao = carteiraTransacaoRepository.findByDespesa(operacaoEncontrada);
		carteiraTransacaoRepository.delete(carteiraTransacaoOperacao);
		operacaoRepository.delete(operacaoEncontrada);
	}
}
