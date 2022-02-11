package br.com.renanlabs.mvc.financesonpoint.dto;

import javax.validation.constraints.NotBlank;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;

public class RequisicaoNovaCarteira {

	private Long id;
	
	@NotBlank
	private String descricao;
	
	private Double valor;
	
	public RequisicaoNovaCarteira() {
		// TODO Auto-generated constructor stub
	}
	
	public RequisicaoNovaCarteira(Carteira carteira) {
		this.id = carteira.getId();
		this.descricao = carteira.getDescricao();
		this.valor = carteira.getValor();
	}
	
	public Carteira toCarteira() {
		Carteira carteira = new Carteira();
		carteira.setId(id);
		carteira.setDescricao(descricao);
		carteira.setValor(valor);

		return carteira;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	

	
}
