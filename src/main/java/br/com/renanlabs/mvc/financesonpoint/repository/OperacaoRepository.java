package br.com.renanlabs.mvc.financesonpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long> {

	//List<Operacao> findByStatus(StatusPedido status);
	
}