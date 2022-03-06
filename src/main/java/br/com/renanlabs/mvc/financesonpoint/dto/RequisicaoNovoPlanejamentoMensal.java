package br.com.renanlabs.mvc.financesonpoint.dto;

import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;

public class RequisicaoNovoPlanejamentoMensal {

	private Long id;

	private String descricao;
	private Double valor;
	private Double saldo;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

	


}
