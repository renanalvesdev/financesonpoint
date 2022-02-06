package br.com.renanlabs.mvc.financesonpoint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoNovaOperacao;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.repository.OperacaoRepository;

@Controller
@RequestMapping("operacao")
public class OperacaoController {

	@Autowired
	private OperacaoRepository operacaoRepository;

	
	/**methods to handling showing of form**/
	
	//show new Operation form
	@GetMapping("formulario")
	public String showNewForm(RequisicaoNovaOperacao requisicao) {
		return "operacao/formulario";
	}

	// show fetched Operation form
	@GetMapping("/formulario/editar/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Operacao operacao = operacaoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		RequisicaoNovaOperacao requisicaoNovaOperacao = new RequisicaoNovaOperacao(operacao);
		model.addAttribute("requisicaoNovaOperacao", requisicaoNovaOperacao);
		
		return "operacao/formulario";
	}

	
	/** methods to handling CRUD operations to entity 'Operations' **/
	
	//save
	@PostMapping("save")
	public String save(@Valid RequisicaoNovaOperacao requisicao, BindingResult result) {

		if (result.hasErrors()) {
			return "operacao/formulario";
		}

		Operacao operacao = requisicao.toOperacao();
		operacaoRepository.save(operacao);

		return "redirect:/home";
	}

}
