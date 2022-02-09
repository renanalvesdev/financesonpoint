package br.com.renanlabs.mvc.financesonpoint.dto;

import javax.validation.constraints.NotBlank;

import br.com.renanlabs.mvc.financesonpoint.model.Categoria;

public class RequisicaoNovaCategoria {

	private Long id;
	
	@NotBlank
	private String descricao;
	
	public RequisicaoNovaCategoria() {
		// TODO Auto-generated constructor stub
	}
	
	public RequisicaoNovaCategoria(Categoria categoria) {
		this.id = categoria.getId();
		this.descricao = categoria.getDescricao();
	}
	
	public Categoria toCategoria() {
		Categoria categoria = new Categoria();
		categoria.setId(id);
		categoria.setDescricao(descricao);

		return categoria;
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



	
}
