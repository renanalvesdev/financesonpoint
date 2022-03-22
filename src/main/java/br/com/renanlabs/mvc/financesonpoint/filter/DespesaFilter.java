package br.com.renanlabs.mvc.financesonpoint.filter;

import java.time.LocalDate;

public class DespesaFilter {

	private LocalDate date;
	
	private Integer month;
	
	private Integer year;


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
	

	
	
}
