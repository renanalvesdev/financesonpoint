package br.com.renanlabs.mvc.financesonpoint.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Formula;

@Entity
public class PlanejamentoMensal {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private BigDecimal valor;
	
	private BigDecimal saldo;
	
	@Formula("(SELECT COALESCE(SUM(o.valor),0) FROM Operacao o where o.planejamento_mensal_id = id)")
	private BigDecimal gasto = BigDecimal.ZERO;
	
	private Integer mes;
	private Integer ano;
	
	
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
		return valor.subtract(gasto);
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public BigDecimal getGasto() {
		return gasto;
	}
	public void setGasto(BigDecimal gasto) {
		this.gasto = gasto;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	

}
