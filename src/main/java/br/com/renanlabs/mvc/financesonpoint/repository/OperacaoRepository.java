package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.model.Operacao;

@Repository
public interface OperacaoRepository extends JpaRepository<Operacao, Long>, OperacaoRepositoryCustom {

	@Query("select o from Operacao o where year(o.data) = :year and  month(o.data) = :month")
	public List<Operacao> findByMonthAndYear(@Param("month") int month, @Param("year") int year);
	
}