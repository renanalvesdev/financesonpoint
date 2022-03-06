package br.com.renanlabs.mvc.financesonpoint.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

//despesa

@Entity
public class Operacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	private Double valor;
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
	private TipoOperacao tipo;	
	
	private boolean efetuada;
	
	@OneToOne
	private Carteira carteira;

	@OneToOne
	private Categoria categoria;
	
	@OneToOne
	private PlanejamentoMensal planejamentoMensal;

	
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
	public TipoOperacao getTipo() {
		return tipo;
	}
	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}
	public Carteira getCarteira() {
		return carteira;
	}
	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public PlanejamentoMensal getPlanejamentoMensal() {
		return planejamentoMensal;
	}
	public void setPlanejamentoMensal(PlanejamentoMensal planejamentoMensal) {
		this.planejamentoMensal = planejamentoMensal;
	}
	
	
	


}
