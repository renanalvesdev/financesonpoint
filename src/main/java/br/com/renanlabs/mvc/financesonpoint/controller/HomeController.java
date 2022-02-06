package br.com.renanlabs.mvc.financesonpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.renanlabs.mvc.financesonpoint.model.Operacao;
import br.com.renanlabs.mvc.financesonpoint.repository.OperacaoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private OperacaoRepository repository;
	
	@GetMapping
	public String home(Model model) {
		List<Operacao> operacoes = repository.findAll();
		model.addAttribute("operacoes", operacoes);
		return "home"; 
	}
	
	/*
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Operacao> operacoes = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("operacoes", operacoes);
		model.addAttribute("status", status);
		return "home"; 
	}*/
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
