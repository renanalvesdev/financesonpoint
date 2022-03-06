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

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoNovoPlanejamentoMensal;
import br.com.renanlabs.mvc.financesonpoint.model.PlanejamentoMensal;
import br.com.renanlabs.mvc.financesonpoint.service.PlanejamentoMensalService;

@Controller
@RequestMapping("planejamentoMensal")
public class PlanejamentoMensalController {
	
	@Autowired
	private PlanejamentoMensalService planejamentoMensalService;
	
	@GetMapping("formulario")
	public String showNewForm(RequisicaoNovoPlanejamentoMensal requisicao, Model model) {
		
		return "planejamentoMensal/formulario";
	}

	// show fetched Operation form
	@GetMapping("/formulario/editar/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		
		PlanejamentoMensal planejamentoMensal = planejamentoMensalService.findById(id);
		
		RequisicaoNovoPlanejamentoMensal requisicaoNovaPlanejamentoMensal = new RequisicaoNovoPlanejamentoMensal(planejamentoMensal);
		
		model.addAttribute("requisicaoNovoPlanejamentoMensal", requisicaoNovaPlanejamentoMensal);
		
		return "planejamentoMensal/formulario";
	}

	
	//save
	@PostMapping("save")
	public String save(@Valid RequisicaoNovoPlanejamentoMensal requisicao, BindingResult result) {

		if (result.hasErrors()) {
			return "planejamentoMensal/formulario";
		}

		PlanejamentoMensal planejamentoMensal = requisicao.toPlanejamentoMensal();
		planejamentoMensalService.save(planejamentoMensal);

		return "redirect:/home";
	}

}
