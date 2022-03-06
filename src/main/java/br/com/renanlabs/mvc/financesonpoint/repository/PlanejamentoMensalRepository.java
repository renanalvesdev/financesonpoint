package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;

@Repository
public interface PlanejamentoMensalRepository extends JpaRepository<PlanejamentoMensal, Long> {
	
	@Query("select p from PlanejamentoMensal p where p.ano = :year and  p.mes = :month")
	List<PlanejamentoMensal> findByMonthAndYear (@Param("month") int month, @Param("year") int year );

}