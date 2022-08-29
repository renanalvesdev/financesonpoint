package br.com.renanlabs.mvc.financesonpoint.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.model.TipoTransacao;

public class RequisicaoCarteiraTransacao {

	private Long id;
	
	@NotBlank
	private String descricao;
	
	private BigDecimal valor;
	
	private TipoTransacao tipo;	
	
	private Carteira destino;
	
	private Carteira carteira;
	
	public RequisicaoCarteiraTransacao() {
		// TODO Auto-generated constructor stub
	}
	
	public RequisicaoCarteiraTransacao(CarteiraTransacao carteiraTransacao) {
		this.id = carteiraTransacao.getId();
		this.descricao = carteiraTransacao.getDescricao();
		this.valor = carteiraTransacao.getValor();
		this.tipo = carteiraTransacao.getTipo();
		this.destino = carteiraTransacao.getDestino();
		this.carteira = carteiraTransacao.getCarteira();
	}
	
	public CarteiraTransacao toCarteiraTransacao() {
		CarteiraTransacao carteiraTransacao = new CarteiraTransacao();
		carteiraTransacao.setId(id);
		carteiraTransacao.setDescricao(descricao);
		carteiraTransacao.setValor(valor);
		carteiraTransacao.setTipo(tipo);
		carteiraTransacao.setDestino(destino);
		carteiraTransacao.setCarteira(carteira);

		return carteiraTransacao;
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

	public TipoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}

	public Carteira getDestino() {
		return destino;
	}

	public void setDestino(Carteira destino) {
		this.destino = destino;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	
	
	

	
}
