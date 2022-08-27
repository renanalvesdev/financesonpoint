package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;

@Repository
public interface CarteiraTransacaoRepository extends JpaRepository<CarteiraTransacao, Integer> {

	List<CarteiraTransacao> findByCarteiraOrderByDataDesc(Carteira carteira);
	CarteiraTransacao findByDespesa(Operacao despesa);
}