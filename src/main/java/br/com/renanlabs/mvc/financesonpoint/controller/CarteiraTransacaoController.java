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

import br.com.renanlabs.mvc.financesonpoint.dto.RequisicaoCarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.exception.FinancesOnPointException;
import br.com.renanlabs.mvc.financesonpoint.model.Carteira;
import br.com.renanlabs.mvc.financesonpoint.model.CarteiraTransacao;
import br.com.renanlabs.mvc.financesonpoint.service.CarteiraService;
import br.com.renanlabs.mvc.financesonpoint.service.CarteiraTransacaoService;

@Controller
@RequestMapping("carteiraTransacao")
public class CarteiraTransacaoController {

	
	@Autowired
	private CarteiraTransacaoService carteiraTransacaoService;
	
	@Autowired
	private CarteiraService carteiraService;
	

	@GetMapping("formulario/carteira/{id}")
	public String showNewForm(@PathVariable("id") long id, Model model) {
		
		Carteira carteira = carteiraService.findById(id);
		
		RequisicaoCarteiraTransacao requisicaoCarteiraTransacao = new RequisicaoCarteiraTransacao(new CarteiraTransacao(carteira));
		
		List<Carteira> carteiras = carteiraService.findAll();
		
		model.addAttribute("carteiras", carteiras);
		model.addAttribute("requisicaoCarteiraTransacao", requisicaoCarteiraTransacao);
		
		return "carteiraTransacao/formulario";
	}

	@GetMapping("/formulario/editar/{id}")
	public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
		
		CarteiraTransacao carteiraTransacao = carteiraTransacaoService.findById(id);
		
		RequisicaoCarteiraTransacao requisicaoCarteiraTransacao = new RequisicaoCarteiraTransacao(carteiraTransacao);
		model.addAttribute("requisicaoCarteiraTransacao", requisicaoCarteiraTransacao);
		
		return "carteiraTransacao/formulario";
	}

	
	//save
	@PostMapping("save")
	public String save(@Valid RequisicaoCarteiraTransacao requisicao, BindingResult result, Model model) {

		String successRedirect = "redirect:/carteira/listagem";
		String errorRedirect = "carteiraTransacao/formulario";
		
		if (result.hasErrors()) {
			return errorRedirect;
		}

		try {
			CarteiraTransacao carteiraTransacao = requisicao.toCarteiraTransacao();
			carteiraTransacaoService.save(carteiraTransacao);
		} catch (FinancesOnPointException e) {
			 model.addAttribute("errorMessage",e.getMessage());
			 return errorRedirect;
		}
		
		return successRedirect;

	}

}
