package br.com.renanlabs.mvc.financesonpoint.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.renanlabs.mvc.financesonpoint.dto.DespesaChart;

@Repository
public interface ChartRepositoryCustom {

	List<DespesaChart> findDespesaChart(Integer month, Integer year);
}
