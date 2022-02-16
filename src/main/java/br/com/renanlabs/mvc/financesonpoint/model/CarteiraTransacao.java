package br.com.renanlabs.mvc.financesonpoint.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CarteiraTransacao {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private Double valor;
	
	private LocalDate data;
	
	//wallet to which the transaction belongs
	@ManyToOne
	private Carteira carteira;
	
	//from where in transfer
	@OneToOne
	private Carteira origem;
	
	//to where in transfer
	@OneToOne
	private Carteira destino;
	
	//expense id
	@OneToOne
	private Operacao despesa;
	
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipo;	

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

	public Carteira getOrigem() {
		return origem;
	}

	public void setOrigem(Carteira origem) {
		this.origem = origem;
	}

	public Carteira getDestino() {
		return destino;
	}

	public void setDestino(Carteira destino) {
		this.destino = destino;
	}

	public Operacao getDespesa() {
		return despesa;
	}

	public void setDespesa(Operacao despesa) {
		this.despesa = despesa;
	}

	public TipoTransacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoTransacao tipo) {
		this.tipo = tipo;
	}
	
	
	
	

}