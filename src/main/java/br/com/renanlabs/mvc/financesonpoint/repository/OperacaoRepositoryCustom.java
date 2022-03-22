package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import br.com.renanlabs.mvc.financesonpoint.filter.DespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;

public interface OperacaoRepositoryCustom {

	List<Operacao> findByFilter(DespesaFilter filter);
}
