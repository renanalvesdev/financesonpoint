package br.com.renanlabs.mvc.financesonpoint.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoNovaCategoria;
import br.com.renanlabs.mvc.financesonpoint.model.Categoria;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CategoriaRepository;

@Controller
@RequestMapping("categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	
	@GetMapping("listagem")
	public String listagem(Model model) {
		List<Categoria> categorias = categoriaRepository.findAll();
		model.addAttribute("categorias", categorias);
		return "categoria/listagem"; 
	}
	
	
	/**methods to handling showing of form**/
	
	@GetMapping("formulario")
	public String showNewForm(RequisicaoNovaCategoria requisicao) {
		return "categoria/formulario";
	}

	@GetMapping("/formulario/editar/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		RequisicaoNovaCategoria requisicaoNovaCategoria = new RequisicaoNovaCategoria(categoria);
		model.addAttribute("requisicaoNovaCategoria", requisicaoNovaCategoria);
		
		return "categoria/formulario";
	}

	
	//save
	@PostMapping("save")
	public String save(@Valid RequisicaoNovaCategoria requisicao, BindingResult result) {

		if (result.hasErrors()) {
			return "categoria/formulario";
		}

		Categoria categoria = requisicao.toCategoria();
		categoriaRepository.save(categoria);

		return "redirect:/categoria/listagem";
	}

}
