package br.com.renanlabs.mvc.financesonpoint.dto;

import java.time.LocalDate;

import br.com.renanlabs.mvc.financesonpoint.filter.DespesaFilter;
import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.Categoria;
import br.com.renanlabs.mvc.financesonpoint.util.DateUtil;

public class RequisicaoDespesaFilter {

	private String date;

	private Categoria categoria; 
	
	private Carteira carteira;
	
	public RequisicaoDespesaFilter() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public DespesaFilter toDespesaFilter() {
		
		DespesaFilter despesaFilter = new DespesaFilter();
		
		LocalDate localDate = DateUtil.stringToDate(DateUtil.MM_YYYY, date);	
		
		despesaFilter.setDate(localDate);
		despesaFilter.setYear(localDate.getYear());
		despesaFilter.setMonth(localDate.getMonthValue());
		despesaFilter.setCategoria(categoria);
		despesaFilter.setCarteira(carteira);
		
		return despesaFilter;
	}
}
