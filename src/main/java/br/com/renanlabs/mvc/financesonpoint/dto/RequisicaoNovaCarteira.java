package br.com.renanlabs.mvc.financesonpoint.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;

public class RequisicaoNovaCarteira {

	private Long id;
	
	@NotBlank
	private String descricao;
	
	private BigDecimal valor =  BigDecimal.ZERO;
	
	private BigDecimal saldo =  BigDecimal.ZERO;
	
	
	public RequisicaoNovaCarteira() {
		// TODO Auto-generated constructor stub
	}
	
	public RequisicaoNovaCarteira(Carteira carteira) {
		this.id = carteira.getId();
		this.descricao = carteira.getDescricao();
		this.valor = carteira.getValor();
		this.saldo = carteira.getSaldo();
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}


	

	
}
