package br.com.renanlabs.mvc.financesonpoint.dto;

import java.math.BigDecimal;

import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;

public class RequisicaoNovoPlanejamentoMensal {

	private Long id;

	private String descricao;
	private BigDecimal valor;
	private BigDecimal saldo;
	private String mesAno;

	public RequisicaoNovoPlanejamentoMensal() {
		
	}

	public RequisicaoNovoPlanejamentoMensal(PlanejamentoMensal planejamentoMensal) {
		this.id = planejamentoMensal.getId();
		this.descricao = planejamentoMensal.getDescricao();
		this.valor = planejamentoMensal.getValor();
		this.saldo = planejamentoMensal.getSaldo();
		this.mesAno = planejamentoMensal.getAno() + "-" + String.format("%02d" , planejamentoMensal.getMes());
	}

	public PlanejamentoMensal toPlanejamentoMensal() {
		PlanejamentoMensal planejamentoMensal  = new PlanejamentoMensal();
		planejamentoMensal.setId(id);
		planejamentoMensal.setDescricao(descricao);
		planejamentoMensal.setValor(valor);
		planejamentoMensal.setSaldo(saldo);
		planejamentoMensal.setAno(Integer.parseInt(mesAno.split("-")[0]));
		planejamentoMensal.setMes(Integer.parseInt(mesAno.split("-")[1]));
		return planejamentoMensal;
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

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	


}
