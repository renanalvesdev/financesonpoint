package br.com.renanlabs.mvc.financesonpoint.dto;

public class DespesaChart {

	private String descricao;
	private Double total;
	
	
	public DespesaChart(String descricao, Double total) {
		this.descricao = descricao;
		this.total = total;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}
