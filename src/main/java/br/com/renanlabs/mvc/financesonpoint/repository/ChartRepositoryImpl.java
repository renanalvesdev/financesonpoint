package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.dto.DespesaChart;

@Repository
public class ChartRepositoryImpl implements ChartRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<DespesaChart> findDespesaChart(Integer month, Integer year) {

		Query nativeQuery = entityManager
				.createNativeQuery("select c.descricao, sum (o.valor)\r\n"
						+ "from carteira c \r\n"
						+ "inner join operacao o \r\n"
						+ "on c.id = o.carteira_id \r\n"
						+ "where date_part('month', o.data) = :monthParam\r\n"
						+ "and date_part('year', o.data) = :yearParam\r\n"
						+ "\r\n"
						+ "group by c.id ");

		nativeQuery.setParameter("monthParam", month);
		nativeQuery.setParameter("yearParam", year);
		
		List<Object[]> result =  nativeQuery.getResultList();
		
		List<DespesaChart> amounts = result
				.stream()
				.map(a ->  new DespesaChart((String)a[0], (Double)a[1]) )
				.collect(Collectors.toList());	
		
		return amounts;
	}

}
