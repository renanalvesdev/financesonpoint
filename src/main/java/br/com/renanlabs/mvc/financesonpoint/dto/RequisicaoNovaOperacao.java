package br.com.renanlabs.mvc.financesonpoint.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;

public class RequisicaoNovaOperacao {

	private Long id;
	
	@NotBlank
	private String descricao;
	
	private Double valor;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	private boolean efetuada ;

	private Carteira carteira;
	
	public RequisicaoNovaOperacao() {
		// TODO Auto-generated constructor stub
	}
	
	//converting Operacao to RequisicaoNovaOperacao
	public RequisicaoNovaOperacao(Operacao operacao) {
		this.id = operacao.getId();
		this.descricao = operacao.getDescricao();
		this.valor = operacao.getValor();
		this.data = operacao.getData();
		this.efetuada = operacao.isEfetuada();
		this.carteira = operacao.getCarteira();
	}
	
	public Operacao toOperacao() {
		Operacao operacao = new Operacao();
		operacao.setId(id);
		operacao.setDescricao(descricao);
		operacao.setData(data);
		operacao.setValor(valor);
		operacao.setEfetuada(efetuada);
		operacao.setCarteira(carteira);
		
		return operacao;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean isEfetuada() {
		return efetuada;
	}

	public void setEfetuada(boolean efetuada) {
		this.efetuada = efetuada;
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



	public LocalDate getData() {
		return data;
	}


	public void setData(LocalDate data) {
		this.data = data;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}
	
	
	
}
