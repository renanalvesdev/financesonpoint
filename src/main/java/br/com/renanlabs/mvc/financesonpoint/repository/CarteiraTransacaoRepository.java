package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;

@Repository
public interface CarteiraTransacaoRepository extends JpaRepository<CarteiraTransacao, Long> {

	List<CarteiraTransacao> findByCarteiraOrderByDataDesc(Carteira carteira);
}