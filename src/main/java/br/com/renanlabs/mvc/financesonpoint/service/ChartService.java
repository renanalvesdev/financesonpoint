package br.com.renanlabs.mvc.financesonpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.dto.DespesaChart;
import br.com.renanlabs.mvc.financesonpoint.repository.ChartRepositoryCustom;

@Service
public class ChartService {

	@Autowired
	private ChartRepositoryCustom chartRepository;
	
	public List<DespesaChart> despesasAmountPorMesAndAno(Integer mes, Integer ano){
		return chartRepository.findDespesaChart(mes, ano);
	}
}
