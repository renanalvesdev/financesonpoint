package br.com.renanlabs.mvc.financesonpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renanlabs.mvc.financesonpoint.dto.AmountChart;
import br.com.renanlabs.mvc.financesonpoint.repository.ChartRepositoryCustom;

@Service
public class ChartService {

	@Autowired
	private ChartRepositoryCustom chartRepository;
	
	public List<AmountChart> amountCarteiraPorMesAndAno(Integer mes, Integer ano){
		return chartRepository.findAmountCarteiraMesChart(mes, ano);
	}
	
	public List<AmountChart> amountCategoriaPorMesAndAno(Integer mes, Integer ano){
		return chartRepository.findAmountCategoriaMesChart(mes, ano);
	}
}
