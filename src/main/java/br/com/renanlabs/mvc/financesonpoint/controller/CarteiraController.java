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

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoNovaCarteira;
import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.repository.CarteiraRepository;

@Controller
@RequestMapping("carteira")
public class CarteiraController {

	@Autowired
	private CarteiraRepository carteiraRepository;

	
	@GetMapping("listagem")
	public String listagem(Model model) {
		List<Carteira> carteiras = carteiraRepository.findAll();
		model.addAttribute("carteiras", carteiras);
		return "carteira/listagem"; 
	}
	
	
	/**methods to handling showing of form**/
	
	@GetMapping("formulario")
	public String showNewForm(RequisicaoNovaCarteira requisicao) {
		return "carteira/formulario";
	}

	@GetMapping("/formulario/editar/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Carteira carteira = carteiraRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		RequisicaoNovaCarteira requisicaoNovaCarteira = new RequisicaoNovaCarteira(carteira);
		model.addAttribute("requisicaoNovaCarteira", requisicaoNovaCarteira);
		
		return "carteira/formulario";
	}

	
	//save
	@PostMapping("save")
	public String save(@Valid RequisicaoNovaCarteira requisicao, BindingResult result) {

		if (result.hasErrors()) {
			return "carteira/formulario";
		}

		Carteira carteira = requisicao.toCarteira();
		carteiraRepository.save(carteira);

		return "redirect:/carteira/listagem";
	}

}
