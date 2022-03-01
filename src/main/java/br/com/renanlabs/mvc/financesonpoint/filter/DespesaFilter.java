package br.com.renanlabs.mvc.financesonpoint.filter;

import java.time.LocalDate;

public class DespesaFilter {

	private LocalDate date;
	
	private int month;
	
	private int year;


	public DespesaFilter() {
		// TODO Auto-generated constructor stub
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

	
	
}
