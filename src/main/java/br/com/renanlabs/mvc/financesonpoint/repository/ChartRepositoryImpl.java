package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.dto.AmountChart;

@Repository
public class ChartRepositoryImpl implements ChartRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<AmountChart> findAmountCarteiraMesChart(Integer month, Integer year) {

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
		
		List<AmountChart> amounts = result
				.stream()
				.map(a ->  new AmountChart((String)a[0], (Double)a[1]) )
				.collect(Collectors.toList());	
		
		return amounts;
	}
	
	@Override
	public List<AmountChart> findAmountCategoriaMesChart(Integer month, Integer year) {

		Query nativeQuery = entityManager
				.createNativeQuery("select c.descricao, sum (o.valor)\r\n"
						+ "from categoria c \r\n"
						+ "inner join operacao o \r\n"
						+ "on c.id = o.categoria_id \r\n"
						+ "where date_part('month', o.data) = :monthParam\r\n"
						+ "and date_part('year', o.data) = :yearParam\r\n"
						+ "\r\n"
						+ "group by c.id ");

		nativeQuery.setParameter("monthParam", month);
		nativeQuery.setParameter("yearParam", year);
		
		List<Object[]> result =  nativeQuery.getResultList();
		
		List<AmountChart> amounts = result
				.stream()
				.map(a ->  new AmountChart((String)a[0], (Double)a[1]) )
				.collect(Collectors.toList());	
		
		return amounts;
	}


}
