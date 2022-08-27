package br.com.renanlabs.mvc.financesonpoint.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.Categoria;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;

/**
 * @author jdoe
 *
 */
public class RequisicaoNovaOperacao {

	private Integer id;

	@NotBlank
	private String descricao;

	@NotNull
	private Double valor;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;

	private boolean efetuada;

	@NotNull
	private Carteira carteira;

	@NotNull(message = "A categoria é obrigatória")
	private Categoria categoria;

	private PlanejamentoMensal planejamento;

	public RequisicaoNovaOperacao() {
		// TODO Auto-generated constructor stubpode
	}

	// converting Operacao to RequisicaoNovaOperacao
	public RequisicaoNovaOperacao(Operacao operacao) {
		this.id = operacao.getId();
		this.descricao = operacao.getDescricao();
		this.valor = operacao.getValor();
		this.data = operacao.getData();
		this.efetuada = operacao.isEfetuada();
		this.carteira = operacao.getCarteira();
		this.categoria = operacao.getCategoria();
		this.planejamento = operacao.getPlanejamentoMensal();
	}

	public Operacao toOperacao() {
		Operacao operacao = new Operacao();
		operacao.setId(id);
		operacao.setDescricao(descricao);
		operacao.setData(data);
		operacao.setValor(valor);
		operacao.setEfetuada(efetuada);
		operacao.setCarteira(carteira);
		operacao.setCategoria(categoria);
		operacao.setPlanejamentoMensal(planejamento);
		
		return operacao;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public PlanejamentoMensal getPlanejamento() {
		return planejamento;
	}

	public void setPlanejamento(PlanejamentoMensal planejamento) {
		this.planejamento = planejamento;
	}

	
}
