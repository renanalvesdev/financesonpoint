package br.com.renanlabs.mvc.financesonpoint.dto;

import java.time.LocalDate;

import br.com.renanlabs.mvc.financesonpoint.filter.DespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.util.DateUtil;

public class RequisicaoDespesaFilter {

	private String date;

	public RequisicaoDespesaFilter() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	public DespesaFilter toDespesaFilter() {
		
		DespesaFilter despesaFilter = new DespesaFilter();
		
		LocalDate localDate = DateUtil.stringToDate(DateUtil.MM_YYYY, date);	
		
		despesaFilter.setDate(localDate);
		despesaFilter.setYear(localDate.getYear());
		despesaFilter.setMonth(localDate.getMonthValue());
		
		return despesaFilter;
	}
}
