package br.com.renanlabs.mvc.financesonpoint.filter;

import java.time.LocalDate;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.Categoria;

public class DespesaFilter {

	private LocalDate date;
	
	private Integer month;
	
	private Integer year;

	private Categoria categoria;
	
	private Carteira carteira;

	public DespesaFilter() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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
	
	
	
}
