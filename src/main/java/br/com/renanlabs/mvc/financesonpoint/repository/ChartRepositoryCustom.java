package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.dto.AmountChart;

@Repository
public interface ChartRepositoryCustom {

	List<AmountChart> findAmountCarteiraMesChart(Integer month, Integer year);
	List<AmountChart> findAmountCategoriaMesChart(Integer month, Integer year);
}
